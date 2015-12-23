package com.shekhargulati.adventofcode_2015

import java.nio.file.Paths

import org.scalatest.{FunSpec, Matchers}

import scala.io.Source

class Puzzle12Test extends FunSpec with Matchers {

  describe("Puzzle 12 Spec") {
    it("should sum all numbers 1") {
      val sum = Puzzle12.sum("[1,2,3]")
      sum should be(6)
    }

    it("should sum all numbers 2") {
      val sum = Puzzle12.sum( """{"a":2,"b":4}""")
      sum should be(6)
    }

    it("should sum all numbers 3") {
      val sum = Puzzle12.sum("[[[3]]]")
      sum should be(3)
    }

    it("should sum all numbers 4") {
      val sum = Puzzle12.sum( """{"a":{"b":4},"c":-1}""")
      sum should be(3)
    }

    it("should sum all numbers 5") {
      val sum = Puzzle12.sum( """{"a":[-1,1]}""")
      sum should be(0)
    }

    it("should sum all numbers 6") {
      val sum = Puzzle12.sum( """[-1,{"a":1}]""")
      sum should be(0)
    }

    it("should sum all numbers 7") {
      val sum = Puzzle12.sum( """[]""")
      sum should be(0)
    }

    it("should sum all numbers 8") {
      val sum = Puzzle12.sum( """[]""")
      sum should be(0)
    }

    it("should work with real data") {
      val input = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle12.txt").toFile).mkString

      val sum = Puzzle12.sum(input)
      sum should be(119433)
    }


    it("should parse json 1") {
      val sum = Puzzle12.sum1("[1,2,3]")
      sum should be(6)
    }

    it("should parse json 2") {
      val sum = Puzzle12.sum1( """[1,{"c":"red","b":2},3]""")
      sum should be(4)
    }

    it("should parse json 3") {
      val sum = Puzzle12.sum1( """{"d":"red","e":[1,2,3,4],"f":5}""")
      sum should be(0)
    }

    it("should parse json 4") {
      val sum = Puzzle12.sum1( """[1,"red",5]""")
      sum should be(6)
    }

    it("should work with real data 2") {
      val input = Source
        .fromFile(Paths.get("src", "test", "resources", "puzzle12.txt").toFile).mkString

      val sum = Puzzle12.sum1(input)
      sum should be(68466)
    }


  }


}