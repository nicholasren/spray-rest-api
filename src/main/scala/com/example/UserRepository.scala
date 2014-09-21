package com.example

import scala.concurrent._

class UserRepository(val ec: ExecutionContext) {
  def fetch(s: String): Future[User] =
    future {
      User(s, 1)
    } (ec)
}

object UserRepository {
  def apply(ec: ExecutionContext) = new UserRepository(ec)
}
