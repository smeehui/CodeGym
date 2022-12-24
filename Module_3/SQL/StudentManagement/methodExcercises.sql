USE studentManagement;
SELECT s.Address, COUNT(s.Address) as NumberOfStudents
FROM Student s
GROUP BY s.Address;

SELECT s2.StudentID,S2.StudentName,AVG(m.Mark) as AVERAGE FROM Mark m
JOIN Student S2 on m.StudentID = S2.StudentID
GROUP BY S2.StudentName,s2.StudentID;


SELECT s2.StudentID, S2.StudentName, AVG(m.Mark) as AVERAGE
FROM Mark m
         JOIN Student S2 on m.StudentID = S2.StudentID
GROUP BY S2.StudentName, s2.StudentID
HAVING AVERAGE >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);



