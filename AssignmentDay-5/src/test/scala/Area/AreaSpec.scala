package Area
import org.scalatest.{BeforeAndAfter, FunSuite, MustMatchers}

class AreaSpecs extends FunSuite with MustMatchers with BeforeAndAfter{


  val testArea = new Area

  test("when sides are positive"){
    val actualResult = testArea.area("rectangle",5,4,(a,b)=> a*b)
    val expectedResult = "Area of rectangle is 20"
    actualResult must equal(expectedResult)
  }

  test("when one side is negative"){
    val actualResult = testArea.area("rectangle",-5,4,(a,b)=> a*b)
    val expectedResult = "Invalid Parameters"
    actualResult must equal(expectedResult)
  }

  test("when two side are negative"){
    val actualResult = testArea.area("rectangle",-5,-4,(a,b)=> a*b)
    val expectedResult = "Invalid Parameters"
    actualResult must equal(expectedResult)
  }

  test("For the shape rhombus"){
    val actualResult = testArea.area("rhombus",5,4,(a,b)=> a*b)
    val expectedResult = "Area of rhombus is 20"
    actualResult must equal(expectedResult)
  }

  test("For the shape parallelogram"){
    val actualResult = testArea.area("parallelogram",5,4,(a,b)=> a*b)
    val expectedResult = "Area of parallelogram is 20"
    actualResult must equal(expectedResult)
  }

  test("For the shape square"){
    val actualResult = testArea.area("square",5,4,(a,b)=> a*b)
    val expectedResult = "Not defined yet for square"
    actualResult must equal(expectedResult)
  }
}
