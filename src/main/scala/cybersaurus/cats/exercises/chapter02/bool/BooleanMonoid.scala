package cybersaurus.cats.exercises.chapter02.bool

import cats.Monoid

final class AndBooleanMonoid extends Monoid[Boolean] {
  override def empty: Boolean = true

  override def combine(x: Boolean, y: Boolean): Boolean = x && y
}

final class OrBooleanMonoid extends Monoid[Boolean] {
  override def empty: Boolean = false

  override def combine(x: Boolean, y: Boolean): Boolean = x || y
}

final class XorBooleanMonoid extends Monoid[Boolean] {
  override def empty: Boolean = false

  override def combine(x: Boolean, y: Boolean): Boolean = x ^ y
}
