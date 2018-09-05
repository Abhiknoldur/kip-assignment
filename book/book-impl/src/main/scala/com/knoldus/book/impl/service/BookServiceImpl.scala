package com.knoldus.book.impl.service

import akka.{Done, NotUsed}
import com.knoldus.book.api.{Book, BookService}
import com.knoldus.book.impl.eventsourcing._
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.{PersistentEntityRef, PersistentEntityRegistry}

import scala.concurrent.ExecutionContext

class BookServiceImpl(persistentEntityRegistry: PersistentEntityRegistry, bookRepository: BookRepository)
                     (implicit ec: ExecutionContext) extends BookService {

  override def createBook(isbn: String, name: String, author: String,genre: String): ServiceCall[NotUsed, String] = {
    ServiceCall { _ =>
      val book = Book(isbn, name, author, genre)
      ref(isbn).ask(CreateBookCommand(book)).map {
        case Done => s"Hello! Your book  ${book.name} has been Added."
      }
    }
  }


  override def getBookByName(name: String): ServiceCall[NotUsed, String] =
    ServiceCall { _ =>
    bookRepository.getBookByName(name).map(book =>
      s"Book for name:$name has id: ${book.get.isbn} and author: ${book.get.author} and  belongs to ${book.get.genre} genre."
    )
  }

/*
  override def updateBookByIsbn(isbn: String): ServiceCall[NotUsed, String] = ???
*/

  def ref(isbn: String): PersistentEntityRef[BookCommand[_]] = {
    persistentEntityRegistry
      .refFor[BookEntity](isbn)
  }

}
