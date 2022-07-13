CREATE DATABASE evently;
DROP DATABASE evently;
DROP TABLE evently.plogindetails;
CREATE TABLE evently.plogindetails (
  id INT NOT NULL AUTO_INCREMENT,
  userName VARCHAR(300) NOT NULL,
  userPassword VARCHAR(300) NOT NULL,
  participantsName VARCHAR(300) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (userName)
);

DROP TABLE  evently.event;
CREATE TABLE evently.event (
  id INT NOT NULL AUTO_INCREMENT,
  event_no VARCHAR(300) NOT NULL,
  event_name VARCHAR(300) NOT NULL,
  coordinator_name VARCHAR(300) NOT NULL,
  coordinator_no VARCHAR(300) NOT NULL,
  free VARCHAR(300) NOT NULL,
  venue VARCHAR(300) NOT NULL,
  date_time VARCHAR(300) NOT NULL,
  PRIMARY KEY (id)
);


DROP TABLE  evently.card;
CREATE TABLE evently.card (
  id INT NOT NULL AUTO_INCREMENT,
  event_name VARCHAR(300) NOT NULL,
  event_no VARCHAR(300) NOT NULL,
  card_no VARCHAR(300) NOT NULL,
  exp_date VARCHAR(300) NOT NULL,
  cvv_no VARCHAR(300) NOT NULL,
  card_holder_name VARCHAR(300) NOT NULL,
  PRIMARY KEY (id)
);