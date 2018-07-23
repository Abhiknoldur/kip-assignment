package patternmatch

class ProblemFirst {

  def findMax(l: List[Int]):Int= {
    l match {
      case Nil=>sys.exit
      case x :: tail => if (tail.isEmpty) x else if (x > findMax(tail)) x else findMax(tail)
    }
  }


  def findLength(l:List[Int]):Int={
    l match {
      case Nil=>0
      case _=>findLength(l.tail)+1
    }
  }


  def nth(list: List[Int], n: Int): Int = {
    def tailNth(list: List[Int], n: Int, num: Int): Int = {
      n match {
        case 0 => num
        case _ => tailNth(list.init, n - 1, list.last)
      }
    }

    tailNth(list, n, list.head)
  }

  def findMin(l: List[Int]):Int= {
    l match {
      case Nil=>sys.exit
      case x :: tail => if (tail.isEmpty) x else if (x < findMin(tail)) x else findMin(tail)
    }
  }


}
