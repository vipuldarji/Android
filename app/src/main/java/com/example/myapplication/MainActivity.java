package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.myapplication.dbdao.Song;
import com.example.myapplication.dbdao.SongDAO;
import com.example.myapplication.dbdao.customerDB;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songDB();

        Button button = (Button) findViewById(R.id.btnList);

        button.setOnClickListener(view -> {

            Intent intent = new Intent(this, SongMainActivity.class);
            startActivity(intent);
        });
    }

    public void songDB(){

        customerDB db = customerDB.getInstance(this);
        db.clearAllTables();

        SongDAO songDAO = db.songDAO();

        Song s1 =  new Song(1,"Subtle Things","“Subtle Thing” is a song recorded by American electronic duo Marian Hill. The song was released on February 9, 2018 as the lead single from the band’s second album. The song was written by both of the duo’s members, Samantha Gongol and Jeremy Lloyd, with production handled by the latter of the two. The song peaked at number 42 on the US Dance/Electronic Songs Chart.","59.95","subtlethings");
        Song s2 =  new Song(2,"Red Lips","Remix): youtu.be/qI1ondD4FGU\n" +
                "Available on iTunes: smarturl.it/RedLipsRemix\n" +
                "Spotify: smarturl.it/S_RedLipsRemix\n" +
                "Apple Music: smarturl.it/AM_RedLipsRemix\n" +
                "Listen on YouTube: youtu.be/6JECDSFWosY\n" +
                "Follow Skrillex:skrillex.com/\n","30.00","redlips");
        Song s3 =  new Song(3,"Saint Tropez","\"Saint-Tropez\" is a song by American rapper and singer Post Malone from his third studio album, Hollywood's Bleeding (2019).[1][2] Its name is taken from the French town of Saint-Tropez.[3] It was written by Post Malone, Frank Dukes, Jahaan Sweet, Billy Walsh, Nima Jahanbin, Paimon Jahanbin, and Louis Bell, with production handled by Frank Dukes, Jahaan Sweet, and Wallis Lane.\n" +
                "The song peaked at number 18 on the US Billboard Hot 100 songs chart.\n.","101.00","sainttropez");

        Song s4 =  new Song(4,"Better Now","\"Better Now\" is a song by American rapper and singer Post Malone from his second studio album, Beerbongs & Bentleys (2018). It was written by Post Malone, Billy Walsh, Louis Bell and Frank Dukes, with production handled by the latter two. The song was released to UK contemporary hit radio on May 25, 2018, and US contemporary hit radio on June 5, 2018, as the album's fifth and final single. ","50.00","betternow");

        Song s5 =  new Song(5,"Subtle Things","The music video takes place in a fantasy setting and uses massive CGI animation. The band performs atop a giant statue, which has a 'winged soldier' on top of it, which is similar-looking to the 'winged soldier' on the cover artwork of Linkin Park's Hybrid Theory album","19.95","intheend");

        songDAO.insertSong(s1,s2,s3,s4,s5);
        List<Song> songList = songDAO.getSongList();

        for (Song s : songList){

            Log.i("name",s.getSongName().toString());
            Log.i("desc",s.getSongDesc().toString());
            Log.i("price",s.getSongPrice().toString());
            Log.i("id",s.toString());

        }

    }

}