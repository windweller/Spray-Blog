package com.blog.api

import akka.actor.{Props, ActorSystem}
import akka.event.Logging.InfoLevel
import spray.http.HttpRequest
import spray.http.StatusCodes.{MovedPermanently, NotFound }
import spray.routing.{Directives, RouteConcatenation}
import spray.routing.directives.LogEntry
import java.io.File
import spray.http.MediaTypes._
import com.blog.modules.blog._
import com.blog.modules.user.UserService

trait AbstractSystem {
  implicit def system: ActorSystem
}

//the ReactiveApi trait, which defines the REST endpoints. In keeping with the structure exposed above,
//each endpoint has been kept in its own class. The ReactiveApi trait constructs the classes for these
// endpoints and then concatenates their respective routes.
trait RootApi extends RouteConcatenation with StaticRoute with AbstractSystem {
  this: MainActors =>

  val rootService = system.actorOf(Props(new RootService(routes)))

  lazy val routes = logRequest(showReq _) {
    new ArticleService(articleActor).route ~
    new UserService(userActor).route ~
    staticRoute
  }

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
    path("css" / Segment / Segment) {(subFolder, fileName) =>
        getFromFile(new File("views/css/"+ subFolder + "/" +fileName))
    } ~
    path("js" / Segment) {fileName =>
      getFromFile(new File("views/js/" + fileName), `application/javascript`)
    } ~
    path("js" / Segment / Segment) { (subFolder, fileName) =>
        getFromFile(new File("views/js/" + subFolder + "/" +fileName), `application/javascript`)
    } ~
    path("img" / Segment) {fileName =>
         getFromFile(new File("img/"+fileName))
    } ~ complete(NotFound)
}