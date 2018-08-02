package com.acme.app {
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }
}


object Main extends App {
  import com.acme.app.Margin._
  // use an enumeration value in a test
  var currentMargin = TOP
  // later in the code ...
  if (currentMargin == TOP) println("working on Top")
  // print all the enumeration values
  import com.acme.app.Margin
  Margin.values foreach println
}