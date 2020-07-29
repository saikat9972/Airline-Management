*Airline-management-system*

Steps -install wamp -> Run the wamp -> Go to Mysql console and create Database named Airline 

1 - create table with name login and also enter details

create table login(username varchar(20), password varchar(20));

2 -  create table with name flight and also enter details

create table flight(f_code varchar(10), f_name varchar(20), src varchar(30), dst varchar(30));

3 - create table with name sector and also enter details
create table sector(flight_code varchar(20), capacity varchar(10), class_code varchar(5), class_name varchar(20));

4- create table with name passenger
create table passenger(name varchar(30), gender varchar(20), address varchar(30), ph_no varchar(30), paymment_id varchar(20), fl_id varchar(20), class_code varchar(5), ticket_price varchar(20));


5 -create table with name cancellation
 create table cancellation(name varchar(30), gender varchar(20), address varchar(30), ph_no varchar(30), paymment_id varchar(20), fl_id varchar(20), class_code varchar(5), ticket_price varchar(20));


->Install NetBeans IDE

->Run NetBeans and add the Project 

->add required libraries mysql-dbc-driver and rs2xml.jar

->run the project.
