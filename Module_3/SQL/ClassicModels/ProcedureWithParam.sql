DELIMITER //
DROP PROCEDURE IF EXISTS getCusById;
CREATE PROCEDURE getCusById

(IN cusID INT(2))

BEGIN

    SELECT * FROM customers WHERE customerNumber = cusID;

END //
DELIMITER //;
call getCusById(103);

DELIMITER //
DROP PROCEDURE IF EXISTS GetCustomersCountByCity;
CREATE PROCEDURE GetCustomersCountByCity(

    IN  in_city VARCHAR(50),

    OUT total INT

)

BEGIN

    SELECT COUNT(customerNumber)

    INTO total

    FROM customers

    WHERE city = in_city;

END//

DELIMITER ;
CAll GetCustomersCountByCity('Lyon', @total);
SELECT @total
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
