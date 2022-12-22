USE studentManagement;

#Môn học có credit lớn nhất
SELECT * FROM Subject
WHERE Credit > ALL (SELECT Credit FROM Subject);

# Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT s.SubID,s.SubName,s.Credit,s.Status,M.Mark  FROM Subject s
LEFT JOIN  Mark M  on s.SubID = M.SubID
WHERE Mark >= ALL (SELECT Mark FROM Mark);

# Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT s.StudentID, StudentName, Address, Phone, Status,AVG(M.Mark) AVERAGE_MARK FROM Student s
JOIN Mark M on s.StudentID = M.StudentID
GROUP BY s.StudentID, StudentName, Address, Phone, Status
ORDER BY AVERAGE_MARK DESC ;