package cybersaurus.cats.exercises.chapter03.tree

import cats.syntax.functor._ // Ops.map

import org.scalatest.{Matchers, WordSpec}

class TreeFunctorSpec extends WordSpec with Matchers {
  "TreeFunctor" should {
    implicit val testInstance = new TreeFunctor

    "map a Leaf[Int]" in {
      // Need to declare type as Tree here because the functor is Functor[Tree], not Functor[Leaf].
      val leaf: Tree[Int] = Leaf(222)

      leaf.map(_ * 3) shouldBe Leaf(666)
    }

    "map a Branch[Int]" in {
      // Need to declare type as Tree here because the functor is Functor[Tree], not Functor[Branch].
      val branch: Tree[Int] = Branch(Leaf(123), Leaf(456))

      branch.map(_ + 100) shouldBe Branch(Leaf(223), Leaf(556))
    }
  }
}
