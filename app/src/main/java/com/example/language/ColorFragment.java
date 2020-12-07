package com.example.language;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorFragment extends Fragment {

    MediaPlayer mediaPlayer;
    ArrayList<Word> number;

    public ColorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview =  inflater.inflate(R.layout.word_list, container, false);

        number = new ArrayList<Word>();

        number.add(new Word("Red", "Laal", R.drawable.color_red,R.raw.red));
        number.add(new Word("Yellow", "Peela", R.drawable.color_mustard_yellow,R.raw.yellow));
        number.add(new Word("Green","Hara", R.drawable.color_green,R.raw.green));
        number.add(new Word("Blue","Neela", R.drawable.color_blue,R.raw.blue));
        number.add(new Word("Brown","Bhoora", R.drawable.color_brown,R.raw.brown));
        number.add(new Word("Grey","Dhoosar", R.drawable.color_gray,R.raw.grey));
        number.add(new Word("Black","Kaala", R.drawable.color_black,R.raw.black));
        number.add(new Word("White","Saphed", R.drawable.color_white,R.raw.white));

        WordAdapter list = new WordAdapter(getActivity(), number,R.color.category_colors);
        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = number.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(), currentWord.getSong());
                mediaPlayer.start();
            }
        });



        return rootview;
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}