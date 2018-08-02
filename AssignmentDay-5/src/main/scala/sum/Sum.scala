package sum


class Sum {
  def sum(num1: Double, num2: Double, f: (Double, Double) => Double) = {
    f(num1, num2)
  }

  def sumInts(a: Double, b: Double): Double = a + b

  def sumSquares(a: Double, b: Double): Double = (a * a) + (b * b)

  def sumCubes(a: Double, b: Double): Double = (a * a * a) + (b * b * b)
}