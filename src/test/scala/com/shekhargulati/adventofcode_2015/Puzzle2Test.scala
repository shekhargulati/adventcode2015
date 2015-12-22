package com.shekhargulati.adventofcode_2015

import java.nio.file.Paths

import org.scalatest.{FunSpec, Matchers}

import scala.io.Source

class Puzzle2Test extends FunSpec with Matchers {

  describe("Puzzle 2 Spec") {
    it("should find surface area") {
      val area1 = Puzzle2.surfaceArea(2, 3, 4)
      area1 should be(58)

      val area2 = Puzzle2.surfaceArea(1, 1, 10)
      area2 should be(43)

      val result = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle2.txt").toFile)
        .getLines()
        .map(line => line.split("x"))
        .map(f => Puzzle2.surfaceArea(f(0).toInt, f(1).toInt, f(2).toInt))
        .sum

      println(result)
    }


    it("should find total ribbon required") {
      val area1 = Puzzle2.ribbonLength(2, 3, 4)
      area1 should be(34)

      val area2 = Puzzle2.ribbonLength(1, 1, 10)
      area2 should be(14)

      val result = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle2.txt").toFile)
        .getLines()
        .map(line => line.split("x"))
        .map(f => Puzzle2.ribbonLength(f(0).toInt, f(1).toInt, f(2).toInt))
        .sum

      println(result)
    }
  }

}