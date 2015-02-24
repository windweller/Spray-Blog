package com.blog.modules.nlp

import akka.actor.{ActorLogging, Actor}

/**
 * Created by Aimingnie on 12/21/14.
 */
class inputActor extends Actor with ActorLogging {

  def receive = {
    case _ => log.info("...")
  }

}

object inputMsg {

}