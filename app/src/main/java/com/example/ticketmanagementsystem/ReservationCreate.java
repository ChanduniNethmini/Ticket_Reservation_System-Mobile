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

import java.util.Calendar;

public class ReservationCreate extends AppCompatActivity {
    private EditText editStartLocation;
    private EditText editDestination;
    private Button btnDatePicker;
    private EditText editPassengers;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_create);
        editStartLocation = findViewById(R.id.editStartLocation);
        editDestination = findViewById(R.id.editDestination);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        editPassengers = findViewById(R.id.editPassengers);
        calendar = Calendar.getInstance();

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
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
}






