package co.s4n.practice.controller

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import co.s4n.practice.adapter._
import co.s4n.practice.application.env.Logger
import co.s4n.practice.domain._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import monix.execution.Scheduler.Implicits.global
import io.circe.generic.auto._
import io.circe.syntax._
import scala.util.{Failure, Success}

class UserController extends Logger {

  val userAdapterimp = new UserAdapterImp

  val routeMap: Route = concat {
    concat(
      get {
        path("users") {
          val query = new AllUsersQ(userAdapterimp)
          val userTask = query.query()
          val result = userTask.runToFuture
          onComplete(result) {
            case Success(users) => {
              complete(
                HttpEntity(ContentTypes.`application/json`,
                           users.asJson.noSpaces))
            }
            case Failure(e) => failWith(e)
          }
        }
      },
      get {
        path("user" / LongNumber) {
          id =>
            val query = new FindUserQ(userAdapterimp)
            val userresult = query.query(id.toInt)
            val result = userresult.value
            onComplete(result.runToFuture) {
              case Success(user) => {
                complete(
                  HttpEntity(ContentTypes.`application/json`,
                             user.asJson.noSpaces))
              }
              case Failure(exception) => failWith(exception)
            }
        }
      },
      post {
        path("") {
          entity(as[User]) {
            request =>
              val query = new CreateUserQ(userAdapterimp)
              val queryTask = query.query(request)
              val result = queryTask.runToFuture
              onComplete(result) {
                case Success(users) => {
                  complete(HttpEntity(ContentTypes.`application/json`,
                                      users.asJson.toString()))
                }
                case Failure(exception) => failWith(exception)
              }
          }
        }
      }
    )

  }
}
