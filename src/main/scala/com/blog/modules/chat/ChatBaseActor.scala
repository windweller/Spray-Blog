package com.blog.modules.chat

import com.blog.Config
import com.blog.models.pgdb.User
import scala.collection.mutable._
import akka.actor.{ActorLogging, Actor, ActorRef, ActorSystem}
import spray.http.StatusCodes
import spray.routing.Directives
import org.java_websocket.WebSocket
import com.blog.models._

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
    case Open(ws, hs) =>
      clients += ws
      //1. get client IP address
      val ip = ws.getRemoteSocketAddress.getAddress.toString
      log.info("ws remote socket address: " + ws.getRemoteSocketAddress.getAddress.toString)

      //2. Check existing cookie
      if (hs.hasFieldValue("Cookie")) {
        val cookie = hs.getFieldValue("Cookie")
        //have our cookie
        if(RawCookieUtil.parse(cookie).nonEmpty){
          //check database for the cookie value, if the browser has the cookie
          //match UUID with IP address
          User.getByTokenAndIP(RawCookieUtil.parse(cookie).get, ip)

        }else{ //don't have our cookie

        }
      }

//      ws.send("You are connected now buffoon!")
    case Message(ws, msg) =>

  }
}

object ChatBaseProtocol {

}