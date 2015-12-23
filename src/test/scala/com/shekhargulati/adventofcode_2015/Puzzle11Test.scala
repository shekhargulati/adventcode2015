package com.shekhargulati.adventofcode_2015

import org.scalatest.{FunSpec, Matchers}

class Puzzle11Test extends FunSpec with Matchers {

  describe("Puzzle 11 Spec") {
    it("should contain one increasing straight of at least three letters") {
      val valid = Puzzle11.isValidPassword("abcd[ea]aa")
      valid should be(true)
    }

    it("should not contain i,o,or,l chars") {
      val valid = Puzzle11.isValidPassword("hijklmmn")
      valid should be(false)
    }

    it("should contain two different, non-overlapping pairs") {
//      var valid = Puzzle11.shouldContainAtleastTwoNonOverlappingPairs("abcdefaa")
//      valid should be(false)
//
//      valid = Puzzle11.shouldContainAtleastTwoNonOverlappingPairs("aaa")
//      valid should be(false)
//
//      valid = Puzzle11.shouldContainAtleastTwoNonOverlappingPairs("abcdeaaa")
//      valid should be(false)
//
//      valid = Puzzle11.shouldContainAtleastTwoNonOverlappingPairs("abbceffg")
//      valid should be(true)

      var valid = Puzzle11.shouldContainAtleastTwoNonOverlappingPairs("abcdffaa")
      valid should be(true)

    }
    it("should contain two different, non-overlapping pairs of letters") {
      var valid = Puzzle11.isValidPassword("abccefjk")
      valid should be(false)


      valid = Puzzle11.isValidPassword("abbcegjk")
      valid should be(false)


      valid = Puzzle11.isValidPassword("abbceffg")
      valid should be(false)

      valid = Puzzle11.isValidPassword("abcdeaaa")
      valid should be(false)

    }

    it("should increment password") {
      val input: String = "hxbxxyzz"
      val nextPassword = Puzzle11.nextPassword(input)
      nextPassword should be("hxcaabcc")
    }
  }

}