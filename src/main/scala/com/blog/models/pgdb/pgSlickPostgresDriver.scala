package com.blog.models.pgdb

import slick.driver.PostgresDriver
import com.github.tminglei.slickpg._

trait pgSlickPostgresDriver extends PostgresDriver
with PgArraySupport
with PgDateSupport
with PgRangeSupport
with PgHStoreSupport
with PgSearchSupport
with PgDateSupportJoda {

  override lazy val Implicit = new ImplicitsPlus {}
  override val simple = new SimpleQLPlus {}

  trait ImplicitsPlus extends Implicits
  with ArrayImplicits
  with DateTimeImplicits
  with RangeImplicits
  with HStoreImplicits
  with SearchImplicits


  trait SimpleQLPlus extends SimpleQL
  with ImplicitsPlus
  with SearchAssistants
}

object pgSlickPostgresDriver extends pgSlickPostgresDriver