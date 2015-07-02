package com.white7spirit.bootstrap

import com.white7spirit.Routes
import spray.http.{HttpRequest, HttpResponse, StatusCodes, Timedout}
import spray.routing.HttpServiceActor

class MainActor extends HttpServiceActor with Routes {

  override def actorRefFactory = context

  def receive = handleTimeouts orElse runRoute(routes)

  def handleTimeouts: Receive = {
    case Timedout(x: HttpRequest) =>
      sender ! HttpResponse(
        StatusCodes.InternalServerError,
        "Request time out."
      )
  }
}