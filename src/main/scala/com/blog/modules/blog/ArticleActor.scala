package com.blog.modules.blog

/**
 * Created by Aimingnie on 10/23/14.
 */
class ArticleActor extends Actor with ActorLogging {
  def receive = {
    case _ => log.info("...")
  }
}
