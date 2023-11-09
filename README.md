# BookStore Sample App

 This Bookstore sample app powered with [Spring Boot](http://projects.spring.io/spring-boot/).

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/tr/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

## Running the application locally

To run this application on your local machine execute the `main` method in the `com.mehmetfaruk.bookstore.BookstoreApplication` class from your IDE.

## Usage of H2 Database
This application utilizes the H2 database. You can access the H2 database console using the following URL:

`http://localhost:8080/h2-console` or click [here](http://localhost:8080/h2-console).

### Admin created automatically
The application generates an admin with the username and password in the first request you send.

### Swagger Usage
The application uses Swagger for API documentation. You can access the Swagger UI at the following URL:

`http://localhost:8080/swagger-ui/index.html` or click [here](http://localhost:8080/swagger-ui/index.html).

### Spring Security Usage
This application employs Spring Security 6 for security and authorization. Spring SecurityFilterChain is used for security configuration.

### Basic Authentication
The application utilizes basic authentication for user authentication. Authentication with a username and password is required to access some endpoints.

### Role-Based Endpoint Design
The application is designed to restrict access to certain URLs to users that not authenticated.

# Project summary

## Entities:
- Book: ISBN (unique identifier), Title, Author, Price, Stock Quantity, CreatedDate,
  UpdatedDate.
- User: ID, Name, Email, Password (encrypted), CreatedDate, UpdatedDate.
- Order: Order ID, User ID, Total Price, List of Books, Order Date, CreatedDate,
  UpdatedDate.


## API Endpoints:
#### Book:
- `GET /books`: Retrieves a list of all books ordered by creation date DESC and paging included.
- `GET /books/{isbn}`: Retrieves details of a book by ISBN.
- `POST /books`: Adds a new book (Admin only).
- `PUT /books/{isbn}`: Updates details of a book (Admin only).
- `DELETE /books/{isbn}`: Deletes a book by ISBN (Admin only).
#### User:
- `POST /users/signup`: Registers a new user.
- `POST /users/login`: Authenticates a user and returns a token.
#### Order:
- `POST /orders`: Places a new order for a user with a minimum price of 25$.
- `GET /orders/{userId}`: Gets all orders for a specific user ordered by update date DESC.
- `GET /orders/details/{orderId}`: Gets details of a specific order by its ID with the books under that order.

### Features:
- Spring Boot's layered architecture: Controller, Service, DAO, Entity.
- Passwords are securely hashed, and only authenticated users are able to place orders. Admin operations (e.g., adding or deleting a book) requires admin privileges.
- H2 database integration using Spring Data JPA.
- Basic error handling (Book not found, Insufficient stock, Unauthorized user, Minimum Price For Order).
