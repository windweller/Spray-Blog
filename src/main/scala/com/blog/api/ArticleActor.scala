//package com.blog.api
//
//import akka.actor.Actor
//import spray.routing._
//import spray.http._
//import MediaTypes._
//
////handles all top level
////article-related api calls
////top level of article module
//class ArticleActor extends Actor with ArticleService {
//
//  def actorRefFactory = context
//
//  def receive = runRoute(routes)
//}
//
//trait ArticleService extends HttpService {
//  def routes: Route =
//    path("article") {
//      get {
//        complete {
//          //return article from DB
//          "Article back"
//        }
//      } ~
//      post {
//        complete {
//          //add article to DB
//          ""
//        }
//      } ~
//      put {
//        complete {
//          //change existing articles
//          ""
//        }
//      }
//    }
//}