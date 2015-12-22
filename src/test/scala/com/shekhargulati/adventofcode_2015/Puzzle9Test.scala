package com.shekhargulati.adventofcode_2015

import java.nio.file.Paths

import org.scalatest.{FunSpec, Matchers}

import scala.io.Source

class Puzzle9Test extends FunSpec with Matchers {

  describe("Puzzle 9 Spec") {
    it("should find shortest route") {
      val distance = Puzzle9.shortestDistance(Map(("London", "Dublin") -> 464, ("London", "Belfast") -> 518, ("Dublin", "Belfast") -> 141))
      distance should be(605)
    }

    it("should find shortest distance with real input") {
      val input = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle9.txt").toFile)
        .getLines()
        .map(line => line.trim.split("\\s").filterNot(s => s == "to" || s == "="))
        .map(l => (l(0), l(1)) -> l(2).toInt)
        .toMap

      val distance = Puzzle9.shortestDistance(input)
      distance should be(117)
    }

    it("should find longest distance with real input") {
      val input = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle9.txt").toFile)
        .getLines()
        .map(line => line.trim.split("\\s").filterNot(s => s == "to" || s == "="))
        .map(l => (l(0), l(1)) -> l(2).toInt)
        .toMap

      val distance = Puzzle9.longestDistance(input)
      distance should be(909)
    }
  }

}