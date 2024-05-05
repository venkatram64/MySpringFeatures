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