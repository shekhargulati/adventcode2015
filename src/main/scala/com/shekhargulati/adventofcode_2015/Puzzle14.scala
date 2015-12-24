package com.shekhargulati.adventofcode_2015

/**
  * Created by shekhargulati on 24/12/15.
  */
object Puzzle14 {


  def main(args: Array[String]) {

  }


  def totalTime(flightTime: Int, restTime: Int, speed: Int): Int = {
    var skipStart = flightTime + 1
    var skipEnd = flightTime + restTime

    val totalDistance = (1 to 2503).filter(i => {
      if (skipStart to skipEnd contains i) {
        false
      } else {
        if (i == (skipEnd + 1)) {
          skipStart = skipEnd + flightTime + 1
          skipEnd = (skipStart - 1) + restTime
        }
        true
      }
    }).map(_ => {
      speed
    }).sum

    totalDistance

  }

}
