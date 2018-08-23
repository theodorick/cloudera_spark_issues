
This example app simply loops 100 times and appends 100 rows
to a table each time. The error this demonstrates is that when
running two processes that append to a table, there is a collision
on temporary sub-folders. This is due to each process using a
temporary folder name of "0".

To reproduce the error,
 1. build and the jar by running "./quick-deploy.sh"
 2. deploy the jar to hdfs or a gateway node
 3. run the spark job TWICE, where both jobs are running concurrently
    example on how to run the job use spark2-submit
       the jar is built and placed into hdfs:///tmp/spark-example.jar
       ssh into a hadoop gateway node
       run the following:
```
          rm ./spark-example.jar
          hdfs dfs -get hdfs:///tmp/spark-example.jar ./spark-example.jar
          spark2-submit --class com.example.TableAppenderApp spark-example.jar --master yarn --deploy-mode cluster
```

**NOTE:** Remember, the issue only shows up if two spark jobs are running SIMULTANEOUSLY, so run spark2-submit from two separate login sessions. ONLY ONE JOB FAILS
      
```Example error: Spark fails with an error similar to...
java.io.FileNotFoundException: File hdfs:///tmp/example.db/numbers/_temporary/0 does not exist.
or

Caused by: org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.hdfs.server.namenode.LeaseExpiredException): No lease on /tmp/example.db/numbers/_temporary/0/_temporary/attempt_20180823144832_0000_m_000000_0/part-00000-25d48db6-a221-4674-869d-f136da156378-c000.snappy.parquet (inode 37557163): File does not exist. Holder DFSClient_attempt_20180823144832_0000_m_000000_0_898761748_41 does not have any open files
```
**NOTICE** the sub-folder which is supposed to be a unique task id is 0!
**ALSO** there is a second sub folder under the 0 temporary subfolder!
