package com.kyalo.jpa.repositories;

import com.kyalo.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // select * from author_tbl where first_name = 'kyalo'
    List<Author> findAllByFirstName(String fn);

    // select * from author_tbl where lower(first_name) = 'kyalo'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // select * from author_tbl where lower(first_name) like '%kyalo%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // select * from author_tbl where lower(first_name) like 'kyalo%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from author_tbl where lower(first_name) like '%kyalo%'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // select * from author_tbl where lower(first_name) in ('kyalo', 'kevin')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> fns);
}
