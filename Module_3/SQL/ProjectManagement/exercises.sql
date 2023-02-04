USE projectMgmt;
-- ***Dùng các hàm gộp
-- Câu 1: Cho biết số lượng giáo viên của toàn trường
SELECT COUNT(MAGV) AS SOLUONGGIAOVIEN
FROM GIAOVIEN;
-- Câu 2: Cho biết số lượng giáo viên của bộ môn HTTT
SELECT COUNT(MAGV) AS SOLUONGGIAOVIEN
FROM GIAOVIEN
WHERE GIAOVIEN.MABM = 'HTTT';

-- Câu 3: Tính số lượng giáo viên có người quản lý về mặt chuyên môn
SELECT MAGV, HOTEN
FROM GIAOVIEN
WHERE GVQLCM IS NOT NULL;
-- Câu 4: Tính số lượng giáo viên làm nhiệm vụ quản lý chuyên môn cho giáo viên khác mà thuộc bộ môn HTTT.
SELECT COUNT(MAGV) AS SOLUONGGIAOVIEN
FROM GIAOVIEN
WHERE MAGV IN (SELECT MAGV
               FROM GIAOVIEN
               WHERE GVQLCM IS NOT NULL
                 AND MABM = 'HTTT');
-- Câu 5:  Tính lương trung bình của giáo viên bộ môn Hệ thống thông tin
SELECT AVG(LUONG) AS TB_LUONG
FROM GIAOVIEN
WHERE MABM = 'HTTT';

-- ***Dùng group by
-- Câu 6: Với mỗn bộ môn cho biết bộ môn (MAMB) và số lượng giáo viên của bộ môn đó.
SELECT MABM, COUNT(MAGV) SLGIAOVEN
FROM GIAOVIEN
GROUP BY MABM;

-- Câu 7: Với mỗi giáo viên, cho biết MAGV và số lượng công việc mà giáo viên đó có tham gia.
SELECT THAMGIADT.MAGV, HOTEN, COUNT(THAMGIADT.MAGV) As SLCONGVIEC
FROM THAMGIADT
         JOIN GIAOVIEN g on g.MAGV = THAMGIADT.MAGV
GROUP BY THAMGIADT.MAGV, HOTEN;
-- Câu 8: Với mỗi giáo viên, cho biết MAGV và số lượng đề tài mà giáo viên đó có tham gia.
SELECT GIAOVIEN.MAGV, HOTEN, count(d.MAGV) SOLUONGDETAI
FROM GIAOVIEN
         JOIN THAMGIADT d on GIAOVIEN.MAGV = d.MAGV
GROUP BY GIAOVIEN.MAGV, HOTEN;
-- Câu 9:  Với mỗi bộ môn, cho biết số đề tài mà giáo viên của bộ môn đó chủ trì
SELECT b.MABM, b.TENBM, count(g.MAGV) AS SODETAI
FROM BOMON b
         JOIN GIAOVIEN g on b.MABM = g.MABM
         Join DETAI d on g.MAGV = d.GVCNDT
GROUP BY b.MABM;
-- Câu 10: Với mỗn bộ môn cho biết tên bộ môn và số lượng giáo viên của bộ môn đó.
SELECT b.TENBM, COUNT(g.MAGV) AS SLGIAOVIEN
FROM BOMON b
         LEFT JOIN GIAOVIEN g on b.MABM = g.MABM
GROUP BY b.TENBM;

SELECT BM.TENBM, IFNULL(BM2.SLGV, 0)
FROM BOMON BM
         LEFT JOIN (SELECT GV2.MABM, COUNT(GV2.MABM) SLGV
                    FROM GIAOVIEN GV2
                    GROUP BY GV2.MABM) AS BM2 ON BM.MABM = BM2.MABM;
SELECT *, (SELECT COUNT(GIAOVIEN.MAGV) FROM GIAOVIEN WHERE GIAOVIEN.MABM = BOMON.MABM) AS SLGV
FROM BOMON;
-- ***Dùng GROUP BY + HAVING
-- Câu 11: Cho biết những bộ môn từ 2 giáo viên trở lên.
SELECT b.TENBM, COUNT(g.MAGV) AS SLGIAOVIEN
FROM BOMON b
         JOIN GIAOVIEN g on b.MABM = g.MABM
