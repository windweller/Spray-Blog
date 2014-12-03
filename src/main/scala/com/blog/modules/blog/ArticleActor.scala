package com.blog.modules.blog

import akka.actor.{ActorLogging, Actor}

class ArticleActor extends Actor with ActorLogging {
  import ArticleMsg._

  def receive = {
    case _ => log.info("...")
  }
}

//This object stores message protocols
object ArticleMsg {

}
