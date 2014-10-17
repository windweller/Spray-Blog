package com.blog.models.mongodb

import java.util.UUID

import com.blog.models.mongodb.Util._
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.conversions.scala._
import org.joda.time.DateTime
import com.blog.models.mongodb.DAL._

object User {

  RegisterJodaTimeConversionHelpers()

  val userCollection = db("user")

  case class User(name: Option[String], email: Option[String], password: Option[String], userAssignedToken: String,
                  createdTime: DateTime, auth_level: Integer = 1, avatar_link: Option[String],
                  ip_address: List[String], real_address: List[String])

  def insert(user: User) {
    val uuid = UUID.randomUUID().toString
    val insertObject = user.copy(userAssignedToken = uuid, createdTime = DateTime.now())
    userCollection.insert(insertObject.toMap)
  }

  def update(user: User) {

  }

}