GROUP BY b.TENBM
HAVING SLGIAOVIEN >= 2;
-- Câu 12: Cho tên những giáo viên và số lượng đề tài của những GV tham gia từ 3 đề tài trở lên.
SELECT g.MAGV, g.HOTEN, COUNT(d.MAGV) AS SLDETAI
FROM THAMGIADT d
         JOIN GIAOVIEN g on g.MAGV = d.MAGV
GROUP BY g.MAGV
HAVING SLDETAI >= 3;
-- Câu 13: Cho biết số lượng đề tài được thực hiện trong từng năm.
SELECT YEAR(d.NGAYKT) AS YEAR, COUNT(d.MADT) AS SLDETAI
FROM DETAI d
GROUP BY YEAR;
-- ************************************************A
-- Dùng truy vấn con + mệnh đề SELECT
-- Câu A1: Với mỗi bộ môn, cho biết tên bộ môn và số lượng giáo viên của bộ môn đó.
SELECT b.TENBM, (SELECT COUNT(MAGV) FROM GIAOVIEN WHERE GIAOVIEN.MABM = b.MABM) AS SLGV
FROM BOMON b;
-- Dùng truy vấn con + mệnh đề FROM
-- Câu A2: Cho biết họ tên và lương của các giáo viên bộ môn HTTT
-- Dùng truy vấn con + mệnh đề WHERE
-- Câu A3: Cho biết những giáo viên có lương lớn hơn lương của giáo viên có MAGV=‘001’
-- Câu A4: Cho biết họ tên những giáo viên mà không có một người thân nào
-- Câu A5: Cho những giáo viên có tham gia đề tài
-- Câu A6: Cho những giáo viên có lương nhỏ nhất
-- Câu A7: Cho những giáo viên có lương cao hơn tất cả các giáo viên của bộ môn HTTT
-- Câu A8: Cho biết bộ môn (MABM) có đông giáo viên nhất
-- Câu A9: Cho biết họ tên những giáo viên mà không có một người thân nào. (Sử dụng ALL thay vì NOT IN)
-- Câu A10: Cho biết họ tên những giáo viên có tham gia đề tài. (Sử dụng = ANY thay vì IN)
-- Câu A11: Cho biết các giáo viên có tham gia đề tài.
SELECT DISTINCT GV.HOTEN
FROM GIAOVIEN GV
         JOIN THAMGIADT T on GV.MAGV = T.MAGV
GROUP BY GV.MAGV;

SELECT DISTINCT GV.HOTEN
FROM GIAOVIEN GV
         JOIN THAMGIADT T on GV.MAGV = T.MAGV;
-- Câu A12: Cho biết các giáo viên không có người thân
-- Câu A14: Cho biết những giáo viên có lương lớn hơn lương trung bình của bộ môn mà giáo viên đó làm việc.
SELECT gv.HOTEN
FROM GIAOVIEN gv
         JOIN (SELECT BM.MABM, AVG(LUONG) as TBLUONG
               FROM GIAOVIEN
                        JOIN BOMON BM ON GIAOVIEN.MABM = BM.MABM
               GROUP BY BM.MABM) as T ON T.MABM = gv.MABM
WHERE LUONG > T.TBLUONG;
-- Câu A15: Cho biết những giáo viên có lương lớn nhất
-- Câu A16: Cho biết những đề tài mà giáo viên ‘001’ không tham gia.
SELECT DISTINCT DT.MADT,DT.TENDT
FROM DETAI DT
LEFT OUTER JOIN (SELECT DISTINCT TG2.MADT FROM THAMGIADT TG2 WHERE TG2.MAGV<>'001') as TG on TG.MADT = DT.MADT;

