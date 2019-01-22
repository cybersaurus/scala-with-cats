package cybersaurus.cats.exercises.chapter02.adder

import cats.Semigroup

case class Order(totalCost: Double, quantity: Double)

object Order {
  implicit val orderSemigroup = new Semigroup[Order] {
    override def combine(x: Order, y: Order): Order =
      Order(
        x.totalCost + y.totalCost,
        x.quantity + y.quantity
      )
  }
}
