# Library Management System API

A RESTful web service built with **Spring Boot** and **Spring Data JPA** to manage a library's book inventory. This API handles standard CRUD operations, custom search queries, inventory management (borrowing/returning), and includes robust data validation and exception handling.

## 🚀 Tech Stack

*   **Java 17+** 
*   **Spring Boot 3.x** (Web, Data JPA, Validation)
*   **H2 In-Memory Database** (for rapid development and testing)
*   **Maven** (Dependency Management)
*   **Hibernate** (ORM)

## ✨ Features

*   **Complete CRUD Functionality:** Create, Read, Update, and Delete books.
*   **Inventory Management:** Dedicated business logic endpoints to borrow and return books, dynamically updating available stock and preventing invalid actions (e.g., borrowing an out-of-stock book).
*   **Input Validation:** Ensures data integrity using `jakarta.validation` (`@NotBlank`, `@Min`) to block invalid API requests automatically.
*   **Custom Search:** Filter the library catalog dynamically by author name.
*   **Global Exception Handling:** Custom exceptions caught by `@ControllerAdvice` to return standard JSON error responses instead of stack traces.
*   **Zero-Config Database:** Uses an embedded H2 database that resets on restart, eliminating the need for external database setup.

## 🛠️ Local Setup & Installation

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/samarpitrawat97-eng/LibraryManagementAPI.git](https://github.com/samarpitrawat97-eng/LibraryManagementAPI.git)
