package com.example.RestaurantBookingApp_BackEnd.components;


import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import com.example.RestaurantBookingApp_BackEnd.models.Customer;
import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.models.Table;
import com.example.RestaurantBookingApp_BackEnd.repositories.BookingRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.CustomerRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TableRepository tableRepository;

//    DataLoader Information

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception{


//        make 6 restaurants

        Restaurant restaurant1 = new Restaurant("Nandos", "London", "'I highly recommend their peri chicken'");
        Restaurant restaurant2 = new Restaurant("Wagamama", "London", "Mo 'My go-to! Always tastes brilliant.'");
        Restaurant restaurant3 = new Restaurant("An-Najeeb", "Leicester", "'The service here is impeccable'");
        Restaurant restaurant4 = new Restaurant("Konak", "Leicester", "'This Turkish fusion wows me!'");
        Restaurant restaurant5 = new Restaurant("Pizza Posto", "Edinburgh",  "'The best pizza spot in Edinburgh!'");
        Restaurant restaurant6 = new Restaurant("Scott's Kitchen", "Edinburgh", "'The best breakfast spot in Edinburgh!'");
        Restaurant restaurant7 = new Restaurant("Watan", "London", "Sarah 'One of the best dishes I've ever tried. Wow'");
        Restaurant restaurant8 = new Restaurant("Chaiiwala", "Edinburgh", "Malika 'I dream about their Karak Chai'");

        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);
        restaurantRepository.save(restaurant3);
        restaurantRepository.save(restaurant4);
        restaurantRepository.save(restaurant5);
        restaurantRepository.save(restaurant6);
        restaurantRepository.save(restaurant7);
        restaurantRepository.save(restaurant8);



//        make 1 customer

        Customer customer1 = new Customer("Yasmin", "yasmin@hotmail.com", "Leicester");
        Customer customer2 = new Customer("Sarah", "sarah@hotmail.com", "London");
        Customer customer3 = new Customer("Taliane", "taliane@hotmail.com", "Milton Keynes");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);


//        create tables

        Table table1 = new Table(4 ,restaurant2);
        Table table2 = new Table(6 ,restaurant2);
        Table table3 = new Table(8 ,restaurant2);
        Table table4 = new Table(12 ,restaurant2);
        Table table5 = new Table(2 ,restaurant2);

        Table table6 = new Table(2 ,restaurant1);
        Table table7 = new Table(4 ,restaurant1);
        Table table8 = new Table(6 ,restaurant1);
        Table table9 = new Table(8 ,restaurant1);
        Table table10 = new Table(12 ,restaurant1);
        Table table11 = new Table(2 ,restaurant1);
        Table table12= new Table(2 ,restaurant1);
        Table table13 = new Table(4 ,restaurant1);
        Table table14 = new Table(6 ,restaurant1);

        tableRepository.save(table1);
        tableRepository.save(table2);
        tableRepository.save(table3);
        tableRepository.save(table4);
        tableRepository.save(table5);
        tableRepository.save(table6);
        tableRepository.save(table7);
        tableRepository.save(table8);
        tableRepository.save(table9);
        tableRepository.save(table10);
        tableRepository.save(table11);
        tableRepository.save(table12);
        tableRepository.save(table13);
        tableRepository.save(table14);

//      create list of tables

        List<Table> tableList = new ArrayList<>();

//        add tables to list

        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);
        tableList.add(table7);
//        tableList.add(table11);
//        tableList.add(table12);
//        tableList.add(table13);
//        tableList.add(table14);

//        create bookings

        Booking booking1 = new Booking(customer1, restaurant2, tableList, LocalDate.of(2023, 12, 03), LocalTime.of(14,00));
        booking1.setListOfTables(tableList);
        Booking booking2 = new Booking(customer2, restaurant1, tableList,  LocalDate.of(2023, 9, 02), LocalTime.of(12,00));
        booking2.setListOfTables(tableList);
        Booking booking3 = new Booking(customer3, restaurant2, tableList,LocalDate.of(2023, 11, 12), LocalTime.of(17,00));
        booking3.setListOfTables(tableList);

        Booking booking4= new Booking(customer3, restaurant1, tableList,LocalDate.of(2023, 11, 12), LocalTime.of(17,00));
        booking4.setListOfTables(tableList);

        Booking booking5 = new Booking(customer3, restaurant1, tableList,LocalDate.of(2023, 10, 11), LocalTime.of(17,00));
        booking5.setListOfTables(tableList);


        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
    }









}
