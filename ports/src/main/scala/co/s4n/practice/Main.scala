package co.s4n.practice

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import co.s4n.practice.controller.UserController
//import org.mongodb.scala._

object Main extends App {
  ///-----DB
  //@SuppressWarnings(Array("org.wartremover.warts.NonUnitStatements"))
  /*val uri =
    "mongodb+srv://root:2021@cluster0.4h8bp.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"
  //System.setProperty("org.mongodb.async.type", "netty")
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("test")*/
  //================================================
  val UserControllerService = new UserController
  val routes = UserControllerService.routeMap
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()

  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)
  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
}
