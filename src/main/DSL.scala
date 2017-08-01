import cats.free.{Free, Inject}


object DSL {

  class ActionOps[F[_]](implicit A: Inject[Actions, F]) {

    def findUser(name: String): Free[F, User] = Free.inject[Actions, F](FindUser(name))

  }

  object ActionOps {
    implicit def actionOps[F[_]](implicit I: Inject[Actions, F]): ActionOps[F] =
      new ActionOps[F]
  }

}
