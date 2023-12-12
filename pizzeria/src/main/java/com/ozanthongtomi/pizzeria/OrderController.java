package com.ozanthongtomi.pizzeria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        // Process the order and send it to the server
        orderService.processOrder(order);
        return ResponseEntity.ok("Please wait patiently and your order will be delivered to you by one of our drones");
    }
}