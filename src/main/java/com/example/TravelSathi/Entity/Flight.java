package com.example.TravelSathi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String route;
    private String fromLocation;
    private String toLocation;
    private String airline;
    private Double price;
    private String duration;
    private String departure;
    private String arrival;
    private Integer availableSeats;
    private String image;

    public Flight() {}

    public Flight(String route, String fromLocation, String toLocation, String airline, Double price,
                  String duration, String departure, String arrival, Integer availableSeats, String image) {
        this.route = route;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.airline = airline;
        this.price = price;
        this.duration = duration;
        this.departure = departure;
        this.arrival = arrival;
        this.availableSeats = availableSeats;
        this.image = image;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }

    public String getFromLocation() { return fromLocation; }
    public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }

    public String getToLocation() { return toLocation; }
    public void setToLocation(String toLocation) { this.toLocation = toLocation; }

    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getDeparture() { return departure; }
    public void setDeparture(String departure) { this.departure = departure; }

    public String getArrival() { return arrival; }
    public void setArrival(String arrival) { this.arrival = arrival; }

    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}