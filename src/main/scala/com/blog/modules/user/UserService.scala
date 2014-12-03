package com.blog.modules.user

import akka.actor.{ActorSystem, ActorRef}
import spray.routing.Directives

//TODO: fix/complete this User
class UserService (userActor: ActorRef)(implicit system : ActorSystem) extends Directives {
  lazy val route =
    pathPrefix("user") {
      get {
        complete {
          //return article from DB
          "User back"
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

