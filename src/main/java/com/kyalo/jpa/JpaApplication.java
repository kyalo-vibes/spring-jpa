package com.kyalo.jpa;

import com.github.javafaker.Faker;
import com.kyalo.jpa.models.Author;
import com.kyalo.jpa.models.Video;
import com.kyalo.jpa.repositories.AuthorRepository;
import com.kyalo.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

		@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository){
			return args -> {
				System.out.println("--------------Query 1 --------------------");
				repository.findAllByFirstName("Evie").forEach(System.out::println);
				System.out.println("--------------Query 2 --------------------");
				repository.findAllByFirstNameIgnoreCase("evie").forEach(System.out::println);
				System.out.println("--------------Query 3 --------------------");
				repository.findAllByFirstNameInIgnoreCase(List.of("evie", "sergio", "romana")).forEach(System.out::println);
				System.out.println("--------------Query 4 --------------------");
				repository.findAllByFirstNameContainingIgnoreCase("o").forEach(System.out::println);
				System.out.println("--------------Query 5 --------------------");
				repository.findAllByFirstNameStartsWithIgnoreCase("e").forEach(System.out::println);
				System.out.println("--------------Query 6 --------------------");
				repository.findAllByFirstNameEndsWithIgnoreCase("e").forEach(System.out::println);

				var author = Author.builder()
						.id(1)
						.firstName("Kevin")
						.lastName("Kyalo")
						.email("kk@gmail.com")
						.age(24)
						.build();
				repository.save(author);

				repository.updateAuthor(99,1);

				repository.updateAllAuthorAge(100);

//				for(int i = 0; i < 50; i++) {
//					Faker faker = new Faker();
//					var author = Author.builder()
//							.firstName(faker.name().firstName())
//							.lastName(faker.name().lastName())
//							.email(faker.internet().emailAddress())
//							.age(faker.number().numberBetween(18, 60))
//							.createdAt(LocalDateTime.now())
//							.build();
//					repository.save(author);
//				}
//				var video = Video.builder()
//						.name("abc")
//						.length(35)
//						.build();
//				videoRepository.save(video);
			};
		}

}
