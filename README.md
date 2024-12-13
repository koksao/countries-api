# Countries

This application provides a RESTful API to retrieve information about a specific country using its ISO code.
Country data is initially fetched from an H2 database. If the requested information is not found in the database, 
it is retrieved from the REST Countries API (https://restcountries.com) and added to the H2 database for future requests.

## How to run

To run this application, type
```
mvn spring-boot:run
```

To run tests, type
```
mvn test
```
