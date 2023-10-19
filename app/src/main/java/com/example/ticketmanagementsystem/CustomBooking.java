package com.example.ticketmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticketmanagementsystem.data.models.Reservation;
import com.example.ticketmanagementsystem.data.models.ReservationBooked;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CustomBooking extends BaseAdapter {

    private int layout;
    private Context context;
    private ArrayList<ReservationBooked> modelArrayList;
    private ViewButtonClickListener viewButtonClickListener;

    public CustomBooking(int layout, Context context, ArrayList<ReservationBooked> modelArrayList) {
        this.layout = layout;
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface ViewButtonClickListener {
        void onViewButtonClick(int position);
    }

    public void setViewButtonClickListener(ViewButtonClickListener listener) {
        this.viewButtonClickListener = listener;
    }

    private class ViewHolder {
        TextView reservationDate, bookingDate, startLocation, destination, classType, departureTime, price, seatCount, status;
        Button buttonView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomBooking.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHolder.reservationDate = convertView.findViewById(R.id.reservationDate);
            viewHolder.bookingDate = convertView.findViewById(R.id.bookingDate);
            viewHolder.startLocation = convertView.findViewById(R.id.startLocation);
            viewHolder.destination = convertView.findViewById(R.id.destination);
            viewHolder.classType = convertView.findViewById(R.id.classType);
            viewHolder.departureTime = convertView.findViewById(R.id.depatureTime);
            viewHolder.price = convertView.findViewById(R.id.price);
            viewHolder.seatCount = convertView.findViewById(R.id.seatCount);
            viewHolder.status = convertView.findViewById(R.id.status);
            viewHolder.buttonView = convertView.findViewById(R.id.button6);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ReservationBooked model = modelArrayList.get(position);
        viewHolder.reservationDate.setText("Reservation Date:- " + model.getReservationDate() + "\n");
        viewHolder.bookingDate.setText("Booking Date:- " + model.getBookingDate() + "\n");
        viewHolder.startLocation.setText("From: " + model.getStartLocation() + "\n");
        viewHolder.destination.setText("To: " + model.getDestination() + "\n");
        viewHolder.classType.setText("Class: " + model.getTrainClass() + "\n");
        viewHolder.departureTime.setText("Time: " + model.getDepartureTime() + "\n");
        viewHolder.price.setText("Price:LKR. " + model.getPrice() + "\n");
        viewHolder.seatCount.setText("Seats:" + model.getSeatCount() + "\n");
        viewHolder.status.setText("Status: " + mapStatus(model.getStatus()) + "\n");


        Button viewButton = convertView.findViewById(R.id.button6);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ViewOneReservation.class);
                intent.putExtra("reservationModel", model);
                context.startActivity(intent);
            }
        });

        return convertView;
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
