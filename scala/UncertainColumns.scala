 // Write a Spark program in Scala with columns id, name, and salary, where the data might contain special characters, blanks, and "NA" values that should be treated as nulls. Handle the uncertainty of column names being dynamic and uncertain due to potential special characters.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

val spark = SparkSession.builder.appName("Handle Special Characters and Nulls").getOrCreate()

import spark.implicits._

val data = Seq(
  (1, "#", ""),
  (2, "dd", "$"),
  (3, "NA", "5000"),
  (4, "John", "NA"),
  (5, "", "6000")
)

val df = data.toDF("id", "name", "salary")

def cleanColumns(df: org.apache.spark.sql.DataFrame): org.apache.spark.sql.DataFrame = {
  val specialChars = List("#", "$", "%", "&", "@") 
  
  val cleanedDf = df.columns.foldLeft(df)((currentDf, colName) => {
    currentDf.withColumn(colName, 
      when(
        col(colName).isin(specialChars: _*) || col(colName).isNull || col(colName).equalTo("NA") || col(colName).equalTo(""), 
        lit(null)
      ).otherwise(col(colName))
    )
  })
  
  cleanedDf
}

val cleanedDf = cleanColumns(df)
cleanedDf.show()
