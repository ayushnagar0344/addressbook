package org.example.addressbook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class ContactDTO {

    @NotEmpty(message = "Name is required and cannot be empty")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can only contain letters and spaces")


    private String name;
    private String phone;

    public ContactDTO() {
    }

    public ContactDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
