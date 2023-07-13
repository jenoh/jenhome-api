package models

class Config(val _url: String, val _token: String) {

  def getUrl: String = {
    _url
  }

  def getToken: String = {
    _token
  }
}