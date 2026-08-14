package com.samarpit.LibraryManagementSystemAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LibraryManagementSystemApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApiApplication.class, args);
	}
}
