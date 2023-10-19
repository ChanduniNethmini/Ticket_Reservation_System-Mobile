package com.example.ticketmanagementsystem.data.models;

public class Reservation {
    private String nic;
    private String reservationDate;
    private String bookingDate;
    private String trainID;
    private String trainName;
    private String startLocation;
    private String destination;
    private String trainClass;
    private String departureTime;
    private String price;
    private String seatCount;
    private String status;


    public Reservation(String nic, String reservationDate, String bookingDate, String trainID,String trainName, String startLocation,
                       String destination, String trainClass, String departureTime, String price, String seatCount, String status) {
        this.nic = nic;
        this.reservationDate = reservationDate;
        this.bookingDate = bookingDate;
        this.trainID = trainID;
        this.trainName = trainName;
        this.startLocation = startLocation;
        this.destination = destination;
        this.trainClass = trainClass;
        this.departureTime = departureTime;
        this.price = price;
        this.seatCount = seatCount;
        this.status = status;
    }


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
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

    public String getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
