package com.white7spirit.services

import spray.http.MediaTypes._
import spray.routing.HttpService

trait SimpleTestService extends HttpService {
  val testService =
    path("test") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            s"Hello World"
          }
        }
      }
    } ~
      path("test" / IntNumber) { id =>
        get {
          respondWithMediaType(`text/html`) {
            complete {
              s"Hello World, my id is a $id"
            }
          }
        }
      }
}
