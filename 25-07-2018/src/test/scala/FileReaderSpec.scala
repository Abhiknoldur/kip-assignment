import org.scalatest.{FunSuite,Matchers}

class FileReaderSpec extends FunSuite with Matchers {
  val FileTest = new Fileread

  test("Input any directory address") {
    val actualResult = FileTest.getListOfFiles("/home/knoldus/Downloads/25-07-2018/src/main/scala/Folder1")
    val expectedResult = List("/home/knoldus/Downloads/25-07-2018/src/main/scala/Folder1/Folder2,/home/knoldus/Downloads/25-07-2018/src/main/scala/Folder1/Folder3,/home/knoldus/Downloads/25-07-2018/src/main/scala/Folder1/file1")
    actualResult should equal(expectedResult)
  }
}
