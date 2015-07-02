package com.white7spirit.services

import akka.actor.ActorRefFactory
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest


class SimpleTestServiceTest extends Specification with Specs2RouteTest with SimpleTestService {
  "The Test service" should {
    "return a 'Hello World' for GET request to the 'test' path " in {
      Get("/test") ~> testService ~> check {
        responseAs[String] === "Hello World"
      }
    }

    "return a 'Hello World, my id is a $id' for GET request to the 'test/IntNumrt path'" in {
      Get("/test/256") ~> testService ~> check {
        responseAs[String] === "Hello World, my id is a 256"
      }
    }
  }

  def actorRefFactory: ActorRefFactory = system
}
