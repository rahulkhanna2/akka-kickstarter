package service

import actor.DemoActor
import actor.DemoActor.CheckOffset
import akka.actor.{ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.{ExecutionContext, Future}

class DemoService(implicit val executionContext: ExecutionContext, system: ActorSystem, timeout: Timeout) {

  val demoActor: ActorRef = system.actorOf(DemoActor.props)


  def demoFunction(offset: Int): Future[Int] = {
    (demoActor ? CheckOffset(offset)).mapTo[Int]

  }

}
