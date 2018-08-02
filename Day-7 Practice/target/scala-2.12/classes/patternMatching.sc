

/*def reverse(l: List[Int]): List[Int] =
  l match
  {
  case x :: tail => reverse(tail) ::: List(x)
  case Nil => Nil
}


val l=List(1,2,3,4,5,6,7,8,9)

reverse(l)


l.tail


l.head




def reverseAgain(l: List[Int]): List[Int] =
l match
{
  case l.tail:::l.head=>reverseAgain(l.tail)
  case Nil=>Nil
}
val l=List(1,2,3,4,5,6,7,8,9)

reverseAgain(l)
*/


val l = List(5,4,7,6,7,8,9,7,897)

def findMax(l: List[Int]):Int= {
  l match {
    case Nil=>sys.exit
    case x :: tail => if (tail.isEmpty) x else if (x > findMax(tail)) x else findMax(tail)
  }
}
findMax(l)
/*
def findLength(l:List[Int]):Int={
  l match {
    case Nil=>0
    case _=>findLength(l.tail)+1
  }
}
findLength(l)


*/



  def nth(num: Int, l: List[Int]): Int =
    num match {
    case 0 => l.head
    case _ => nth(num-1, l.drop(1))
  }
nth(1,l)



