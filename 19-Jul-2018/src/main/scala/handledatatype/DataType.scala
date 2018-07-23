package handledatatype

class DataType {
  def returnType(variable: Any): String = {
    variable match {
      case s: String => s"You gave me this string: $s"
      case i: Int => s"thanks for the int: $i"
      case a: Array[Int] => s"an array of int :${a.mkString(",")}"
      case as: Array[String] => s"an array of String :${as.mkString(",")}"
      case list: List[_] => s"thanks for the  List: ${list.toString()}"
      case m: Map[_, _] => s"thanks for the map ${m.toString}"
    }
  }
}
