package com.blog.api

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

//handles all top level
//user-related api calls
//top level of user module
class UserActor extends Actor with UserService{

  def actorRefFactory = context
  def receive = runRoute(routes)
}

trait UserService extends HttpService{
  def routes: Route =
    path("user") {
      get {
        complete {
          //return article from DB
          "Article back"
        }
      } ~
        post {
          complete {
            //add article to DB
            ""
          }
        } ~
        put {
          complete {
            //change existing articles
            ""
          }
        }
    }
}
