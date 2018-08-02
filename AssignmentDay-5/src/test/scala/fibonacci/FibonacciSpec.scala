package fibonacci

import org.scalatest.{FunSuite, MustMatchers}

class FibonacciSpec extends FunSuite with MustMatchers {

  val testfib = new Fibonacci

  test("when limit is greater than 2") {
    val actualResult = testfib.fibonacciMetod(7)
    val expectedResult = println("0 1 1 2 3 5 8")
    actualResult must equal(expectedResult)

  }

  test("when limit is 0") {
    val actualResult = testfib.fibonacciMetod(0)
    val expectedResult = println("Invalid number")
    actualResult must equal(expectedResult)


  }


  test("limit 2") {
    val actualResult = testfib.fibonacciMetod(2)
    val expectedResult = println("0 1 ")
    actualResult must equal(expectedResult)

  }
  test("-1") {
    val actualResult = testfib.fibonacciMetod(0)
    val expectedResult = println("Invalid number")
    actualResult must equal(expectedResult)

  }
}