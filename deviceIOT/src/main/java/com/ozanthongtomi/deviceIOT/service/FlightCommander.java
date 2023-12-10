package com.ozanthongtomi.deviceIOT.service;

import org.springframework.stereotype.Component;

@Component
public class FlightCommander {

    public String pingDroneUnit() {
        String response = "Now delivering... ";
        return response;
    }
    
}
