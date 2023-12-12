package com.ozanthongtomi.deviceIOT.service;

import org.springframework.stereotype.Component;

@Component
public class FlightCommander {

    public void pingDroneUnit() {
        System.out.println("Drone now online.");
    }

    public String deliver() {
        String response = "Now delivering... ";
        return response;
    }


    public String waitForPizza() {
        String response = "Now waiting for Pizza... ";
        return response;
    }


    public String pickUp() {
        String response = "Picking up pizza... ";
        return response;
    }

    public String comeBack() {
        String response = "Now coming back... ";
        return response;
    }
    
}
