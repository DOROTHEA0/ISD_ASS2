
drop table ORDERS;
drop table ORDERLINES;

create table ORDERS
(
	ID INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
	USERID VARCHAR(50),
	DATE TIMESTAMP default CURRENT_TIMESTAMP,
	STATUS VARCHAR(50),
        TOTAL   VARCHAR(50)
);

create table ORDERLINES
(
	ID INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
	ORDERID INTEGER,
        DEVICEID VARCHAR(50),
        QUANTITY   INTEGER,
        DQUANTITY   INTEGER
);

DROP TABLE DEVICES;
create table DEVICES
(
	ID VARCHAR(10) not null primary key,
	PRICE VARCHAR(10),
	TYPE VARCHAR(10),
	QUANTITY VARCHAR(10),
	NAME VARCHAR(30)
);

INSERT INTO DEVICES (ID, PRICE, "TYPE", QUANTITY, "NAME") 
	VALUES ('1111', '$2285', 'laptop', '13', 'game laptop');
INSERT INTO DEVICES (ID, PRICE, "TYPE", QUANTITY, "NAME") 
	VALUES ('7777', '$783', 'mobile', '326', 'Huawei mobile phone');
INSERT INTO DEVICES (ID, PRICE, "TYPE", QUANTITY, "NAME") 
	VALUES ('2222', '$35', 'smart home', '134', 'Smart Plug');
INSERT INTO DEVICES (ID, PRICE, "TYPE", QUANTITY, "NAME") 
	VALUES ('3333', '$32', 'smart home', '100', 'Wireless Switch');
INSERT INTO DEVICES (ID, PRICE, "TYPE", QUANTITY, "NAME") 
	VALUES ('4444', '$78', 'smart home', '100', 'Air Condition');
INSERT INTO DEVICES (ID, PRICE, "TYPE", QUANTITY, "NAME") 
	VALUES ('5555', '$56', 'smart home', '100', 'Floor Mopping Robot');
INSERT INTO DEVICES (ID, PRICE, "TYPE", QUANTITY, "NAME") 
	VALUES ('6666', '$6', 'cable', '100', 'Network Cable');
