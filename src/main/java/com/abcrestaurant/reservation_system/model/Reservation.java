package com.abcrestaurant.reservation_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;
    private String customerName;
    private String customerEmail;
    private int partySize;
    private LocalDateTime reservationTime;
    private String specialRequests;

    // Constructors
    public Reservation() {}

    public Reservation(String customerName, String customerEmail, int partySize, LocalDateTime reservationTime, String specialRequests) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.partySize = partySize;
        this.reservationTime = reservationTime;
        this.specialRequests = specialRequests;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }
}
