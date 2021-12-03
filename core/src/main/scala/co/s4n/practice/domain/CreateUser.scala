package co.s4n.practice.domain

//import monix.eval.Task
import org.mongodb.scala.SingleObservable
import com.mongodb.client.result.InsertOneResult

class CreateUserQ(userAdapter: UserAdapter) {
  def query(user: User): SingleObservable[InsertOneResult] = {
    userAdapter.createUser(user)
  }
}
