/*
package edu.knoldus.com

import db.{DbConfiguration, EmployeesRepository}
import dto.Employees

object Operation extends App with DbConfiguration {

  val employeeRepository = new EmployeesRepository(config)

  employeeRepository.init()
  employeeRepository.insert(Employees(Some(1), "E1", "87654323456", "Developer"))
  employeeRepository.insert(Employees(Some(2), "E2", "87654345555", "Tester"))
  employeeRepository.insert(Employees(Some(3), "E3", "87654654656", "Consultant"))
  println(employeeRepository.findAll)
}
*/
