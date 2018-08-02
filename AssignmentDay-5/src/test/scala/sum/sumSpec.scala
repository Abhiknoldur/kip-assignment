package sum
import org.scalatest.{FunSuite, MustMatchers}

class SumSpec extends FunSuite with MustMatchers {
  val sum=new Sum
  test("passing two  doubles"){

    val actualResult=sum.sum(2.1,3.9,(a,b)=>a+b)
    val expectedResult= 6.0

    actualResult must equal(expectedResult)
  }
  test("passing a negative double"){

    val actualResult=sum.sumSquares(20.1,13.5)
    val expectedResult= 586.26

    actualResult must equal(expectedResult)
  }
  test("passing a float"){

    val actualResult=sum.sumInts(2f,15)
    val expectedResult= 17.0

    actualResult must equal(expectedResult)
  }
  test("passing a zero"){

    val actualResult=sum.sumCubes(0,6)
    val expectedResult= 216

    actualResult must equal(expectedResult)
  }
  test("passing two large numbers"){

    val actualResult=sum.sumCubes(42838374,1545976)
    val expectedResult= 7.861752116544016E22

    actualResult must equal(expectedResult)
  }

}
