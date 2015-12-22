package com.shekhargulati.adventofcode_2015

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle5 {

  def isNice(input: String): Boolean = {
    hasThreeVowels(input) && hasDuplicate(input) && notString(input)
  }

  def isNice_2(input: String): Boolean = {
    hasDuplicatePair(input) && repeatsOneChar(input)
  }


  def hasDuplicatePair(input: String): Boolean = {
    def d(list: List[String]): Boolean = list match {
      case x :: Nil => false
      case x :: xs => if (xs.tail.contains(x)) true else d(xs)
      case _ => false
    }
    d(input.sliding(2, 1).toList)
  }

  def repeatsOneChar(input: String): Boolean = {
    input.zip(input.substring(1)).zip(input.substring(2)).exists(t => t._1._1 == t._2)
  }

  private def hasThreeVowels(input: String): Boolean = input.filter(ch => "aeiou".contains(ch.toString)).length >= 3

  private def hasDuplicate(input: String): Boolean = input.zip(input.substring(1)).exists(t => t._1 == t._2)

  private def notString(input: String, bad: List[String] = List("ab", "cd", "pq", "xy")) = !bad.exists(input.contains(_))

}
