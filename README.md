# bookstore-sample-app

[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)

Bookstore [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/tr/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

## Running the application locally

To run this application on your local machine create a docker container which extends postgres image. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
http://localhost:8080/swagger-ui/index.html
```

```shell
http://localhost:8080/h2-console
```

## Deploying the application to OpenShift

The easiest way to deploy the sample application to OpenShift is to use the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
oc new-app codecentric/springboot-maven3-centos~https://github.com/codecentric/springboot-sample-app
```

This will create:

* An ImageStream called "springboot-maven3-centos"
* An ImageStream called "springboot-sample-app"
* A BuildConfig called "springboot-sample-app"
* DeploymentConfig called "springboot-sample-app"
* Service called "springboot-sample-app"

If you want to access the app from outside your OpenShift installation, you have to expose the springboot-sample-app service:

```shell
oc expose springboot-sample-app --hostname=www.example.com
```

## Project summary

Objective:
Design and implement a RESTful API for an online bookstore using Java and Spring Boot. This API should provide essential functionality for both the user and the bookstore admin.
Requirements:
1. Entities:
- Book: ISBN (unique identifier), Title, Author, Price, Stock Quantity, CreatedAt,
  UpdatedAt.
- User: ID, Name, Email, Password (encrypted), CreatedAt, UpdatedAt.
- Order: Order ID, User ID, Total Price, List of Books, Order Date, CreatedAt,
  UpdatedAt.
2. API Endpoints:
- Book:
- `GET /books`: Retrieve a list of all books ordered by creation date DESC.
- `GET /books/{isbn}`: Retrieve details of a book by ISBN.
- `POST /books`: Add a new book (Admin only).
- `PUT /books/{isbn}`: Update details of a book (Admin only).
- `DELETE /books/{isbn}`: Delete a book by ISBN (Admin only).
- User:
- `POST /users/signup`: Register a new user.
- `POST /users/login`: Authenticate a user and return a token (JWT
  preferred).
- Order:
- `POST /orders`: Place a new order for a user with a minimum price of 25$.
- `GET /orders/{userId}`: Get all orders for a specific user ordered by update date DESC.
- `GET /orders/details/{orderId}`: Get details of a specific order by its ID with the books under that order.
3. Features:
- Use Spring Boot's layered architecture: Controller, Service, DAO, Entity.
- Implement security: Passwords should be securely hashed, and only
  authenticated users should be able to place orders. Admin operations (e.g.,
  adding or deleting a book) should require admin privileges.
- Integrate a database of your choice (e.g., H2 for simplicity, MySQL, or
  PostgreSQL for more realism) using Spring Data JPA.
- Include basic error handling (Book not found, Insufficient stock, Unauthorized user, Minimum Price For Order).


4. Bonus:
- Implement pagination for the `GET /books` endpoint.
- Implement HATEOAS (Hypermedia as the Engine of Application State) to guide
  the clients on possible interactions with your API.
- Implement Swagger UI integration.
- Add a simple rate-limiting mechanism to prevent abuse.
- Include unit and integration tests for your application using JUnit and MockMvc.