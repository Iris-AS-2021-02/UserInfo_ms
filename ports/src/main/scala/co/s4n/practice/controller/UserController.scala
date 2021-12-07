package co.s4n.practice.controller

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import co.s4n.practice.adapter._
import co.s4n.practice.application.env.Logger
import co.s4n.practice.domain._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
//import monix.execution.Scheduler.Implicits.global
import io.circe.generic.auto._
import io.circe.syntax._
import scala.util.{Failure, Success}

class UserController extends Logger {

  val userAdapterimp = new UserAdapterImp

  val routeMap: Route = concat {
    concat(
      get {
        path("user" / LongNumber) { id =>
          val query = new FindUserQ(userAdapterimp)
          val userresult = query.query(id.toInt)
          onComplete(userresult.head()) {
            case Success(user) => {
              complete(
                HttpEntity(ContentTypes.`application/json`, user.toJson()))
            }
            case Failure(exception) => failWith(exception)
          }
        }
      },
      post {
        path("users") {
          entity(as[User]) {
            request =>
              val query = new CreateUserQ(userAdapterimp)
              val queryTask = query.query(request)
              val result = queryTask.head()
              onComplete(result) {
                case Success(users) => {
                  complete(HttpEntity(ContentTypes.`application/json`,
                                      request.asJson.noSpaces))
                }
                case Failure(exception) => failWith(exception)
              }
          }
        }
      },
      patch {
        path("userName") {
          entity(as[User]) {
            request =>
              val query = new UpdateUserQ1(userAdapterimp)
              val queryTask = query.query(request)
              val result = queryTask.head()
              onComplete(result) {
                case Success(users) => {
                  complete(HttpEntity(ContentTypes.`application/json`,
                                      request.asJson.noSpaces))
                }
                case Failure(exception) => failWith(exception)
              }
          }
        }
      },
      patch {
        path("userAbout") {
          entity(as[User]) {
            request =>
              val query = new UpdateUserQ2(userAdapterimp)
              val queryTask = query.query(request)
              val result = queryTask.head()
              onComplete(result) {
                case Success(users) => {
                  complete(HttpEntity(ContentTypes.`application/json`,
                                      request.asJson.noSpaces))
                }
                case Failure(exception) => failWith(exception)
              }
          }
        }
      },
      patch {
        path("userCel") {
          entity(as[User]) {
            request =>
              val query = new UpdateUserQ3(userAdapterimp)
              val queryTask = query.query(request)
              val result = queryTask.head()
              onComplete(result) {
                case Success(users) => {
                  complete(HttpEntity(ContentTypes.`application/json`,
                                      request.asJson.noSpaces))
                }
                case Failure(exception) => failWith(exception)
              }
          }
        }
      }
    )

  }
}
