package co.s4n.practice.domain

import org.mongodb.scala.SingleObservable
import org.mongodb.scala._
import com.mongodb.client.result.UpdateResult

class UpdateUserQ2(userAdapter: UserAdapter) {
  def query(user: User): SingleObservable[UpdateResult] = {
    userAdapter.updateUser2(user)
  }
}
