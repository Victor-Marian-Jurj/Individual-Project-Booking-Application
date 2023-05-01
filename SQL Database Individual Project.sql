CREATE TABLE client(
client_id CHAR(5) PRIMARY KEY,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone_number VARCHAR(20) NOT NULL UNIQUE,
email_adress VARCHAR(50) NOT NULL UNIQUE,
birth_day DATE NOT NULL);


CREATE TABLE hotel(
hotel_id CHAR(5) PRIMARY KEY,
number_of_rooms INTEGER NOT NULL,
rating INTEGER NOT NULL,
name VARCHAR(30) NOT NULL,
location VARCHAR(30) NOT NULL
);


CREATE TABLE payment (
payment_id CHAR(5) PRIMARY KEY,
client_id CHAR(5) NOT NULL UNIQUE,
reservation_id CHAR(5) NOT NULL UNIQUE,
room_price INTEGER NOT NULL,
number_of_nights INTEGER NOT NULL,
total INTEGER NOT NULL,
payment_status VARCHAR(20),
CONSTRAINT fk_client_id
FOREIGN KEY(client_id)
REFERENCES client(client_id),
CONSTRAINT fk_reservation_id
FOREIGN KEY(reservation_id)
REFERENCES reservation(reservation_id)
);


CREATE TABLE reservation (
reservation_id CHAR(5) PRIMARY KEY,
client_id CHAR(5) NOT NULL UNIQUE,
hotel_id CHAR(5) NOT NULL UNIQUE,
room_id CHAR(5) NOT NULL UNIQUE,
reservation_status VARCHAR(20) NOT NULL,
check_in_date DATE NOT NULL,
check_out_date DATE NOT NULL,
CONSTRAINT fk_client_id
FOREIGN KEY (client_id)
REFERENCES client(client_id),
CONSTRAINT fk_hotel_id
FOREIGN KEY (hotel_id)
REFERENCES hotel(hotel_id),
CONSTRAINT fk_room_id
FOREIGN KEY (room_id)
REFERENCES room(room_id)
);

