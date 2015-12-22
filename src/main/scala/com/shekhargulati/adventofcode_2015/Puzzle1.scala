package com.shekhargulati.adventofcode_2015

import scala.annotation.tailrec

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle1 {

  def floor(instructions: String): Int = {
    var result = 0
    instructions.split("").foreach(i => {
      if (i == "(") result = result + 1
      else if (i == ")") result = result - 1
      else result = result + 0
    })
    result
  }

  def floorPosition(instructions: String): Int = {
    var result = 0
    val ins = instructions.split("").takeWhile(i => {
      if (result == -1) {
        false
      } else {
        if (i == "(") result = result + 1
        else if (i == ")") result = result - 1
        else result = result + 0
        true
      }
    })
    ins.length
  }

  def floorR(instructions: String): Int = {
    @tailrec
    def floor(input: String, result: Int): Int = input.split("").toList match {
      case "(" :: xs => floor(xs.mkString(""), result + 1)
      case ")" :: xs => floor(xs.mkString(""), result - 1)
      case _ => result
    }

    floor(instructions, 0)
  }


}
