package org.example.addressbook.exceptions;

/**
 * Custom exception for Address Book not found cases.
 */
public class AddressBookNotFoundException extends RuntimeException {
    public AddressBookNotFoundException(String message) {
        super(message);
    }
}