val name:Option[String]=Some("Abhishek")

name.get

val anotherName :Option[String]=None

anotherName.getOrElse("Meeral")

anotherName.getOrElse(1)

anotherName.fold("Meeral")(_.toLowerCase)

val nameOption =anotherName.map(elem=>println(elem))

val arr=Array(1,2,3,4)

