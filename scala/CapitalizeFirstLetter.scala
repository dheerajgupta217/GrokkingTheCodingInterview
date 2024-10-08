// Let’s create a DataFrame containing names, and we want to create a UDF to capitalize the first letter of each name.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

def capitalizeFirstLetter(name: String): String = {
  if (name == null || name.isEmpty) {
    name
  } else {
    name.substring(0, 1).toUpperCase + name.substring(1).toLowerCase
  }
}

val capitalizeUDF = udf(capitalizeFirstLetter _)
val spark = SparkSession.builder.appName("UDF Example").getOrCreate()
import spark.implicits._

val df = Seq(
  ("rahul"),
  ("umesh"),
  ("vijay"),
  ("pawan")
).toDF("name")

val dfWithCapitalizedNames = df.withColumn("capitalized_name", capitalizeUDF($"name"))
dfWithCapitalizedNames.show(truncate = false)
