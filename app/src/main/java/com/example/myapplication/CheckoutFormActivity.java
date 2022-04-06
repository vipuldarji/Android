package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutFormActivity extends AppCompatActivity {

    TextView songName;
    TextView songPrice;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_form);

        songName = findViewById(R.id.editTextTextPersonName2);

        songPrice = findViewById(R.id.editTextTextPersonName3);

        button = findViewById(R.id.btnSubmit);

        Intent intent = getIntent();

        String name= intent.getStringExtra("nameStr");
        Log.i("songName",name);
        String price= intent.getStringExtra("priceStr");

        //String imageInt = intent.getStringExtra("image");


        songName.setText(name);
        songPrice.setText(price);

        button.setOnClickListener(view -> {

            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Confirmation Box")
                    .setMessage("Continue to place your order Or hit cancel to cancel")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(CheckoutFormActivity.this, "Your order is confirmed", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(CheckoutFormActivity.this,MainActivity.class);
                            startActivity(mainIntent);

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {

                            Toast.makeText(CheckoutFormActivity.this, "Re-Select your song", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .show();

        });
    }
}