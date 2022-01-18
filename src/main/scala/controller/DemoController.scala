package controller

import akka.http.scaladsl.model.StatusCodes.InternalServerError
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{path, _}
import akka.http.scaladsl.server.Route
import service.DemoService

import scala.util.{Failure, Success}


class DemoController(demoService: DemoService) {

  def routes: Route = path("demo") {
    get {
      parameters("offset".?) { offset =>
        val result = demoService.demoFunction(offset.getOrElse("0").toInt)
        onComplete(result) {
          case Success(offset) =>
            complete(HttpEntity(ContentTypes.`application/json`, offset.toString))
          case Failure(ex) => complete(InternalServerError, s"An error occurred: ${ex.getMessage}")
        }
      }
    }
  }

}
