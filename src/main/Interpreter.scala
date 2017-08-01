import cats.{Id, ~>}
import cats.implicits._
import cats.data._

object Interpreter {
  type ConsoleType[A] = Id[A]

  val consoleIntepreter = new (Actions ~> Id) {
    override def apply[A](fa: Actions[A]) = fa match {
      case FindUser(user: String) => User(user)
      case LoginUser(u: User, p: String) => p == u.name
    }
  }

}