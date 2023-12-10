package com.ozanthongtomi.deviceIOT.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="fleet/flight")
public class FlighController {
    
    @Autowired
    private FlightCommander flightCommander;

    @GetMapping
    public String test() {
        return flightCommander.pingDroneUnit();
    }
}
