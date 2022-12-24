CREATE DATABASE IF NOT EXISTS studentManagement;
USE studentManagement;
CREATE TABLE IF NOT EXISTS Class
(
    ClassID INT PRIMARY KEY AUTO_INCREMENT,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME NOT NULL,
    Status Bit NOT NULL
)
;
CREATE TABLE IF NOT EXISTS Student
(
    StudentID   INT PRIMARY KEY AUTO_INCREMENT,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassID     INT NOT NULL,
    FOREIGN KEY ClassFk (ClassID) REFERENCES Class (ClassID)

)
;
CREATE TABLE IF NOT EXISTS Subject
(
    SubID   INT PRIMARY KEY AUTO_INCREMENT,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT (1),
    Status  BIT                  DEFAULT (1),
    CHECK ( Credit >= 1 )
);
CREATE TABLE IF NOT EXISTS Mark
(
    MarkID    INT PRIMARY KEY AUTO_INCREMENT,
    SubID     INT NOT NULL ,
    StudentID INT NOT NULL ,
    Mark      FLOAT DEFAULT (0),
    ExamTimes TINYINT,
    CHECK ( Mark BETWEEN 0 AND 100),
    CONSTRAINT FOREIGN KEY (SubID) REFERENCES Subject (SubID),
    CONSTRAINT FOREIGN KEY (StudentID) REFERENCES Student (StudentID)
);





