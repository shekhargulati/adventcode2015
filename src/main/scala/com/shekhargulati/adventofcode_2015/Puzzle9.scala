package com.shekhargulati.adventofcode_2015

/**
  * Created by shekhargulati on 22/12/15.
  */
object Puzzle9 {

  def shortestDistance(routes: Map[(String, String), Int]): Int = {
    distances(routes).sorted.head
  }

  def longestDistance(routes: Map[(String, String), Int]): Int = {
    distances(routes).sorted.last
  }

  def distances(routes: Map[(String, String), Int]) = {
    val keySet: Set[(String, String)] = routes.keySet
    val locations = keySet.flatMap(t => List(t._1, t._2))
    val possibleRoutes = locations.toList.permutations.toList
    val distances = possibleRoutes.map(route => route.sliding(2).map(l => (l(0), l(1))).map(t => {
      routes.getOrElse(t, routes(t.swap))
    }).sum)
    println(distances)
    distances
  }
}
