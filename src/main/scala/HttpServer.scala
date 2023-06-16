import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{complete, path}
import akka.http.scaladsl.server.{Directives, Route}
import models.Config
import routes.LightsRoutes
import services.LightsServices

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn


object HttpServer {

  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SprayExample")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  def main(args: Array[String]): Unit = {
    val config = new Config(sys.env("url"),sys.env("token"))
    val bindingFuture = Http().newServerAt("localhost", 8080).bind(new LightsRoutes(new LightsServices(config)).route)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}