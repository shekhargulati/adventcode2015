package com.shekhargulati.adventofcode_2015

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle2 {

  def surfaceArea(l: Int, w: Int, h: Int): Int = (2 * l * w + 2 * w * h + 2 * h * l) + List(l * w, w * h, h * l).min

  def ribbonLength(l: Int, w: Int, h: Int): Int = {
    val smallSides = List(l, w, h).sorted.take(2)
    val wrapPresent = smallSides(0) + smallSides(0) + smallSides(1) + smallSides(1)
    val bow = l * w * h
    wrapPresent + bow
  }

}
