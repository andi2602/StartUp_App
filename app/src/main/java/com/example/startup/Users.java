package com.example.startup;

import com.google.firebase.database.Exclude;

public class Users {


    private String name;
    private String email;
    private String ticketCode;
    private String key;

    public Users(){}
    public Users (String name)
    {
        this.name = name;
    }

    public Users(String name, String email, String ticketCode) {
        this.name = name;
        this.email = email;
        this.ticketCode = ticketCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
    @Exclude
    public String getKey() {
        return key;
    }
    @Exclude
    public void setKey(String key) {
        this.key = key;
    }
}
