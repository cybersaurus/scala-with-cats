package cybersaurus.cats.exercises.chapter01.eq

import cats.Eq
import cybersaurus.cats.exercises.chapter01.Cat

object CatInstances {
  implicit val eqCat: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    cat1.name   == cat2.name &&
    cat1.age    == cat2.age &&
    cat1.colour == cat2.colour
  }
}