package db

import org.scalatest.{ BeforeAndAfterEach, FunSuite }

class MeetingRepositorySpec extends FunSuite with DbConfiguration  with BeforeAndAfterEach {

  val meeting = new MeetingRepository(config)

  override def beforeEach(): Unit = {
    meeting.init()
  }

  override def afterEach(): Unit = {
    meeting.drop()
  }

  test("Get MeetingList"){
  assert(meeting.findAll === Nil)
  }
}
