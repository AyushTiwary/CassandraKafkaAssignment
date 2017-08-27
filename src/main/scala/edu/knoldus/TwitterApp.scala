package edu.knoldus

import scala.concurrent.Future
import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import twitter4j._

class TwitterApp {
  val twitter: Twitter = TwitterFactory.getSingleton
  def getUserStatuses(userName: String): Future[List[String]] = Future{
    twitter.getUserTimeline(userName).asScala.toList.flatMap{
      tweet => tweet.getHashtagEntities.toList.map(_.getText)
    }
  }
}
