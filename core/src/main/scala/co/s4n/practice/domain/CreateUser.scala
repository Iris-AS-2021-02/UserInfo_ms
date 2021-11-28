package co.s4n.practice.domain

import monix.eval.Task

class CreateUserQ(userAdapter: UserAdapter) {
  def query(user: User): Task[List[User]] = {
    userAdapter.createUser(user)
  }
}
