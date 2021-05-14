create database tweet_app;

use tweet_app;

create table user_details(
us_first_name varchar(100) not null, 
us_last_name varchar(100), 
us_gender varchar(20) not null,  
us_email_id varchar(100) not null unique, 
us_dob date,
us_password varchar(100) not null
);

create table tweet_details(
tweet_user varchar(100) not null,
tweet_message varchar(200) not null
);



