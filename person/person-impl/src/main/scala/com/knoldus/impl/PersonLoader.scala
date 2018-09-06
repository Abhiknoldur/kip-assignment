package com.knoldus.impl



import com.knoldus.api.{ExternalService, PersonService}
import com.knoldus.welcome.impl.PersonServiceImpl
import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire._
import play.api.libs.ws.ahc.AhcWSComponents

/**
  * The Class PersonLoader.
  *
  */
class PersonLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new PersonApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new PersonApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[PersonService])
}

abstract class PersonApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer: LagomServer = serverFor[PersonService](wire[PersonServiceImpl])

  //Bind the external service in ServiceModule.
  lazy val externalService: ExternalService = serviceClient.implement[ExternalService]
}