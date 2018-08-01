package ttt.entites

import akka.actor.{Actor, ActorRef, PoisonPill}
import ttt.entites

class Player extends Actor with TicTacToeMapper {
  override def receive:PartialFunction[Any,Unit] = {

    case TicTacToeMap(msg)=>printMapInArray(msg)
    case Play(playStep,game)=>game ! playStep
    case PlaceAlreadyFilled=>println("Place is filled already")
    case GameOver=>println("Game is Over !")

  }
}

class Game extends Actor with TicTacToeLogic {

  var map = Array(0, 0, 0, 0, 0, 0, 0, 0, 0)

  override def receive: PartialFunction[Any, Unit] = {
    case PlayStep(index, player) => {
      if (index < 0 || (index - 1) > 8) {
        println("wrong Index")
        sender() ! TicTacToeMap(map)
      }
      /*if (player == 1) sender() ! PlayStep(index, 2)
        else
          sender() ! PlayStep(index, 1)
 */
      else {
        if (isGameOver(map)) {
        //  println("Your Game Is Over")
          println("You Won")
          sender() ! GameOver
        }
        else if (map(index) != 0) {
          println("Filled Place")
          TicTacToeMap(map)
        }
        else
          {
            map(index)=player
            sender()!PlayStep(index,player)
            sender()!TicTacToeMap(map)
          }
      }
    }
  }
  /*  case PlayStep(index, player) => {
      if(index-1 < 0 || index-1 > 8){
        println("Invalid Index.")
        sender() ! TicTacToeMap(map)
      }
      else if(map(index-1) == 0){
        map( index - 1 ) = player
        if(isGameOver(map)) {
          println( "Game Over! You Lost!" )
          sender() ! isGameOver( map )
        }
        else {
          sender() ! TicTacToeMap( map )
        }
      }
      else {
        println("Field Already Filled.")
        sender() ! TicTacToeMap(map)
      }*/

}


sealed trait Message

case class Play(playStep: PlayStep, actorRef: ActorRef) extends Message

case class PlayStep(index: Int, player: Int) extends Message

case class TicTacToeMap(map: Array[Int]) extends Message

case class PlaceAlreadyFilled(place:Int) extends Message

case object GameOver extends Message

trait TicTacToeMapper {
  def printMapInArray(elements:Array[Int]):Unit = {
    (0 to 8).foreach { index =>
      elements(index) match {
        case 0 => print(" - ")
        case 1 => print(" X ")
        case 2 => print(" Y ")
      }
      if((index+1) % 3 == 0) println("\n\n") else print("")
    }
  }
}

trait TicTacToeLogic {
  def isGameOver(map: Array[Int]): Boolean = {
    val validTriples =
      List(
        (1,2,3),
        (4,5,6),
        (7,8,9),
        (1,4,7),
        (2,5,8),
        (3,6,9),
        (1,5,9),
        (3,5,7)
      ) map ( triple =>
        (map(triple._1-1), map(triple._2-1), map(triple._3-1)) match {
          case (1,1,1) => true
          case (2,2,2) => true
          case _ => false
        })
    validTriples.reduce((a,b) => a || b)
  }
}