package co.s4n.practice.repository

import cats.data.EitherT
import monix.eval.Task
import co.s4n.practice.domain._

class UserRepository() {
  @SuppressWarnings(Array("org.wartremover.warts.All"))
  var db: List[User] = {
    List(
      User(1, "Nicolas1", "mail1"),
      User(2, "Nicolas2", "mail2")
    )
  }

  def findUser(userId: Int): EitherT[Task, Int, User] = {
    EitherT(
      Task.now {
        val user = db.find(us => us.id == userId)
        user.map(Right(_)).getOrElse(Left(0))
      }
    )
  }

  def allUsers(): Task[List[User]] = {
    Task.now(db)
  }

  def createUser(user: User): Task[List[User]] = {
    Task.now {
      db = db :+ user
      db
    }
  }
}
