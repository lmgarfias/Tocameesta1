package com.example.luisgarfias.tocameesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        TextView songName = findViewById(R.id.song_now_playing);
        TextView artistName = findViewById(R.id.artist_now_playing);

        String songPlaying = getIntent().getExtras().getString("uniqueString");

        //artistName.setText();
songName.setText(songPlaying);

    }
}
