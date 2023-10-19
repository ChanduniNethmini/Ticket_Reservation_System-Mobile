package com.example.ticketmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticketmanagementsystem.data.api.ApiService;
import com.example.ticketmanagementsystem.data.models.Reservation;
import com.example.ticketmanagementsystem.data.models.ReservationBooked;

public class ViewOneReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_one_reservation);

        ReservationBooked model = getIntent().getParcelableExtra("reservationModel");

        TextView startLocationEditText = findViewById(R.id.tvStartLocation);
        TextView destinationEditText = findViewById(R.id.tvDestination);
        TextView passengersEditText = findViewById(R.id.tvStatus);
        TextView timeEditText = findViewById(R.id.tvDateTime);
        EditText countEditText = findViewById(R.id.tvSeatCount);

        startLocationEditText.setText(model.getStartLocation());
        destinationEditText.setText(model.getDestination());

        passengersEditText.setText(mapStatus("0"));
        timeEditText.setText(model.getReservationDate() + " " + model.getDepartureTime());
        countEditText.setText(model.getSeatCount());

        Button updateButton = findViewById(R.id.button);
        Button deleteButton = findViewById(R.id.button3);

        ReservationBooked reservation = new ReservationBooked(
                model.getId(),
                model.getNic(),
                model.getReservationDate(),
                model.getBookingDate(),
                model.getTrainID(),
                model.getTrainName(),
                model.getStartLocation(),
                model.getDestination(),
                model.getTrainClass(),
                model.getDepartureTime(),
                model.getPrice(),
                model.getSeatCount(),
                model.getStatus()
        );
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reservation.setSeatCount(countEditText.getText().toString());
                Log.d("aaa",reservation.getTrainName());
                if (model.getStatus().equals("0")) {
                    updateReservation(model.getId(), reservation);
                } else {
                    Toast.makeText(ViewOneReservation.this, "Editing is not allowed for this reservation.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteReservation(model.getId());
            }
        });
    }

    private void updateReservation(String id, ReservationBooked newReservation) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ead-backend-da0fe1e8ac2c.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ReservationBooked> call = apiService.updateReservation(id, newReservation);
        call.enqueue(new Callback<ReservationBooked>() {
            @Override
            public void onResponse(Call<ReservationBooked> call, Response<ReservationBooked> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ViewOneReservation.this, "Reservation Created Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ViewOneReservation.this, "Reservation create Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReservationBooked> call, Throwable t) {
                //Log.d("message", "===================" + t.getMessage());
                //Toast.makeText(ViewOneReservation.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ViewOneReservation.this, "Reservation Updated Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewOneReservation.this, Dashboard.class);
                startActivity(intent);
            }
        }, 2000);

    }

    private void deleteReservation(String id) {
        String reservationId = id;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ead-backend-da0fe1e8ac2c.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Void> call = apiService.deleteReservation(reservationId);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("ss","++++++++"+response.code());
                if (response.isSuccessful()) {

                    Toast.makeText(ViewOneReservation.this, "Reservation has Cancelled", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ViewOneReservation.this, Dashboard.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ViewOneReservation.this, "Failed to Cancel reservation", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ViewOneReservation.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String mapStatus(String statusCode) {
        switch (statusCode) {
            case "0":
                return "Booked";
            case "1":
                return "Confirmed";
            case "2":
                return "Completed";
            case "3":
                return "Cancelled";
            default:
                return "Unknown";
        }
    }
}