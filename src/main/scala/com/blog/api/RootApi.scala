package com.blog.api

import akka.actor.{ ActorSystem, Props }
import akka.event.Logging.InfoLevel
import spray.http.HttpRequest
import spray.http.StatusCodes.{ MovedPermanently, NotFound }
import spray.routing.{Directives, RouteConcatenation}
import spray.routing.directives.LogEntry
import java.io.File
import spray.http.MediaTypes._

trait AbstractSystem {
  implicit def system: ActorSystem
}

//the ReactiveApi trait, which defines the REST endpoints. In keeping with the structure exposed above,
//each endpoint has been kept in its own class. The ReactiveApi trait constructs the classes for these
// endpoints and then concatenates their respective routes.
trait RootApi extends RouteConcatenation with StaticRoute with AbstractSystem {


  private def showReq(req : HttpRequest) = LogEntry(req.uri, InfoLevel)
}

trait StaticRoute extends Directives {
  this: AbstractSystem =>

  lazy val staticRoute =
    pathEndOrSingleSlash {
        getFromFile(new File("views/home.html"), `text/html`)
    } ~
      path("css" / Segment) {fileName =>
          getFromFile(new File("views/css/"+fileName), `text/css`)
      } ~
      path("js" / Segment) {fileName =>
        getFromFile(new File("views/js/"+fileName), `application/javascript`)
      } ~
       path("img" / Segment) {fileName =>
         getFromFile(new File("img/"+fileName))
      } ~ complete(NotFound)
}
