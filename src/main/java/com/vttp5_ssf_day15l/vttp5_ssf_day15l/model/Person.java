package com.vttp5_ssf_day15l.vttp5_ssf_day15l.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Person {

    // put in the neccessary validations
    @Min(value = 1, message = "Must be more than 0")
    @Max(value = 99, message = "Must be less than 100")
    private Integer id;

    @NotBlank(message = "Cannot be empty")
    private String fullName;

    @Email
    private String email;

    public Person() {
    }

    public Person(Integer id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + ", " + fullName + ", " + email;
    }

}
