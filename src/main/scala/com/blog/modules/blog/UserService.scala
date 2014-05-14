package com.blog.modules.blog

import akka.actor.{ActorSystem, ActorRef}
import spray.routing.Directives

/**
 * Created by Aimingnie on 5/14/14.
 */
class UserService (userActor: ActorRef)(implicit system : ActorSystem) extends Directives {

}

