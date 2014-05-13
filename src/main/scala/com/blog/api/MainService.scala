package com.blog.api

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

import java.io.File

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MainServiceActor extends Actor with MainService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}

// this trait defines our service behavior independently from the service actor
trait MainService extends HttpService {

  val myRoute =
    path("") {
      get {
        getFromFile(new File("views/home.html"), `text/html`)
//        getFromFile("views/home.html")
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