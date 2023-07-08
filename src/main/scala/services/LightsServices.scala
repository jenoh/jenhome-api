package services
import akka.http.scaladsl.client.RequestBuilding.Put
import akka.http.scaladsl.model.HttpEntity.LastChunk.data
import models.Config

class LightsServices(config: Config) {
  def on: String = {
//    val reqJs = Json.obj("PARAMS" -> Json.obj("param1" -> value1))
    Put(config.getUrl + "/api/" + config.getToken + "/lights/1/" + "state",data = Map("key" -> "value"))
//    print(config.getUrl)
    "Light on"
  }

  def off: String = return "off"

}