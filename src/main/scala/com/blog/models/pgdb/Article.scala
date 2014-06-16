package com.blog.models.pgdb

//import scala.slick.driver.MySQLDriver.simple._
import java.sql.Timestamp

import scala.slick.driver.PostgresDriver.simple._

/**
 * Created by Aimingnie on 4/12/14.
 */
object Article {

case class Article(id: Option[Int] = None, title: String, author: String, content: String,
                   modifiedTime: Option[Timestamp] = None, createdTime: Option[Timestamp] = None,
                   pinned: Boolean = false, isDraft: Boolean = false, language: Byte = 0,
                   coverImage: Option[String] = None)

class ArticleTable(tag: Tag) extends Table[Article](tag, "Article") {

  def id = column[Option[Int]]("ART_ID", O.PrimaryKey, O.AutoInc)
  def title = column[String]("ART_TITLE")
  def author = column[String]("ART_AUTHOR")
  def content = column[String]("ART_CONTENT", O.DBType("TEXT"))
  def modifiedTime = column[Option[Timestamp]]("MODIFIED_DATE", O.Nullable)
  def createdTime = column[Option[Timestamp]]("CREATED_DATE")
  def pinned = column[Boolean]("PINNED") // 0 means unpinned, 1 means pinned
  def isDraft = column[Boolean]("ISDRAFT") // 0 means not draft, 1 draft
  def language = column[Byte]("LANGUAGE") // 0 means English, 1 means Chinese

  def coverImage = column[Option[String]]("COVER_IMAGE", O.Nullable)

  def * = (id, title, author, content, modifiedTime,
    createdTime, pinned, isDraft, language, coverImage) <> (Article.tupled, Article.unapply _)
}

  val articles = TableQuery[ArticleTable]

  def take(number: Int)(implicit s: Session) = {
    val query = for(a <- articles if a.pinned === false && a.isDraft === false) yield a
    query.take(number).list
  }

  /* Insert a new Article  */
  /* takes in an Article, return the Article with auto id attached  */
  def insert(article: Article)(implicit s: Session): Article = {
    val articleId = articles returning articles.map(_.id) += article
    article.copy(id = articleId)
  }

  def takePinned(implicit s: Session) = {
    val query = for(a <- articles if a.pinned === true && a.isDraft === false) yield a
    query.list
  }

  def get(id: Int)(implicit s: Session) = {
    val query = for(a <- articles if a.id === id && a.isDraft === false) yield a
    query.list
  }

}