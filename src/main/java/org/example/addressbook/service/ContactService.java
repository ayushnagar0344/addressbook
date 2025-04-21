package org.example.addressbook.service;

import org.example.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Contact addContact(Contact contact) {
        contact.setId(idCounter++);
        contactMap.put(contact.getId(), contact);
        return contact;
    }

    public Contact updateContact(int id, Contact contact) {
        if (!contactMap.containsKey(id)) {
            return null;
        }
        contact.setId(id);
        contactMap.put(id, contact);
        return contact;
    }

    public boolean deleteContact(int id) {
        return contactMap.remove(id) != null;
    }
}
