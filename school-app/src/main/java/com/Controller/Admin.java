package com.Controller;

import jakarta.persistence.*;

@Entity
@Table
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private Long id;
    private String name;
    private String phoneNumber;
    private String adress;

    public Admin(Long id, String name, String phoneNumber, String adress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }

    public Admin() {
        this.name = "";
        this.phoneNumber = "";
        this.adress = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
