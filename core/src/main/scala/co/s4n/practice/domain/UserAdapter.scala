package co.s4n.practice.domain

import org.mongodb.scala.SingleObservable
import com.mongodb.client.result.InsertOneResult
import org.mongodb.scala._

trait UserAdapter {
  def findUser(userId: Int): SingleObservable[Document]
  def createUser(user: User): SingleObservable[InsertOneResult]
}
