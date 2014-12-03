package com.blog.modules.chat

import com.blog.Config
import com.blog.models.pgdb.User
import scala.collection.mutable._
import akka.actor.{ActorLogging, Actor, ActorRef, ActorSystem}
import spray.http.StatusCodes
import spray.routing.Directives
import org.java_websocket.WebSocket
import com.blog.models._


//Chat service completely depends on WS and not on REST
//It doesn't extend and have Spray's Routing directive at all
class ChatBaseActor extends Actor with ActorLogging {
  import com.blog.api.WsServerMsg._
  import ChatBaseMsg._

  val clients = ListBuffer[WebSocket]()

  //goes to either CLI package or NLP package, based on JSON field "mode"
  def receive = {
    case Open(ws, hs) =>
      clients += ws
      //1. get client IP address
      val ip = ws.getRemoteSocketAddress.getAddress.toString
      log.info("ws remote socket address: " + ws.getRemoteSocketAddress.getAddress.toString)

      //2. if any username is being sent over
      //client side js checks on cookie


    case Message(ws, msg) =>

  }
}

object ChatBaseMsg {

  case class Send()
  case class InternalError()

}