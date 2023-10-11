package com.example.ticketmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ticketmanagementsystem.data.models.Reservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CustomBooking extends BaseAdapter {

    private int layout;
    private Context context;
    private ArrayList<Reservation> modelArrayList;

    public CustomBooking(int layout, Context context, ArrayList<Reservation> modelArrayList) {
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
    private class ViewHolder{
        TextView idtxt,titletxt, travelertxt, reservationDate, bookingDate, trainID, startLocation,destination, classType, depatureTime,price,seatCount,status;      ;
    }
    private String extractDate(Date date) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }
    private String extractTime(Date date) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());  // 24-hour format
        return sdf.format(date);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomBooking.ViewHolder viewHolder = new ViewHolder();
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(layout, null);

//        viewHolder.idtxt=convertView.findViewById(R.id.idtxt);
//        viewHolder.travelertxt=convertView.findViewById(R.id.travelertxt);
        viewHolder.reservationDate=convertView.findViewById(R.id.reservationDate);
        viewHolder.bookingDate=convertView.findViewById(R.id.bookingDate);
//        viewHolder.trainID=convertView.findViewById(R.id.trainID);
        viewHolder.startLocation=convertView.findViewById(R.id.startLocation);
        viewHolder.destination=convertView.findViewById(R.id.destination);
        viewHolder.classType=convertView.findViewById(R.id.classType);
        viewHolder.depatureTime=convertView.findViewById(R.id.depatureTime);
        viewHolder.price=convertView.findViewById(R.id.price);
        viewHolder.seatCount=convertView.findViewById(R.id.seatCount);
        viewHolder.status=convertView.findViewById(R.id.status);

        Reservation model=modelArrayList.get(position);
//        viewHolder.idtxt.setText("ID:- " +model.getid() + "\n");
//        viewHolder.travelertxt.setText("TravellerId:- "+model.getTravelerID());
//        viewHolder.trainID.setText("TrainId:-"+model.getTrainID()+"\n");
        viewHolder.reservationDate.setText("Reservation Date:- " + extractDate(model.getReservationDate()) + "\n");
        viewHolder.bookingDate.setText("Booking Date:- " + extractDate(model.getBookingDate()) + "\n");
        viewHolder.startLocation.setText("From: "+model.getStartLocation()+"\n");
        viewHolder.destination.setText("To: "+model.getDestination()+"\n");
        viewHolder.classType.setText("Class: "+model.getClassType()+"\n");
        viewHolder.depatureTime.setText("Time:  " + extractTime(model.getDepartureTime()) + "\n");
        viewHolder.price.setText("Price:LKR. "+model.getPrice()+"\n");
        viewHolder.seatCount.setText("Seats:"+model.getSeatCount()+"\n");
        viewHolder.status.setText("Status:-"+model.getStatus()+"\n");
        return convertView;
    }


}
