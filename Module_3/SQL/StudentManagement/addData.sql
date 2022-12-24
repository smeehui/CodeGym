USE studentManagement;
INSERT INTO Class (ClassName, StartDate, Status)
VALUES ('A1', '2008-12-20', 1);
INSERT INTO Class (ClassName, StartDate, Status)
VALUES ('A2', '2008-12-22', 1);
INSERT INTO Class (ClassName, StartDate, Status)
VALUES ('B3', CURRENT_DATE, 0);
DELETE
FROM Class;
ALTER TABLE Class
    AUTO_INCREMENT = 1;
INSERT INTO Student (StudentName, Address, Phone, Status, ClassID)
VALUES ('Mạnh', 'HCM', '0912311113', 0, 1);
INSERT INTO Student(StudentName, Address, Phone, Status, ClassID)
VALUES ('Hoa', 'Hue', null, 0, 2);

INSERT INTO Subject (SubName, Credit, Status)
VALUES ('CF', 5, 1)
;
INSERT INTO Subject (SubName, Credit, Status)
VALUES ('C', 6, 1)
;
INSERT INTO Subject (SubName, Credit, Status)
VALUES ('HDJ', 5, 1)
;
INSERT INTO Subject (SubName, Credit, Status)
VALUES ('RDBMS', 10, 1)
;

INSERT INTO Mark(SubID, StudentID, Mark, ExamTimes)
VALUES (1,1,8,1);
INSERT INTO Mark(SubID, StudentID, Mark, ExamTimes)
VALUES (1,2,10,2);
INSERT INTO Mark(SubID, StudentID, Mark, ExamTimes)
VALUES (2,1,12,1);