// + — — — — — — — — — -+ — — — — — — +
// |timestamp |userid|
// + — — — — — — — — — -+ — — — — — — -+
// |2018–01–01T11:00:00Z| u1
// |2018–01–01T12:00:00Z| u1
// |2018–01–01T11:00:00Z| u2
// |2018–01–02T11:00:00Z| u2
// |2018–01–01T12:15:00Z| u1
// + — — — — — — — — — -+ — — — +
// Problem Statement:
// Given a timeseries clickstream hit data of user activity, enrich the data with session id and visit number.
// A session will be defined as 30 mins of inactivity and maximum 2 hours.

// Expected Output:
// Output should have 3 columns :
// timestamp userid and session_id
// Values of session_id as per logic should be u1_s2, u1_s1, u2_s1, etc

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
val spark = SparkSession.builder.appName("SessionizeClicks").getOrCreate()
import spark.implicits._

val data = Seq(
  ("2018-01-01T11:00:00Z", "u1"),
  ("2018-01-01T12:00:00Z", "u1"),
  ("2018-01-01T11:00:00Z", "u2"),
  ("2018-01-02T11:00:00Z", "u2"),
  ("2018-01-01T12:15:00Z", "u1")
).toDF("timestamp", "userid")

val df = data.withColumn("timestamp", unix_timestamp($"timestamp", "yyyy-MM-dd'T'HH:mm:ss'Z'"))
val windowSpec = Window.partitionBy("userid").orderBy("timestamp")
val dfWithPrev = df.withColumn("prev_timestamp", lag("timestamp", 1).over(windowSpec))
val dfWithTimeDiff = dfWithPrev.withColumn("time_diff", $"timestamp" - $"prev_timestamp")
val dfWithSessionFlag = dfWithTimeDiff.withColumn("session_flag", when($"time_diff" > 1800 || $"time_diff".isNull, 1).otherwise(0))
val windowSpec2 = Window.partitionBy("userid").orderBy("timestamp").rowsBetween(Window.unboundedPreceding, Window.currentRow)
val dfWithSessionId = dfWithSessionFlag.withColumn("session_id", sum($"session_flag").over(windowSpec2))
val dfWithSessionIdString = dfWithSessionId.withColumn("session_id", concat($"userid", lit("_s"), $"session_id"))
val dfWithOriginalTimestamp = dfWithSessionIdString.withColumn("timestamp", from_unixtime($"timestamp", "yyyy-MM-dd'T'HH:mm:ss'Z'"))
val result = dfWithOriginalTimestamp.select("timestamp", "userid", "session_id")
result.show(truncate = false)
