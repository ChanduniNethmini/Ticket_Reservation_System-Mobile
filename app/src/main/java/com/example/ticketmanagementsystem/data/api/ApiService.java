package com.example.ticketmanagementsystem.data.api;

import com.example.ticketmanagementsystem.data.models.Reservation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.Body;

public interface ApiService {

    @GET("api/reservations/getAll")
    Call<ArrayList<Reservation>> getAllReservations();

    // Assuming similar endpoints exist for other CRUD operations:
    @POST("api/reservations/add")
    Call<Reservation> createReservation(@Body Reservation reservation);

//    @PUT("reservations/update/{id}")
//    Call<Reservation> updateReservation(@Path("id") String id, @Body Reservation reservation);

//    @DELETE("reservations/delete/{id}")
//    Call<Void> deleteReservation(@Path("id") String id);
}
