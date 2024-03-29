package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.models.RestaurantDTO;
import com.example.RestaurantBookingApp_BackEnd.models.Table;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    BookingService bookingService;


    public RestaurantDTO getRestaurantDTO(Restaurant restaurant) {
        List<Long> bookingIds = new ArrayList<>();
        List<Long> tableIds = new ArrayList<>();
        for (Booking booking : restaurant.getBookings()) {
            Long id = booking.getId();
            bookingIds.add(id);
        }
        for (Table table : restaurant.getTables()) {
            Long id = table.getId();
            tableIds.add(id);
        }
        RestaurantDTO restaurantDTO = new RestaurantDTO(restaurant.getId(), restaurant.getName(), tableIds, restaurant.getLocation(), bookingIds);
        return restaurantDTO;
    }
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return restaurant;
    }

}
