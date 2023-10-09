package com.example.ticketmanagementsystem;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBHelperReservation extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "reservation.db";

    public DBHelperReservation(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
//        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    //insert code start here
//    private static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE " + Reservation.Pay.TABLE_NAME + " (" +
//                    Reservation.Pay._ID + " INTEGER PRIMARY KEY," +
//                    Reservation.Pay.COLUMN_1 + " TEXT," +
//                    Reservation.Pay.COLUMN_2 + " TEXT," +
//                    Reservation.Pay.COLUMN_3 + " TEXT," +
//                    Reservation.Pay.COLUMN_4 + " TEXT)";
//
//
//
//    private static final String SQL_DELETE_ENTRIES =
//            "DROP TABLE IF EXISTS " + Reservation.Pay.TABLE_NAME;
//
//
//    public long paymentAdd(String pickup, String destination, String date, String seat){
//        // Gets the data repository in write mode
//        SQLiteDatabase db = getWritableDatabase();
//
//        // Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//        values.put(Reservation.Pay.COLUMN_1, pickup);
//        values.put(Reservation.Pay.COLUMN_2, destination);
//        values.put(Reservation.Pay.COLUMN_3, date);
//        values.put(Reservation.Pay.COLUMN_4, seat);
//
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId = db.insert(Reservation.Pay.TABLE_NAME, null, values);
//
//        return newRowId;
//    }
//
//
//    //update code start here
//    public Boolean updatePayment(String pickup, String destination, String date, String seat){
//        SQLiteDatabase db = getWritableDatabase();
//
//        // New value for one column
//        //video eke meke cashholder name eka update nokrannai dala thiyenne
//        ContentValues values = new ContentValues();
//        values.put(Reservation.Pay.COLUMN_1, pickup);
//        values.put(Reservation.Pay.COLUMN_3, date);
//        values.put(Reservation.Pay.COLUMN_4, seat);
//
//        // Which row to update, based on the title
//        String selection = Reservation.Pay.COLUMN_2 + " LIKE ?";
//        String[] selectionArgs = { destination };
//
//        int count = db.update(
//                Reservation.Pay.TABLE_NAME,
//                values,
//                selection,
//                selectionArgs);
//
//        if(count>=1)
//        {
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//
//    //delete function
//    public void deletePay(String cashholderN){
//        SQLiteDatabase db = getWritableDatabase();
//        // Define 'where' part of query.
//        String selection = Reservation.Pay.COLUMN_2 + " LIKE ?";
//        // Specify arguments in placeholder order.
//        String[] selectionArgs = { cashholderN };
//        // Issue SQL statement.
//        int deletedRows = db.delete(Reservation.Pay.TABLE_NAME, selection, selectionArgs);
//    }
//
//    //retrive data
//    public ArrayList  readAllPayment(){
//        String cashholderN = "Ayesh";
//        SQLiteDatabase db =getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                BaseColumns._ID,
//                Reservation.Pay.COLUMN_1,
//                Reservation.Pay.COLUMN_2,
//                Reservation.Pay.COLUMN_3,
//                Reservation.Pay.COLUMN_4,
//        };
//
//        // Filter results WHERE "title" = 'My Title'
//        String selection = Reservation.Pay.COLUMN_2 + " = ?";
//        String[] selectionArgs = { cashholderN };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                Reservation.Pay.COLUMN_2 + " ASC";
//
//        Cursor cursor = db.query(
//                Reservation.Pay.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                null,
//                // The columns for the WHERE clause
//                null ,         // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                sortOrder               // The sort order
//        );
//
//        ArrayList  paydetails = new ArrayList<>();
//        while(cursor.moveToNext()) {
//            String paycustomer = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_2));
//            String paycardN = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_1));
//            String payExpire = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_3));
//            String payCvc = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_4));
//
//            paydetails.add(paycustomer);
//            paydetails.add(paycardN);
//            paydetails.add(payExpire);
//            paydetails.add(payCvc);
//        }
//        cursor.close();
//        return paydetails;
//    }
//
//
//    //search code start here
//    public List readAllPayment(String cashholderN){
//
//        SQLiteDatabase db =getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                BaseColumns._ID,
//                Reservation.Pay.COLUMN_1,
//                Reservation.Pay.COLUMN_2,
//                Reservation.Pay.COLUMN_3,
//                Reservation.Pay.COLUMN_4,
//        };
//
//        // Filter results WHERE "title" = 'My Title'
//        String selection = Reservation.Pay.COLUMN_2 + " LIKE ?";
//        String[] selectionArgs = { cashholderN };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                Reservation.Pay.COLUMN_2 + " ASC";
//
//        Cursor cursor = db.query(
//                Reservation.Pay.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                selection,
//                // The columns for the WHERE clause
//                selectionArgs ,         // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                sortOrder               // The sort order
//        );
//
//        ArrayList payInfo = new ArrayList<>();
//        while(cursor.moveToNext()) {
//
//            String cardN = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_1));
//            String paycusName = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_2));
//            String exp = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_3));
//            String cvc = cursor.getString(cursor.getColumnIndexOrThrow(Reservation.Pay.COLUMN_4));
//            payInfo.add(cardN);//0
//            payInfo.add(paycusName);//1 this index will use to get data of username (search eka implement kraddi oni wenwa)
//            payInfo.add(exp);//2
//            payInfo.add(cvc);//3
//        }
//        cursor.close();
//        return payInfo;
//    }



}