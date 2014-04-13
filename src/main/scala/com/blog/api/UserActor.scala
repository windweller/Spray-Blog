package com.blog.api

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

/**
 * Created by Aimingnie on 4/12/14.
 */
class UserActor extends Actor with UserService{

  def actorRefFactory = context

  def receive = runRoute(userRoutes)
}

trait UserService extends HttpService{
  val userRoutes =
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
