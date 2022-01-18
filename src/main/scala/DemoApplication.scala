import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.util.Timeout
import config.Constants.{ServerHost, ServerPort}
import controller.DemoController
import org.slf4j.{Logger, LoggerFactory}
import service.DemoService

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.{Failure, Success}

object DemoApplication extends App {
  implicit val system: ActorSystem = ActorSystem("akka-kickstarter")
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  protected val logger: Logger = LoggerFactory.getLogger(this.getClass)


  implicit val timeout: Timeout = Timeout(10 seconds)

  val demoService = new DemoService()
  val demoController = new DemoController(demoService)

  val routesHandler = demoController.routes

  val bindingFuture = Http().newServerAt(ServerHost, ServerPort).bind(routesHandler)

  bindingFuture.onComplete {
    case Success(binding) ⇒
      val localAddress = binding.localAddress
      logger.info(s"Demo Application is listening on ${localAddress.getHostName}:${localAddress.getPort}!!!!")
    case Failure(exception) => logger.info("Unable to start Demo Application Service due to ", exception)
  }


}
