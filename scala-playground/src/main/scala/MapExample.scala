package com.vancone.coding.playground

object MapExample extends App {
  var capitals = Map( "China" -> "Beijing", "France" -> "Paris")
  capitals += ("Japan" -> "Tokyo")
  println(capitals("France"))
}
