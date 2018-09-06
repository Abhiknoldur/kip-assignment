package com.knoldus.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * The External service trait.
  */
trait ExternalService extends Service {

  def getGuest(): ServiceCall[NotUsed, RootJsonObject]

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("external-service")
      .withCalls(
        pathCall("/deepakmehra10/227713bfa0aded2196059d6a623ea4e2/raw", getGuest _)
      ).withAutoAcl(true)
    // @formatter:on
  }
}