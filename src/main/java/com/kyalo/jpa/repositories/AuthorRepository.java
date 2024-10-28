package com.kyalo.jpa.repositories;

import com.kyalo.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorAge(int age);
}