CREATE TABLE room (
room_id CHAR(5) PRIMARY KEY,
room_number INTEGER NOT NULL,
room_type VARCHAR(20) NOT NULL,
room_floor INTEGER NOT NULL,
room_price INTEGER NOT NULL
);
-------------------------------------------------------------------------------------------------------------
DELETE FROM client;
SELECT * FROM client
INSERT INTO client VALUES ('C0001', 'Aurelian', 'Temisan', '0744896214', 'a.temisan@yahoo.com', '1987-08-22' );
INSERT INTO client VALUES ('C0002', 'Lutu', 'Camataru', '0766852102', 'camataru.lutu@gmail.com', '1975-06-14');
INSERT INTO client VALUES ('C0003', 'Alexandru', 'Rafila', '0768521478', 'rafirafi@gmail.com', '1991-01-10');
INSERT INTO client VALUES ('C0004', 'Ili Marian', 'Vasilcoiu', '0743159753', 'iliemarian@yahoo.com', '1984-06-21');
INSERT INTO client VALUES ('C0005', 'Vasile', 'Prodan', '0748891114', 'v.prodan@yahoo.com', '1980-02-23' );
INSERT INTO client VALUES ('C0006', 'Sile', 'Camataru', '0722302102', 'camataru.sile@gmail.com', '1970-07-19');
INSERT INTO client VALUES ('C0007', 'Bogdan', 'Serban', '0765369742', 'bogdanserb@gmail.com', '1977-03-30');
INSERT INTO client VALUES ('C0008', 'Marian', 'Stoica', '0754895256', 'stoicamarian@yahoo.com', '1974-05-11');
INSERT INTO client VALUES ('C0009', 'Paul', 'Dondoe', '0743996214', 'd.paul@yahoo.com', '1998-10-22' );
INSERT INTO client VALUES ('C0010', 'Constantin', 'Mogosanu', '0755685492', 'mogos.ctin@gmail.com', '1970-11-14');
INSERT INTO client VALUES ('C0011', 'Cosmin', 'Vlad', '0769621478', 'cosminv@gmail.com', '1999-12-13');
INSERT INTO client VALUES ('C0012', 'Ion Ion', 'Tiriac', '0744589321', 'ionion@yahoo.com', '1988-06-21');
INSERT INTO client VALUES ('C0013', 'Daniela', 'Marcu', '0749895514', 'm.daniela@yahoo.com', '1966-08-29' );
INSERT INTO client VALUES ('C0014', 'Alexandra', 'Marinescu', '0766001202', 'marinescu.alexandra@gmail.com', '1975-06-14');
INSERT INTO client VALUES ('C0015', 'Cristina Teodora', 'Uncheasu', '0768961002', 'cris.uncheasu@gmail.com', '1990-12-10');
INSERT INTO client VALUES ('C0016', 'Monica Daniela', 'Tunaru', '0763012021', 'tunaru.dani@yahoo.com', '1962-02-02');
INSERT INTO client VALUES ('C0017', 'Aura', 'Calota', '0766895147', 'a.calota@yahoo.com', '1971-03-04' );
INSERT INTO client VALUES ('C0018', 'Alexandru', 'Rosu', '0766850007', 'rosu.alex@gmail.com', '2000-09-14');
INSERT INTO client VALUES ('C0019', 'Monica', 'Barladeanu', '0765789456', 'moni.moni@gmail.com', '2001-01-17');
INSERT INTO client VALUES ('C0020', 'Daniel', 'Naicu', '0744558812', 'naicu.daniel@yahoo.com', '1984-06-21');
INSERT INTO client VALUES ('C0021', 'Cristina Maria', 'Topescu', '0744001122', 'cris.maria@yahoo.com', '1969-04-03' );
INSERT INTO client VALUES ('C0022', 'Crina', 'Popa', '0785274102', 'popa.cristina@gmail.com', '1998-09-23');
INSERT INTO client VALUES ('C0023', 'Bogdan', 'Zamfir', '0773578108', 'zamfir.bogdan@gmail.com', '1990-08-10');
INSERT INTO client VALUES ('C0024', 'Gabriela Alexandra', 'Vasilcoiu', '0743397158', 'gabi.vasilcoiu@yahoo.com', '1982-06-09');
INSERT INTO client VALUES ('C0025', 'Maria', 'Ispas', '0744920783', 'maria.ispas@yahoo.com', '1979-02-02' );
INSERT INTO client VALUES ('C0026', 'Ion Marin', 'Ciubotariu', '0755248963', 'ciubotariu.marin@gmail.com', '1992-11-26');
INSERT INTO client VALUES ('C0027', 'Robert', 'Sperila', '0743258147', 'sperila.robert@gmail.com', '1991-01-10');
INSERT INTO client VALUES ('C0028', 'Madalin', 'Toma', '0758951357', 'toma.madalin@yahoo.com', '1984-06-21');
INSERT INTO client VALUES ('C0029', 'Aurelian Ionut', 'Cristoiu', '0744998855', 'cristoiu.aurelian@yahoo.com', '1968-04-25' );
INSERT INTO client VALUES ('C0030', 'Clara Maria', 'Serban', '0754892301', 'serban.clara@gmail.com', '1975-06-14');
INSERT INTO client VALUES ('C0031', 'Tatiana Floriana', 'Belulescu', '0756849210', 'tatiana.floriana@gmail.com', '1991-01-10');
------------------------------------------------------------------------------------------------------------
INSERT INTO hotel VALUES ('H0001', 50, 4, 'Hotel Transilvania', 'Cluj-Napoca');
INSERT INTO hotel VALUES ('H0002', 100, 5, 'Athenee Palace Hilton', 'Bucuresti');
INSERT INTO hotel VALUES ('H0003', 80, 4, 'Grand Hotel Continental', 'Bucuresti');
INSERT INTO hotel VALUES ('H0004', 60, 3, 'Hotel Bella Muzica', 'Brasov');
INSERT INTO hotel VALUES ('H0005', 62, 3, 'Articus', 'Craiova');
INSERT INTO hotel VALUES ('H0006', 120, 4, 'Hotel Ramada Parc', 'Bucuresti');
INSERT INTO hotel VALUES ('H0007', 40, 3, 'Hotel Ibis', 'Cluj-Napoca');
INSERT INTO hotel VALUES ('H0008', 90, 5, 'Hotel Kronwell', 'Brasov');
INSERT INTO hotel VALUES ('H0009', 70, 4, 'Hotel Mercure', 'Sibiu');
INSERT INTO hotel VALUES ('H0010', 110, 5, 'JW Marriott Bucharest', 'Bucuresti');
INSERT INTO hotel VALUES ('H0011', 55, 4, 'Hotel Continental Forum', 'Sibiu');
INSERT INTO hotel VALUES ('H0012', 150, 5, 'Radisson Blu Hotel', 'Bucuresti');
INSERT INTO hotel VALUES ('H0013', 30, 3, 'Hotel City Plaza', 'Cluj-Napoca');
INSERT INTO hotel VALUES ('H0014', 65, 4, 'Hotel Golden Tulip', 'Bucuresti');
INSERT INTO hotel VALUES ('H0015', 95, 5, 'Hilton Sibiu', 'Sibiu');
INSERT INTO hotel VALUES ('H0016', 74, 3, 'Green House', 'Craiova');
INSERT INTO hotel VALUES ('H0017', 120, 4, 'Hotel Crowne Plaza', 'Bucuresti');
INSERT INTO hotel VALUES ('H0018', 50, 3, 'Hotel Aro Palace', 'Brasov');
INSERT INTO hotel VALUES ('H0019', 85, 4, 'Hotel Novotel', 'Bucuresti');
INSERT INTO hotel VALUES ('H0020', 70, 4, 'Hotel Golden Tulip Ana Tower', 'Sibiu');
INSERT INTO hotel VALUES ('H0021', 40, 3, 'Hotel Premier', 'Sibiu');
INSERT INTO hotel VALUES ('H0022', 100, 5, 'Sheraton Bucharest Hotel', 'Bucuresti');
INSERT INTO hotel VALUES ('H0023', 61, 4, 'Europeca', 'Craiova');
INSERT INTO hotel VALUES ('H0024', 60, 4, 'Hotel Capitol', 'Timisoara');
INSERT INTO hotel VALUES ('H0025', 130, 5, 'InterContinental', 'Bucuresti');
INSERT INTO hotel VALUES ('H0026', 45, 3, 'Hotel Opera Plaza', 'Cluj-Napoca');
INSERT INTO hotel VALUES ('H0027', 75, 4, 'Hotel RIN Central', 'Bucuresti');
INSERT INTO hotel VALUES ('H0028', 95, 4, 'Hotel Ramada', 'Sibiu');
INSERT INTO hotel VALUES ('H0029', 110, 5, 'Hotel Hilton Garden Inn', 'Bucharest');
INSERT INTO hotel VALUES ('H0030', 50, 4, 'Hotel Traian', 'Iasi');
INSERT INTO hotel VALUES ('H0031', 85, 4, 'Ramada', 'Craiova');
------------------------------------------------------------------------------------------
INSERT INTO room VALUES ('RM001', 35, 'single', 2, 220);
INSERT INTO room VALUES ('RM002', 87, 'double', 5, 300);
INSERT INTO room VALUES ('RM003', 65, 'suite', 3, 350);
INSERT INTO room VALUES ('RM004', 55, 'single', 3, 240);
INSERT INTO room VALUES ('RM005', 35, 'single', 2, 250);
INSERT INTO room VALUES ('RM006', 101, 'single', 8, 300);
INSERT INTO room VALUES ('RM007', 25, 'double', 1, 280);
INSERT INTO room VALUES ('RM008', 79, 'single', 5, 650);
INSERT INTO room VALUES ('RM009', 65, 'double', 4, 287);
INSERT INTO room VALUES ('RM010', 105, 'single', 8, 300);
INSERT INTO room VALUES ('RM011', 40, 'double', 3, 250);
INSERT INTO room VALUES ('RM012', 132, 'single', 9, 320);
INSERT INTO room VALUES ('RM013', 20, 'single', 1, 260);
INSERT INTO room VALUES ('RM014', 49, 'double', 3, 320);
INSERT INTO room VALUES ('RM015', 85, 'single', 7, 350);
INSERT INTO room VALUES ('RM016', 58, 'suite', 3, 325);
INSERT INTO room VALUES ('RM017', 115, 'single', 9, 260);
INSERT INTO room VALUES ('RM018', 24, 'double', 1, 310);
INSERT INTO room VALUES ('RM019', 74, 'suite', 3, 380);
INSERT INTO room VALUES ('RM020', 63, 'single', 3, 320);
INSERT INTO room VALUES ('RM021', 33, 'double', 1, 280);
INSERT INTO room VALUES ('RM022', 99, 'single', 8, 240);
INSERT INTO room VALUES ('RM023', 41, 'double', 2, 320);
INSERT INTO room VALUES ('RM024', 51, 'single', 3, 210);
INSERT INTO room VALUES ('RM025', 122, 'single', 9, 220);
INSERT INTO room VALUES ('RM026', 31, 'double', 2, 280);
INSERT INTO room VALUES ('RM027', 18, 'single', 1, 300);
INSERT INTO room VALUES ('RM028', 73, 'single', 1, 300);
INSERT INTO room VALUES ('RM029', 95, 'double', 9, 360);
INSERT INTO room VALUES ('RM030', 18, 'single', 1, 270);
INSERT INTO room VALUES ('RM031', 70, 'single', 5, 245);
------------------------------------------------------------------------------------------
INSERT INTO reservation VALUES ('RE001', 'C0001', 'H0001', 'RM001', 'Confirmed', '2023-02-10', '2023-02-15');
INSERT INTO reservation VALUES ('RE002', 'C0002', 'H0002', 'RM002', 'Pending', '2023-04-18', '2023-04-20');
INSERT INTO reservation VALUES ('RE003', 'C0003', 'H0003', 'RM003', 'Confirmed', '2023-05-13', '2023-05-15');
INSERT INTO reservation VALUES ('RE004', 'C0004', 'H0004', 'RM004', 'Pending', '2023-06-01', '2023-06-02');
INSERT INTO reservation VALUES ('RE005', 'C0005', 'H0005', 'RM005', 'Confirmed', '2023-07-15', '2023-07-17');
INSERT INTO reservation VALUES ('RE006', 'C0006', 'H0006', 'RM006', 'Pending', '2023-08-14', '2023-08-15');
INSERT INTO reservation VALUES ('RE007', 'C0007', 'H0007', 'RM007', 'Confirmed', '2023-07-15', '2023-07-17');
INSERT INTO reservation VALUES ('RE008', 'C0008', 'H0008', 'RM008', 'Pending', '2023-08-14', '2023-08-15');
INSERT INTO reservation VALUES ('RE009', 'C0009', 'H0009', 'RM009', 'Confirmed', '2023-07-15', '2023-07-17');
INSERT INTO reservation VALUES ('RE010', 'C0010', 'H0010', 'RM010', 'Pending', '2023-02-12', '2023-02-14');
INSERT INTO reservation VALUES ('RE011', 'C0011', 'H0011', 'RM011', 'Confirmed', '2023-10-15', '2023-10-17');
INSERT INTO reservation VALUES ('RE012', 'C0012', 'H0012', 'RM012', 'Confirmed', '2023-11-15', '2023-11-17');
INSERT INTO reservation VALUES ('RE013', 'C0013', 'H0013', 'RM013', 'Pending', '2023-04-17', '2023-04-18');
INSERT INTO reservation VALUES ('RE014', 'C0014', 'H0014', 'RM014', 'Confirmed', '2023-07-15', '2023-07-17');
INSERT INTO reservation VALUES ('RE015', 'C0015', 'H0015', 'RM015', 'Confirmed', '2023-09-25', '2023-09-28');
INSERT INTO reservation VALUES ('RE016', 'C0016', 'H0016', 'RM016', 'Confirmed', '2023-05-28', '2023-05-29');
INSERT INTO reservation VALUES ('RE017', 'C0017', 'H0017', 'RM017', 'Pending', '2023-01-12', '2023-01-13');
INSERT INTO reservation VALUES ('RE018', 'C0018', 'H0018', 'RM018', 'Pending', '2023-08-19', '2023-08-21');
INSERT INTO reservation VALUES ('RE019', 'C0019', 'H0019', 'RM019', 'Pending', '2023-04-10', '2023-04-12');
INSERT INTO reservation VALUES ('RE020', 'C0020', 'H0020', 'RM020', 'Pending', '2023-08-02', '2023-08-03');
INSERT INTO reservation VALUES ('RE021', 'C0021', 'H0021', 'RM021', 'Pending', '2023-02-06', '2023-02-10');
INSERT INTO reservation VALUES ('RE022', 'C0022', 'H0022', 'RM022', 'Confirmed', '2023-01-15', '2023-01-20');
INSERT INTO reservation VALUES ('RE023', 'C0023', 'H0023', 'RM023', 'Confirmed', '2023-11-15', '2023-11-17');
INSERT INTO reservation VALUES ('RE024', 'C0024', 'H0024', 'RM024', 'Pending', '2023-10-10', '2023-10-11');
INSERT INTO reservation VALUES ('RE025', 'C0025', 'H0025', 'RM025', 'Confirmed', '2023-03-01', '2023-03-08');
INSERT INTO reservation VALUES ('RE026', 'C0026', 'H0026', 'RM026', 'Pending', '2023-08-08', '2023-08-16');
INSERT INTO reservation VALUES ('RE027', 'C0027', 'H0027', 'RM027', 'Confirmed', '2023-05-15', '2023-05-22');
INSERT INTO reservation VALUES ('RE028', 'C0028', 'H0028', 'RM028', 'Confirmed', '2023-12-15', '2023-12-22');
INSERT INTO reservation VALUES ('RE029', 'C0029', 'H0029', 'RM029', 'Confirmed', '2023-10-15', '2023-10-19');
INSERT INTO reservation VALUES ('RE030', 'C0030', 'H0030', 'RM030', 'Confirmed', '2023-12-15', '2023-12-20');
INSERT INTO reservation VALUES ('RE031', 'C0031', 'H0031', 'RM031', 'Confirmed', '2023-03-01', '2023-03-05');
--------------------------------------------------------------------------------------
INSERT INTO payment VALUES ('PM001', 'C0001', 'RE001', 220, 5, 1100, 'Paid');
INSERT INTO payment VALUES ('PM002', 'C0002', 'RE002', 300, 2, 600, 'Declined');
INSERT INTO payment VALUES ('PM003', 'C0003', 'RE003', 350, 2, 700, 'Paid');
INSERT INTO payment VALUES ('PM004', 'C0004', 'RE004', 240, 1, 240, 'Declined');
INSERT INTO payment VALUES ('PM005', 'C0005', 'RE005', 250, 2, 500, 'Paid');
INSERT INTO payment VALUES ('PM006', 'C0006', 'RE006', 300, 1, 300, 'Declined');
INSERT INTO payment VALUES ('PM007', 'C0007', 'RE007', 280, 2, 560, 'Paid');
INSERT INTO payment VALUES ('PM008', 'C0008', 'RE008', 650, 1, 650, 'Declined');
INSERT INTO payment VALUES ('PM009', 'C0009', 'RE009', 287, 2, 574, 'Paid');
INSERT INTO payment VALUES ('PM010', 'C0010', 'RE010', 300, 2, 600, 'Declined');
INSERT INTO payment VALUES ('PM011', 'C0011', 'RE011', 250, 2, 500, 'Paid');
INSERT INTO payment VALUES ('PM012', 'C0012', 'RE012', 320, 2, 640, 'Declined');
INSERT INTO payment VALUES ('PM013', 'C0013', 'RE013', 260, 1, 260, 'Paid');
INSERT INTO payment VALUES ('PM014', 'C0014', 'RE014', 320, 2, 640, 'Declined');
INSERT INTO payment VALUES ('PM015', 'C0015', 'RE015', 350, 3, 1050, 'Paid');
INSERT INTO payment VALUES ('PM016', 'C0016', 'RE016', 325, 1, 325, 'Declined');
INSERT INTO payment VALUES ('PM017', 'C0017', 'RE017', 260, 1, 260, 'Paid');
INSERT INTO payment VALUES ('PM018', 'C0018', 'RE018', 310, 2, 620, 'Declined');
INSERT INTO payment VALUES ('PM019', 'C0019', 'RE019', 380, 2, 760, 'Paid');
INSERT INTO payment VALUES ('PM020', 'C0020', 'RE020', 320, 1, 320, 'Declined');
INSERT INTO payment VALUES ('PM021', 'C0021', 'RE021', 280, 4, 1120, 'Paid');
INSERT INTO payment VALUES ('PM022', 'C0022', 'RE022', 240, 5, 1200, 'Declined');
INSERT INTO payment VALUES ('PM023', 'C0023', 'RE023', 320, 2, 640, 'Paid');
INSERT INTO payment VALUES ('PM024', 'C0024', 'RE024', 210, 1, 210, 'Declined');
INSERT INTO payment VALUES ('PM026', 'C0026', 'RE026', 280, 8, 2240, 'Declined');
INSERT INTO payment VALUES ('PM027', 'C0027', 'RE027', 300, 7, 2100, 'Paid');
INSERT INTO payment VALUES ('PM028', 'C0028', 'RE028', 300, 7, 2100, 'Declined');
INSERT INTO payment VALUES ('PM029', 'C0029', 'RE029', 360, 4, 1440, 'Paid');
INSERT INTO payment VALUES ('PM030', 'C0030', 'RE030', 270, 5, 1350, 'Declined');
INSERT INTO payment VALUES ('PM031', 'C0031', 'RE031', 245, 4, 980, 'Paid');
----------------------------------------------------------------
SELECT * FROM client
SELECT * FROM hotel
SELECT * FROM payment
SELECT * FROM reservation
SELECT * FROM room

