USE classicmodels;

-- IN parameter
DELIMITER //
CREATE PROCEDURE getCustomerById
(IN ID INT)
BEGIN
    SELECT * FROM customers
    WHERE customerNumber = ID;
end //
DELIMITER ;
CALL getCustomerById(103);
-- OUT parameter
DELIMITER //
CREATE PROCEDURE getCustomerCountByCity(IN city varchar(10),OUT Total INT)
BEGIN
    SELECT COUNT(c.customerNumber)
    INTO Total
    FROM customers c
    WHERE c.city = city;
end //
DELIMITER ;

CALL getCustomerCountByCity('Lyon', @out);
SELECT @`out`
