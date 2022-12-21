USE studentManagement;

SELECT *
FROM Class
WHERE Status = TRUE;

SELECT *
FROM Subject
WHERE Credit < 10;

SELECT s.StudentID, s.StudentName, c.ClassName
FROM Student s
         INNER JOIN Class c ON s.ClassID = c.ClassID
WHERE ClassName = 'A1';

SELECT s.StudentID, s.StudentName, ClassName, SubName, Mark
FROM Student s
         JOIN Class C on C.ClassID = s.ClassID
         JOIN Mark M on s.StudentID = M.StudentID
         JOIN Subject S2 on S2.SubID = M.SubID;

SELECT s.StudentID, s.StudentName, ClassName, SubName, Mark
FROM Student s
         JOIN Class C on C.ClassID = s.ClassID
         JOIN Mark M on s.StudentID = M.StudentID
         JOIN Subject S2 on S2.SubID = M.SubID
WHERE SubName = 'CF'
