CREATE DATABASE transport6;
--USE transport6;

CREATE TABLE transport
(
	transportId INT NOT NULL AUTO_INCREMENT,
	transportType VARCHAR(20) NOT NULL UNIQUE,
	PRIMARY KEY(transportId)
);

CREATE TABLE routes
(
	routeId INT NOT NULL AUTO_INCREMENT,
	routeNumber INT NOT NULL UNIQUE,
	PRIMARY KEY(routeId)
);

CREATE TABLE transportRoutes
(
	transportRoutesId INT NOT NULL AUTO_INCREMENT,
	transportId INT NOT NULL,
	routeId INT NOT NULL,
	PRIMARY KEY (transportRoutesId),
	FOREIGN KEY (transportId) REFERENCES transport(transportId),
	FOREIGN KEY (routeId) REFERENCES routes(routeId)
);

INSERT INTO transport (transportType) VALUES (“bus”);
INSERT INTO transport (transportType) VALUES (“tram”);
INSERT INTO transport (transportType) VALUES (“trolleybus”);

INSERT INTO routes (routeNumber) VALUES (1);
INSERT INTO routes (routeNumber) VALUES (2);
INSERT INTO routes (routeNumber) VALUES (3);
INSERT INTO routes (routeNumber) VALUES (4);
INSERT INTO routes (routeNumber) VALUES (5);

INSERT INTO transportRoutes (transportId, routeId) VALUES (1, 3);
INSERT INTO transportRoutes (transportId, routeId) VALUES (2, 3);
INSERT INTO transportRoutes (transportId, routeId) VALUES (3, 3);
INSERT INTO transportRoutes (transportId, routeId) VALUES (1, 2);
INSERT INTO transportRoutes (transportId, routeId) VALUES (2, 4);
