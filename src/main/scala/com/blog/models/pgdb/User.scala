package com.blog.models.pgdb

import java.sql.Timestamp
import java.util.UUID
import com.github.nscala_time.time.Imports._


case class User(id: Option[Int], nickname: Option[String],
                email: Option[String], password: Option[String], userAssignedToken: Option[String],
                ipAddresses: List[String], authorizedIPAdresses: Option[List[String]],
                createdTime: LocalDateTime, auth_level: Byte, avatar: Option[String])

trait UserComponent{

  import pgSlickPostgresDriver.simple._

  class UserTable(tag: Tag) extends Table[User](tag, "User") {
    def id = column[Option[Int]]("USER_ID", O.PrimaryKey, O.AutoInc)
    def nickname = column[Option[String]]("USER_NAME")
    def email = column[Option[String]]("USER_EMAIL")
    def password = column[Option[String]]("USER_PASSWORD", O.Nullable)
    def userAssignedToken = column[Option[String]]("USER_ASSIGNED_TOKEN")
    def ipAddresses = column[List[String]]("USER_IP_LIST", O.Nullable)
    def authorizedIPAdresses = column[Option[List[String]]]("USER_AUTH_IP_LIST", O.Nullable)
    def createdTime = column[LocalDateTime]("USER_CREATEDTIME")
    def auth_level = column[Byte]("AUTH_LEVEL")            //Highest level: 16

    def avatar = column[Option[String]]("USER_AVATAR", O.Nullable)

    def * = (id, nickname, email, password, userAssignedToken,
      ipAddresses, authorizedIPAdresses, createdTime, auth_level, avatar) <> (User.tupled, User.unapply _)
  }

  val users = TableQuery[UserTable]

  def insert(user: User)(implicit s: Session): User = {
    val uuid = UUID.randomUUID().toString
    val userId = (users returning users.map(_.id)) += user.copy(userAssignedToken = Some(uuid))
    user.copy(id=userId, userAssignedToken = Some(uuid))
  }

  //most generic default user adding
  //save ip address, assign auth_level as 1
  def defaultUserInsert(ipAdress: String)(implicit s: Session): User = {
    insert(User(None, None, None, None, None, List(ipAdress), None, DateTime.now.toLocalDateTime, 1, None))
  }

  def getFromEmail(email: String)(implicit s: Session) = {
    val userQuery = for (u <- users if u.email === email) yield u
    userQuery.take(1).list
  }

  def getByTokenAndIP(UUID: String, IP: String)(implicit s: Session) = {
    val userQuery = for (u <- users if u.userAssignedToken === UUID) yield u
    userQuery.take(1).list
  }
}
