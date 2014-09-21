package com.example

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import scala.concurrent.future
import org.mockito.Mockito._
import org.mockito.Matchers._
import org.specs2.specification.BeforeExample

class MyServiceSpec extends Specification with Specs2RouteTest with BeforeExample with MyService {
  def actorRefFactory = system

  override val userRepository: UserRepository = mock(classOf[UserRepository])
  def before = {
    when(userRepository.fetch(anyString())).thenReturn(future{new User("greeting", 1)})
  }


  "MyService" should {
    "return a greeting for GET requests to the root path" in {
      Get("/users/greeting") ~> myRoute ~> check {
        responseAs[String] must contain("greeting")
      }
    }
  }
}
