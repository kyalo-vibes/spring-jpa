package com.kyalo.jpa.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AUTHOR_TBL")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "author_sequence", allocationSize = 1)
    //@TableGenerator(name = "author_generator", table = "author_sequence", pkColumnName = "sequence_name", valueColumnName = "sequence_value", initialValue = 1,allocationSize = 1)
    private Integer id;

    @Column(name="f_name")
    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime lastModified;
}
