package org.example.addressbook.repository;

import org.example.addressbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for accessing Contact entities.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    // JpaRepository provides CRUD methods like existsById and deleteById
}