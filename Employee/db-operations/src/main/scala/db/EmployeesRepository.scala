package db


import dto.Employees
import slick.basic.DatabaseConfig
import slick.dbio.DBIOAction
import slick.jdbc.H2Profile

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class EmployeesRepository(val config: DatabaseConfig[H2Profile]) extends Db with EmployeeTable {

  import config.profile.api._
  import scala.concurrent.ExecutionContext.Implicits.global

  def init(): Unit =
    Await.result(
      db.run(DBIOAction.seq(employees.schema.create)),
      Duration.Inf
    )

  def drop(): Unit =
    Await.result(
      db.run(DBIOAction.seq(employees.schema.drop)),
      Duration.Inf
    )


  def insert(employee: Employees): Employees =
    Await.result(
      db.run(employees returning employees.map(_.Eid) += employee).map(Eid => employee.copy(Eid = Some(Eid))),
      Duration.Inf
    )

  def find(id: Int): Option[Employees] =
    Await.result(
      db.run((for (employees <- employees if employees.Eid === id) yield employees).result.headOption),
      Duration.Inf
    )

  def findAll: List[Employees] = Await.result(
    db.run((for (employee <- employees) yield employee).result),
    Duration.Inf
  ).toList

  def update(Eid: Int, Ename: String, Econtact: String, Edessignation: String): Boolean = {
    val query = for (employees <- employees if employees.Eid === Eid)
      yield (employees.Ename, employees.Econtact, employees.Edessignation)
    Await.result(
      db.run(query.update(Ename, Econtact, Edessignation)) map {
        _ > 0
      },
      Duration.Inf
    )
  }

  def delete(Eid: Int): Boolean =
    Await.result(
      db.run(employees.filter(_.Eid === Eid).delete) map {
        _ > 0
      },
      Duration.Inf
    )
}
