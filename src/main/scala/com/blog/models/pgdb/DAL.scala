package com.blog.models.pgdb

//import scala.slick.driver.MySQLDriver.simple._

import com.blog.Config._

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.jdbc.meta.MTable


object DAL {

  //either db.mysql._
  //or db.postgresql._

  val db = Database.forURL(url = dbURL, user = dbUser, password= dbPassword, driver = dbDriver)


  def databaseInit() {
    db.withSession{ implicit session =>
      if (MTable.getTables("Article").list().isEmpty) {
        Article.articles.ddl.create
      } else if (MTable.getTables("User").list().isEmpty) {
        User.users.ddl.create
      }
    }
  }
}