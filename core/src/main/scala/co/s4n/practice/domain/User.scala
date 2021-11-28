package co.s4n.practice.domain

case class User(
    id: Int,
    name: String,
    email: String
)

object User {
  def apply(id: Int, name: String, email: String): User =
    new User(id, name, email)
}
