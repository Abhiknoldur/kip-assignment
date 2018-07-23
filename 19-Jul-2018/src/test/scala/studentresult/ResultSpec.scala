package studentresult


import org.scalatest.{FunSuite, Matchers}

class ResultSpec extends FunSuite with Matchers {


  val listOfStudents: List[Student] = List(
    Student(1, "Bob", "11", "A"),
    Student(2, "Dab", "10", "C"),
    Student(3, "Tab", "10", "B")
  )
  val listOfStudentsNew: List[Student] = List(
    Student(1, "Bob", "11", "A"),
    Student(2, "Dab", "10", "C"),
  )

  val listOfScoreCard: List[ScoreCard] = List(
    ScoreCard(1, 88.0f, 45.0f, 79.0f),
    ScoreCard(2, 67.0f, 80.0f, 45.0f),
    ScoreCard(3, 99.0f, 87.0f, 85.0f)
  )

  val listOfScoreCardNew: List[ScoreCard] = List(
    ScoreCard(1, 88.0f, 45.0f, 79.0f),
    ScoreCard(2, 67.0f, 80.0f, 45.0f),
  )

  val marksheet = new StudentResult

  test("Top three students in class.") {
    val actualResult = marksheet.topThreeStudents(listOfStudents, listOfScoreCard)
    val expectedResult = List((3, "Tab", "10", "B"), (1, "Bob", "11", "A"), (2, "Dab", "10", "C"))
    actualResult should equal(expectedResult)
  }

  test("Top three students in class when list size is less than 2.") {
    assertThrows[Exception](marksheet.topThreeStudents(listOfStudentsNew, listOfScoreCardNew))
  }

  test(" Subject1 topper") {
    val actualResult = marksheet.subject1Topper(listOfStudents, listOfScoreCard)
    val expectedResult = (3, "Tab", "10", "B", 99.0, 87.0, 85.0, 271.0)
    actualResult should equal(expectedResult)
  }

  test(" Subject2 topper") {
    val actualResult = marksheet.subject1Topper(listOfStudents, listOfScoreCard)
    val expectedResult = (3, "Tab", "10", "B", 99.0, 87.0, 85.0, 271.0)
    actualResult should equal(expectedResult)
  }

  test(" Subject3 topper") {
    val actualResult = marksheet.subject1Topper(listOfStudents, listOfScoreCard)
    val expectedResult = (3, "Tab", "10", "B", 99.0, 87.0, 85.0, 271.0)
    actualResult should equal(expectedResult)
  }

}