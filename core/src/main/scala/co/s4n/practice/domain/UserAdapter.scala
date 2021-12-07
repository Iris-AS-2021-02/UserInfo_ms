package co.s4n.practice.domain

import org.mongodb.scala.SingleObservable
import com.mongodb.client.result.InsertOneResult
import org.mongodb.scala._
import com.mongodb.client.result.UpdateResult

trait UserAdapter {
  def findUser(userId: Int): SingleObservable[Document]
  def createUser(user: User): SingleObservable[InsertOneResult]
  def updateUser1(user: User): SingleObservable[UpdateResult]
  def updateUser2(user: User): SingleObservable[UpdateResult]
  def updateUser3(user: User): SingleObservable[UpdateResult]
}
