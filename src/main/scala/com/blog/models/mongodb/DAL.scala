package com.blog.models.mongodb

/**
 * Created by Aimingnie on 7/15/14.
 */
import com.mongodb.casbah.Imports._
import com.blog.Config._

object DAL {
  val mongoClient =  MongoClient(dbHost)
  val db = mongoClient(dbDatabase)
}

object Util {

  implicit class caseClassImprovements(val cc: AnyRef) {
    def toMap = {
      (Map[String, Any]() /: cc.getClass.getDeclaredFields) { (a, f) =>
        f.setAccessible(true)
        a + (f.getName -> f.get(cc))
      }
    }
  }
}