SELECT phone_number, birth_day from client;
SELECT number_of_nights, room_price, total from payment;
SELECT room_id, room_number from room;

SELECT * FROM table_name WHERE condition
SELECT * FROM hotel WHERE rating = 4;
SELECT * FROM room WHERE room_number < 10;
SELECT * FROM room WHERE room_number < 10  OR room_floor = 3;
SELECT * FROM hotel WHERE name LIKE 'Hotel%';
SELECT * FROM client WHERE email_adress LIKE '%@yahoo.com';
SELECT * FROM room WHERE room_type LIKE '_in___';
SELECT * FROM room WHERE room_price < 400 AND room_price > 300;
SELECT * FROM hotel ORDER BY number_of_rooms DESC;
SELECT DISTINCT room_price FROM room;
SELECT * FROM hotel LIMIT 10 OFFSET 10;
SELECT MIN (number_of_rooms) FROM hotel WHERE number_of_rooms < 50;
SELECT MAX (room_price) FROM room WHERE room_price < 300;
SELECT AVG (room_price) FROM room WHERE room_price > 300;
SELECT SUM(number_of_rooms) FROM hotel WHERE number_of_rooms > 80;
SELECT COUNT(number_of_nights) FROM payment WHERE number_of_nights > 3;
SELECT number_of_nights FROM payment WHERE number_of_nights > 4 GROUP BY number_of_nights;
SELECT COUNT(total) FROM payment GROUP BY total HAVING COUNT(payment) > 1; 
SELECT COUNT(first_name) FROM client GROUP BY first_name HAVING COUNT(client) > 1; 
SELECT MAX(total) FROM payment GROUP BY total HAVING (total) > 350 ORDER BY total;
UPDATE room SET room_number = 40 WHERE room_number = 35;
UPDATE room SET room_price = 10000 WHERE room_price = 650;
ALTER TABLE reservation ADD COLUMN Observation varchar(50);
DELETE FROM room WHERE total > 300;
ALTER TABLE reservation DROP COLUMN observation;
-----------------------------------------------------
SELECT client.first_name, client.last_name, reservation.check_in_date, reservation.check_out_date FROM client INNER JOIN reservation ON client.client_id = reservation.client_id;
----------------------------------------------
SELECT client.client_id, client.first_name, client.last_name, payment.payment_id, payment.reservation_id, payment.total
FROM client
INNER JOIN payment
ON client.client_id = payment.client_id;
----------------------------------------------
SELECT client.client_id, client.first_name, client.last_name, reservation.reservation_id, reservation.hotel_id, reservation.check_in_date, reservation.check_out_date
FROM client
LEFT JOIN reservation
ON client.client_id = reservation.client_id;
--------------------------------------------------
SELECT reservation.reservation_id, reservation.client_id, hotel.hotel_id, hotel.name, hotel.location
FROM reservation
RIGHT JOIN hotel
ON reservation.hotel_id = hotel.hotel_id;
----------------------------------------------------------
SELECT client.client_id, client.first_name, client.last_name, reservation.reservation_id, reservation.hotel_id, hotel.name, hotel.location
FROM client
FULL JOIN reservation
ON client.client_id = reservation.client_id
FULL JOIN hotel
ON reservation.hotel_id = hotel.hotel_id;
---------------------------------------------------
SELECT client.*, reservation.*, room.*
FROM client
INNER JOIN reservation ON client.client_id = reservation.client_id
INNER JOIN room ON reservation.room_id = room.room_id;
-------------------------------------------------
CREATE OR REPLACE VIEW HotelRevenue AS
SELECT hotel.hotel_id, hotel.name, SUM(payment.total) AS revenue
FROM hotel
INNER JOIN reservation ON hotel.hotel_id = reservation.hotel_id
INNER JOIN payment ON reservation.reservation_id = payment.reservation_id
GROUP BY hotel.hotel_id, hotel.name
ORDER BY revenue DESC;

