package com.ozanthongtomi.deviceIOT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ozanthongtomi.deviceIOT.service.FlightCommander;

@RestController
@RequestMapping(path="/device")
public class FlightController {
    
    @Autowired
    private FlightCommander flightCommander;

    @GetMapping
    public String test() {
        return flightCommander.pingDroneUnit();
    }
}
