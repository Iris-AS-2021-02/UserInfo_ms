package co.s4n.practice.adapter

import akka.actor.ActorSystem
import co.s4n.practice.domain._
import co.s4n.practice.repository.{UserRepository}
import org.mongodb.scala.result.InsertOneResult
import org.mongodb.scala._
import com.mongodb.client.result.UpdateResult

class UserAdapterImp extends UserAdapter {
  implicit val system = ActorSystem()
  implicit val executionContext = system.dispatcher
  val userRepository = new UserRepository()

  override def findUser(id: Int): SingleObservable[Document] = {
    userRepository.findUser(id)
  }

  override def createUser(user: User): SingleObservable[InsertOneResult] = {
    userRepository.createUser(user)
  }

  override def updateUser(user: User): SingleObservable[UpdateResult] = {
    userRepository.updateUser(user)
  }
}
