package com.example

import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat


case class User(name: String, age: Int)
object User {
  implicit def userJsonFormat: RootJsonFormat[User] = jsonFormat2(User.apply)
}
