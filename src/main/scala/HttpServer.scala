import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{complete, path}
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn


object HttpServer {

  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SprayExample")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  def route: Route = path("tutorials") {    Directives.get {      complete("all tutorials")    }  }

  def main(args: Array[String]): Unit = {

    val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}