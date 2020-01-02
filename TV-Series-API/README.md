# TV Series REST API

### Overview:
A Spring Boot REST API for interacting with a TV Series database containing movie objects with the following properties:

- *ID*
- *Title*
- *Release Year*
- *Genre*
- *Description*

Authentication is first required before access is allowed to the resources of this API.

#### Getting All TV Series
To get all series TV Series in the database, a GET request is made to the following endpoint:
```
GET http://localhost:8080/api/tv-series
```
TV series may be filtered according to release year, genre, or both, by passing values to the *genre* (string) and *year* (integer) query parameters. Passing no values to these parameters will return all series in the database.

```
GET http://localhost:8080/api/tv-series?year={year}&genre={'genre'}

Return all TV series in the database filtered by the specified genre and release year.

GET http://localhost:8080/api/tv-series?year={year}

Returns all TV series in the database filtered by the specified year.

GET http://localhost:8080/api/tv-series?genre={'genre'}

Returns all TV series in the database filtered by the specified genre.
```

#### Get TV Series By ID
To return a single TV series by its ID, a GET request is made to the following endpoint:
```
GET http://localhost:8080/api/tv-series/{id}

Where {id} (integer) is the ID of the desired series.
```

#### Add TV Series
To add a TV series to the database, a POST request is made to the following endpoint:

```
POST http://localhost:8080/api/tv-series

With the request body containing the following JSON object of the new series to be added:

{
  "title": value,
  "year": value,
  "genre": value,
  "description": value
}
```

#### Delete TV Series
To delete a TV series from the database, a DELETE request is made to the following endpoint:
```
DELETE http://localhost:8080/api/tv-series/{id}

Where {id} is the ID of the TV Series entry to be deleted from the database.
```
