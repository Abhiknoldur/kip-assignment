package db


import slick.lifted.ProvenShape
import dto.MeetingLog
trait MeetingLogTable {this :Db=>
  import config.profile.api._

  class MeetingLogOperation(tag:Tag) extends Table[MeetingLog](tag,"MeetingLog") {
    def id: Rep[Int] = column[Int]("ID", O.PrimaryKey, O.AutoInc)

    def Mid: Rep[String] = column[String]("MID")

   // def MDate: Rep[String] = column[String]("MeetingDate")

    def MTime: Rep[Int] = column[Int]("MeetingTime")

    def RId:Rep[String]=column[String]("RoomId")

    def MStatus:Rep[Boolean]=column[Boolean]("MeetingStatus")

    def InitTime:Rep[String]=column[String]("InitTime")

    def * : ProvenShape[MeetingLog] = (id.?,Mid, MTime, MStatus, RId,InitTime) <> (MeetingLog.tupled,MeetingLog.unapply)
  }
  val meetingsLogs =TableQuery[MeetingLogOperation]
}
