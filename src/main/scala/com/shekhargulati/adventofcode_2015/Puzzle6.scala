package com.shekhargulati.adventofcode_2015

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle6 {

  val state = Array.fill[Boolean](1000, 1000)(false)


  def lightCount(instruction: String): Int = {
    runInstr(instruction)

    state.map(row => row.count(_ == true)).sum
  }

  def runInstr(instruction: String): Unit = {
    val tokens = instruction.split("\\s")

    tokens.take(2) match {
      case Array("turn", "on") => turnOn(tokens(2).split(",").map(_.toInt), tokens(4).split(",").map(_.toInt))
      case Array("turn", "off") => turnOff(tokens(2).split(",").map(_.toInt), tokens(4).split(",").map(_.toInt))
      case _ => toggle(tokens(1).split(",").map(_.toInt), tokens(3).split(",").map(_.toInt))
    }
  }

  def turnOn(first: Array[Int], second: Array[Int]) = first(0) to second(0) foreach (row => first(1) to second(1) foreach (col => state(row)(col) = true))

  def toggle(first: Array[Int], second: Array[Int]) = {
    println(s"${first(0)} >> ${first(1)}")
    println(s"${second(0)} >> ${second(1)}")
    first(0) to second(0) foreach (row => first(1) to second(1) foreach (col => state(row)(col) = !state(row)(col)))
  }

  def turnOff(first: Array[Int], second: Array[Int]) = first(0) to second(0) foreach (row => first(1) to second(1) foreach (col => state(row)(col) = false))

}
