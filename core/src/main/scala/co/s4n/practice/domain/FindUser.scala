package co.s4n.practice.domain

import org.mongodb.scala.SingleObservable
import org.mongodb.scala._

class FindUserQ(userAdapter: UserAdapter) {
  def query(id: Int): SingleObservable[Document] = {
    userAdapter.findUser(id)
  }
}
