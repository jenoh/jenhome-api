package routes

import akka.http.scaladsl.server.Directives.{complete, path, pathPrefix}
import akka.http.scaladsl.server.{Directives, Route}
import services.LightsServices

class LightsRoutes(lightsServices: LightsServices) {
  def route: Route = pathPrefix("lights") {
    Directives.concat(
      path("on") {
        Directives.put {
          complete(lightsServices.on)
        }
      },
      path("off") {
        Directives.put {
          complete(lightsServices.off)
        }
      })
  }
}