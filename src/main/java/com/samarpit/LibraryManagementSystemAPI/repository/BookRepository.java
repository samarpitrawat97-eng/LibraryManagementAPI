package com.samarpit.LibraryManagementSystemAPI.repository;
import com.samarpit.LibraryManagementSystemAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}