package com.white7spirit

import com.white7spirit.services.SimpleTestService
import spray.routing.{HttpService, Route}

trait Routes extends HttpService
with SimpleTestService {

  def routes: Route = {
    testService
  }
}
