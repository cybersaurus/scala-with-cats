package cybersaurus.cats.exercises.chapter1.show

import cats.Show
import cybersaurus.cats.exercises.chapter1.Cat

object CatInstances {
  implicit val showCat = Show.show[Cat] { cat =>
    s"${cat.name} is a ${cat.age} year-old ${cat.colour} cat."
  }
}