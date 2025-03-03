To create the topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic my-test-topic --partitions 3 --replication-factor 1

To delete the topic 

kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic my-test-topic




on ubantu

zookeeper-server-start.sh ~/kafka_2.13-3.1.0/config/zookeeper.properties
kafka-server-start.sh ~/kafka_2.13-3.1.0/config/kraft/server.properties


or
after install confluent kafka on ubuntu

confluent local services start


kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first-topic
kafka-topics.sh --bootstrap-server localhost:9092 --describe

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic --from-beginning

confluent local services stop