-- Câu A17: Cho biết họ tên những giáo viên có vai trò quản lý về mặt chuyên môn với các viên khác
-- Câu A18: Cho biết những giáo viên có lương lớn nhất.
-- Câu A19: Cho biết những bộ môn (MABM) có đông giáo viên nhấ
-- Câu A20: Cho biết những tên bộ môn, họ tên của trưởng bộ môn và số lượng giáo viên của bộ môn có đông giáo viên nhất
-- Câu A21: Cho biết những giáo viên có lương lớn hơn mức lương trung bình của giáo viên bộ môn Hệ thống thông tin mà không trực thuộc bộ môn hệ thống thông tin
-- Câu A22: Cho tên biết đề tài có đông giáo viên tham gia nhất viên bộ môn Hệ thống thông tin mà không trực thuộc bộ môn hệ thống thông tin
-- ************************************************B
-- Câu B2: Tìm các giáo viên không tham gia đề tài nào
SELECT *
FROM GIAOVIEN
WHERE GIAOVIEN.MAGV NOT IN (SELECT DISTINCT TG.MAGV FROM THAMGIADT TG);

SELECT *
FROM GIAOVIEN GV
WHERE NOT EXISTS(SELECT DISTINCT *
                 FROM GIAOVIEN G
                          JOIN THAMGIADT T on G.MAGV = T.MAGV
                 WHERE T.MAGV = GV.MAGV);

-- Câu B3: Tìm các giáo viên vừa tham gia đề tài vừa là trưởng bộ môn.
-- Câu B4: Liệt kê những giáo viên có tham gia đề tài và những giáo viên là trưởng bộ môn.
-- Câu B5: Tìm các giáo viên (MAGV) mà tham gia tất cả các đề tài
-- Câu B6: Tìm các giáo viên (MAGV) mà tham gia tất cả các đề tài (Dùng NOT EXISTS)
-- Câu B7: Tìm các giáo viên (MAGV) mà tham gia tất cả các đề tài (Dùng NOT EXISTS)
-- Câu B9: Tìm tên các giáo viên ‘HTTT’ mà tham gia tất cả các đề tài thuộc chủ đề ‘QLGD


-- ADVANCED
-- Cho biết tên giáo viên và tên của giáo viên có nhiều người thân nhất
SELECT g.HOTEN, COUNT(n.MAGV) as SLNT
FROM GIAOVIEN g
         JOIN NGUOITHAN n on g.MAGV = n.MAGV
GROUP BY g.HOTEN
HAVING SLNT >= ALL (SELECT COUNT(NGUOITHAN.MAGV) FROM NGUOITHAN GROUP BY NGUOITHAN.MAGV);
-- Cho biết tên của giáo viên lớn tuổi nhất của bộ môn hệ thống thông tin
SELECT g.HOTEN, (YEAR(NOW()) - YEAR(g.NGSINH)) as AGE
FROM GIAOVIEN g
         JOIN BOMON b on b.MABM = g.MABM
WHERE g.MABM = 'HTTT'
GROUP BY g.HOTEN, (YEAR(NOW()) - YEAR(g.NGSINH))
HAVING AGE >= ALL (SELECT (YEAR(NOW()) - YEAR(NS.NGSINH))
                   FROM (SELECT NGSINH
                         FROM GIAOVIEN
                                  JOIN BOMON b2 on b2.MABM = GIAOVIEN.MABM
                         WHERE GIAOVIEN.MABM = 'HTTT') as NS);
-- Cho biết tên những đề tài mà giáo viên Nguyễn Hoài An chưa tham gia
-- Cho biết tên của giáo viên chủ nhiệm nhiều đề tài nhất.
-- Cho biết tên giáo viên và tên bộ môn của giáo viên tham gia nhiều đề tài nhất
-- Cho biết tên đề tài nào mà được tất cả giáo viên của bộ môn hóa hữu cơ tham gia

-- Đề tài có đông giáo viên tham gia nhất.
SELECT TG.MADT, COUNT(DISTINCT MAGV) AS SLGV
FROM THAMGIADT TG
GROUP BY TG.MADT
HAVING SLGV >= ALL (SELECT COUNT(DISTINCT MAGV) AS SLGV
                    FROM THAMGIADT TG
                    GROUP BY TG.MADT);

