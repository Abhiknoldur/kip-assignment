package meeting.knoldus.com

import scala.io.StdIn._
import db.{DbConfiguration, MeetingLogRepository, MeetingRepository}
import dto.{Meeting, MeetingLog}
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}


object EmployeeMeeting extends App with DbConfiguration {

  val meetingRepository = new MeetingRepository(config)
  val meetingLogRepository = new MeetingLogRepository(config)

  meetingRepository.init()
  meetingLogRepository.init()
  /*  meetingRepository.insert(Meeting(Some(1),"06-07-2018",1000,4,"Conference"))
  meetingRepository.insert(Meeting(Some(2),"06-07-2018",1000,4,"Meeting"))*/
  if(meetingLogRepository.findAll.size == 0) {
    meetingLogRepository.insert(MeetingLog(Some(1), "C1", 0, false, "ConferenceRoom", ""))
    meetingLogRepository.insert(MeetingLog(Some(2), "M1", 0, false, "MeetingRoom1", ""))
    meetingLogRepository.insert(MeetingLog(Some(3), "M2", 0, false, "MeetingRoom2", ""))
    meetingLogRepository.insert(MeetingLog(Some(4), "M3", 0, false, "MeetingRoom3", ""))
    meetingLogRepository.insert(MeetingLog(Some(5), "M4", 0, false, "MeetingRoom4", ""))
    meetingLogRepository.insert(MeetingLog(Some(6), "M5", 0, false, "MeetingRoom5", ""))
  }
  println(meetingLogRepository.findAll)


  val now = Calendar.getInstance
  List(MeetingLog(Some(1),"C1",120,true,"ConferenceRoom","10:24"),
    MeetingLog(Some(2),"M1",0,false,"MeetingRoom1",""),
    MeetingLog(Some(3),"M2",0,false,"MeetingRoom2",""),
    MeetingLog(Some(4),"M3",0,false,"MeetingRoom3",""),
    MeetingLog(Some(5),"M4",0,false,"MeetingRoom4",""),
    MeetingLog(Some(6),"M5",0,false,"MeetingRoom5",""))
  List(Meeting(Some(1),0,"Sun Aug 05 23:45:22 IST 2018",120,7,"C1"))

  println("Enter employee count: ")
  val Ecount=readInt()

  println("Enter time in hh:mm : ")
  val datetimestring = readLine()
//  val formatter_datetime = new java.text.SimpleDateFormat("hh:mm")
//  val parsed = formatter_datetime.parse(datetimestring)
//  val date = new java.sql.Date(parsed.getTime())
//
////  println("Enter employee count: ")
//  val datetimestring1 = readLine()
//  val formatter_datetime1 = new java.text.SimpleDateFormat("hh:mm")
//  val parsed1 = formatter_datetime1.parse(datetimestring1)
//  val date1 = new java.sql.Date(parsed1.getTime())
//
//
//  val duration = ((date.getTime() - date1.getTime())/60000).toInt

  //First Stage when 1st meeting start
  if(meetingRepository.findAll.size == 0)
    {
      if(Ecount>5)
        {
          meetingLogRepository.update(1,"C1",120,true,"ConferenceRoom",datetimestring)// ConferenceRooom=true
//          meetingRepository.insert(1,0,now.getTime().toString,duration,Ecount,"C1")
          meetingRepository.insert(Meeting(Some(1),0,now.getTime().toString,120,Ecount,"C1"))
          // ConferenceRooom=true
                   //          yaha c1 ka status true hona chahiya
        }
      else
        {
          if(Ecount>1)
            {
              meetingRepository.insert(Meeting(Some(1),0,now.getTime().toString,120,Ecount,"M1"))
              meetingLogRepository.update(2,"M1",120,true,"MeetingRoom",datetimestring)
            }
          else
            {
              meetingRepository.insert(Meeting(Some(1),0,now.getTime().toString,30,Ecount,"M1"))
              meetingLogRepository.update(2,"M1",30,true,"MeetingRoom",datetimestring)
            }
         // MeetingRoom1=true//          m1 = true
        }
    }
  else
    {
                  //      status update in database
      if(Ecount>5)
        {
            //          if c1 is busy then operation on m else c
        }
      else
        {

        }
    }

  println(meetingLogRepository.findAll)
  println(meetingRepository.findAll)

}