SELECT * FROM HotelRevenue
------------------------------------------------------
CREATE OR REPLACE VIEW client_reservations AS
SELECT client.first_name, client.last_name, reservation.reservation_id, reservation.check_in_date, reservation.check_out_date, payment.total
FROM client
JOIN reservation ON client.client_id = reservation.client_id
JOIN payment ON reservation.reservation_id = payment.reservation_id;

SELECT * FROM client_reservations;
-------------------------------------------------------
SELECT first_name FROM client UNION ALL
SELECT reservation_status FROM reservation;
-------------------------------------------------
SELECT room_id FROM room UNION
SELECT room_id FROM reservation;
----------------------------------------------------------
SELECT 'Customer' AS client_id, phone_number, email_adress
FROM client
UNION
SELECT 'Cazare' AS hotel_id, name, location
FROM hotel
------------------------------------------------------
SELECT 'Customer' AS client_id, phone_number, email_adress
FROM client
UNION ALL
SELECT 'Cazare' AS hotel_id, name, location
FROM hotel
-----------------------------------------------------------
select substring(first_name,1,5) from client

select upper (name) from hotel

select name, length(name) from hotel

select last_name, length(last_name) from client

select * from client where EXTRACT(YEAR FROM birth_day) > 1975

select * from reservation where DATE_PART('MONTH' , check_in_date) = 01

SELECT first_name, COALESCE(client_id, 'Unknown') AS client_id
FROM client;

CREATE INDEX index_client
ON client (first_name, last_name);















