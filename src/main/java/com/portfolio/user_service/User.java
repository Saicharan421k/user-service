package com.portfolio.user_service;

import jakarta.persistence.*;
import lombok.Data;

@Data // From Lombok: automatically creates getters, setters, toString(), etc.
@Entity // From Jakarta Persistence: marks this class as a database entity.
@Table(name = "users", schema = "user_schema") // Specifies the table name and schema.
public class User {

    @Id // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells the database to automatically generate this ID.
    private Long id;

    @Column(nullable = false) // Marks the corresponding database column as NOT NULL.
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // The email must be provided and must be unique.
    private String email;

    @Column(nullable = false)
    private String passwordHash; // We only ever store a HASH of the password, never the real one.

}