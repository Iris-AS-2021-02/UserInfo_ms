package co.s4n.practice.domain

import cats.data.EitherT
import monix.eval.Task

class FindUserQ(userAdapter: UserAdapter) {
  def query(id: Int): EitherT[Task, Int, User] = {
    userAdapter.findUser(id)
  }
}
