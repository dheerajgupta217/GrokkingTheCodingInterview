// Given a dataset of students’ scores in different subjects, transform the data to have each student’s scores for all subjects in a single row. The input data consists of tuples with student name, subject, and score. The desired output is a DataFrame where each row represents a student and their scores in each subject.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

val spark = SparkSession.builder.appName("Student Scores").getOrCreate()
import spark.implicits._

val data = Seq(
  ("Alice", "Math", 85),
  ("Alice", "Science", 90),
  ("Bob", "Math", 78),
  ("Bob", "Science", 82),
  ("Charlie", "Math", 92),
  ("Charlie", "Science", 87)
)

val df = data.toDF("Name", "Subject", "Score")

val pivotDF = df.groupBy("Name").pivot("Subject").agg(first("Score"))

pivotDF.show(truncate = false)
