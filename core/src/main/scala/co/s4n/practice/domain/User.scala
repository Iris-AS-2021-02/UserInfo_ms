package co.s4n.practice.domain

case class User(
    id: Int,
    name: String,
    about: String,
    cel: String
)

object User {
  def apply(id: Int, name: String, about: String, cel: String): User =
    new User(id, name, about, cel)
}
