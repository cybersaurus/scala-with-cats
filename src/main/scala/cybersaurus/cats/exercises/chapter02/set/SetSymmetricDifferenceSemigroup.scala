package cybersaurus.cats.exercises.chapter02.set

import cats.Semigroup

class SetSymmetricDifferenceSemigroup[E] extends Semigroup[Set[E]] {
  override def combine(x: Set[E], y: Set[E]): Set[E] = (x diff y) union (y diff x)
}