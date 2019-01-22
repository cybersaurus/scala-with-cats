package cybersaurus.cats.exercises.chapter02.set

import cats.Semigroup

// No monoid for set intersection, as there is no `empty` value.
class SetIntersectionSemigroup[E] extends Semigroup[Set[E]] {
  override def combine(x: Set[E], y: Set[E]): Set[E] = x & y
}