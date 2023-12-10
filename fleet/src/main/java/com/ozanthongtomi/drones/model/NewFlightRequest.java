package com.ozanthongtomi.drones.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class NewFlightRequest {
    private Long id;
    private Location destination;
    private Location startingPoint;
    private int weight;

    public NewFlightRequest(Long id, int weight, Location destination, Location startingPoint){
        this.id = id;
        this.weight = weight;
        this.destination = destination;
        this.startingPoint = startingPoint;
    }
}
