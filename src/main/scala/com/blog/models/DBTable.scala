package com.blog.models

import scala.slick.driver.MySQLDriver.simple._
import shapeless.TypeOperators.T

/**
 * Created by Aimingnie on 4/26/14.
 */
abstract class DBTable {
  def getTableQuery:TableQuery[T]
}
