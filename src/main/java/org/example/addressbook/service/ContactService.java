package org.example.addressbook.service;

import lombok.extern.slf4j.Slf4j;
import org.example.addressbook.dto.ContactDTO;
import org.example.addressbook.exceptions.AddressBookNotFoundException;
import org.example.addressbook.model.Contact;
import org.example.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// UC2
@Slf4j
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    private final Map<Integer, Contact> contactMap = new HashMap<>();
    private int idCounter = 1;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactMap.values());
    }

    public Contact getContactById(int id) {
        if (!contactMap.containsKey(id)) {
            throw new AddressBookNotFoundException("Address Book entry with ID " + id + " was not found.");
        }
        Contact contact = contactMap.get(id);
        log.info("Retrieved contact: {}", contact);
        return contact;
    }

    public Contact addContact(ContactDTO dto) {
        Contact contact = new Contact(idCounter++, dto.getName(), dto.getPhone());
        contactMap.put(contact.getId(), contact);
        return contact;
    }

    public Contact updateContact(int id, ContactDTO dto) {
        if (!contactMap.containsKey(id)) {
            throw new AddressBookNotFoundException("Cannot update. Address Book entry with ID " + id + " was not found.");
        }
        Contact updated = new Contact(id, dto.getName(), dto.getPhone());
        contactMap.put(id, updated);
        return updated;
    }

    public boolean deleteContact(int id) {
        if (!contactRepository.existsById(id)) {
            throw new AddressBookNotFoundException("Cannot delete. Address Book entry with ID " + id + " was not found.");
        }
        contactRepository.deleteById(id);
        return true;
    }
}