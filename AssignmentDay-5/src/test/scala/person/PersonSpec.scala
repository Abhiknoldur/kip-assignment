package person

import org.scalatest.{FunSuite, MustMatchers}


class PersonSpec extends FunSuite with MustMatchers {
  val personobj = new Person("xyz", 55)
  val personobj1 = new Person("xyz", 45)
  val personobj2 = new Person("abc", 14)

  test("comparing personobj with personobj2") {

    val actualResult = personobj > personobj2
    val expectedResult = false

    actualResult must equal(expectedResult)
  }

  test("comparing personobj with personobj1") {

    val actualResult = personobj < personobj1
    val expectedResult = false

    actualResult must equal(expectedResult)
  }

  test("comparing personobj2 with personobj1") {

    val actualResult = personobj2 > personobj1
    val expectedResult = false

    actualResult must equal(expectedResult)
  }

}