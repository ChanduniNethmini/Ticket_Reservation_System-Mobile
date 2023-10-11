package com.example.ticketmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ticketmanagementsystem.data.api.ApiService;
import com.example.ticketmanagementsystem.data.models.Reservation;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReservationCreate extends AppCompatActivity {
    private EditText editStartLocation;
    private EditText editDestination;
    private Button btnDatePicker;
    private EditText editPassengers;
    private Calendar calendar;
    private Button btnCreateReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_create);
        editStartLocation = findViewById(R.id.editStartLocation);
        editDestination = findViewById(R.id.editDestination);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        editPassengers = findViewById(R.id.editPassengers);
        btnCreateReservation = findViewById(R.id.btnCreateReservation);
        calendar = Calendar.getInstance();

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        btnCreateReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createReservation();
            }
        });
    }
    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ead-backend-da0fe1e8ac2c.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    private void createReservation() {
        String startLocation = editStartLocation.getText().toString();
        String destination = editDestination.getText().toString();
        String reservationDate = btnDatePicker.getText().toString();
        int seatCount = Integer.parseInt(editPassengers.getText().toString());

        // Create a Reservation object (add necessary fields)
        Reservation reservation = new Reservation(startLocation, destination, reservationDate, seatCount);

        // Make the API call using Retrofit
        getApiService().createReservation(reservation).enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(ReservationCreate.this, "Reservation Created Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReservationCreate.this, "Failed to Create Reservation", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                Toast.makeText(ReservationCreate.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Handle the selected date
                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        btnDatePicker.setText(selectedDate);
                    }
                }, year, month, day);

        datePickerDialog.show();
    }

    private static ApiService getApiService(){
      ApiService apiService = getRetrofit().create(ApiService.class);
      return apiService;
    }
}






