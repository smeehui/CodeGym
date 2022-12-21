USE QuanLyBanHang;

INSERT INTO Customer (cName, cAge)
VALUES ('Minh Quan', 10);
INSERT INTO Customer (cName, cAge)
VALUES ('Ngoc Oanh', 20);
INSERT INTO Customer (cName, cAge)
VALUES ('Hong Ha', 50);

INSERT INTO Orders (cID, oDate, totalPrice)
VALUES (1, '2006-3-21', null);
INSERT INTO Orders (cID, oDate, totalPrice)
VALUES (2, '2006-3-23', null);
INSERT INTO Orders (cID, oDate, totalPrice)
VALUES (1, '2006-3-16', null);

INSERT INTO Product(pName, pPrice)
VALUES ('May Giat', 3);
INSERT INTO Product(pName, pPrice)
VALUES ('Tu Lanh', 5);
INSERT INTO Product(pName, pPrice)
VALUES ('Dieu Hoa', 7);
INSERT INTO Product(pName, pPrice)
VALUES ('Quat', 1);
INSERT INTO Product(pName, pPrice)
VALUES ('Bep Dien', 2);

INSERT INTO OrderDetails(oID, pID, oQty)
VALUES (1, 1, 3);
INSERT INTO OrderDetails(oID, pID, oQty)
VALUES (1, 3, 7);
INSERT INTO OrderDetails(oID, pID, oQty)
VALUES (1, 4, 2);
INSERT INTO OrderDetails(oID, pID, oQty)
VALUES (2, 1, 1);
INSERT INTO OrderDetails(oID, pID, oQty)
VALUES (3, 1, 8);
INSERT INTO OrderDetails(oID, pID, oQty)
VALUES (2, 5, 4);
INSERT INTO OrderDetails(oID, pID, oQty)
VALUES (2, 3, 3);

SELECT ord.oID, ord.oDate, oQty * pPrice as TotalPrice
FROM Orders ord
         JOIN OrderDetails ords ON ord.oID = ords.oID
         JOIN Product P on P.pID = ords.pID;

SELECT c.cName, p.pName
FROM Customer c
         JOIN Orders O on c.cID = O.cID
         JOIN OrderDetails OD on O.oID = OD.oID
         JOIN Product P on P.pID = OD.pID;

SELECT cName
FROM Customer
WHERE cID NOT IN (SELECT c.cID
                  FROM Customer c
                           JOIN Orders O on c.cID = O.cID);

SELECT os.oID, O.oDate,p.pName,os.oQty, P.pPrice * os.oQty as totalPrice
FROM OrderDetails os
         JOIN Orders O on O.oID = os.oID
         JOIN Product P on P.pID = os.pID
ORDER BY totalPrice;

SELECT pName,SUM(os.oQty*pPrice) as Total FROM OrderDetails os
JOIN Product P on P.pID = os.pID
GROUP BY p.pName
ORDER BY Total;




