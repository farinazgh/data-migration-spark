package com.acast.spark

import org.apache.log4j._
import org.apache.spark.sql._
import org.apache.spark.sql.types._

import java.sql.Timestamp
import java.util.Properties

object InsertToPostGres {
  case class Episode(
                      id: String
                      , name: String
                      , author: String
                      , contentType: String
                      , description: String
                      , episodeType: String
                      , image: String
                      , link: String
                      , rssLink: String
                      , mediaUrl: String
                      , rssGuid: String
                      , showId: String
                      , subtitle: String
                      , summary: String
                      , rating: String
                      , url: String
                      , sourceMediaUrl: String
                      , sourceMediaUrls: String
                      , sourceMediaFilename: String
                      , imageTitle: String
                      , keywords: String
                      , original: String
                      , categories: String
                      , tags: String
                      , publishingDate: String
                      , permissions: String
                      , adSettings: String
                      , lastPublished: String
                      , episodeNumber: String
                      , body: String
                      , timeline: String
                      , seasonNumber: Long
                      , contentLength: Long
                      , duration: Double
                      , hosted: Boolean
                      , deleted: Boolean
                      , created: Timestamp
                      , modified: Timestamp
                    )


  def main(args: Array[String]) {

/*
    import org.postgresql.util.PGobject
    val jsonObject = new PGobject

*/

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession
      .builder
      .appName("InsertToPostGres")
      .master("local[*]")
      .getOrCreate()
    val episodeSchema = new StructType()
      .add("id", StringType, nullable = true)
      .add("duration", DoubleType, nullable = true)
      .add("contentLength", LongType, nullable = true)
      .add("seasonNumber", LongType, nullable = true)
      .add("rating", StringType, nullable = true)
      .add("name", StringType, nullable = true)
      .add("author", StringType, nullable = true)
      .add("contentType", StringType, nullable = true)
      .add("description", StringType, nullable = true)
      .add("tags", StringType, nullable = true)
      .add("episodeType", StringType, nullable = true)
      .add("original", StringType, nullable = true)
      .add("permissions", StringType, nullable = true)
      .add("image", StringType, nullable = true)
      .add("link", StringType, nullable = true)
      .add("rssLink", StringType, nullable = true)
      .add("mediaUrl", StringType, nullable = true)
      .add("rssGuid", StringType, nullable = true)
      .add("showId", StringType, nullable = true)
      .add("subtitle", StringType, nullable = true)
      .add("summary", StringType, nullable = true)
      .add("url", StringType, nullable = true)
      .add("sourceMediaUrl", StringType, nullable = true)
      .add("sourceMediaUrls", StringType, nullable = true)
      .add("imageTitle", StringType, nullable = true)
      .add("sourceMediaFilename", StringType, nullable = true)
      .add("categories", StringType, nullable = true)
      .add("episodeNumber", StringType, nullable = true)
      .add("publishingDate", StringType, nullable = true)
      .add("keywords", StringType, nullable = true)
      .add("adSettings", StringType, nullable = true)
      .add("lastPublished", StringType, nullable = true)
      .add("body", StringType, nullable = true)
      .add("timeline", StringType, nullable = true)
      .add("hosted", BooleanType, nullable = true)
      .add("deleted", BooleanType, nullable = true)
      .add("created", TimestampType, nullable = true)
      .add("modified", TimestampType, nullable = true)

    import spark.implicits._
    val episodes = spark.read
      .schema(episodeSchema)
      .parquet("classes/data/nullRemoved.parquet")
      .as[Episode]

    episodes.printSchema()
    episodes.show()

    val connectionProperties = new Properties()
    connectionProperties.put("user", "postgres")
    connectionProperties.put("password", "Tcuaescv13571983#")
    connectionProperties.put("driver", "org.postgresql.Driver")
    //    connectionProperties.put("stringtype", "unspecified")

    /*
         .withColumn("adSettings", to_json(col("adSettings")))
         .withColumn("sourceMediaUrls", to_json(col("sourceMediaUrls")))
         .withColumn("timeline", to_json(col("timeline")))
         .withColumn("permissions", to_json(col("permissions")))
         .withColumn("body", to_json(col("body")))
         .withColumn("original", to_json(col("original")))
         .withColumn("categories", to_json(col("categories")))
         .withColumn("keywords", to_json(col("keywords")))
         .withColumn("tags", to_json(col("tags")))
         */


    episodes
      .write.mode(SaveMode.Overwrite)
      .option("truncate", value = true)
      .jdbc("jdbc:postgresql://dataservice.cwlleutxy2bh.eu-west-1.rds.amazonaws.com:5432/postgres", "public.episode_", connectionProperties)

    spark.stop()
  }
}

