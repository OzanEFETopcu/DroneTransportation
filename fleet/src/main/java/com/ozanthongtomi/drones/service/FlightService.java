package com.ozanthongtomi.drones.service;

import java.util.*;

import com.ozanthongtomi.drones.helper.Helper;
import com.ozanthongtomi.drones.model.Drone;
import com.ozanthongtomi.drones.model.NewFlightRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.ozanthongtomi.drones.model.Flight;
import com.ozanthongtomi.drones.model.NewDroneRequest;
import com.ozanthongtomi.drones.repository.FlightRepository;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final DroneService droneService;

    @Autowired
    public FlightService(FlightRepository flightRepository, DroneService droneService) {
        this.flightRepository = flightRepository;
        this.droneService = droneService;
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(@PathVariable Long id) {
        try {
            return Optional.ofNullable(flightRepository.findById(id)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new));
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Flight createFlight(NewFlightRequest flight) {
        Helper helper = new Helper();
        // get the distance
        double distance = helper.calculateDistance(flight.getStartingPoint(), flight.getDestination());

        // get minimum capacity (logic: capacity = distance (km) * weight (kg))
        int weight = flight.getWeight();
        int minimumCapacityRequired = (int) (distance * weight);

        // find suitable drone (the first one that's available & match required capacity from the list)
        List<Drone> drones = droneService.findAll();

        Drone choosenDrone = helper.getSuitableDrone(drones, minimumCapacityRequired);

        if (choosenDrone != null) {
            Flight newFlight = new Flight();
            newFlight.setId(choosenDrone.getId());
            newFlight.setWeight(flight.getWeight());
            newFlight.setStartingPoint(flight.getStartingPoint());
            newFlight.setDestination(flight.getDestination());
            newFlight.setDroneId(choosenDrone.getId());
            changeDroneStatus(choosenDrone.getId(), choosenDrone.getName(), choosenDrone.getCapacity());
            System.out.println(commandFly(choosenDrone.getId()));
            return flightRepository.save(newFlight);

        } else {
            System.out.println("No drone available or match the capacity required.");
            return null;
        }
    }

    public Flight updateFLight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Drone> connectDrone() {
        String uri = "http://localhost:8082/dronora/drones";
        RestTemplate restTemplate = new RestTemplate();
        Drone[] result = restTemplate.getForObject(uri, Drone[].class);
        return Arrays.asList(result);
    };

    public void changeDroneStatus(Long id, String name, int capacity) {
        String uri = "http://localhost:8082/dronora/drones/" + id.toString();
        RestTemplate restTemplate = new RestTemplate();


        // Create a NewDroneRequest object with the desired status
        NewDroneRequest updatedDroneRequest = new NewDroneRequest(id, name, capacity, "UNAVAILABLE");
        System.out.println(updatedDroneRequest);
        // Make the PUT request
        restTemplate.put(uri, updatedDroneRequest);
        
    };

    public String commandFly(Long id) {
            String uri = "http://localhost:80" + id.toString() + "/device"; //+ id.toString();

            RestTemplate restTemplate = new RestTemplate();

            String response = restTemplate.getForObject(uri, String.class);
            return response;
    }

        public String deliver(Long id) {
                String uri = "http://localhost:80" + id.toString() + "/device/deliver"; //+ id.toString();

                RestTemplate restTemplate = new RestTemplate();

                String response = restTemplate.getForObject(uri, String.class);
                return response;
        }

    
    
}

