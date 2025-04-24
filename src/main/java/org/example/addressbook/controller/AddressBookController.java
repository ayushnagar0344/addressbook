package org.example.addressbook.controller;

import org.example.addressbook.dto.ContactDTO;
import org.example.addressbook.model.Contact;
import org.example.addressbook.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    private final ContactService service;

    public AddressBookController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {
        return createResponse(service.getContactById(id));
    }

    @PostMapping
    public ResponseEntity<Contact> addContact(@Valid @RequestBody ContactDTO contactDTO) {
        return ResponseEntity.ok(service.addContact(contactDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable int id, @Valid @RequestBody ContactDTO contactDTO) {
        return createResponse(service.updateContact(id, contactDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {
        boolean deleted = service.deleteContact(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private <T> ResponseEntity<T> createResponse(T body) {
        return body != null ? ResponseEntity.ok(body) : ResponseEntity.notFound().build();
    }
}