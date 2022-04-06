package com.example.myapplication.dbdao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface CustomerDAO {
    @Query("select * from customer")
    List<Customer> getCustomerList();
    @Insert
    void insertCustomer(Customer ... customer);
    @Update
    void updateCustomer(Customer ... customer);
    @Delete
    void deleteCustomer(Customer ... customer);
    @Query("DELETE FROM customer")
    public void deleteCustomerTable();

}
