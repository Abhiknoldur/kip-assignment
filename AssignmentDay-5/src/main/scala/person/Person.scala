package person
class Person(val name: String, val age: Int)extends Ordered[Person]{
  def compare(that:Person)={
    if(this.name==that.name)
    {
      this.age-that.age
    }
    else
    {
      this.name.length-that.name.length
    }
  }

  /*def main (args: Array[String] ): Unit = {

    val personOne = new Person("Test", 24)
    val personTwo = new Person("Test", 25)
    println(personOne > personTwo)
  }*/
}

