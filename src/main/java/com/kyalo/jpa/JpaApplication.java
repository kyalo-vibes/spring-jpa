package com.kyalo.jpa;

import com.kyalo.jpa.models.Author;
import com.kyalo.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

		@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository){
			return args -> {
				var author = Author.builder()
						.firstName("Kevin")
						.lastName("Kyalo")
						.email("zjwY7@example.com")
						.age(24)
						.createdAt(LocalDateTime.now())
						.build();
				repository.save(author);
			};
		}

}
