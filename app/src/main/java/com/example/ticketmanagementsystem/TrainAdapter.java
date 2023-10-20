package com.example.ticketmanagementsystem;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ticketmanagementsystem.data.models.Trains;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.TrainViewHolder> {
    private ArrayList<Trains> trainList;
    private String countNum;

    public void setTrainList(ArrayList<Trains> trains,String count) {
        trainList = trains;
        countNum = count;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_item, parent, false);
        return new TrainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainViewHolder holder, int position) {
        Trains train = trainList.get(position);
        String count = countNum;


        holder.trainNameTextView.setText(train.getName());
        holder.trainStartTimeTextView.setText(train.getStartLocationArrivalTime());
        holder.trainLocationTextView.setText(train.getStartLocation());
        holder.trainDestinationTextView.setText(train.getDestination());
        holder.trainSeatCount.setText(train.getAvailableSeats());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReservationCreate.class);

                intent.putExtra("id", train.getId());
                intent.putExtra("name", train.getName());
                intent.putExtra("date", train.getDate());
                intent.putExtra("startTime", train.getStartLocationDepartureTime());
                intent.putExtra("startLocation", train.getStartLocation());
                intent.putExtra("destination", train.getDestination());
                intent.putExtra("passengerCount", count);
                intent.putExtra("trainClass", train.getTrainClass());
                intent.putExtra("price", train.getTicketPrice());

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainList != null ? trainList.size() : 0;
    }

    public static class TrainViewHolder extends RecyclerView.ViewHolder {
        TextView trainNameTextView;
        TextView trainStartTimeTextView;
        TextView trainLocationTextView;
        TextView trainDestinationTextView;
        TextView trainSeatCount;

        public TrainViewHolder(@NonNull View itemView) {
            super(itemView);
            trainNameTextView = itemView.findViewById(R.id.trainNameTextView);
            trainStartTimeTextView = itemView.findViewById(R.id.trainStartTimeTextView);
            trainLocationTextView = itemView.findViewById(R.id.trainLocationTextView);
            trainDestinationTextView = itemView.findViewById(R.id.trainDestinationTextView);
            trainSeatCount = itemView.findViewById(R.id.trainSeatCountTextView);
        }
    }
}

