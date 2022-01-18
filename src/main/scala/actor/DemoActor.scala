package actor

import actor.DemoActor.CheckOffset
import akka.actor.{Actor, Props}
import akka.pattern.pipe

import scala.concurrent.{ExecutionContext, Future}

object DemoActor {
  def props(implicit executionContext: ExecutionContext): Props = Props(new DemoActor())

  sealed trait Command

  case class CheckOffset(offset: Int) extends Command
}

class DemoActor(implicit val executionContext: ExecutionContext) extends Actor {
  override def receive: Receive = {
    case CheckOffset(offset) =>
      val result = Future(offset)
      result.pipeTo(sender())
  }
}
