DELIMITER //

CREATE PROCEDURE findAllCustomers()

BEGIN

SELECT * FROM customers;

END //;
CALL findAllCustomers()