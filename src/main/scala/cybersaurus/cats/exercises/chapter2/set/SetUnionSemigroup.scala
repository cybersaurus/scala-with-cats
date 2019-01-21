package cybersaurus.cats.exercises.chapter2.set

import cats.Semigroup

class SetUnionSemigroup[E] extends Semigroup[Set[E]] {
  override def combine(x: Set[E], y: Set[E]): Set[E] = x ++ y
}
