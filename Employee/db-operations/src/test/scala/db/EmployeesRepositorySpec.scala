package db


import org.scalatest.{BeforeAndAfterEach, FunSuite}

class EmployeesRepositorySpec extends FunSuite with DbConfiguration  with BeforeAndAfterEach {

  val employees=new EmployeesRepository(config)

  override def beforeEach(){
   employees.init()
  }

  override def afterEach() {
    employees.drop()
  }

  test("Get all books"){
    assert(employees.findAll === Nil)
  }

}
