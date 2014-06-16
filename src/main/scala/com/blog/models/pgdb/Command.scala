package com.blog.models.pgdb

/**
 * Created by Aimingnie on 4/12/14.
 */
object Command {

  case class Command(id: Option[Int], name: String, code: String, auth_level: Byte)


}
