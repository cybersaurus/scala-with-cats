package cybersaurus.cats.exercises.chapter04.writer

import cats.data.Writer
import cats.instances.vector._

class Factorial {
  def slowly[A](body: => Writer[Vector[String], Int]): Writer[Vector[String], Int] = try body finally Thread.sleep(100)

  def factorial(n: Int): Writer[Vector[String], Int] = {

    val factN = slowly(
      if (n == 0)
        Writer(Vector[String](), 1)
      else
        factorial(n-1).map(_ * n)
    )

    factN.mapWritten(logs => logs :+ s"fact $n ${factN.value}")
  }
}

@deprecated(message = "Example to be fixed above")
class OldFactorial {
  def slowly[A](body: => A):A = try body finally Thread.sleep(100)

  def factorial(n: Int): Int = {
    val ans = slowly(if(n == 0) 1 else n * factorial(n - 1))
    println(s"fact $n $ans")
    ans
  }
}
