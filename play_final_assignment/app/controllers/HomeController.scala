package controllers


import akka.Done
import form.UserForm
import javax.inject.Inject
import models.CacheRepo
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
class HomeController @Inject()(cc: ControllerComponents,
                               userForm: UserForm,
                               cacheRepo: CacheRepo) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def signIn() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.signIn())
  }


  def signUp() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.signUp())
  }

  def forgotPassword() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.forgotPassword())
  }

  def profile() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.viewUser())
  }

  def addAssignment() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.AddAssignment())
  }

  def viewAssignment() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.ViewAssignment())
  }

  def viewUser() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.viewUser())
  }


  def register: Action[AnyContent] = Action.async { implicit request =>

    userForm.userForm.bindFromRequest.fold(
      formWithError => {
        Future.successful(BadRequest(s"${formWithError.errors}"))
      },
      data => {
        cacheRepo.get(data.email).flatMap{ optionalUser =>
          optionalUser.fold{
            cacheRepo.store(data).map{
              case Done => Ok("SignIn Sucessfully...")
              case _ =>InternalServerError("Something Went Wrong")
            }
          }{_ =>
            Future.successful(Ok("User already exist"))
          }
        }
      }
    )

  }



  def getUser(email :String): Action[AnyContent] = Action.async { implicit request =>
    cacheRepo.get(email).map{ optionalUser =>
      optionalUser.fold{
        NotFound("user does not exsit")
      } {
        user=>
          Ok(s"${user.email},${user.password}")
      }

    }
  }

}
