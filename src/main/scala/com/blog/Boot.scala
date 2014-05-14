package com.blog

import akka.actor.{ActorSystem, Props}
import akka.io.{IO, Tcp}
import spray.can.Http
import com.blog.api.MainServiceActor
import com.blog.Config._

//import scala.slick.driver.MySQLDriver.simple._
import models._

object Boot extends App {

  //construct database tables
  //it needs improvement
  DAL.databaseInit()

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("spray-blog")

  // create and start our service actor
  val service = system.actorOf(Props[MainServiceActor], "spray-blog")

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(service, interface = host, port = portHTTP)
}

object Config {
  import com.typesafe.config.ConfigFactory

  private val config = ConfigFactory.load
  config.checkValid(ConfigFactory.defaultReference)

  val host = config.getString("service.host")
  val portHTTP = config.getInt("service.port")
  val portTcp = config.getInt("service.ports.tcp")
  val portWs = config.getInt("service.ports.ws")

  //database
  val dbURL = config.getString("db.postgresql.url")
  val dbUser = config.getString("db.postgresql.user")
  val dbPassword = config.getString("db.postgresql.password")
  val dbDriver = config.getString("db.postgresql.driver")
}