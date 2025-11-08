package com.example.TravelSathi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String duration;
    private String availability;
    private Integer seats;
    private String transmission;
    private Double rating;
    private String image;

    public Car() {}

    public Car(String name, Double price, String duration, String availability, Integer seats,
               String transmission, Double rating, String image) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.availability = availability;
        this.seats = seats;
        this.transmission = transmission;
        this.rating = rating;
        this.image = image;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public Integer getSeats() { return seats; }
    public void setSeats(Integer seats) { this.seats = seats; }

    public String getTransmission() { return transmission; }
    public void setTransmission(String transmission) { this.transmission = transmission; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}