case class Person(fName : String,lName : String) {


  def personPrint() = println(s"$fName,$lName")

}
object Person{
  def apply(fName:String)={
    new Person(fName,"Sharma")

  }
}

val per=Person("Abhi")
per.personPrint()
