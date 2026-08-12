package com.samarpit.LibraryManagementSystemAPI.controller;

import com.samarpit.LibraryManagementSystemAPI.model.Book;
import com.samarpit.LibraryManagementSystemAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // GET endpoint: /api/books/search?author=AuthorName
    @GetMapping("/search")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    // --- NEW BUSINESS LOGIC ENDPOINTS ---

    // POST endpoint: /api/books/{id}/borrow
    @PostMapping("/{id}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable Long id) {
        Book updatedBook = bookService.borrowBook(id);
        return ResponseEntity.ok(updatedBook);
    }

    // POST endpoint: /api/books/{id}/return
    @PostMapping("/{id}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        Book updatedBook = bookService.returnBook(id);
        return ResponseEntity.ok(updatedBook);
    }

    // ------------------------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}