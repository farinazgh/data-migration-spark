export PATH=$PATH:/Users/farinaz.ghasemi/tools/spark/bin
spark-submit --master "local[*]" --class com.acast.
spark.RemoveNullDataset data-migration-spark-1.0-SNAPSHOT.jar 