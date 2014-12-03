package com.blog.models.pgdb


object Command {

  case class Command(id: Option[Int], name: String, code: String, auth_level: Byte)


}
