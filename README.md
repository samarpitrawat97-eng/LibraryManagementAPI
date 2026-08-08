Markdown
# Library Management System API

A RESTful backend service built with Spring Boot and MySQL to manage library resources, including books and authors. 

## Tech Stack
* **Language:** Java
* **Framework:** Spring Boot
* **Database:** MySQL
* **Dependencies:** Spring Web, Spring Data JPA, MySQL Connector

## Prerequisites
Ensure you have the following installed on your local machine:
* Java Development Kit (JDK 17 or higher)
* MySQL Server 
* Git
* Postman (for API testing)

## Local Setup & Launch Instructions

### 1. Database Configuration
Ensure your MySQL server is running and create a new database:
```sql
CREATE DATABASE library_db;
This application uses an environment variable to secure your database password. You will need to set this variable on your machine before running the application so it can successfully authenticate.

2. Clone and Run
Open your terminal and run the following commands to clone the repository and start the server:

Bash
# Clone the repository
git clone [https://github.com/YOUR_USERNAME/library-management-api.git](https://github.com/YOUR_USERNAME/library-management-api.git)
cd library-management-api

# Set your local database password variable for the terminal session
export DB_PASSWORD="your_actual_mysql_password"

# Build and run the application using the Maven wrapper
./mvnw spring-boot:run
The application will start on http://localhost:8080. Hibernate will automatically connect to MySQL and generate the necessary tables.

API Endpoints (Current Progress)
Books
Method	Endpoint	Description
GET	/api/books	Retrieve a list of all books
POST	/api/books	Add a new book to the database
Example POST Request Body:

JSON
{
    "title": "The Hobbit",
    "isbn": "978-0547928227",
    "authorName": "J.R.R. Tolkien",
    "publishedYear": 1937
}
Author
Samarpit Rawat
Computer Science and Engineering, NIT Raipur CSE'29
