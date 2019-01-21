package cybersaurus.cats.exercises.chapter2.adder

import cats.Semigroup
import cats.syntax.semigroup._

class SuperAdder {
  def add[A: Semigroup](items: List[A]): A = items.reduce(_ |+| _)
}
