package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.*;
import com.example.RestaurantBookingApp_BackEnd.repositories.BookingRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.CustomerRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TableRepository tableRepository;

    //Default constructor ???

    public BookingDTO getBookingDTO(Booking booking) {
        List<Long> tableIds = new ArrayList<>();
        for (Table table : booking.getListOfTables()) {
            Long id = table.getId();
            tableIds.add(id);
        }
        BookingDTO bookingDTO = new BookingDTO(booking.getCustomer().getId(), booking.getCustomer().getName(), booking.getRestaurant().getId(), tableIds, booking.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), booking.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        return bookingDTO;
    }

        public List<Booking> getAllBookings(){
            List<Booking> allBookings = bookingRepository.findAll();
            return allBookings;

    }








    public BookingDTO getBookingById (Long bookingId){
          Booking booking = bookingRepository.findById(bookingId).get();
          BookingDTO bookingDTO = getBookingDTO(booking);
          return bookingDTO;
//        BookingDTO bookingDTO = new ArrayList<>();
//        List<Booking> allBookings = bookingRepository.findById(bookingId).get();
//        for(Booking booking : allBookings){
//            BookingDTO bookingDTO = getBookingDTO(booking);
//            allBookingDTOs.add(bookingDTO);
//        }
//        return allBookingDTOs;
////        return bookingRepository.findById(bookingId).get();
    }

//    public void makeNewBooking(Long customerId, Long bookingId){
//        Optional<Booking> booking =  bookingRepository.findById(bookingId);
//        Optional<Customer> customer = customerRepository.findById(customerId);
//    }

    public Booking makeNewBooking(BookingDTO bookingDTO){
        // make new booking object and get the customer name and the dateAndTime

        //add customer object to the new booking object:
        Customer customer = customerRepository.findById(bookingDTO.getCustomerId()).get();

        //add restaurant object to the new booking object:
        Restaurant restaurant = restaurantRepository.findById(bookingDTO.getRestaurantId()).get();

        //add time and date??- need to add a 2-hour slot
        LocalTime time = bookingDTO.getTime();

        LocalDate date = bookingDTO.getDate();

        List<Table> listTable = new ArrayList<>();

//        Table table1 = new Table();
        for (Long tableId : bookingDTO.getTableIds()){
            Table table = tableRepository.findById(tableId).get();
            listTable.add(table);
        }


        Booking booking = new Booking(customer, restaurant, listTable, date, time);
        bookingRepository.save(booking);

        return booking;

    }

    public void deleteBooking(Long bookingId){
//        Booking booking = bookingRepository.findById(bookingId).get();
        bookingRepository.deleteById(bookingId);
    }


    public List<Booking> getAllBookingsByCustomerId(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        List<Booking> bookings = customer.getBookings();
        return bookings;
    }
}
