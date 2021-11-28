package co.s4n.practice.adapter

import akka.actor.ActorSystem
import co.s4n.practice.domain._
import co.s4n.practice.repository.{UserRepository}
import cats.data.EitherT
import monix.eval.Task

class UserAdapterImp extends UserAdapter {
  implicit val system = ActorSystem()
  implicit val executionContext = system.dispatcher
  val userRepository = new UserRepository()

  override def allUsers(): Task[List[User]] = {
    userRepository.allUsers()
  }

  override def findUser(id: Int): EitherT[Task, Int, User] = {
    userRepository.findUser(id)
  }

  override def createUser(user: User): Task[List[User]] = {
    userRepository.createUser(user)
  }
}
