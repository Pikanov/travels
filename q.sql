CREATE TABLE travels.type_transport(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_tarnsport VARCHAR(255) NOT NULL);
INSERT INTO travels.type_transport(name_tarnsport) VALUES('Ship'),('Train'),('Aircraft'),('Bus');
CREATE TABLE travels.type_tour(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_tour VARCHAR(255) NOT NULL);
INSERT INTO travels.type_tour(name_tour) VALUES('cruise'),('shopping'),('relax'),('travel'),('excursion'),('therapy');
CREATE TABLE travels.travel_vouchers (
	taravelVaucherId BIGINT PRIMARY KEY AUTO_INCREMENT, 
	typeOfTransport INT,
	food BOOLEAN NOT NUll,
	numberOfDays INT NOT NULL,
	price INT NOT NULL,
	typeOfTour INT,
	FOREIGN KEY (typeOfTransport) REFERENCES travels.type_transport(id) ON DELETE CASCADE,
	FOREIGN KEY (typeOfTour) REFERENCES travels.type_tour(id) ON DELETE CASCADE );
INSERT INTO travels.travelvouchers(typeOfTransport, food, numberOfDays, price, typeOfTour) 
	VALUES(1, TRUE, 21, 2000, 1),
		(2, FALSE, 2, 200, 2),
		(3, TRUE, 7, 500, 3),
		(4, FALSE, 3, 400, 4),
		(3, TRUE, 10, 700, 3),
		(1, FALSE, 15, 3000, 1),
		(2, FALSE, 1, 100, 5),
		(4, TRUE, 14, 1000, 6);

SELECT taravelVaucherId, type_transport.name_tarnsport, food, numberOfDays, price, type_tour.name_tour FROM travels.travelvouchers 
	JOIN type_transport ON travelvouchers.typeOfTransport=type_transport.id 
	JOIN type_tour ON travelvouchers.typeOfTour=type_tour.id;