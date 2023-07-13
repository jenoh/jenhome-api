package routes

import akka.http.scaladsl.server.Directives.{complete, parameters, path, pathPrefix}
import akka.http.scaladsl.server.{Directives, Route}
import services.LightsServices

class LightsRoutes(lightsServices: LightsServices) {
  def route: Route = pathPrefix("lights") {
    Directives.concat(
      path("on") {
        parameters("id") { (id) =>
          Directives.put {
            complete(lightsServices.on(id))
          }
        }
      },
      path("off") {
        parameters("id") { (id) =>
          Directives.put {
            complete(lightsServices.off(id))
          }
        }
      })
  }
}