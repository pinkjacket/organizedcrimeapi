SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS organizations (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 truename VARCHAR,
 location VARCHAR,
 membership VARCHAR,
 govtrelationship VARCHAR
);

CREATE TABLE IF NOT EXISTS individuals (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 organizationid INTEGER
);