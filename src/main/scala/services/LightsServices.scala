package services

import akka.http.scaladsl.client.RequestBuilding.Get
import models.Config
class LightsServices(config: Config) {
  def on: String = {
//    Get("localhost:8089/api")
    print(config.getUrl())
    "Light on"
  }
  def off: String = return "off"

}