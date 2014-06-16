package com.blog.models.mongodb

import org.joda.time.DateTime

/**
 * Created by Aimingnie on 6/16/14.
 */
case class User(
  id: Long,
  name: String,
  email: String,
  password: String,
  userAssignedToken: String,
  listOfIP: Option[List[String]],
  createdTime: DateTime,
  auth_level: Byte,
  profile_image_url: Option[String]
)

object User {

}
