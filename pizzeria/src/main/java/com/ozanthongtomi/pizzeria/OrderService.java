package com.ozanthongtomi.pizzeria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void processOrder(Order order) {
        // Process the order logic (e.g., save order details)

        // Send order to the fleet server to find an available drone


        // Get drone to deliver

        // Log the status of delivery

        System.out.println("Order placed successfully!");
    }
}