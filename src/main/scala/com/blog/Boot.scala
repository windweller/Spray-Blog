package com.blog

import akka.actor.{ActorSystem, Props}
import akka.io.{IO, Tcp}
import spray.can.Http
import com.blog.api.MyServiceActor

import scala.slick.driver.MySQLDriver.simple._
import java.sql.{DriverManager, Connection}
import models._
import com.typesafe.config.ConfigFactory

object Boot extends App {

  //construct database tables
  //can we just check if the database is established?

//  DAL.databaseInit()
  val config = ConfigFactory.load()
  val host = config.getString("service.host")
  val port = config.getInt("service.port")

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("spray-blog")

  // create and start our service actor
  val service = system.actorOf(Props[MyServiceActor], "spray-blog")

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(service, interface = host, port = port)
}