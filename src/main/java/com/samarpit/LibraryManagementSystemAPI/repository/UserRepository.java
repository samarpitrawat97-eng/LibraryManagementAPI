package com.samarpit.LibraryManagementSystemAPI.repository;

import com.samarpit.LibraryManagementSystemAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA magically writes the SQL query for this based on the method name!
    Optional<User> findByEmail(String email);
}