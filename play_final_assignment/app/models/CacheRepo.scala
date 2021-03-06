package models

import akka.Done
import form.User
import javax.inject.Inject
import play.api.cache.AsyncCacheApi

import scala.concurrent.Future

class CacheRepo @Inject()(cache: AsyncCacheApi) {

  def store(user: User): Future[Done] = {
    cache.set(user.email, user.password)
  }

  def get(email:String): Future[Option[User]] = {
    cache.get(email)
  }

}
