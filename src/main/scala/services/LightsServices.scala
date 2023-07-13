package services
import akka.http.scaladsl.client.RequestBuilding.Put
import scala.concurrent.ExecutionContext.Implicits.global
import models.Config

class
LightsServices(config: Config) {
  def on: String = {
    Put(config.getUrl + "/api/" + config.getToken + "/lights/1/" + "state", "on:true")
    "Light on"
  }

  def off: String = {
    Put(config.getUrl + "/api/" + config.getToken + "/lights/1/" + "state", "on:false")
    "Light off"
  }

}