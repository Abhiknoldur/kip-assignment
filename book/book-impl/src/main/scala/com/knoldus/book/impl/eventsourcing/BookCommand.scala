package com.knoldus.book.impl.eventsourcing

import akka.Done
import com.knoldus.book.api.Book
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.{Format, Json}

trait BookCommand[R] extends ReplyType[R]


case class CreateBookCommand(book: Book) extends BookCommand[Done]

object CreateBookCommand{
  implicit val format: Format[CreateBookCommand] = Json.format
}

case class GetBookCommand(isbn: String,genre :String) extends BookCommand[Book]

object GetBookCommand{
  implicit val format: Format[GetBookCommand] = Json.format
}

/*
case class UpdateBookCommand(isbn: String) extends BookCommand[Book]

object UpdateBookCommand{
  implicit val format: Format[UpdateBookCommand] = Json.format
}*/