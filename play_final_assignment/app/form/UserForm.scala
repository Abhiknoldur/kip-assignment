package form

import play.api.data.Form
import play.api.data.Forms.{email, mapping, number, optional, text}


case class User(email: String, password: Int)

class UserForm {

  val userForm = Form(
    mapping(
      "email" -> email,
      "password" -> number

    )(User.apply)(User.unapply)
  )
}


