--#, puchases, views
Create table  category (
id IDENTITY,
name VARCHAR(100),
description VARCHAR(200),
image_url VARCHAR(50),
isActive BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO Category (name, description, image_url, isActive) VALUES ('Computers','Category for all model Computers','CAT_1.png',true);
INSERT INTO Category (name, description, image_url, isActive) VALUES ('Phones','Category for all model Phones','CAT_2.png',true);
INSERT INTO Category (name, description, image_url, isActive) VALUES ('Televisions','Category for all model Televisions','CAT_3.png',true);


Create table user_detail (
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),

CONSTRAINT pk_user_detail_id PRIMARY KEY (id)
);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Jermaine','Williams','ADMIN',true,'admin', 'jermaine@onlineshop.com','416-456-99099');
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Thomas','James','SUPPLIER',true,'12345', 'thomas@onlineshop.com','789-456-11099');
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Kevin','Ratherford','SUPPLIER',true,'12345', 'kevin@onlineshop.com','435-467-6789');


Create table product (
id IDENTITY,
code VARCHAR(25),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(100),
unit_price DECIMAL (10, 2),
isActive BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT default 0,
views INT default 0,

CONSTRAINT pk_product_id PRIMARY KEY (id),
CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)
);

INSERT INTO product(code, name, brand, description, unit_price, isActive, category_id, supplier_id) 
VALUES ('PRDPH12345IP1', 'iPhone 5s', 'Apple', 'Apples iPhone made in 2016', 700, true, 2, 2);

INSERT INTO product(code, name, brand, description, unit_price, isActive, category_id, supplier_id) 
VALUES ('PRDPH12345SG1', 'Samsung s7', 'Samsung', 'Samsung Phone made in 2017', 600, true, 2, 2);

INSERT INTO product(code, name, brand, description, unit_price, isActive, category_id, supplier_id) 
VALUES ('PRDPH12345GX1', 'Google Pixel', 'Google', 'Google Phone made in 2018', 550, true, 2, 2);

INSERT INTO product(code, name, brand, description, unit_price, isActive, category_id, supplier_id) 
VALUES ('PRDPH12345MB1', 'MAC BOOK PRO', 'Apple', 'Apple Laptop released in 2017', 2500, true, 1, 3);

INSERT INTO product(code, name, brand, description, unit_price, isActive, category_id, supplier_id) 
VALUES ('PRDPH12345DL1', 'Del Latitude e1500', 'DELL', 'DELL Laptop released in 2015', 1500, true, 1, 3);
