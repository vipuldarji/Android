package com.example.myapplication.dbdao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PaymentDAO {

    @Query("select * from payment")
    List<Payment> getPaymentList();
    @Insert
    void insertPayment(Payment ... payment);
    @Update
    void updatePayment(Payment ... payment);
    @Delete
    void deletePayment(Payment ... payment);
    @Query("DELETE FROM payment")
    public void deletePaymentTable();

}
