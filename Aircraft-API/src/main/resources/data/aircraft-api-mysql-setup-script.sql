CREATE DATABASE IF NOT EXISTS `aircrafts-api`;

USE `aircrafts-api`;

DROP TABLE IF EXISTS aircraft;

CREATE TABLE IF NOT EXISTS 
	aircraft (id INTEGER PRIMARY KEY, 
			   make VARCHAR(25), 
               model VARCHAR(25), 
               maximum_range VARCHAR(25), 
               maximum_altitude VARCHAR(25), 
               fuel_capacity VARCHAR(25), 
               maximum_speed VARCHAR(25), 
               sector VARCHAR(25));
               
INSERT INTO aircraft VALUES 
					(1, "BOEING", "787-8", "8,202 miles", "43,000 ft", "126,206 litres", "593 mph", "commercial"),
                    (2,"AIRBUS", "A380 Plus", "9,445 miles", "43,028 ft", "320,000 litres", "630 mph", "commercial"),
                    (3, "CESSNA", "172 Skyhawk", "736 miles", "13,000 ft", "212 litres", "188 mph", "private"),
                    (4, "LOCKHEED MARTIN", "F-35B Lightning II", "518 miles", "50,000 ft", "7,875 litres", "1,200 mph", "military"),
                    (5, "CIRRUS", "SR22", "1,207 miles", "17,500 ft", "382 litres", "234 mph", "private"),
                    (6, "BOEING", "C-17 Globemaster III", "6,456 miles", "45,000 ft", "127,291 litres", "590 mph", "military");
                    
