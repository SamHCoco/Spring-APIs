# Aircraft RESTful API

## Overview (Updated as new features are added):

A RESTful API for interacting with a database of aircrafts, allowing the client to consume JSON data on their following specs:
- *Make*
- *Model*
- *Maximum altitude - ft*
- *Fuel capacity - litres*
- *Maximum Speed - mph*
- *Sector - (commercial, military or private)*

### Get All Aircrafts
To return all the aircraft in the database, make a HTTP GET request to the following endpoint:
```
GET http://localhost:8080/api/aircrafts
```

### Get A Single Aircraft
To return a single aircraft from the database, specified by its ID in the database, make a HTTP GET request to the following endpoint:
```
GET http://localhost:8080/api/aircrafts/{id}
```

### Get All Aircrafts By Sector
To return all aircrafts in the database which operate in the specified sector, make a HTTP GET request to the following endpoint:
```
GET http://localhost:8080/api/aircrafts/{sector}
For example, to get all military aircrafts in the database, we use the following endpoint:
http://localhost:8080/api/aircrafts/military
```

### Add Aircrafts
To add aircrafts to the database, make a HTTP POST request to the following endpoint:
```
POST http://localhost:8080/api/aircrafts
For example, to add two aircrafts send the request with the request body containing a JSON array (if JSON is being used) of 2 aircraft objects with the following key-values pairs:
[
  {
    "make": "value",
    "model" : "value",
    "maximumAltitude": "value",
    "fuelCapacity": "value",
    "maximumSpeed": "value",
    "sector": "value"
  },
  {
    "make": "value",
    "model" : "value",
    "maximumAltitude": "value",
    "fuelCapacity": "value",
    "maximumSpeed": "value",
    "sector": "value"
  }
]
```
### Delete Aircraft
To delete an aircraft from the database, make a HTTP DELETE request to the following endpoint:
```
DELETE http://localhost:8080/api/aircrafts/{id}
Where {id} is the ID of the aircraft to be deleted.
```

### Update Aircraft
To update an aircraft in the database, make a HTTP PUT request to the following endpoint:
```
PUT http://localhost:8080/api/aircraft/{id}

Where {id} is the ID of the aircraft to be updated.
For example, to update the make, range, and speed properties of aircraft
with ID equal 2 in the database, a PUT request is sent to:
http://localhost:8080/api/aircrafts/2

With the request body containing the key-value specification of the fields
to be updated:

{
  "make": "updated-make",
  "maximumRange": "updated-range",
  "maximumSpeed": "updated-speed"
}
```
