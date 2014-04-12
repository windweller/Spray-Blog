package com.blog.models

import scala.slick.driver.MySQLDriver.simple._
import java.sql.Timestamp
/**
 * Created by Aimingnie on 4/12/14.
 */
object User {

  case class User(id: Option[Int], name: Option[String], email: String, password: String, createdTime: Timestamp, auth_level: Byte, avatar: Option[String])

  class UserTable(tag: Tag) extends Table[User](tag, "Users") {
    def id = column[Option[Int]]("USER_ID", O.PrimaryKey, O.AutoInc)
    def name = column[Option[String]]("USER_NAME", O.Nullable)
    def email = column[String]("USER_EMAIL", O.Nullable)
    def password = column[String]("USER_PASSWORD", O.Nullable)
    def createdTime = column[Timestamp]("USER_CREATEDTIME")
    def auth_level = column[Byte]("AUTH_LEVEL")            //Highest level: 16

    def avatar = column[Option[String]]("USER_AVATAR", O.Nullable)

    def * = (id, name, email, password, createdTime, auth_level, avatar) <> (User.tupled, User.unapply _)
  }

  val users = TableQuery[UserTable]


  def insert(user: User)(implicit s: Session): User = {
    val userId = (users returning users.map(_.id)) += user
    user.copy(id=userId)
  }

  def get(email: String)(implicit s: Session) = {
    val userQuery = for (u <- users if u.email === email) yield u
    userQuery.take(1).list
  }
}
