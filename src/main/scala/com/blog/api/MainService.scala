package com.blog.api

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

import java.io.File
import akka.util.Timeout
import scala.concurrent.duration._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
// MainService provides the actor for
class MainServiceActor extends Actor with MainService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  def receive = runRoute(route)
}

// this trait defines our service behavior independently from the service actor
trait MainService extends HttpService {

  implicit val timeout = Timeout(10 seconds)

  def route: Route =
    path("") {
      get {
        getFromFile(new File("views/home.html"), `text/html`)
      }
    } ~
    path("css" / Segment) {fileName =>
        get {
          getFromFile(new File("views/css/"+fileName), `text/css`)
        }
    } ~
    path("js" / Segment) {fileName =>
        getFromFile(new File("views/js/"+fileName), `application/javascript`)
    }
}