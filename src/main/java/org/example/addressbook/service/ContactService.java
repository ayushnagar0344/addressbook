package org.example.addressbook.service;
import org.example.addressbook.dto.ContactDTO;

import org.example.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.*;

// UC2
@Service
public class ContactService {
    private final Map<Integer, Contact> contactMap = new HashMap<>();
    private int idCounter = 1;

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactMap.values());
    }

    public Contact getContactById(int id) {
        return contactMap.get(id);
    }

    public Contact addContact(ContactDTO dto) {
        Contact contact = new Contact(idCounter++, dto.getName(), dto.getPhone());
        contactMap.put(contact.getId(), contact);
        return contact;
    }

    public Contact updateContact(int id, ContactDTO dto) {
        if (!contactMap.containsKey(id)) {
            return null;
        }
        Contact updated = new Contact(id, dto.getName(), dto.getPhone());
        contactMap.put(id, updated);
        return updated;
    }

    public boolean deleteContact(int id) {
        return contactMap.remove(id) != null;
    }
}
