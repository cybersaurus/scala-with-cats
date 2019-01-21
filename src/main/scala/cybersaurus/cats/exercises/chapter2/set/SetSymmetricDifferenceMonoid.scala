package cybersaurus.cats.exercises.chapter2.set

import cats.Monoid

class SetSymmetricDifferenceMonoid[E] extends SetSymmetricDifferenceSemigroup[E] with Monoid[Set[E]] {
  override def empty: Set[E] = Set.empty[E]
}
