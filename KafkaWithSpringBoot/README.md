On windows:
Step 1: start the zookeeper
D:\Kafka_srijan\kafka>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
Step 2: start the kafka server
D:\Kafka_srijan\kafka>bin\windows\kafka-server-start.bat config\server.properties
Step 3: create the topic
D:\Kafka_srijan\kafka\bin\windows>kafka-topics.bat --create --topic emp-topic --partitions 3 --replication-factor 1 --bootstrap-server localhost:9092

Step 4: list of topics
D:\Kafka_srijan\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --list

Step 5: describe the topic
D:\Kafka_srijan\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --describe emp-topic

step 6: To simulate producer and consumer run both of them in different consoles.
in producer console enter some messages, automatically consumer reads them

start producer:  
D:\Kafka_srijan\kafka>bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic emp-topic

into this window enter messages and hit enter

start consumer:
D:\Kafka_srijan\kafka>bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic emp-topic --from-beginning



-------------------------
To create topic in kafka

kafka-topics.sh --bootstrap-server localhost:9092 --create --topic my-sb-emp-topic --partitions 3 --replication-factor 1


To delete the topic

kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic my-sb-emp-topic



use postman to send the data in the following way, using post request
http://localhost:8090/employee/newEmp

{
"firstName": "Srijan",
"lastName": "Veerareddy",
"designation": "Software engineer",
"employeeNo": "AN-103"
}