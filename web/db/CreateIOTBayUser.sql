/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  komei
 * Created: 2020-5-29
 */
drop table if exists `iotbay_user`;

create table iotbay_user(
	USER_ID varchar(30) not null,
	USER_FIRST_NAME varchar(30) not null,
	USER_SECOND_NAME varchar(30) not null,
	USER_PASSWORD varchar(20) not null,
	USER_DOB varchar(20) default null,
	USER_PHONE varchar(20) default null,
	USER_EMAIL varchar(30) default null,
	USER_ADDRESS varchar(100) not null,
	USER_IS_ADMIN decimal(6, 0) not null,
	primary key(USER_ID)
);
