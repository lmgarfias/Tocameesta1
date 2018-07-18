package com.example.luisgarfias.tocameesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating the list of genres, Setting initial capacity to allocate for memory (only if known)
        final ArrayList<String> listOfGenres = new ArrayList<>(5);
        listOfGenres.add("BANDA");
        listOfGenres.add("MARIACHI");
        listOfGenres.add("ROCK");
        listOfGenres.add("RANCHERAS");
        listOfGenres.add("HIPHOP");

        /*Create an adapter for the main menu where all genres are shown*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfGenres);
        ListView genreListView = findViewById(R.id.genre_list);
        genreListView.setAdapter(adapter);
        genreListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                 @Override
                                                 public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {

                                                     //Store the genre as a String to be used as a filter of the general list of songs
                                                     String currentGenre = listOfGenres.get(index);
                                                     Intent mainToGenre = new Intent(MainActivity.this, ListOfSongs.class);

                                                     //Pass the Genre string selected
                                                     mainToGenre.putExtra("uniqueString", currentGenre);
                                                     startActivity(mainToGenre);

                                                 }
                                             }
        );

    }
}


