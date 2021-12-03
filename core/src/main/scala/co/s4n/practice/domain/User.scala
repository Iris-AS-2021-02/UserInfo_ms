package co.s4n.practice.domain

case class User(
    id: Int,
    name: String,
    cel: String
)

object User {
  def apply(id: Int, name: String, cel: String): User =
    new User(id, name, cel)
}
