package co.s4n.practice

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import co.s4n.practice.controller.UserController

object Main extends App {

  val UserControllerService = new UserController
  val routes = UserControllerService.routeMap
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()

  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)
  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
}
