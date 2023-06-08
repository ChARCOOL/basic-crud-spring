# Java Application with PostgreSQL Database (Basic CRUD App)

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

This repository contains a basic CRUD (Create, Read, Update, Delete) Java application with a PostgreSQL database backend. The application provides RESTful APIs for managing user entities using Spring Boot, JPA, and Docker Compose for containerization.

## Prerequisites

- Docker
- Java 17
- Maven

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### Installation

1. Clone the repository: `git clone https://github.com/ChARCOOL/basic-crud-spring.git`
2. Navigate to the project directory: `cd basic-crud-spring`
3. Build the Java application using Maven: `mvn clean package`
4. Start the Docker containers: docker-compose up -d

### Usage

- The Java application will be accessible at `http://localhost:8080`.
- The PostgreSQL database will be available at `localhost:5432`.
- Use a REST client or tools like cURL or Postman to interact with the API endpoints.

### Configuration

The application uses environment variables for database connection configuration. Modify the `docker-compose.yml` file or set the environment variables directly.

### API Endpoints

| HTTP Method | Endpoint          | Description                 |
| ----------- | ----------------- | --------------------------- |
| GET         | `/api/users`      | Retrieve all users          |
| GET         | `/api/users/{id}` | Retrieve a user by ID       |
| POST        | `/api/users`      | Create a new user           |
| PUT         | `/api/users/{id}` | Update an existing user     |
| DELETE      | `/api/users/{id}` | Delete a user               |

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)
