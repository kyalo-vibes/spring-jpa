package com.kyalo.jpa.models.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable// Makes the class an embedded entity
public class OrderId implements Serializable {
    private String username;

    private LocalDateTime orderDate;
}
