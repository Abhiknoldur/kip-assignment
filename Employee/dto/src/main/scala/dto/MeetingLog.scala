package dto

  case class MeetingLog (
                       id:Option[Int],
                       Mid:String,
                       MTime:Int,
                       MStatus:Boolean,
                       RId:String,
                       InitTime:String
                      )
