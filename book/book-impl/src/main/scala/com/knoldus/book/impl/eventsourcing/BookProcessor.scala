package com.knoldus.book.impl.eventsourcing

import com.lightbend.lagom.scaladsl.persistence.cassandra.{CassandraReadSide, CassandraSession}
import com.lightbend.lagom.scaladsl.persistence.{AggregateEventTag, ReadSideProcessor}

import scala.concurrent.ExecutionContext

class BookProcessor(session: CassandraSession, readSide: CassandraReadSide)(implicit ec: ExecutionContext)
  extends ReadSideProcessor[BookEvent] {

  val bookRepository = new BookRepository(session)

  override def buildHandler(): ReadSideProcessor.ReadSideHandler[BookEvent] = {
    readSide.builder[BookEvent]("BookEventOffset")
      .setGlobalPrepare(bookRepository.createTable)
      .setPrepare(_ => bookRepository.createPreparedStatements)
      .setEventHandler[BookCreated](e ⇒ bookRepository.storeBook(e.event.book))
      .build()
  }

  override def aggregateTags: Set[AggregateEventTag[BookEvent]] =
    BookEvent.Tag.allTags
}
