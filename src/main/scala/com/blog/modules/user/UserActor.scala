package com.blog.modules.user

/**
 * Created by Aimingnie on 10/23/14.
 */
class UserActor extends Actor with ActorLogging {
  def receive = {
    case _ => log.info("...")
  }
}
