CREATE DATABASE IF NOT EXISTS `aircrafts-api`;

USE `aircrafts-api`;

DROP TABLE IF EXISTS aircraft;

CREATE TABLE IF NOT EXISTS 
	aircraft (id INTEGER PRIMARY KEY, 
			   make VARCHAR(25), 
               model VARCHAR(25), 
               `range` VARCHAR(25), 
               maximum_altitude VARCHAR(25), 
               fuel_capacity VARCHAR(25), 
               maximum_speed VARCHAR(25), 
               sector VARCHAR(25));
               
INSERT INTO aircraft VALUES 
					(1, 
                    "BOEING", 
                    "787-8", 
                    "13,200 km", 
                    "43,000 ft", 
                    "126,206 Litres", 
                    "593 mph", 
                    "commercial");
