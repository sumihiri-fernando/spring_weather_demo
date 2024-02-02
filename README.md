## Spring Boot Weather Application

### Overview

Create a new Spring Boot project using your preferred IDE or Spring Initializr.
Include dependencies for Spring Web, Spring Data JPA, Spring DevTools, MySQL Connector, Spring Boot Test, Spring REST Docs MockMVC, Jakarta Persistence API, H2 Database, and Mockito.

A Spring Boot application that provides weather data through a REST API.

This is a weather project that fetches weather data from different countries and cities Spring Boot (version 3.2.2) application that can be used as a starter for creating a project complete with built-in weather condition check via country ID and city ID, and much more.

### Features

Outline the main features of your application, such as:

- Fetch weather data for a specific city
- Retrieve a list of cities for a particular country
- Exception handling for invalid requests
- Dockerized deployment
- Continuous Integration with Github Actions

### Installation

To set up the project locally, follow these steps:

- Clone the repository from GitHub: git clone https://github.com/sumihiri-fernando/spring_weather_demo.git
- Navigate to the project directory: cd spring_weather_demo
- Ensure you have Maven installed: Maven Installation Guide
- Build the project using Maven: mvn clean install
- Run the application: mvn spring-boot:run

### Application demonstrates:

- Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
- Packaging as a single WAR with an embedded container: No need to install a container separately on the host, just run using the `java -jar` command
- Writing a RESTful service using annotation: supports both XML and JSON request/response; simply use desired `Accept` header in your request.
- Exception mapping from application exceptions to the right HTTP response with exception details in the body.
- *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
- Automatic CRUD functionality against the data source using Spring *Repository* pattern.
- Demonstrates MockMVC test framework with associated libraries.
- All APIs are "self-documented" by Swagger2 using annotations

### Usage

Once the application is running, you can interact with it using the following endpoints:

- Fetch weather data for a specific city: GET /api/weatherData/{city_id}
- Retrieve cities for a specific country: GET /api/{country}/cities
- Create a city: POST /api/cities
- Retrieve information about a city by ID: GET /api/cities/{id}
- Update a city: PUT /api/cities/{id}
- Delete a city: DELETE /api/cities/{id}

Ensure that your requests are directed to port 8080.

Here are some endpoints you can call:

#### Get information about weather, city, and country etc

```
http://localhost:8080/api/countries/7

{
    "countryId": 7,
    "countryName": "Yeman"
}

http://localhost:8080/api/cities

{
    "cityId": 2,
    "cityName": "Rome",
    "weatherList": [
        {
            "id": 2,
            "temperature": "-2°C",
            "cityId": 2,
            "condition": "Snow"
        },
        {
            "id": 303,
            "temperature": "-2°C",
            "cityId": 2,
            "condition": "Snow"
        },
        {
            "id": 352,
            "temperature": "-23°C",
            "cityId": 2,
            "condition": "Snow"
        }
    ],
    "countryId": 1
}
```

### Testing

Unit tests for the REST API endpoints are available using JUnit and Mockito. To run the tests, execute the following command:

mvn test

The tests cover both positive and negative scenarios to ensure the reliability and correctness of the application's behavior.

### Dockerization

The application can be containerized using Docker. To build a Docker image, follow these steps:

- Install Docker on your machine: Docker Installation Guide
  Navigate to the project directory
- Build the Docker image: docker build -t spring_weather_demo .
- Run the Docker container: docker run -p 8080:8080 spring_weather_demo

### Continuous Integration

Continuous Integration is set up using GitHub Actions. With each commit, the workflow automatically builds, tests, and deploys the application. The CI configuration file is available in the .github/workflows directory.

### Contributing

Contributions to the project are welcome! If you encounter any bugs, have suggestions for enhancements, or want to submit pull requests, please follow these guidelines:

- Fork the repository
- Create your feature branch: git checkout -b feature/new-feature
- Commit your changes: git commit -am 'Add new feature'
- Push to the branch: git push origin feature/new-feature
- Submit a pull request

### Dependencies Used:

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- MySQL Connector
- Spring Boot Starter Test
- Spring REST Docs MockMVC
- Jakarta Persistence API
- H2 Database
- Mockito

### License

This project is licensed under the [MIT](https://choosealicense.com/licenses/mit/) License.