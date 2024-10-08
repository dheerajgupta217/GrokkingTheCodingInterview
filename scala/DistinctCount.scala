import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

val spark = SparkSession.builder.appName("Order Count").getOrCreate()

import spark.implicits._

val data = Seq(
  (101, "[pizza,samosa,idli]"),
  (102, "[kachori,sambhar,idli]"),
  (103, "[dosa,vada,pizza]"),
  (104, "[samosa,idli,chai]"),
  (105, "[pizza,chai,dosa]")
)

val df = data.toDF("billid", "Ordername")

val dfCleaned = df.withColumn("Ordername", regexp_replace(col("Ordername"), "\\[|\\]", ""))
val dfSplit = dfCleaned.withColumn("Ordername", split(col("Ordername"), ","))
val dfExploded = dfSplit.withColumn("Item", explode(col("Ordername"))).select("Item")
val dfCount = dfExploded.groupBy("Item").count()

dfCount.show()
