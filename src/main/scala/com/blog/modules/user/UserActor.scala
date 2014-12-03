package com.blog.modules.user

import akka.actor.{ActorLogging, Actor}

class UserActor extends Actor with ActorLogging {
  def receive = {
    case _ => log.info("...")
  }
}

object UserMsg {

  case class Check()
  case class Create()
  case class Update()

}