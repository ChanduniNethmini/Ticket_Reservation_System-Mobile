package com.example.ticketmanagementsystem.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Reservation {
    @SerializedName("id")
    private String id;
    @SerializedName("travelerID")
    private int travelerID;
    @SerializedName("reservationDate")
    private Date reservationDate;
    @SerializedName("bookingDate")
    private Date bookingDate;
    @SerializedName("trainID")
    private String trainID;
    @SerializedName("startLocation")
    private String startLocation;
    @SerializedName("destination")
    private String destination;
    @SerializedName("classType")
    private String classType;
    @SerializedName("departureTime")
    private Date departureTime;
    @SerializedName("price")
    private float price;
    @SerializedName("seatCount")
    private int seatCount;
    @SerializedName("status")
    private int status;

    public Reservation(String id, String trainID, String startLocation, float price) {
        this.id = id;
        this.travelerID = travelerID;
        this.reservationDate = reservationDate;
        this.bookingDate = bookingDate;
        this.trainID = trainID;
        this.startLocation = startLocation;
        this.destination = destination;
        this.classType = classType;
        this.departureTime = departureTime;
        this.price = price;
        this.seatCount = seatCount;
        this.status = status;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public int getTravelerID() {
        return travelerID;
    }

    public void setTravelerID(int travelerID) {
        this.travelerID = travelerID;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
