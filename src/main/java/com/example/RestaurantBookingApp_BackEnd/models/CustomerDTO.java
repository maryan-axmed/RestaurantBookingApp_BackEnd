package com.example.RestaurantBookingApp_BackEnd.models;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private List<Long> bookingIds;
    private String location;
//    CONSTRUCTOR
    public CustomerDTO(Long id, String name,String email, List bookingsIds, String location){
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookingIds = bookingsIds;
        this.location = location;
    }

//    DEFAULT CONSTRUCTOR
    public CustomerDTO(){}

//    GETTERS AND SETTERS

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<Long> bookingIds) {
        this.bookingIds = bookingIds;
    }
}
