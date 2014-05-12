package com.blog.api

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

class ArticleActor extends Actor with ArticleService {

  def actorRefFactory = context

  def receive = runRoute(articleRoutes)
}

trait ArticleService extends HttpService {
  val articleRoutes =
    path("article") {
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