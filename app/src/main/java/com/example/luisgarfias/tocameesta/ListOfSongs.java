package com.example.luisgarfias.tocameesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListOfSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_songs);

        String selectedGenre = getIntent().getExtras().getString("uniqueString");

        Toast.makeText(ListOfSongs.this, selectedGenre, Toast.LENGTH_SHORT).show();

        final ArrayList<Song> listOfSongs = new ArrayList<>();

        // All HIPHOP songs
        listOfSongs.add(new Song("Puto", "Molotov", "", Song.Genre.HIPHOP));
        listOfSongs.add(new Song("Si Señor", "Control Machete", "", Song.Genre.HIPHOP));
        listOfSongs.add(new Song("Chúntaros Style", "El Gran Silencio", "", Song.Genre.HIPHOP));
        listOfSongs.add(new Song("Dormir Soñando", "El Gran Silencio", "", Song.Genre.HIPHOP));

        //ALL Rock songs
        listOfSongs.add(new Song("Afuera", "Caifanes", "", Song.Genre.ROCK));
        listOfSongs.add(new Song("Ingrata", "Café Tacvba", "", Song.Genre.ROCK));
        listOfSongs.add(new Song("Oye mi Amor", "Maná", "", Song.Genre.ROCK));
        listOfSongs.add(new Song("En la Ciudad de la Furia", "Soda Stereo", "", Song.Genre.ROCK));

        //All BANDA songs
        listOfSongs.add(new Song("Adiós Amor", "Christian Nodal", "", Song.Genre.BANDA));
        listOfSongs.add(new Song("Háblame de ti", "Banda Sinaloense MS", "", Song.Genre.BANDA));
        listOfSongs.add(new Song("Ya es muy tarde", "La Arrolladora Banda el Limón", "", Song.Genre.BANDA));
        listOfSongs.add(new Song("La Fea", "Banda El Recodo", "", Song.Genre.BANDA));

        // All Mariachi songs
        listOfSongs.add(new Song("Guadalajara", "Vicente Fernandez", "", Song.Genre.MARIACHI));
        listOfSongs.add(new Song("Huapango de Moncayo", "Mariachi Vargas de Tecalitlan", "", Song.Genre.MARIACHI));
        listOfSongs.add(new Song("Cielito Lindo ", "Mariachi Vargas de Tecalitlan", "", Song.Genre.MARIACHI));
        listOfSongs.add(new Song("Canción Mixteca", "Mariachi Vargas de Tecalitlan", "", Song.Genre.MARIACHI));

        // All Norteñas
        listOfSongs.add(new Song("Tragos Amargos", "Ramon Ayala y sus Bravos del Norte", "", Song.Genre.RANCHERAS));
        listOfSongs.add(new Song("La Chona", "Los Tucanes de Tijuana", "", Song.Genre.RANCHERAS));
        listOfSongs.add(new Song("Jefe de Jefes", "Los Tigres del Norte", "", Song.Genre.RANCHERAS));
        listOfSongs.add(new Song("Tragos Amargos", "Ramon Ayala y sus Bravos del Norte", "", Song.Genre.RANCHERAS));

/* Create a new list filtering the genre selected*/
        final ArrayList<Song> songsSelected = new ArrayList<>(4);

        for (int i = 0; i < listOfSongs.size(); i++) {

            if (listOfSongs.get(i).getmGenre().toString().contains(selectedGenre)) {
                songsSelected.add(listOfSongs.get(i));
            }
        }

        SongAdapter itemAdapter = new SongAdapter(this, songsSelected);
        ListView songListView = findViewById(R.id.list_of_songs);
        songListView.setAdapter(itemAdapter);
        // When Clicking on the song to be played

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {

                                            Song songToPlay = songsSelected.get(index);
                                            Intent genreToSong = new Intent(ListOfSongs.this, NowPlaying.class);

                                            //Pass the Song name string selected
                                            genreToSong.putExtra("uniqueString", songToPlay.getmSongName());
                                            startActivity(genreToSong);
                                        }
                                    }
        );

    }
}