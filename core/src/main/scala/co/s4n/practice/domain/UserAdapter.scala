package co.s4n.practice.domain

import cats.data.EitherT
import monix.eval.Task

trait UserAdapter {
  def findUser(userId: Int): EitherT[Task, Int, User]
  def allUsers(): Task[List[User]]
  def createUser(user: User): Task[List[User]]
}
