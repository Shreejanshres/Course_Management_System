CREATE DATABASE collegeinformation;

USE collegeinformation;

CREATE TABLE courses (
    ID int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(40) NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE modules (
    ID int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(40) NOT NULL,
    Level int(11) NOT NULL,
    Course_ID int(11) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (Course_ID) REFERENCES courses(ID)
);
CREATE TABLE optionalmodules (
    ID int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(40) NOT NULL,
    Course_ID int(11) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (Course_ID) REFERENCES courses(ID)
);
CREATE TABLE admins (
    ID int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(40) NOT NULL,
    Address varchar(40) NOT NULL,
    Phone varchar(40) NOT NULL,
    DOB varchar(40) NOT NULL,
    Email varchar(40) NOT NULL,
    Password varchar(40) NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE students (
    ID int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(40) NOT NULL,
    Address varchar(40) NOT NULL,
    Phone varchar(40) NOT NULL,
    DOB varchar(40) NOT NULL,
    Level int(11) NOT NULL,
    Email varchar(40) NOT NULL,
    Password varchar(40) NOT NULL,
    Course_ID int(11) NOT NULL,
    Marks1 int(11),
    Marks2 int(11),
    Marks3 int(11),
    Option1 int(11),
    Option2 int(11),
    PRIMARY KEY (ID),
    FOREIGN KEY (Course_ID) REFERENCES courses(ID),
    FOREIGN Key (Option1) REFERENCES optionalmodules(ID),
    FOREIGN key (Option2) REFERENCES optionalmodules(ID)
);

CREATE TABLE teachers (
    ID int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(40) NOT NULL,
    Address varchar(40) NOT NULL,
    Phone varchar(40) NOT NULL,
    DOB varchar(40) NOT NULL,
    Email varchar(40) NOT NULL,
    Password varchar(40) NOT NULL,
    Module_ID int(11) ,
    Optional_Id int(11) ,
    PRIMARY KEY (ID),
    FOREIGN KEY (Module_ID) REFERENCES modules(ID),
    FOREIGN Key (Optional_Id) REFERENCES optionalmodules(ID)
);
INSERT INTO admins(ID,Name,Address,Phone,DOB,Email,Password) VALUES(1,"Admin","Naxal","9878942178","20/08/1998",'admin1@eclass.edu.np',"admin1");