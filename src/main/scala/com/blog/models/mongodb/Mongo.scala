package com.blog.models.mongodb

import reactivemongo.api.MongoDriver

import scala.concurrent.ExecutionContext

/**
 * Created by Aimingnie on 6/16/14.
 */
object Mongo {
  implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

  val driver = new MongoDriver()
  val connection = driver.connection(List("localhost:27017"))
  val db = connection("Spray-Blog")
}
