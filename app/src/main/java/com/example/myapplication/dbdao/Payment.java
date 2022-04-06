package com.example.myapplication.dbdao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment")
public class Payment {

    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="payment_id")
    private int paymentId;

    @ColumnInfo(name="card_number")
    private String cardNumber;

    @ColumnInfo(name="cvv")
    private String cvv;

    @ColumnInfo(name="card_name")
    private String cardName;


    public Payment() {
    }


    public Payment(int paymentId, String cardNumber, String cvv, String cardName) {
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardName = cardName;
    }


    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    //@NonNull
    @Override
    public String toString() {


        return "Payment{" +
                "paymentId=" + paymentId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
