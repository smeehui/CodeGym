-- Create db
CREATE DATABASE IF NOT EXISTS Products;
USE Products;
CREATE TABLE product_data(
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    productCode VARCHAR(10) NOT NULL UNIQUE ,
    productName VARCHAR(50) NOT NULL,
    productPrice INTEGER,
    productQuantity INTEGER,
    productDescription VARCHAR(255),
    productStatus BIT
);
-- Query before create index
EXPLAIN SELECT * FROM product_data
WHERE productStatus = false;

-- Query after create index
ALTER TABLE product_data
ADD UNIQUE index_productCode (productCode);

EXPLAIN SELECT * FROM product_data
        WHERE productCode = 'MG02';

ALTER TABLE product_data
    ADD UNIQUE index_productCodeAndName (productCode, productName);

EXPLAIN SELECT * FROM product_data
        WHERE productName = 'Máy giặt' AND productCode LIKE 'MG%';

-- Create view to get info
-- addNewProduct
CREATE VIEW product_data_view AS
    SELECT productCode, productName, productPrice, productStatus
    FROM product_data;
SELECT * FROM product_data_view;

INSERT INTO product_data_view VALUES ('TV03','Tivi',7000000,false);

SELECT * FROM product_data;

-- Create procedure for adding new product
DELIMITER //
CREATE PROCEDURE addNewProduct(
    IN pCode VARCHAR(10),
    IN pName VARCHAR(50),
    IN pPrice DOUBLE,
    IN pQuantity INT,
    IN pDescription VARCHAR(255),
    IN pStatus BIT
)
BEGIN
    INSERT INTO product_data(PRODUCTCODE, PRODUCTNAME, PRODUCTPRICE, PRODUCTQUANTITY, PRODUCTDESCRIPTION, PRODUCTSTATUS)
    VALUES (pCode,pName,pPrice,pQuantity,pDescription,pStatus);
end //
DELIMITER ;

CALL addNewProduct('MG03','Máy giặt',4700000,5,'Just imported',true);
-- Edit product by ID
DELIMITER //
CREATE PROCEDURE editProductById(
IN pID INT,
IN pCode VARCHAR(10),
IN pName VARCHAR(50),
IN pPrice DOUBLE,
IN pQuantity INT,
IN pDescription VARCHAR(255),
IN pStatus BIT
)
BEGIN
    UPDATE product_data
        SET PRODUCTCODE = pCode,
            PRODUCTNAME = pName,
            PRODUCTPRICE = pPrice,
            PRODUCTQUANTITY = pQuantity,
            PRODUCTDESCRIPTION = pDescription,
            productStatus = pStatus
    WHERE ID = pID;
end //
DELIMITER ;

CALL editProductById(1,'MG01','Máy giặt',2700000,10,'Like new',true);
-- Delete product by ID
DELIMITER //
CREATE PROCEDURE deleteProductById(IN pID INT)
BEGIN
    DELETE FROM product_data WHERE ID = pID;
end //
DELIMITER ;
CALL deleteProductById(9);