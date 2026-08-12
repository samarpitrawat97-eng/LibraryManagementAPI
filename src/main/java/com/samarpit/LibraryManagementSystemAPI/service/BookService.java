package com.samarpit.LibraryManagementSystemAPI.service;

import com.samarpit.LibraryManagementSystemAPI.exception.ResourceNotFoundException;
import com.samarpit.LibraryManagementSystemAPI.model.Book;
import com.samarpit.LibraryManagementSystemAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // --- NEW BUSINESS LOGIC METHODS ---

    public Book borrowBook(Long id) {
        // 1. Find the book (this uses your existing method that handles the 404 error!)
        Book book = getBookById(id);

        // 2. Check if there are copies available
        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("Sorry, this book is currently out of stock!");
        }

        // 3. Decrease the available copies by 1 and save
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return bookRepository.save(book);
    }

    public Book returnBook(Long id) {
        Book book = getBookById(id);

        // Prevent returning more copies than the library actually owns
        if (book.getAvailableCopies() >= book.getTotalCopies()) {
            throw new RuntimeException("All copies of this book are already in the library!");
        }

        // Increase the available copies by 1 and save
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        return bookRepository.save(book);
    }
}