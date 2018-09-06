package com.knoldus.welcome.impl


import com.knoldus.api.{ExternalService, PersonService, RootJsonObject}
import com.lightbend.lagom.scaladsl.api.ServiceCall
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Implementation of the WelcomeService.
  */
class PersonServiceImpl(externalService: ExternalService)(implicit ec: ExecutionContext) extends PersonService {

  private final val log: Logger = LoggerFactory.getLogger(classOf[PersonServiceImpl])

  /**
    *
    * @param name - Name of the user to be greeted.
    * @return
    */
  override def Person(name: String) = ServiceCall { _ =>
    log.info(s"Person with name $name, greeted.")
    Future.successful(s"Welcome, $name")
  }

  /**
    * Consumes the user data from external service.
    *
    * @return
    */
  override def consumeUser() = ServiceCall { _ =>
    val result: Future[RootJsonObject] = externalService.getGuest().invoke()
    result.map(response => response)
  }
}