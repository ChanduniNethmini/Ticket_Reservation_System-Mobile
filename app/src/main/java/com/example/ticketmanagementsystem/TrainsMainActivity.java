package com.example.ticketmanagementsystem;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ticketmanagementsystem.data.api.ApiService;
import com.example.ticketmanagementsystem.data.models.Trains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TrainsMainActivity extends AppCompatActivity {
    private RecyclerView trainRecyclerView;
    private TrainAdapter trainAdapter;
    private Button searchButton;
    private Spinner startLocationSpinner, endLocationSpinner;
    private EditText dateEditText, seatsNumberEditText;
    private ProgressBar loadingProgressBar;
    private Button chooseDateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trains);

        trainRecyclerView = findViewById(R.id.trainRecyclerView);
        trainAdapter = new TrainAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        trainRecyclerView.setLayoutManager(layoutManager);
        trainRecyclerView.setAdapter(trainAdapter);

        searchButton = findViewById(R.id.trainSearch);
        startLocationSpinner = findViewById(R.id.trainStart);
        endLocationSpinner = findViewById(R.id.trainEnd);
        //dateEditText = findViewById(R.id.trainDate);
        seatsNumberEditText = findViewById(R.id.trainSeatsNumber);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        chooseDateButton = findViewById(R.id.chooseDateButton);

        chooseDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });


        List<String> stationList = Arrays.asList("Galle", "Weligama", "Matara", "Beliaththa");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stationList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        startLocationSpinner.setAdapter(spinnerAdapter);
        endLocationSpinner.setAdapter(spinnerAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });
    }
    private void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String selectedDate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                chooseDateButton.setText(selectedDate);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private void performSearch() {
        loadingProgressBar.setVisibility(View.VISIBLE);

        String startLocation = startLocationSpinner.getSelectedItem().toString();
        String endLocation = endLocationSpinner.getSelectedItem().toString();
        String date = chooseDateButton.getText().toString();
        String seatsNumber = seatsNumberEditText.getText().toString();

        if (startLocation.isEmpty() || endLocation.isEmpty() || date.isEmpty() || seatsNumber.isEmpty() || (startLocation == endLocation) ){
            Toast.makeText(TrainsMainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            loadingProgressBar.setVisibility(View.GONE);
            return;
        }
        Toast.makeText(TrainsMainActivity.this, "Searching Available Trains.....", Toast.LENGTH_LONG).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ead-backend-da0fe1e8ac2c.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Trains>> call = apiService.searchTrains(
                startLocation,
                endLocation,
                date,
                seatsNumber
        );

        call.enqueue(new Callback<ArrayList<Trains>>() {
            @Override
            public void onResponse(Call<ArrayList<Trains>> call, Response<ArrayList<Trains>> response) {
                loadingProgressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    ArrayList<Trains> trains = response.body();
                    trainAdapter.setTrainList(trains,seatsNumber);
                } else {
                    Toast.makeText(TrainsMainActivity.this, "No results found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Trains>> call, Throwable t) {
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(TrainsMainActivity.this, "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


