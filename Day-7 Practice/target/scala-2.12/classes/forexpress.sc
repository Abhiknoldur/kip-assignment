val list: List[Int] = List(1, 2, 3, 4, 5, 6)
list.headOption

val list2: List[Int] = List(7, 8, 9, 1, 2, 3)


list.flatMap(l1 =>
  list2.map(l2 =>
    l1 + l2
  )
)

for {
  l1 <- list
  l2 <- list2
  if l1 >= 5
} yield l1 + l2


for {
  l1 <- list

} yield incre(l1)
val persons = List(
  Person("fhhjghk", true),
  Person("Abi", false)
)
val x: Option[String] = None

def incre(List: Int) = List + 1

for {
  person <- persons
  name = person.Name

  if (person.IsActive)
} yield "I'm " + name

@deprecated("My message", "sdfg")
def sing: Unit = println("Sing")

case class Person(Name: String, IsActive: Boolean)


x match {
  case Some(test) => println(test)
  case _ => println("Something")
}