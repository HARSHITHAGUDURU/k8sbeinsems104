package com.example.TravelSathi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stay")
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Double rating;
    private Double price;
    private String image;

    public Stay() {}

    public Stay(String name, String location, Double rating, Double price, String image) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}