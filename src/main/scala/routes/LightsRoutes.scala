package routes

import akka.http.scaladsl.server.Directives.{complete, path}
import akka.http.scaladsl.server.{Directives, Route}
import services.LightsServices

class LightsRoutes(lightsServices: LightsServices) {
  def route: Route = path("tutorials") {
    Directives.get {
      complete(lightsServices.on)
    }
  }
}