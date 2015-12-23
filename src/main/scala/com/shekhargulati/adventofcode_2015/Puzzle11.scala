package com.shekhargulati.adventofcode_2015

/**
  * Created by shekhargulati on 23/12/15.
  */
object Puzzle11 {


  def nextPassword(input: String): String = {
    val increment1: String = increment(input)
    if (isValidPassword(increment1)) increment1 else nextPassword(increment(increment1))
  }

  def increment(input: String): String = {
    val next_char = getNextCharacter(input.reverse.head)
    if (next_char == 'a') {
      increment(input.init.mkString("")) + 'a'
    } else {
      input.init.mkString("") + next_char
    }
  }

  val A = 97

  def getNextCharacter(c: Char): Char = {
    val base_num = c.toInt - A + 1
    ((base_num % 26) + A).toChar
  }


  def isValidPassword(password: String): Boolean = shouldNotContain(password, List('l', 'o', 'i')) && shouldBeStraightLetters(password, 3) && shouldContainAtleastTwoNonOverlappingPairs(password)

  def shouldBeStraightLetters(password: String, count: Int): Boolean = password.toCharArray.sliding(3).exists(t => t(0) + 1 == t(1) && t(1) + 1 == t(2))

  def shouldNotContain(password: String, chars: List[Char]): Boolean = !password.toCharArray.exists(p => chars.contains(p))

  def shouldContainAtleastTwoNonOverlappingPairs(password: String): Boolean = {
    def r(sliding: List[String], result: Int): Int = sliding match {
      case x :: Nil => {
        //        println(s"first $x")
        if (x(0) == x(1)) result + 1 else result
      }
      case x :: xs if x != xs.head => {
        //        println(s"second $x")
        if (x(0) == x(1)) r(xs, result + 1) else r(xs, result)
      }
      case x :: xs => {
        //        println(s"third $x")
        r(xs, result)
      }
      case _ => result
    }
    r(password.sliding(2).toList, 0) >= 2
  }


  //    .count(s => if (s.length < 2) false else s(0) == s(1)) >= 2

}
