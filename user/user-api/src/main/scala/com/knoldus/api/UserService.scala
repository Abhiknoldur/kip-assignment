package com.knoldus.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import play.api.libs.json.{Format, Json}

import scala.collection.mutable.ListBuffer

trait UserService extends Service {


  def getUser(id: Int): ServiceCall[NotUsed, User]

  def postUser: ServiceCall[User, String]

  def putUser(id: Int,newName:String): ServiceCall[NotUsed, String]

  def deleteUser(id: Int): ServiceCall[NotUsed, String]

  def showUser(): ServiceCall[NotUsed, UserData]



  override final def descriptor: Descriptor = {
    import Service._
    named("user")
      .withCalls(
        restCall(Method.GET,"/api/getUser/:id", getUser _),
        restCall(Method.POST,"/api/postUser/", postUser _),
        restCall(Method.PUT,"/api/putUser/:id/:name",putUser _),
        restCall(Method.DELETE,"/api/deleteUser/:id",deleteUser _),
        restCall(Method.GET,"/api/showUser/",showUser _)
      )
      .withAutoAcl(true)
  }
}
case class User(id:Int,Username:String)

object User
{
  implicit val format: Format[User] = Json.format[User]
}


case class UserData(userList: ListBuffer[User])

object UserData{
  implicit val userDataFormat: Format[UserData] = Json.format
  val userBuffer: ListBuffer[User] = ListBuffer(User(1,"Avi"),User(2,"Rishu"),User(3,"Sid"),User(4,"Abhishek"))

}