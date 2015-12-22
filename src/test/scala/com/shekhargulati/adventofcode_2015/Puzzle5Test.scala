package com.shekhargulati.adventofcode_2015

import java.nio.file.Paths

import org.scalatest.{FunSpec, Matchers}

import scala.io.Source

class Puzzle5Test extends FunSpec with Matchers {

  describe("Puzzle 5 Spec") {
    it("string is nice when it contains at least three vowels") {
      val nice = Puzzle5.isNice("aaeiou")
      nice should be(true)
    }

    it("string is nice when it contains less than vowels") {
      val nice = Puzzle5.isNice("aae")
      nice should be(true)
    }

    it("check strings") {
      var nice = Puzzle5.isNice("ugknbfddgicrmopn")
      nice should be(true)

      nice = Puzzle5.isNice("aaa")
      nice should be(true)

      nice = Puzzle5.isNice("jchzalrnumimnmhp")
      nice should be(false)

      nice = Puzzle5.isNice("haegwjzuvuyypxyu")
      nice should be(false)

      nice = Puzzle5.isNice("dvszwmarrgswjxmb")
      nice should be(false)


      val result = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle5.txt").toFile)
        .getLines()
        .filter(line => Puzzle5.isNice_2(line.trim))
        .length

      println(result)

    }

    it("has duplicate pairs") {
      var res = Puzzle5.isNice_2("aaa")
      res should be(false)

      res = Puzzle5.isNice_2("xxyxx")
      res should be(true)

      val result = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle5.txt").toFile)
        .getLines()
        .filter(line => Puzzle5.isNice_2(line.trim))
        .length

      println(result)

      res = Puzzle5.isNice_2("uurcxstgmygtbstg")
      res should be(false)

      res = Puzzle5.isNice_2("ieodomkazucvgmuy")
      res should be(false)

    }
  }

}