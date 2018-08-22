package form

import play.api.data.Form
import play.api.data.Forms.{text, mapping, number}


case class User(fName :String,mName: String,lName :String,userName :String,password :String,mobile :String,age:Int,gender:String,Hobbies:String)

class UserForm {

  val userForm = Form(
    mapping(
      "fName" -> text,
      "mName" -> text,
      "lName" ->  text,
      "userName"-> text,
      "password"->text,
      "mobile"->text,
      "age"->number,
      "gender"->text,
      "hobbies" ->text

    )(User.apply)(User.unapply)
  )
}


