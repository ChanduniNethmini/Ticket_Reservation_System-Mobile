package com.example.ticketmanagementsystem.data.api;

import com.example.ticketmanagementsystem.data.models.Reservation;
import com.example.ticketmanagementsystem.data.models.ReservationBooked;
import com.example.ticketmanagementsystem.data.models.Trains;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/trains/getAll")
    Call<ArrayList<Trains>> getAllTrains();

    @GET("api/reservations/getAll")
    Call<ArrayList<ReservationBooked>> getAllReservations();

    @POST("api/reservations/add")
    Call<Reservation> createReservation(@Body Reservation reservation);

    @PUT("api/reservations/update/{id}")
    Call<ReservationBooked> updateReservation(@Path("id") String id, @Body ReservationBooked reservation);

    @DELETE("api/reservations/cancel/{id}")
    Call<Void> deleteReservation(@Path("id") String id);

    @GET("api/trains/search")
    Call<ArrayList<Trains>> searchTrains(
            @Query("fromStationName") String fromStationName,
            @Query("toStationName") String toStationName,
            @Query("date") String date,
            @Query("minAvailableSeatCount") String minAvailableSeatCount
    );
}
