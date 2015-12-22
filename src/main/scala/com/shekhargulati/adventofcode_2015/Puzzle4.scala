package com.shekhargulati.adventofcode_2015

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle4 {

  def mine(input: String): Long = {
    var i = 0L
    while (!MD5Digest.md5(s"$input$i").startsWith("000000")) {
      i = i + 1
    }
    i
  }


}
