package fibonacci


class Fibonacci {
  def fibonacciMetod(x: Int): Unit = {

    def fib(x: Int, prevnum: Int, nextnum: Int): Unit = {

      if (x <= 0) println("Invalid number") else {

        print(s"$prevnum ")
        x match {
          case 1 => ()
          case _ => fib(x - 1, nextnum, (nextnum + prevnum))
        }

      }

    }
    (fib(x, 0, 1))

  }


}
