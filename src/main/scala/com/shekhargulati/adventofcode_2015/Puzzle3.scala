package com.shekhargulati.adventofcode_2015

import scala.annotation.tailrec

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle3 {

  def houseReceivePresent(instruction: String): Int = {
    @tailrec
    def rec(input: List[String], pos: (Int, Int), result: List[(Int, Int)]): List[(Int, Int)] = input match {
      case "^" :: xs => rec(xs, (pos._1 + 1, pos._2), (pos._1 + 1, pos._2) +: result)
      case "v" :: xs => rec(xs, (pos._1 - 1, pos._2), (pos._1 - 1, pos._2) +: result)
      case ">" :: xs => rec(xs, (pos._1, pos._2 + 1), (pos._1, pos._2 + 1) +: result)
      case "<" :: xs => rec(xs, (pos._1, pos._2 - 1), (pos._1, pos._2 - 1) +: result)
      case _ => result
    }

    val allHouses = rec(instruction.split("").toList, (0, 0), List((0, 0)))
    println(allHouses)
    allHouses.distinct.size
  }


  def houseReceivePresent2(instruction: String): Int = {
    @tailrec
    def rec(input: List[String], santaPos: (Int, Int), bantaPos: (Int, Int), isSanta: Boolean, result: List[(Int, Int)]): List[(Int, Int)] = input match {
      case "^" :: xs => {
        if (isSanta)
          rec(xs, (santaPos._1 + 1, santaPos._2), bantaPos, false, (santaPos._1 + 1, santaPos._2) +: result)
        else
          rec(xs, santaPos, (bantaPos._1 + 1, bantaPos._2), true, (bantaPos._1 + 1, bantaPos._2) +: result)
      }
      case "v" :: xs => {
        if (isSanta)
          rec(xs, (santaPos._1 - 1, santaPos._2), bantaPos, false, (santaPos._1 - 1, santaPos._2) +: result)
        else
          rec(xs, santaPos, (bantaPos._1 - 1, bantaPos._2), true, (bantaPos._1 - 1, bantaPos._2) +: result)
      }
      case ">" :: xs => {
        if (isSanta)
          rec(xs, (santaPos._1, santaPos._2 + 1), bantaPos, false, (santaPos._1, santaPos._2 + 1) +: result)
        else
          rec(xs, santaPos, (bantaPos._1, bantaPos._2 + 1), true, (bantaPos._1, bantaPos._2 + 1) +: result)
      }
      case "<" :: xs => {
        if (isSanta)
          rec(xs, (santaPos._1, santaPos._2 - 1), bantaPos, false, (santaPos._1, santaPos._2 - 1) +: result)
        else
          rec(xs, santaPos, (bantaPos._1, bantaPos._2 - 1), true, (bantaPos._1, bantaPos._2 - 1) +: result)
      }
      case _ => result
    }

    val allHouses = rec(instruction.split("").toList, (0, 0), (0, 0), true, List((0, 0)))
    println(allHouses)
    allHouses.distinct.size
  }

}
