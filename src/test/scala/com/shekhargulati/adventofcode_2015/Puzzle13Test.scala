package com.shekhargulati.adventofcode_2015

import org.scalatest.{FunSpec, Matchers}

class Puzzle13Test extends FunSpec with Matchers {

  def toNumber(sign: String, value: String): Int = sign match {
    case "gain" => value.toInt
    case "lose" => -value.toInt
  }

  describe("Puzzle 13") {
    it("should find total hapiness") {
      val input =
        """
          |Alice would gain 54 happiness units by sitting next to Bob.
          |Alice would lose 79 happiness units by sitting next to Carol.
          |Alice would lose 2 happiness units by sitting next to David.
          |Bob would gain 83 happiness units by sitting next to Alice.
          |Bob would lose 7 happiness units by sitting next to Carol.
          |Bob would lose 63 happiness units by sitting next to David.
          |Carol would lose 62 happiness units by sitting next to Alice.
          |Carol would gain 60 happiness units by sitting next to Bob.
          |Carol would gain 55 happiness units by sitting next to David.
          |David would gain 46 happiness units by sitting next to Alice.
          |David would lose 7 happiness units by sitting next to Bob.
          |David would gain 41 happiness units by sitting next to Carol.
        """.stripMargin

      val map: Map[(String, String), Int] = input.split("\\n").filterNot(_.trim.isEmpty).map(line => line.split("\\s")).map(r => ((r(0), r(10).replace(".", "")), toNumber(r(2), r(3)))).toMap

      map.foreach(println)

      val result = Puzzle13.totalHapinessUnit(map)
      result should be(330)
    }
  }

}