package db

import dto.Meeting
import slick.basic.DatabaseConfig
import slick.dbio.DBIOAction
import slick.jdbc.H2Profile

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class MeetingRepository (val config: DatabaseConfig[H2Profile]) extends Db with MeetingTable {
  import config.profile.api._
  
  import scala.concurrent.ExecutionContext.Implicits.global

  def init(): Unit =
    Await.result(
      db.run(DBIOAction.seq(meetings.schema.create)),
      Duration.Inf
    )


  def drop(): Unit =
    Await.result(
      db.run(DBIOAction.seq(meetings.schema.drop)),
      Duration.Inf
    )


  def insert(meeting: Meeting): Meeting=
    Await.result(
      db.run(meetings returning meetings.map(_.id) += meeting).map(id => meeting.copy(id = Some(id))),
      Duration.Inf
    )

  def find(id: Int): Option[Meeting] =
    Await.result(
      db.run((for (meeting <- meetings if meeting.id === id) yield meeting).result.headOption),
      Duration.Inf
    )



  def findAll: List[Meeting] = Await.result(
    db.run((for (meeting <- meetings) yield meeting).result),
    Duration.Inf
  ).toList

  def update(id: Int, Mid:Int,MDate:String,  MTime: Int,ECount :Int,RId :String): Boolean = {
    val query = for (meeting <- meetings if meeting.id === id)
      yield (meeting.Mid,meeting.MDate,meeting.MTime,meeting.ECount,meeting.RId)
    Await.result(
      db.run(query.update(Mid,MDate,MTime,ECount,RId)) map { _ > 0 },
      Duration.Inf
    )
  }

  def delete(Eid: Int): Boolean =
    Await.result(
      db.run(meetings.filter(_.id === Eid).delete) map { _ > 0 },
      Duration.Inf
    )

}
