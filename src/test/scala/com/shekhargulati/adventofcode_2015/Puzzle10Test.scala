package com.shekhargulati.adventofcode_2015

import org.scalatest.{FunSpec, Matchers}

class Puzzle10Test extends FunSpec with Matchers {

  describe("Puzzle 10 Spec") {
    it("should say 1 as 11") {
      val result = Puzzle10.lookAndSay1("1")
      result should be("11")
    }

    it("should say 11 as 21") {
      val result = Puzzle10.lookAndSay1("11")
      result should be("21")
    }

    it("should say 21 as 1211") {
      val result = Puzzle10.lookAndSay1("21")
      result should be("1211")
    }

    it("should say 1211 as 111221") {
      val result = Puzzle10.lookAndSay1("1211")
      result should be("111221")
    }

    it("should say 111221 as 312211") {
      val result = Puzzle10.lookAndSay1("111221")
      result should be("312211")
    }


    it("should say 3113322113 as X") {
      var result = "3113322113"
      1 to 50 foreach(i => result = Puzzle10.lookAndSay1(result))
      result.length should be("X")
    }
  }

}