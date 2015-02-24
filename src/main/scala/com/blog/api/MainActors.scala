package com.blog.api

import akka.actor.Props
import com.blog.modules.blog._
import com.blog.modules.nlp.inputActor
import com.blog.modules.user._

/**
 * Created by Aimingnie on 5/14/14.
 */
//Here is where we build up all actors
trait MainActors {
  this: AbstractSystem =>

  lazy val articleActor = system.actorOf(Props[ArticleActor], "article")
  lazy val userActor = system.actorOf(Props[UserActor], "user")
  lazy val inputActor = system.actorOf(Props[inputActor], "input")
}
