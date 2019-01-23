package cybersaurus.cats.exercises.chapter04

import cats.Id

class IdSimpleMonad[A] extends SimpleMonad[Id] {
  override def pure[A](a: A): Id[A] = a

  override def flatMap[A, B](value: Id[A])(func: A => Id[B]): Id[B] = func(value)

  override def map[A, B](value: Id[A])(func: A => B): Id[B] = func(value)
}
