package services

import akka.http.scaladsl.client.RequestBuilding.Put
import scala.concurrent.ExecutionContext.Implicits.global
import models.Config

class
LightsServices(config: Config) {
  def on(id: String): String = {
    Put(config.getUrl + "/api/" + config.getToken + "/lights/" + id + "/" + "state", "on:true")
    "Light on"
  }

  def off(id: String): String = {
    Put(config.getUrl + "/api/" + config.getToken + "/lights/" + id + "/" + "state", "on:false")
    "Light off"
  }

}