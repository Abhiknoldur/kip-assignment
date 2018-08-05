package db

import dto.MeetingLog
import slick.basic.DatabaseConfig
import slick.dbio.DBIOAction
import slick.jdbc.H2Profile

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class MeetingLogRepository (val config: DatabaseConfig[H2Profile]) extends Db with MeetingLogTable {
  import config.profile.api._

  import scala.concurrent.ExecutionContext.Implicits.global

  def init(): Unit =
    Await.result(
      db.run(DBIOAction.seq(meetingsLogs.schema.create)),
      Duration.Inf
    )


  def drop(): Unit =
    Await.result(
      db.run(DBIOAction.seq(meetingsLogs.schema.drop)),
      Duration.Inf
    )


  def insert(meeting: MeetingLog): MeetingLog=
    Await.result(
      db.run(meetingsLogs returning meetingsLogs.map(_.id) += meeting).map(id => meeting.copy(id = Some(id))),
      Duration.Inf
    )

  def find(id: Int): Option[MeetingLog] =
    Await.result(
      db.run((for (meeting <- meetingsLogs if meeting.id === id) yield meeting).result.headOption),
      Duration.Inf
    )



  def findAll: List[MeetingLog] = Await.result(
    db.run((for (meeting <- meetingsLogs) yield meeting).result),
    Duration.Inf
  ).toList

  def update(id: Int,Mid:String,  MTime: Int,MStatus :Boolean,RId :String,InitTime:String): Boolean = {
    val query = for (meeting <- meetingsLogs if meeting.id === id)
      yield (meeting.Mid,meeting.MTime,meeting.MStatus,meeting.RId,meeting.InitTime)
    Await.result(
      db.run(query.update(Mid,MTime,MStatus,RId,InitTime)) map { _ > 0 },
      Duration.Inf
    )
  }

  def delete(Eid: Int): Boolean =
    Await.result(
      db.run(meetingsLogs.filter(_.id === Eid).delete) map { _ > 0 },
      Duration.Inf
    )

}
