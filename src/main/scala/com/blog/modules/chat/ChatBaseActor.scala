package com.blog.modules.chat

import com.blog.Config
import scala.collection.mutable._
import akka.actor.{ActorLogging, Actor, ActorRef, ActorSystem}
import spray.http.StatusCodes
import spray.routing.Directives
import org.java_websocket.WebSocket

/**
 * Created by Aimingnie on 6/5/14.
 */

//Chat service completely depends on WS and not on REST
//It doesn't extend and have Spray's Routing directive at all
class ChatBaseActor extends Actor with ActorLogging{
  import com.blog.api.WsServerProt._
  import ChatBaseProtocol._

  val clients = ListBuffer[WebSocket]()

  def receive = {
    case Open(ws, hs) => {
      clients += ws
      log.debug("registered monitor for url {}", ws.getResourceDescriptor)
      ws.send("You are connected now buffoon!")
    }
  }
}

object ChatBaseProtocol {

}