package com.shekhargulati.adventofcode_2015

import java.nio.file.Paths

import org.scalatest.{FunSpec, Matchers}

import scala.io.Source

class Puzzle6Test extends FunSpec with Matchers {

  describe("Puzzle 6") {
    it("should turnon all lights") {
      val count = Puzzle6.lightCount("turn on 0,0 through 999,999")

      count should be(1000000)
    }

    it("should toggle all lights") {
      //      println(Array.fill[Boolean](2, 2)(true).toList.foreach(l => l.foreach(println)))
      val count = Puzzle6.lightCount("toggle 0,0 through 999,0")

      count should be(1000)
    }

    it("turn off") {
      val count = Puzzle6.lightCount("turn off 499,499 through 500,500")

      count should be(1000)
    }

    it("actual test data set") {
      Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle6.txt").toFile)
        .getLines()
        .foreach(line => Puzzle6.runInstr(line.trim))

      val result = Puzzle6.state.map(row => row.count(_ == true)).sum

      println(result)
    }


    it("actual test data set brightness") {
      Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle6.txt").toFile)
        .getLines()
        .foreach(line => Puzzle6_2.runInstr(line.trim))

      var totalBrightness = 0
      val result = Puzzle6_2.state.foreach(row => row.foreach(i => totalBrightness = totalBrightness + i))

      println(totalBrightness)
    }
  }

}