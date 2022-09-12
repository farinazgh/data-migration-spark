package com.acast.spark

import org.apache.log4j._
import org.apache.spark.sql._
import org.apache.spark.sql.types._

import java.sql.Timestamp

object GenerateEpisodeWithDuplicateIds {


  case class Episode(
                      id: String
                      , showId: String
                      , author: String
                      , categories: String
                      , contentLength: Long
                      , contentType: String
                      , description: String
                      , duration: Double
                      , episodeNumber: String
                      , episodeType: String
                      , hosted: Boolean
                      , image: String
                      , imageTitle: String
                      , keywords: String
                      , lastPublished: String
                      , link: String
                      , rssLink: String
                      , mediaUrl: String
                      , name: String
                      , publishingDate: String
                      , seasonNumber: Long
                      , subtitle: String
                      , summary: String
                      , rating: String
                      , tags: String
                      , adSettings: String
                      , original: String
                      , permissions: String
                      , sourceMediaUrl: String
                      , sourceMediaUrls: String
                      , sourceMediaFilename: String
                      , timeline: String
                      , url: String
                      , deleted: Boolean
                      , rssGuid: String
                      , created: Timestamp
                      , modified: Timestamp
                      , body: String
                    )

  def main(args: Array[String]) {

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession
      .builder
      .appName("GenerateEpisodeWithDuplicateIds")
      .master("local[*]")
      .getOrCreate()

    val episodeSchema = new StructType()
      .add("id", StringType, nullable = true)
      .add("showId", StringType, nullable = true)
      .add("author", StringType, nullable = true)
      .add("categories", StringType, nullable = true)
      .add("contentLength", LongType, nullable = true)
      .add("contentType", StringType, nullable = true)
      .add("description", StringType, nullable = true)
      .add("duration", DoubleType, nullable = true)
      .add("episodeNumber", StringType, nullable = true)
      .add("episodeType", StringType, nullable = true)
      .add("hosted", BooleanType, nullable = true)
      .add("image", StringType, nullable = true)
      .add("imageTitle", StringType, nullable = true)
      .add("keywords", StringType, nullable = true)
      .add("lastPublished", StringType, nullable = true)
      .add("link", StringType, nullable = true)
      .add("rssLink", StringType, nullable = true)
      .add("mediaUrl", StringType, nullable = true)
      .add("name", StringType, nullable = true)
      .add("publishingDate", StringType, nullable = true)
      .add("seasonNumber", LongType, nullable = true)
      .add("subtitle", StringType, nullable = true)
      .add("summary", StringType, nullable = true)
      .add("rating", StringType, nullable = true)
      .add("tags", StringType, nullable = true)
      .add("adSettings", StringType, nullable = true)
      .add("original", StringType, nullable = true)
      .add("permissions", StringType, nullable = true)
      .add("sourceMediaUrl", StringType, nullable = true)
      .add("sourceMediaUrls", StringType, nullable = true)
      .add("sourceMediaFilename", StringType, nullable = true)
      .add("timeline", StringType, nullable = true)
      .add("url", StringType, nullable = true)
      .add("deleted", BooleanType, nullable = true)
      .add("rssGuid", StringType, nullable = true)
      .add("created", TimestampType, nullable = true)
      .add("modified", TimestampType, nullable = true)
      .add("body", StringType, nullable = true)


    import spark.implicits._
    spark.conf.set("spark.sql.legacy.json.allowEmptyString.enabled", value = true)
    val ds = spark.read.option("inferSchema", "true").schema(episodeSchema).json("data/episodes.json").as[Episode]

/*

    spark.read.schema(episodeSchema).json("data/episodes.json").filter($"_corrupt_record".isNotNull).count()
    spark.read.schema(episodeSchema).json("data/episodes.json").select("_corrupt_record").show()

*/

    ds.show()
    ds.printSchema()

    ds.write.mode(SaveMode.Overwrite).parquet("data/episodes" + System.currentTimeMillis())

    /*

        val json = "[{\"resource_serialized\":\"{\\\"createdOn\\\":\\\"2000-07-20 00:00:00.0\\\",\\\"genderCode\\\":\\\"0\\\"}\",\"id\":\"00529e54-0f3d-4c76-9d3\"}]"

        import spark.implicits._
        val df = spark.read.json(Seq(json).toDS)
        val jsonColumn = from_json($"resource_serialized", MapType(StringType, StringType))
        val keysDF = df.select(explode(map_keys(jsonColumn))).distinct()
        val keys = keysDF.collect().map(f => f.get(0))
        val keyCols = keys.map(f => jsonColumn.getItem(f).as(f.toString))
        df.select($"id" +: keyCols: _*).show(false)

        */


    spark.stop()
  }
}

