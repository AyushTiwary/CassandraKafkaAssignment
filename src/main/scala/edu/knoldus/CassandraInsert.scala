package edu.knoldus

import org.slf4j.{Logger, LoggerFactory}
import com.datastax.driver.core.{Row, Session}

import scala.collection.JavaConverters._

object CassandraInsert extends CassandraProvider{
  private val log: Logger = LoggerFactory.getLogger(getClass.getName)
  def insertHashTags(hashTag: String): List[Row] = {
    cassandraConn.execute(s"CREATE TABLE IF NOT EXISTS hashtagstable (hashtag text PRIMARY KEY) ")
    log.info(s"Inserting $hashTag")
    cassandraConn.execute(s"INSERT INTO hashtagstable(hashtag) VALUES ('$hashTag')").asScala.toList
  }
}
