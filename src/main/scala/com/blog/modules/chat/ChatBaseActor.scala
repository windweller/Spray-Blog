package com.blog.modules.chat

import com.blog.Config
import akka.actor.{ActorLogging, Actor, ActorRef, ActorSystem}
import spray.http.StatusCodes
import spray.routing.Directives

/**
 * Created by Aimingnie on 6/5/14.
 */

//Chat service completely depends on WS and not on REST
//It doesn't extend and have Spray's Routing directive at all
class ChatBaseActor extends Actor with ActorLogging{
  def receive = {
    case _ => log.info("...")
  }
}

object ChatBaseProtocol {

}