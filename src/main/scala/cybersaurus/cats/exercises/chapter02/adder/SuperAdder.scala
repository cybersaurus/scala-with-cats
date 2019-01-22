package cybersaurus.cats.exercises.chapter02.adder

import cats.Semigroup
import cats.syntax.semigroup._

class SuperAdder {
  def add[A: Semigroup](items: List[A]): A = items.reduce(_ |+| _)
}
