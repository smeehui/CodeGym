package com.huy.app.model;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotEmpty(message = "Full name can not be empty")
    @Valid
    @NotBlank(message = "Full name can not be empty")
    private String fullName;
//    @NotEmpty(message = "Email can not be empty")
    @Valid @NotBlank(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;
//    @NotEmpty(message = "Phone can not be empty")
    @Valid @NotBlank(message = "Phone can not be empty")
    private String phone;
//    @NotEmpty(message = "Address can not be empty")
    @Valid @NotBlank(message = "Address can not be empty")
    private String address;
    private double balance;
    public Customer() {
    }

    public Customer(Long id, @Valid @NotBlank String fullName, @Valid @NotBlank @Email String email, @Valid @NotBlank String phone, @Valid @NotBlank String address, double balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
