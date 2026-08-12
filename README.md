# Library Management System API

A RESTful web service built with **Spring Boot** and **Spring Data JPA** to manage a library's book inventory. This API allows for seamless CRUD operations, custom search queries, and features centralized global exception handling for clean, consistent error responses.

## 🚀 Tech Stack

*   **Java 17+** 
*   **Spring Boot 3.x** (Web, Data JPA)
*   **H2 In-Memory Database** (for rapid development and testing)
*   **Maven** (Dependency Management)
*   **Hibernate** (ORM)

## ✨ Features

*   **Complete CRUD Functionality:** Create, Read, Update, and Delete books.
*   **Custom Search:** Filter the library catalog dynamically by author name.
*   **Global Exception Handling:** Custom `ResourceNotFoundException` caught by a `@ControllerAdvice` class to return standard 404 JSON error responses instead of stack traces.
*   **Zero-Config Database:** Uses an embedded H2 database that resets on restart, eliminating the need for external database setup.

## 🛠️ Local Setup & Installation

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/samarpitrawat97-eng/LibraryManagementAPI.git](https://github.com/samarpitrawat97-eng/LibraryManagementAPI.git)
