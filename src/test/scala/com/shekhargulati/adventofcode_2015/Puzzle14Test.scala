package com.shekhargulati.adventofcode_2015

import org.scalatest.{FunSpec, Matchers}

class Puzzle14Test extends FunSpec with Matchers {

  describe("Puzzle 14 Spec") {
    it("read data") {
      val input =
        """
          |Vixen can fly 8 km/s for 8 seconds, but then must rest for 53 seconds.
          |Blitzen can fly 13 km/s for 4 seconds, but then must rest for 49 seconds.
          |Rudolph can fly 20 km/s for 7 seconds, but then must rest for 132 seconds.
          |Cupid can fly 12 km/s for 4 seconds, but then must rest for 43 seconds.
          |Donner can fly 9 km/s for 5 seconds, but then must rest for 38 seconds.
          |Dasher can fly 10 km/s for 4 seconds, but then must rest for 37 seconds.
          |Comet can fly 3 km/s for 37 seconds, but then must rest for 76 seconds.
          |Prancer can fly 9 km/s for 12 seconds, but then must rest for 97 seconds.
          |Dancer can fly 37 km/s for 1 seconds, but then must rest for 36 seconds.
        """.stripMargin

      val max = input.split("\\n")
        .filterNot(_.trim.isEmpty)
        .map(line => line.split("\\s"))
        .map(ar => {
          println(s"${ar(0)}")
          Puzzle14.totalTime(ar(6).toInt, ar(13).toInt, ar(3).toInt)
        }).max


      println("max >> " + max)

      //      println(Puzzle14.totalTime(10, 127, 14))
    }
  }


}