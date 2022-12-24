USE studentManagement;

SELECT * FROM Student s
WHERE s.StudentName LIKE 'h%';

SELECT * FROM Class c
WHERE MONTH(c.StartDate)>=12;

SELECT * FROM Subject s
WHERE s.Credit>=3 AND s.Credit<=5;

UPDATE Student
SET ClassID = 2
WHERE StudentName = 'Hung';

SELECT StudentName,SubName,Mark FROM Student S
JOIN Mark M ON M.StudentID= S.StudentID
JOIN Subject S2 on S2.SubID = M.SubID
ORDER BY Mark ASC ,StudentName ASC ;