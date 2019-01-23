package cybersaurus.cats.exercises.chapter04.eval

import cats.Eval

trait Foldable {
  @deprecated(message="Impl to be improve in foldRight, using Eval")
  def stackUnsafeFoldRight[A, B](as: List[A], acc: B)(fn: (A, B) => B): B = as match {
    case Nil          => acc
    case head :: tail => fn(head, stackUnsafeFoldRight(tail, acc)(fn))
  }

  def foldRight[A, B](as: List[A], acc: B)(fn: (A, B) => B): B = {

    // As foldRight signature, but with each B replaced by Eval[B].
    def foldRightEval[A, B](as: List[A], evalAcc: Eval[B])(fnEval: (A, Eval[B]) => Eval[B]): Eval[B] = as match {
      case Nil          => evalAcc
      case head :: tail => Eval.defer(
        fnEval(head, foldRightEval(tail, evalAcc){fnEval})
      )
    }

    foldRightEval(as, Eval.now(acc)){ (a, evalB) => evalB.map(b => fn(a,b)) }.value
  }
}
