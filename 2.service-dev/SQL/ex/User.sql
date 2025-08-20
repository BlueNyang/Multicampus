CREATE TABLE users (
   user_id    VARCHAR2(20) PRIMARY KEY,
   username   VARCHAR(30),
   password   VARCHAR(30) NOT NULL,
   user_email VARCHAR(50)
);