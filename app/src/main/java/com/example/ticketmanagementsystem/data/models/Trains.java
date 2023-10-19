package com.example.ticketmanagementsystem.data.models;

import com.google.gson.annotations.SerializedName;

public class Trains {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("date")
    private String date;

    @SerializedName("trainClass")
    private String trainClass;

    @SerializedName("startLocation")
    private String startLocation;

    @SerializedName("destination")
    private String destination;

    @SerializedName("availableSeats")
    private String availableSeats;

    @SerializedName("ticketPrice")
    private String ticketPrice;

    @SerializedName("totalPrice")
    private String totalPrice;

    @SerializedName("startLocationArrivalTime")
    private String startLocationArrivalTime;

    @SerializedName("startLocationDepartureTime")
    private String startLocationDepartureTime;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStartLocationArrivalTime(String startLocationArrivalTime) {
        this.startLocationArrivalTime = startLocationArrivalTime;
    }

    public void setStartLocationDepartureTime(String startLocationDepartureTime) {
        this.startLocationDepartureTime = startLocationDepartureTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTrainClass() {
        return trainClass;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getStartLocationArrivalTime() {
        return startLocationArrivalTime;
    }

    public String getStartLocationDepartureTime() {
        return startLocationDepartureTime;
    }
}
