package com.example.ticketmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ticketmanagementsystem.data.api.ApiService;
import com.example.ticketmanagementsystem.data.models.Reservation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DisplayBookings extends AppCompatActivity {
    private Button button;
    private ArrayList<Reservation> modelArrayList;
    private ApiService myApi;
    private ListView lv;
    private String BaseUrl="https://ead-backend-da0fe1e8ac2c.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_display_bookings);
        button = (Button) findViewById(R.id.button6);
        lv = findViewById(R.id.lv);
        modelArrayList = new ArrayList<>();

        displayRetrofitData();
    }

    private void displayRetrofitData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi=retrofit.create( ApiService.class );
        Call<ArrayList<Reservation>> arrayListCall=myApi.getAllReservations();
        arrayListCall.enqueue (new Callback<ArrayList<Reservation>>() {
            @Override
            public void onResponse(Call<ArrayList<Reservation>> call, Response<ArrayList<Reservation>> response) {
                if (response.body() != null) {
                    modelArrayList = response.body();
                    CustomBooking custom = new CustomBooking(R.layout.bookingsingleview, DisplayBookings.this, modelArrayList);
                    lv.setAdapter(custom);
                } else {
                    Toast.makeText(DisplayBookings.this, "Response body is empty", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Reservation>> call, Throwable t) {
                Toast.makeText(DisplayBookings.this, "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
