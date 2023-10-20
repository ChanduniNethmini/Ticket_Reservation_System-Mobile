package com.example.ticketmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ticketmanagementsystem.data.api.ApiService;
import com.example.ticketmanagementsystem.data.models.Reservation;
import com.example.ticketmanagementsystem.data.models.ReservationBooked;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Ongoing extends AppCompatActivity {

    private Button button;
    private ArrayList<ReservationBooked> modelArrayList;
    private ApiService myApi;
    private ListView lv;
    private String BaseUrl = "https://ead-backend-da0fe1e8ac2c.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ongoing);

        button = findViewById(R.id.button6);
        lv = findViewById(R.id.lv);
        modelArrayList = new ArrayList<>();

        CustomBooking customAdapter = new CustomBooking(R.layout.bookingsingleview, Ongoing.this, modelArrayList);
        lv.setAdapter(customAdapter);

        customAdapter.setViewButtonClickListener(new CustomBooking.ViewButtonClickListener() {
            @Override
            public void onViewButtonClick(int position) {
                ReservationBooked selectedReservation = modelArrayList.get(position);
                openEditReservationActivity(selectedReservation);
            }
        });

        displayRetrofitData();
    }

    private void displayRetrofitData() {
        Toast.makeText(Ongoing.this, "Bookings Loading.....", Toast.LENGTH_LONG).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ApiService.class);
        Call<ArrayList<ReservationBooked>> arrayListCall = myApi.getAllReservations();
        arrayListCall.enqueue(new Callback<ArrayList<ReservationBooked>>() {
            @Override
            public void onResponse(Call<ArrayList<ReservationBooked>> call, Response<ArrayList<ReservationBooked>> response) {
                if (response.body() != null) {
                    ArrayList<ReservationBooked> allReservations = response.body();
                    modelArrayList.clear();

                    Date currentDate = Calendar.getInstance().getTime();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String todayDate = dateFormat.format(currentDate);

                    for (ReservationBooked reservation : allReservations) {
                        if (reservation.getReservationDate().equals(todayDate)) {
                            modelArrayList.add(reservation);
                        }
                    }

                    CustomBooking customAdapter = new CustomBooking(R.layout.bookingsingleview, Ongoing.this, modelArrayList);
                    lv.setAdapter(customAdapter);
                    Toast.makeText(Ongoing.this, "No Ongoing Reservations", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Ongoing.this, "No Ongoing Reservations", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ReservationBooked>> call, Throwable t) {
                Toast.makeText(Ongoing.this, "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void openEditReservationActivity(ReservationBooked reservation) {
        Intent intent = new Intent(Ongoing.this, EditReservation.class);
        startActivity(intent);
    }

}
