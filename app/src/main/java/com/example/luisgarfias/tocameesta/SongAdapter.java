package com.example.luisgarfias.tocameesta;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luisgarfias on 7/14/18.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Song currentSong = getItem(position);
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_property, parent, false);
        }
        TextView songName = (TextView) listItemView.findViewById(R.id.song_name_textview);
        songName.setText(currentSong.getmSongName());

        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name_textview);
        artistName.setText(currentSong.getmArtistName());

        return listItemView;
    }
}
