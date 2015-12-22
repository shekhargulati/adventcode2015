package com.shekhargulati.adventofcode_2015

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle10 {

  def lookAndSay(input: String): String = {
    @tailrec
    def runLength(list: List[String], result: List[(Int, String)]): List[(Int, String)] = list match {
      case x :: xs =>
        runLength(xs.dropWhile(_ == x), result ++ List((xs.takeWhile(_ == x).size + 1, x)))
      case _ => result
    }


    val rl: List[(Int, String)] = runLength(input.split("").toList, List())
    rl.map(t => t._1 + t._2).mkString("")
  }


  def lookAndSay1(input: String): String = {
    val resultBuffer = ListBuffer[(Int, String)]()
    @tailrec
    def runLength(list: List[String]): Unit = list match {
      case x :: xs =>
        resultBuffer.append((xs.takeWhile(_ == x).size + 1, x))
        runLength(xs.dropWhile(_ == x))
      case _ =>
    }


    runLength(input.split("").toList)
    resultBuffer.map(t => t._1 + t._2).mkString("")

  }



}
