package db

import dto.Employees
import slick.lifted.ProvenShape

trait EmployeeTable {
  this: Db =>

  import config.profile.api._

  class EmployeeOperation(tag: Tag) extends Table[Employees](tag, "Employees") {
    def Eid: Rep[Int] = column[Int]("Eid", O.PrimaryKey,  O.AutoInc)

    def Ename: Rep[String] = column[String]("ENAME")

    def Econtact: Rep[String] = column[String]("ECONTACTS")

    def Edessignation: Rep[String] = column[String]("DESIGNATION")

    def * : ProvenShape[Employees] = (Eid.?, Ename, Econtact, Edessignation) <> (Employees.tupled, Employees.unapply)
  }


  val employees = TableQuery[EmployeeOperation]

}
