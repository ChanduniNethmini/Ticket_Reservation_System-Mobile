package com.example.ticketmanagementsystem.data.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ReservationBooked implements Parcelable {
    private String id;
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

    public ReservationBooked(String id, String nic, String reservationDate, String bookingDate, String trainID, String trainName, String startLocation, String destination, String trainClass, String departureTime, String price, String seatCount, String status) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nic);
        dest.writeString(reservationDate);
        dest.writeString(bookingDate);
        dest.writeString(trainID);
        dest.writeString(trainName);
        dest.writeString(startLocation);
        dest.writeString(destination);
        dest.writeString(trainClass);
        dest.writeString(departureTime);
        dest.writeString(price);
        dest.writeString(seatCount);
        dest.writeString(status);
    }

    public static final Parcelable.Creator<ReservationBooked> CREATOR = new Parcelable.Creator<ReservationBooked>() {
        public ReservationBooked createFromParcel(Parcel in) {
            return new ReservationBooked(in);
        }

        public ReservationBooked[] newArray(int size) {
            return new ReservationBooked[size];
        }
    };

    private ReservationBooked(Parcel in) {
        id = in.readString();
        nic = in.readString();
        reservationDate = in.readString();
        bookingDate = in.readString();
        trainID = in.readString();
        trainName = in.readString();
        startLocation = in.readString();
        destination = in.readString();
        trainClass = in.readString();
        departureTime = in.readString();
        price = in.readString();
        seatCount = in.readString();
        status = in.readString();
    }

}
