package cybersaurus.cats.exercises.chapter2.set

import cats.Monoid

final class SetUnionMonoid[E] extends SetUnionSemigroup[E] with Monoid[Set[E]] {
  override def empty = Set.empty[E]
}
