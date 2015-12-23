package com.shekhargulati.adventofcode_2015

import scala.annotation.tailrec
import scala.util.matching.Regex.Match

/**
  * Created by shekhargulati on 23/12/15.
  */
object Puzzle12 {

  def sum(input: String): Int = {
    val pattern = """(-?\d+)""".r
    val it: Iterator[Match] = pattern.findAllMatchIn(input)
    it.map(m => m.group(1).toInt).sum
  }


  import spray.json._

  def sum1(input: String): Int = {
    var sum = 0
    val json: JsValue = input.parseJson
    json match {
      case x: JsArray => {
        sum = sum + parseJsArray(x)
      }
      case x: JsObject => {
        sum = sum + parseJsObject(x)
      }
      case _ => throw new IllegalArgumentException("unsupported")
    }
    sum
  }

  def parseJsArray(arr: JsArray): Int = {
    @tailrec
    def parR(list: List[JsValue], result: Int): Int = list match {
      case (x: JsNumber) :: xs => parR(xs, result + x.value.toInt)
      case (x: JsObject) :: xs => parR(xs, result + parseJsObject(x))
      case (x: JsArray) :: xs => parR(xs, result + parseJsArray(x))
      case (x: JsString) :: xs => parR(xs, result)
      case _ => result
    }
    parR(arr.elements.toList, 0)
  }

  def parseJsObject(obj: JsObject): Int = {
    if (obj.fields.values.exists(_ == JsString("red")))
      0
    else {
      @tailrec
      def parR(list: List[(String, JsValue)], result: Int): Int = list match {
        case (_, x: JsNumber) :: xs => parR(xs, result + x.value.toInt)
        case (_, x: JsArray) :: xs => parR(xs, result + parseJsArray(x))
        case (_, x: JsObject) :: xs => parR(xs, result + parseJsObject(x))
        case (_, x: JsString) :: xs => parR(xs, result)
        case x => result
      }
      parR(obj.fields.toList, 0)

    }


  }

}

