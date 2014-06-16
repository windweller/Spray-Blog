package com.blog.modules.chat

/**
 * Created by Aimingnie on 6/15/14.
 */
class RawCookieUtil(rawCookie: String) {


}

object RawCookieUtil {
  /**
   * This function returns either null
   * or the encrypted string associated with
   * "wind_castle_userIdentity"
   *
   * @param rawCookie
   * @return
   */
  def parse(rawCookie: String): Option[String] = {
    val rawCookies = rawCookie.trim.split(";")
    val mapOfCookies = rawCookies.flatMap(rawCookie => convertToMap(rawCookie)).toMap
    mapOfCookies.get("wind_castle_userIdentity")
  }

  def convertToMap(rawCookie: String): Map[String, String] = {
    val rawCookieNameAndValue = rawCookie.split("=")
    Map(rawCookieNameAndValue(0).trim -> rawCookieNameAndValue(1).trim)
  }
}