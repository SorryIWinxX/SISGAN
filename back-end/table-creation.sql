USE sisgan_server;

CREATE TABLE USERS (
id INTEGER AUTO_INCREMENT,
id_card VARCHAR(20),
id_card_ica INTEGER,
id_driving_license INTEGER,
first_name VARCHAR(100),
last_name VARCHAR(100),
password VARCHAR(200),
birth_date DATE,
mark VARCHAR(100),
farm_name VARCHAR(100),
email VARCHAR(100),
PRIMARY KEY(id)
);

CREATE TABLE INTERNAL_MOVEMENT_GUIDES (
id INTEGER AUTO_INCREMENT,
id_user_transporter INTEGER,
vehicle_plate VARCHAR(10),
origin VARCHAR(100),
destination VARCHAR(100),
signature_petitioner VARCHAR(100),
application_date DATE,
movement_date DATE,
signature_ica_official VARCHAR(100),
PRIMARY KEY(id),
FOREIGN KEY(id_user_transporter) REFERENCES USERS(id)
);

CREATE TABLE ROLES (
id INTEGER,
id_user INTEGER,
rol_name VARCHAR(10),
PRIMARY KEY(id),
FOREIGN KEY(id_user) REFERENCES USERS(id)
);

CREATE TABLE LOTS (
id INTEGER AUTO_INCREMENT,
id_user INTEGER,
id_internal_movement_guide INTEGER,
lot_name VARCHAR(80) UNIQUE,
creation_date DATE,
last_modification DATE,
PRIMARY KEY(id),
FOREIGN KEY(id_user) REFERENCES USERS(id),
FOREIGN KEY(id_internal_movement_guide) REFERENCES INTERNAL_MOVEMENT_GUIDES(id)
);

CREATE TABLE CATTLES (
id INTEGER AUTO_INCREMENT,
id_lot INTEGER,
birth_date DATE,
weight INTEGER,
height INTEGER,
sex VARCHAR(1),
breed VARCHAR(15),
PRIMARY KEY(id),
FOREIGN KEY(id_lot) REFERENCES LOTS(id)
);