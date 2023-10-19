package com.example.ticketmanagementsystem.data.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Station implements Parcelable {
    private String stationName;
    private int stationCount;
    private String arrivalTime;
    private String departureTime;

    public Station(String stationName, int stationCount, String arrivalTime, String departureTime) {
        this.stationName = stationName;
        this.stationCount = stationCount;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    // Parcelable implementation
    protected Station(Parcel in) {
        stationName = in.readString();
        stationCount = in.readInt();
        arrivalTime = in.readString();
        departureTime = in.readString();
    }

    public static final Parcelable.Creator<Station> CREATOR = new Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
            return new Station(in);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(stationName);
        parcel.writeInt(stationCount);
        parcel.writeString(arrivalTime);
        parcel.writeString(departureTime);
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getStationCount() {
        return stationCount;
    }

    public void setStationCount(int stationCount) {
        this.stationCount = stationCount;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
