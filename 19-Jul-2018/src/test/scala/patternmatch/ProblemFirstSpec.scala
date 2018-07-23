
package patternmatch

import org.scalatest._

class ProblemFirstSpec extends FunSuite with MustMatchers {
  val testPattern = new ProblemFirst
  test("Input a valid random list for maximum element") {
    val actualResult = testPattern.findMax(List(4, 8, 1, 3, 9, 5, 3))
    val expectedResult = 9
    actualResult must equal(expectedResult)
  }

  test("Input a valid random List for length of the list") {
    val actualResult = testPattern.findLength(List(1, 2, 3, 4, 5))
    val expectedResult = 5
    actualResult must equal(expectedResult)
  }


  test("Input a valid list and nth number") {
    val actualResult = testPattern.nth(List(1, 2, 3, 4, 5, 6, 7), 4)
    val expectedResult = 4
    actualResult must equal(expectedResult)
  }


  test("Input a valid random list for minimal element") {
    val actualResult = testPattern.findMin(List(4, 8, 1, 3, 9, 5, 3))
    val expectedResult = 1
    actualResult must equal(expectedResult)
  }
}
