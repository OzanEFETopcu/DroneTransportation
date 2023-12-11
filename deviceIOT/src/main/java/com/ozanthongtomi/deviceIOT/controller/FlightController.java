package com.ozanthongtomi.deviceIOT.controller;
import java.util.concurrent.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ozanthongtomi.deviceIOT.service.FlightCommander;

@RestController
@RequestMapping(path="/device")
public class FlightController {
    
    @Autowired
    private FlightCommander flightCommander;

    @GetMapping
    public void test() {
        flightCommander.pingDroneUnit();
    }

    @GetMapping(path="/deliver")
    public String deliver() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println(flightCommander.pickUp()), 3, TimeUnit.SECONDS);
        scheduler.schedule(() -> System.out.println(flightCommander.waitForPizza()), 3, TimeUnit.SECONDS);
        scheduler.schedule(() -> System.out.println(flightCommander.deliver()), 3, TimeUnit.SECONDS);

        scheduler.shutdown();
        return flightCommander.comeBack();
    }

}
