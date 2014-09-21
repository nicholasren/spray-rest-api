package com.example

import akka.actor.Actor
import spray.routing._
import scala.concurrent.ExecutionContext

//the actor which will accept request and distribute to other actors/objects
class MyServiceActor(userRepo: UserRepository) extends Actor with MyService {

  def actorRefFactory = context

  def receive = runRoute(myRoute)

  override val userRepository: UserRepository = userRepo
}

// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {
  implicit val ec: ExecutionContext = actorRefFactory.dispatcher
  val userRepository: UserRepository

  val myRoute =
    path("users" / Segment) {
      userId => {
        get {
          complete {
            //must import SprayJsonSupport to get a json mashaller
            import spray.httpx.SprayJsonSupport._
            userRepository fetch userId
          }
        }
      }
    }
}