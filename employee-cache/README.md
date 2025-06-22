step 1: Run the docker-compose up  

which is for starting the mysql server

if you want to stop the mysql server then run the docker-compose down


step 1: if you want you can use local mysql server, but change the port number in application.yml
create database employee_db and run the employee.sql script





for update

for post  http://localhost:8081/api/v1/employees

{
"firstName":"Srijan",
"lastName":"Veerareddy",
"email": "srijan.veerareddy@sri.com",
"designation":"Developer",
"employeeNo": "SV100"   
}

put    http://localhost:8081/api/v1/employees

{
"id": 2,
"firstName":"Srijan",
"lastName":"Veerareddy",
"email": "srijan.veerareddy@sri.com",
"designation":"Sr. Developer",
"employeeNo": "SV100"   
}

get  http://localhost:8081/api/v1/employees/srijan.veerareddy@gmail.com

