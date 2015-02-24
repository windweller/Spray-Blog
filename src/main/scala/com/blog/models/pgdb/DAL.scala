package com.blog.models.pgdb


import com.blog.Config._

import scala.slick.jdbc.meta.MTable


class DAL extends ArticleComponent with UserComponent{

  import pgSlickPostgresDriver.simple._

  val db = Database.forURL(url = dbURL, user = dbUser, password= dbPassword, driver = dbDriver)

  def databaseInit() {

    db.withSession{ implicit session =>

      if (MTable.getTables("Article").list(session).isEmpty) {
        articles.ddl.create
      } else if (MTable.getTables("User").list(session).isEmpty) {
        users.ddl.create
      }

    }
  }
}

object DAL extends DAL