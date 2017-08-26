CREATE TABLE category(

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)

);
INSERT INTO category (name, description,image_url,is_active) VALUES ('crunchychocolates', 'Everlasting crunchy feel you experience!', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('blackandwhite chocolates', 'delicious enjoyment in your life!', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('chocolates', 'Fade away with chocolates!', 'CAT_3.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('chocolates', 'Fade away with chocolates!', 'CAT_3.png', true);

CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Aathira', 'Santhosh', 'ADMIN', true, 'admin', 'aathirasanthosh4@gmail.com', '7305070142');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Dhana', 'lakshmi', 'SUPPLIER', true, '12345', 'lakshmidhana@gmail.com', '9700990205');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('yamini', 'yams', 'SUPPLIER', true, '12345', 'yaminiyams@gmail.com', '7777777777');

CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	


INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('A11', 'DreamChocolate', 'Cadbury', 'Melts in mouth with tremoundouse feel!', 800, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('A12', 'Ferrero-Rocher', 'Ferrero', 'Everlasting feel of crunchy-nuts empowered chocolates!', 750, 2, true, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('A13', 'freddo', 'CandyBars', 'Childrens Crush!',900, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('B11', 'Nestle Cereals ', 'Nestle', 'awesome feel', 6000, 3, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('B12', 'candycum', 'candy', 'Fade away in your life!',1200, 5, true, 1, 3 );

