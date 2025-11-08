package com.example.TravelSathi.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., "STAY", "FLIGHT", "CAR"
    private Long itemId;
    private int numPersons;
    private double totalAmount;
    private LocalDate bookingDate;
    private String status; // e.g., "PENDING", "CONFIRMED", "FAILED"

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Booking() {}

    public Booking(String type, Long itemId, int numPersons, double totalAmount, LocalDate bookingDate, String status, User user) {
        this.type = type;
        this.itemId = itemId;
        this.numPersons = numPersons;
        this.totalAmount = totalAmount;
        this.bookingDate = bookingDate;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getNumPersons() {
        return numPersons;
    }

    public void setNumPersons(int numPersons) {
        this.numPersons = numPersons;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}