package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SongDetailsActivity extends AppCompatActivity {

    TextView name;
    TextView desc;
    TextView price;
    ImageView image;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        name = findViewById(R.id.songNametextView);
        desc = findViewById(R.id.songdesctextView);
        price = findViewById(R.id.pricetextView);
        image = findViewById(R.id.songImageView);

        Intent intent = getIntent();

        String nameStr= intent.getStringExtra("name");
        String descStr= intent.getStringExtra("desc");
        String priceStr= intent.getStringExtra("price");
        Integer imageInt = intent.getIntExtra("image",0);


        name.setText(nameStr);
        desc.setText(descStr);
        price.setText(priceStr);
        image.setImageResource(imageInt);

        button = (Button) findViewById(R.id.btnCheckout);

        button.setOnClickListener(view ->  {

            Log.i("button clicked",nameStr);

            Intent formIntent = new Intent(this,CheckoutFormActivity.class);

            formIntent.putExtra("nameStr",nameStr);
            formIntent.putExtra("priceStr",priceStr);

            startActivity(formIntent);

        });

    }
}