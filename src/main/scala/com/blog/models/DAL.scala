package com.blog.models

import com.typesafe.config.ConfigFactory
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.jdbc.meta.MTable

/**
 * Created by Aimingnie on 4/17/14.
 */
object DAL {

  val config = ConfigFactory.load()

  val db = Database.forURL(url = config.getString("db.url"),
    user = config.getString("db.user"), password = config.getString("db.password"), driver = config.getString("db.driver"))

  val currentTables = List[DBTable](Article, User)

  db.withSession{ implicit session =>
    if (MTable.getTables("Articles").list().isEmpty) {
      Article.articles.ddl.create
    }

//    for (table <- currentTables) {
//      if (MTable.getTables(table.getClass.getName.split("\\$").last).list().isEmpty)
//        table.getTableQuery.ddl
//    }

  }

}


//  Database.forURL("jdbc:mysql://localhost:3306/SprayBlog?characterEncoding=UTF-8", user="root", password="root", driver = "com.mysql.jdbc.Driver") withSession {
//    implicit session =>
//
//      (Article.articles.ddl ++ User.users.ddl).create
//  }