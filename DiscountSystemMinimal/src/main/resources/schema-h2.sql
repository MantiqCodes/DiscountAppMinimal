	--select count (*) from rds_users where USER_TYPE='Affilitate'; --76
	--select count (*) from rds_users where USER_TYPE='Employee'; --116
	--select count (*) from rds_users where USER_TYPE='Customer'; --308
	--select count(*) from rds_users; --500
	--select *from RDS_USERS;


DROP TABLE IF EXISTS RDS_USERS CASCADE;

CREATE SEQUENCE IF NOT EXISTS RDS_USERS_SEQ;


CREATE TABLE IF NOT EXISTS RDS_USERS (
						ID  BIGINT DEFAULT  RDS_USERS_SEQ .nextval PRIMARY KEY ,
						FIRST_NAME VARCHAR(150) ,
						LAST_NAME VARCHAR(150) ,
						USERNAME VARCHAR(50 ) not null unique,
						PASSWORD VARCHAR(50) not null, 
						EMAIL    VARCHAR(256 ) unique not null , 
						ADDRESS  VARCHAR(200 ), 
						USER_TYPE VARCHAR(10),
						PHONE   VARCHAR(60 ), 
						CITY  VARCHAR(100 ), 
						COUNTRY  VARCHAR(100 ),  
						IS_ACTIVE NUMERIC(1,0), 
						ACTIVE_DATE TIMESTAMP default CURRENT_TIMESTAMP(),
						ENT_DATE TIMESTAMP default CURRENT_TIMESTAMP()  
						);


 DROP TABLE IF EXISTS RDS_ITEMS CASCADE;
CREATE SEQUENCE  IF NOT EXISTS  RDS_ITEMS_SEQ;
 CREATE TABLE IF NOT EXISTS RDS_ITEMS(
 					ID BIGINT DEFAULT  RDS_ITEMS_SEQ .nextval  PRIMARY KEY , 
 					NAME VARCHAR(150) NOT NULL,
 					DESCRIPTION VARCHAR(256),
 					PRICE NUMERIC(10,5),
 					CATEGORY VARCHAR(50),
 					UNIT_OF_MEASURE VARCHAR(10)
 					);

 					
DROP TABLE IF EXISTS RDS_INVENTORY CASCADE; 					
CREATE SEQUENCE  IF NOT EXISTS RDS_INVENTORY_SEQ;
 CREATE TABLE IF NOT EXISTS RDS_INVENTORY(
 				ID BIGINT DEFAULT  RDS_INVENTORY_SEQ .nextval  PRIMARY KEY,
 				QTY_ON_HAND NUMERIC(10),
 				QTY_SOLD NUMERIC(10),
 				QTY_TOTAL NUMERIC(10),
 				ENT_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
 				ITEM_ID BIGINT , FOREIGN KEY(ITEM_ID) REFERENCES RDS_ITEMS(ID)

 				);
 				
 				
 				

DROP TABLE IF EXISTS RDS_INVOICE CASCADE;
CREATE SEQUENCE IF NOT EXISTS RDS_INVOICE_SEQ;
CREATE TABLE IF NOT EXISTS RDS_INVOICE (
						ID BIGINT DEFAULT  RDS_INVOICE_SEQ.nextval PRIMARY KEY , 
						ENTRY_COUNT NUMERIC(10),
						DOC_PRICE NUMERIC(10,5),
						DOC_PRICE_AFTER_DISCOUNT NUMERIC(10,5),
						DOC_DISCOUNT NUMERIC(10,5),
						DISCOUNT_BASE VARCHAR(50),
						NON_GROCERY_ITEM_TOTAL NUMERIC(10,5),
						DOC_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
						CUSTOMER_ID BIGINT ,FOREIGN KEY(CUSTOMER_ID) REFERENCES RDS_USERS(ID)
						
						);



DROP TABLE IF EXISTS RDS_INVOICE_DETAILS CASCADE;
CREATE SEQUENCE IF NOT EXISTS RDS_INVOICE_ITEMS_SEQ;
CREATE TABLE IF NOT EXISTS RDS_INVOICE_ITEMS (
						ID BIGINT DEFAULT  RDS_INVOICE_ITEMS_SEQ.nextval PRIMARY KEY , 
						INVOICE_ID BIGINT ,
						QTY NUMERIC(10,5),
						RATE NUMERIC(10,5),
						ITEM_TOTAL NUMERIC(10,5),
						ITEM_ID BIGINT, 
						FOREIGN KEY(ITEM_ID) REFERENCES RDS_ITEMS(ID)
						
						);
ALTER TABLE RDS_INVOICE_ITEMS ADD	FOREIGN KEY(INVOICE_ID) REFERENCES RDS_INVOICE(ID);


