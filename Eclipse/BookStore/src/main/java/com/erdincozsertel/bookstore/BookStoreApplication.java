package com.erdincozsertel.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BookStoreApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BookStoreApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
