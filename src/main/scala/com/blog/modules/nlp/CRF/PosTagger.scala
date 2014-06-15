package com.blog.modules.nlp.CRF
/**
 * Created by tomtung
 * Source: https://github.com/tomtung/nlp-class/tree/master/hw4
 *
 */
trait PosTagger {
  def computePosTag(input: IndexedSeq[String]): IndexedSeq[String]
}