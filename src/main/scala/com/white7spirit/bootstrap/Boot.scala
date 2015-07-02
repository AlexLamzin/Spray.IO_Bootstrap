package com.white7spirit.bootstrap

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http

object Boot extends App {

  import com.white7spirit.Configs._

  implicit val timeout = Timeout(defaultTimeout)
  implicit val system = ActorSystem(actorSystemName)

  val service = system.actorOf(Props[MainActor], serviceName)

  IO(Http) ? Http.Bind(service, interface, port)
}
