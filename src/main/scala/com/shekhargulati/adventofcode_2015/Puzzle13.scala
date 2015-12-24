package com.shekhargulati.adventofcode_2015

import scala.collection.mutable.ListBuffer

/**
  * Created by shekhargulati on 23/12/15.
  */
object Puzzle13 {

  def totalHapinessUnit(map: Map[(String, String), Int]): Int = {
    val m = scala.collection.mutable.Map[(String, String), Int]()
    map.foreach {
      case (k, v) =>
        println(k)
        val opp = map.find(_._1 == k.swap).get._2
        m.put(k, opp + v)
    }

    println(m)

    val list = ListBuffer[(String, String)]()
    m.keySet.foreach(k => {
      if (!list.exists(_ == k.swap)) {
        list.append(k)
      }
    })

    println(list.map(t => m(t)))
    list.map(t => m(t)).sum
  }

}
