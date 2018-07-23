package handledatatype

import org.scalatest._

class DataTypeSpec extends FunSuite with MustMatchers {
  val testDataType = new DataType
  test("Input Any number") {
    val actualResult = testDataType.returnType(12)
    val expectedResult = "thanks for the int: 12"
    actualResult must equal(expectedResult)

  }
  test("Input Any String") {
    val actualResult = testDataType.returnType("Hi")
    val expectedResult = "You gave me this string: Hi"
    actualResult must equal(expectedResult)

  }

  test("Input Any Integer Array") {
    val actualResult = testDataType.returnType(Array(1, 2, 3, 4, 5))
    val expectedResult = "an array of int :1,2,3,4,5"
    actualResult must equal(expectedResult)

  }
  test("Input Any String Array") {
    val actualResult = testDataType.returnType(Array("Avi", "Rishu", "Sid"))
    val expectedResult = "an array of String :Avi,Rishu,Sid"
    actualResult must equal(expectedResult)

  }

  test("Input Any List") {
    val actualResult = testDataType.returnType(List("Avi", 1, "Sid"))
    val expectedResult = "thanks for the  List: List(Avi, 1, Sid)"
    actualResult must equal(expectedResult)
  }

  test("Input Any Map") {
    val actualResult = testDataType.returnType(Map(1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5))
    val expectedResult = "thanks for the map Map(1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5)"
    actualResult must equal(expectedResult)
  }
}
