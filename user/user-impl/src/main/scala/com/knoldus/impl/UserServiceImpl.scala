package com.knoldus.impl

import akka.NotUsed
import com.knoldus.api.{User, UserData, UserService}
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.Future



class UserServiceImpl extends UserService {

  override def getUser(id: Int): ServiceCall[NotUsed, User] = ServiceCall[NotUsed,User] { _ =>
    val queriedUser = UserData.userBuffer.find(user => user.id ==id)
    val user =queriedUser.getOrElse(User(-1,""))
    Future.successful(user)
  }

  private def isUserExist(id: Int): Boolean = {
    UserData.userBuffer.exists(user => user.id == id)
  }

  override def postUser: ServiceCall[User, String] = ServiceCall{ user => {
    if(isUserExist(user.id)){
      Future.successful("User is added already .Enter another user")
    }
    else {
      UserData.userBuffer +=user
      Future.successful("Your User Added")
    }
  }
  }

  override def putUser(id: Int, newName:String): ServiceCall[NotUsed, String] = { _ =>{
    if(isUserExist(id)){
      val existingUser = UserData.userBuffer.find(user => user.id == id).get
      UserData.userBuffer -= existingUser
      UserData.userBuffer += User(existingUser.id ,newName)
      Future.successful("Name is Updated")
    } else {
      Future.successful("User can not be found")
    }
  }
  }

  override def deleteUser(id: Int): ServiceCall[NotUsed, String] =  ServiceCall { _ => {
    if(isUserExist(id)){
      UserData.userBuffer -= UserData.userBuffer.find(user=> user.id == id).get
      Future.successful("Deleted")
    } else {
      Future.successful("User can not be found")
    }
  }
  }


  override def showUser(): ServiceCall[NotUsed, UserData] = { _ =>
    Future.successful(UserData(UserData.userBuffer))
  }


}