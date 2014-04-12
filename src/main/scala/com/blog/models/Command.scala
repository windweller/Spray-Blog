package com.blog.models

import scala.slick.driver.MySQLDriver.simple._
import java.sql.Timestamp

/**
 * Created by Aimingnie on 4/12/14.
 */
object Command {

  case class Command(id: Option[Int], name: String, code: String, auth_level: Byte)


}
