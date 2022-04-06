package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.dbdao.Song;
import com.example.myapplication.dbdao.SongDAO;
import com.example.myapplication.dbdao.customerDB;

import java.util.ArrayList;
import java.util.List;

public class SongMainActivity extends AppCompatActivity implements SongListenerInterface {


    private RecyclerView recyclerView;
    private List<String> name;
    private List<Integer> image;
    private SongListAdapter songListAdapter;
    private List<Integer> id;
    private List<String> price;
    private List<String> desc;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_main);

        recyclerView =  findViewById(R.id.recyclerView);
        button = (Button) findViewById(R.id.sngDetails);

        name = new ArrayList<>();
        image = new ArrayList<>();
        id = new ArrayList<>();
        price = new ArrayList<>();
        desc = new ArrayList<>();

        customerDB db = customerDB.getInstance(this);

        SongDAO songDAO = db.songDAO();

        List<Song> songList = songDAO.getSongList();

        for (Song s: songList){

            name.add(s.getSongName());

            desc.add(s.getSongDesc());
            price.add(s.getSongPrice());

            String imageName = s.getSongImage();

            int imageId = getResources().getIdentifier(imageName,"drawable",getPackageName());

            image.add(imageId);
        }

        songListAdapter = new SongListAdapter(this,name,id,image, price, desc);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(songListAdapter);

    }

    @Override
    public void onSongSelected(String name,String desc,String price, Integer image) {

        Intent detailsIntent = new Intent(this,SongDetailsActivity.class);

        detailsIntent.putExtra("name",name);
        detailsIntent.putExtra("desc",desc);
        detailsIntent.putExtra("price",price);
        //detailsIntent.putExtra("image",image);
        detailsIntent.putExtra("image",image);
        startActivity(detailsIntent);

    }
}