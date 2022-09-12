package com.acast.spark

import org.apache.log4j._
import org.apache.spark.sql._
import org.apache.spark.sql.types._

import java.sql.Timestamp

object RemoveNullDataset {

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


  /*
    val columns = episode.columns
    for (columnName <- columns) {
      if (episode.schema(columnName).dataType.typeName == "string") {
        println(episode.schema(columnName).name)
      }
    }
  */


  def main(args: Array[String]) {
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("RemoveNullDataset")
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
      .parquet("classes/data/faultyEpisode.parquet")
      .as[Episode]

    episodes.printSchema()




    //update a frame in place ?

    /*
    If you use withColumn with the name of an existing column (col_name), Spark “overwrites”/shadows the original column. This essentially gives the appearance of editing the column directly as if it were mutable.

    By creating a loop across the original columns and reusing the same DataFrame variable spark_df, I use the same principle to simulate a mutable DataFrame, creating a chain of column-wise transformations, each time “overwriting” a column (per #1 - see below)

    Spark UDFs expect all parameters to be Column types, which means it attempts to resolve column values for each parameter. Because api_function’s first parameter is a literal value that will be the same for all rows in the vector, you must use the lit() function. Simply passing col_name to the function will attempt to extract the column values for that column. As far as I could tell, passing col_name is equivalent to passing col(col_name).
     */

    import org.apache.spark.sql.functions.regexp_replace
    episodes
      .withColumn("id", regexp_replace($"id", "\u0000", ""))
      .withColumn("summary", regexp_replace($"summary", "\u0000", ""))
      .withColumn("description", regexp_replace($"description", "\u0000", ""))
      .withColumn("subtitle", regexp_replace($"subtitle", "\u0000", ""))

      .withColumn("rating", regexp_replace($"rating", "\u0000", ""))
      .withColumn("name", regexp_replace($"name", "\u0000", ""))
      .withColumn("author", regexp_replace($"author", "\u0000", ""))
      .withColumn("contentType", regexp_replace($"contentType", "\u0000", ""))
      .withColumn("tags", regexp_replace($"tags", "\u0000", ""))
      .withColumn("episodeType", regexp_replace($"episodeType", "\u0000", ""))
      .withColumn("original", regexp_replace($"original", "\u0000", ""))
      .withColumn("permissions", regexp_replace($"permissions", "\u0000", ""))
      .withColumn("image", regexp_replace($"image", "\u0000", ""))
      .withColumn("link", regexp_replace($"link", "\u0000", ""))
      .withColumn("rssLink", regexp_replace($"rssLink", "\u0000", ""))
      .withColumn("mediaUrl", regexp_replace($"mediaUrl", "\u0000", ""))
      .withColumn("rssGuid", regexp_replace($"rssGuid", "\u0000", ""))
      .withColumn("showId", regexp_replace($"showId", "\u0000", ""))
      .withColumn("url", regexp_replace($"url", "\u0000", ""))
      .withColumn("sourceMediaUrl", regexp_replace($"sourceMediaUrl", "\u0000", ""))
      .withColumn("sourceMediaUrls", regexp_replace($"sourceMediaUrls", "\u0000", ""))
      .withColumn("imageTitle", regexp_replace($"imageTitle", "\u0000", ""))
      .withColumn("sourceMediaFilename", regexp_replace($"sourceMediaFilename", "\u0000", ""))
      .withColumn("categories", regexp_replace($"categories", "\u0000", ""))
      .withColumn("episodeNumber", regexp_replace($"episodeNumber", "\u0000", ""))
      .withColumn("publishingDate", regexp_replace($"publishingDate", "\u0000", ""))
      .withColumn("keywords", regexp_replace($"keywords", "\u0000", ""))
      .withColumn("adSettings", regexp_replace($"adSettings", "\u0000", ""))
      .withColumn("lastPublished", regexp_replace($"lastPublished", "\u0000", ""))
      .withColumn("body", regexp_replace($"body", "\u0000", ""))
      .withColumn("timeline", regexp_replace($"timeline", "\u0000", ""))

      .write.mode(SaveMode.Overwrite).parquet("data/nullFreeEpisode" + System.currentTimeMillis() + ".parquet")

    spark.stop()
  }
}

