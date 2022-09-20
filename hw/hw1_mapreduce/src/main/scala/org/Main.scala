package org

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.io.PrintWriter

object Main {
  def main(args : Array[String]) : Unit = {
    // setup spark config
    val conf = new SparkConf().setAppName("MapReduce").setMaster("local[4]")
    val sc = new SparkContext(conf)

    // mapreduce pipeline
    val textRDD = sc.textFile("test.txt")
    val intermediate_rdd1 = textRDD.flatMap(f=>f.split(" "))
    val intermediate_rdd2 = intermediate_rdd1.filter(f=>{!"".equals(f.trim())})
    val intermediate_rdd3= intermediate_rdd2.map(w=>w.toLowerCase())
    val intermediate_rdd4 = intermediate_rdd3.map(w=>(w, 1))
    val reduced_rdd = intermediate_rdd4.reduceByKey((a, b)=>a + b)

    //print out result
    reduced_rdd.coalesce(1).saveAsTextFile("output")
  }
}
