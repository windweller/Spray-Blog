package com.blog

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import com.blog.api.MyServiceActor

object Boot extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("spray-blog")

  // create and start our service actor
  val service = system.actorOf(Props[MyServiceActor], "spray-blog")

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
}