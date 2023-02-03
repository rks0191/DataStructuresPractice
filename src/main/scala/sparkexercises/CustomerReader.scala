package sparkexercises

import org.apache.spark.sql.SparkSession


object CustomerReader {
  def main(args: Array[String]): Unit = {
    val inputSparkSession = SparkSession.builder().getOrCreate()
    val inputDf = inputSparkSession.sqlContext.read.csv("data.csv")
  }

}
