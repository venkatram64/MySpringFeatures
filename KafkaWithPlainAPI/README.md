To create the topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic my-test-topic --partitions 3 --replication-factor 1

To delete the topic 

kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic my-test-topic