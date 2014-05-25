package com.blog.models

//import scala.slick.driver.MySQLDriver.simple._
import scala.slick.driver.PostgresDriver.simple._
import scala.slick.jdbc.meta.MTable
import com.blog.Config._


object DAL {

  //either db.mysql._
  //or db.postgresql._
  val db = Database.forURL(url = dbURL, user = dbUser, password= dbPassword, driver = dbDriver)

  def databaseInit() {
    db.withSession{ implicit session =>
      if (MTable.getTables("Article").list().isEmpty) {
        Article.articles.ddl.create
        User.users.ddl.create
      }
    }
  }
}