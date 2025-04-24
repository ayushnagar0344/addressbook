package org.example.addressbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The entity class representing a Contact in the AddressBook system.
 */
@Entity // Marks this class as a JPA entity to be managed by Hibernate.
@Data // Lombok annotation to generate getters, setters, and other methods.
@NoArgsConstructor // Generates a required no-args constructor.
@AllArgsConstructor // Generates a constructor with all fields.
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key.
    private Integer id;

   
   
    private String name;

    private String email;

    // Optionally, you can add custom logic or methods if needed.
}