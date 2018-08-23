FILE='target/scala-2.11/example-spark-assembly-1.0.0.jar'

rm $FILE

set -e

sbt -Xss256m 'set test in assembly := {}' clean assembly

## upload to hdfs using httpfs

#HTTPFS_URL='????'
#curl -vf "$HTTPFS_URL/spark-example.jar/?user.name=hdfs&op=CREATE&overwrite=true" -XPUT --data-binary @$FILE -H "Content-Type: application/octet-stream" -L -k
#curl -vf "$HTTPFS_URL/spark-example.jar/?user.name=hdfs&op=SETPERMISSION&permission=777" -XPUT  -k
