/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  komei
 * Created: 2020-5-31
 */
drop table if exists `iotbay_user`;

create table iotbay_userlog(
	LOG_ID varchar(30) not null,
	USER_ID varchar(30) not null,
	USER_STATUS varchar(30) not null,
	STATUS_TIME varchar(30) not null,
	
	primary key(LOG_ID)
);
