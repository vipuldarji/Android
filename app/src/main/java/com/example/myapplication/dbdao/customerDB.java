package com.example.myapplication.dbdao;

import android.content.Context;

import androidx.room.Room;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Customer.class, Payment.class, Song.class}, version = 1, exportSchema = false)
public abstract class customerDB<CustomerDAO> extends RoomDatabase{

    private static final String DB_NAME = "customer_db";
    private static customerDB instance;

    public static synchronized customerDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), customerDB.class, DB_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract PaymentDAO paymentDAO();
    public abstract SongDAO songDAO();

}
