package com.blog.models

import com.typesafe.config.ConfigFactory
//import scala.slick.driver.MySQLDriver.simple._
import scala.slick.driver.PostgresDriver.simple._
import scala.slick.jdbc.meta.MTable

/**
 * Created by Aimingnie on 4/17/14.
 */
object DAL {

  val config = ConfigFactory.load()
  //either db.mysql._
  //or db.postgresql._
  val db = Database.forURL(url = config.getString("db.postgresql.url"),
    user = config.getString("db.postgresql.user"), password= config.getString("db.postgresql.password"),
    driver = config.getString("db.postgresql.driver"))

  def databaseInit() {
    db.withSession{ implicit session =>
      if (MTable.getTables("Articles").list().isEmpty) {
        Article.articles.ddl.create
        User.users.ddl.create
      }
    }
  }
}