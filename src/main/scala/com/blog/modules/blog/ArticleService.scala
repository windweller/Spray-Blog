package com.blog.modules.blog

import com.blog.Config
import akka.actor.{ActorRef, ActorSystem}
import spray.http.StatusCodes
import spray.routing.Directives

class ArticleService(articleActor: ActorRef)(implicit system : ActorSystem) extends Directives {

  lazy val route =
    pathPrefix("article") {
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


