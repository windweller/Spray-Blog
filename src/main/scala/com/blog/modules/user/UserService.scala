package com.blog.modules.user

import akka.actor.{ActorLogging, Actor, ActorSystem, ActorRef}
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

//This object stores message protocols
object UserProtocol {

}

class UserActor extends Actor with ActorLogging {
  def receive = {
    case _ => log.info("...")
  }
}