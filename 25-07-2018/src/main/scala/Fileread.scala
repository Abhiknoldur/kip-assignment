import java.io.File
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global    //for Excecution context
import scala.util.{Failure,Success}

class Fileread {
  def getListOfFiles(dir: String):Future[String] = Future{
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.toList mkString ","
    } else {
      List[File]() mkString ","
    }
  }
  val o=getListOfFiles("/home/knoldus/Downloads/25-07-2018/src/main/scala/Folder1")

  o.onComplete{
    case Success(res)=>println(res)
    case Failure(ex)=>println(ex.getMessage)
  }
  Thread.sleep(3000)
}
