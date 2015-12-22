package com.shekhargulati.adventofcode_2015

import java.nio.file.Paths

import scala.io.Source

object Puzzle8 {

  def main(args: Array[String]) {
    secondPart
  }

  def firstPart: Unit = {
    val lines = Source.fromFile(Paths.get("src", "test", "resources", "puzzle8.txt").toFile).getLines().toList
    val fileContent = lines.mkString("")
    val charsInMem = fileContent.length
    val charCode = fileContent.replaceAll("\\\\x..|\\\\.", "!").length
    println((charsInMem - charCode) + lines.map(l => 2).sum)
  }

  def secondPart: Unit = {
    val lines = Source.fromFile(Paths.get("src", "test", "resources", "puzzle8.txt").toFile).getLines().toList
    var c = 0
    lines.foreach(l => {
      c = c + l.count(_ == '\\') + l.count(_ == '"') + l.length + 2
    })
    val fileContent = lines.mkString("")
    val charsInMem = fileContent.length
    println((c - charsInMem))
  }
}
