package com.blog

import akka.actor.{ActorSystem, Props}
import akka.io.{IO, Tcp}
import spray.can.Http
import com.blog.api._

import models.pgdb.DAL

object Boot extends App with MainActors with RootApi {

  //construct database tables; it needs improvement
  DAL.databaseInit()

  implicit lazy val system = ActorSystem("spray-blog")

  private val ws = new WsServer(Config.portWs)
  ws.forResource("/nlp/ws", Some(inputActor))
  ws.start()

  sys.addShutdownHook({system.shutdown(); ws.stop()})

  IO(Http) ! Http.Bind(rootService, interface = Config.host, port = Config.portHTTP)
}

object Config {
  import com.typesafe.config.ConfigFactory

  private val config = ConfigFactory.load
  config.checkValid(ConfigFactory.defaultReference)

  val host = config.getString("service.host")
  val portHTTP = config.getInt("service.port")
  val portTcp = config.getInt("service.ports.tcp")
  val portWs = config.getInt("service.ports.ws")

  //RDMS database
  val dbURL = config.getString("db.postgresql.url")
  val dbUser = config.getString("db.postgresql.user")
  val dbPassword = config.getString("db.postgresql.password")
  val dbDriver = config.getString("db.postgresql.driver")

}