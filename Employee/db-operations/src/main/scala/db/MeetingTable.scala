package db

import slick.lifted.ProvenShape
import dto.Meeting
trait MeetingTable {this :Db=>
  import config.profile.api._

  class MeetingOperation(tag:Tag) extends Table[Meeting](tag,"Meeting") {
    def id: Rep[Int] = column[Int]("ID", O.PrimaryKey, O.AutoInc)

    def Mid: Rep[Int] = column[Int]("MID")

    def MDate: Rep[String] = column[String]("MeetingDate")

    def MTime: Rep[Int] = column[Int]("MeetingTime")

    def ECount: Rep[Int] =column[Int]("EmployeeCount")

    def RId:Rep[String]=column[String]("RoomId")

    def * : ProvenShape[Meeting] = (id.?,Mid, MDate, MTime, ECount, RId) <> (Meeting.tupled,Meeting.unapply)
  }
val meetings =TableQuery[MeetingOperation]
}
