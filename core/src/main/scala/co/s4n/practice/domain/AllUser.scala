package co.s4n.practice.domain

import monix.eval.Task

class AllUsersQ(userAdapter: UserAdapter) {
  def query(): Task[List[User]] = {
    userAdapter.allUsers()
  }
}
