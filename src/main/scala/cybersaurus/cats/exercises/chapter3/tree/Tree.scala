package cybersaurus.cats.exercises.chapter3.tree

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A],
                           right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]