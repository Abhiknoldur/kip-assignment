package com.knoldus.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * The welcome service trait.
  */
trait PersonService extends Service {

  def Person(name: String): ServiceCall[NotUsed, String]

  def consumeUser(): ServiceCall[NotUsed, RootJsonObject]

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("welcome")
      .withCalls(
        pathCall("/api/person/:name", Person _),
        pathCall("/consume/user", consumeUser _)
      )
      .withAutoAcl(true)
    // @formatter:on
  }
}