package cybersaurus.cats.exercises.chapter03.tree

import cats.Functor

final class TreeFunctor extends Functor[Tree] {
  override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = {
    fa match {
      case Leaf(a)     => Leaf(f(a))
      case Branch(l,r) => Branch(map(l)(f), map(r)(f))
    }
  }
}