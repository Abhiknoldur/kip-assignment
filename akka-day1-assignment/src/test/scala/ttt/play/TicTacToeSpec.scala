/*
import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import ttt.entites.{Game, Play, PlayStep, Player}

class TicTacToeSpec() extends TestKit(ActorSystem("MySpec")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "An Game actor" should {

    "be able to change and return the state of tic tac toe game" in {
    /*  val system=ActorSystem("GameActor")
      val props =Props[Game]
      val ref=system.actorOf(props)
      ref ! "state updated"*/
    val test = system.actorOf(Props[Player])
      test ! Play(PlayStep(2,1), system.actorOf(Props[Game]))
      expectMsg("state updated")
    }

    "be able to send Tic Tac Toe Map and a GameOver when a condition is met" in {
   /*   val system=ActorSystem("GameActor")
     /* val props=Props[Player]
      val ref=system.actorOf(props)*/
     system ! Play(PlayStep(2,1), system.actorOf(Props[Game]), PlayStep(3,1), system.actorOf(Props[Game])), Play(PlayStep(1,1), system.actorOf(Props[Game]))
      expectMsg()*/
   val test = system.actorOf(Props[Player])
      test ! Play(PlayStep(2,1), system.actorOf(Props[Game]), PlayStep(3,1), system.actorOf(Props[Game])), Play(PlayStep(1,1), system.actorOf(Props[Game]))
      expectNoMessage()
    }

    "be able to send PlaceAlreadyFilled Message when a PlayStep is sent on a non empty step" in {
      val system=ActorSystem("GameActor")
      val props=Props[Game]
      val ref=system.actorOf(props)
      ref ! "Non-Empty step"
      expectMsg("Non-Empty step")
    }
  }
}*/
