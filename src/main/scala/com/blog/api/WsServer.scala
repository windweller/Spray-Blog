package com.blog.api

import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer


class WsServer (val port: Int) extends WebSocketServer {

}

object WsServer {
  sealed trait ReactiveServerMessage
  case class Message(ws : WebSocket, msg : String)
    extends ReactiveServerMessage
  case class Open(ws : WebSocket, hs : ClientHandshake)
    extends ReactiveServerMessage
  case class Close(ws : WebSocket, code : Int, reason : String, external : Boolean)
    extends ReactiveServerMessage
  case class Error(ws : WebSocket, ex : Exception)
    extends ReactiveServerMessage
}