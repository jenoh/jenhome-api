package models

class Config(val _url: String, val _token: String) {

  def getUrl(): String = {
    return _url
  }

  def getToken(): String = {
    return _token
  }
}