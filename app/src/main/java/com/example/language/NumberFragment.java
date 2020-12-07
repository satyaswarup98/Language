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

public class NumberFragment extends Fragment {
    MediaPlayer mediaPlayer;
    ArrayList<Word> number;

    public NumberFragment() {
        // Required empty public constructor
    }

    //change
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        //change
        View rootView =  inflater.inflate(R.layout.word_list, container, false);

        number = new ArrayList<Word>();
        number.add(new Word("One", "Ek", R.drawable.number_one,R.raw.one));
        number.add(new Word("Two", "Do", R.drawable.number_two,R.raw.two));
        number.add(new Word("Three", "Teen", R.drawable.number_three,R.raw.three));
        number.add(new Word("Four","Chaar", R.drawable.number_four,R.raw.four));
        number.add(new Word("Five","Paanch", R.drawable.number_five,R.raw.five));
        number.add(new Word("Six","Chhah", R.drawable.number_six,R.raw.six));
        number.add(new Word("Seven","Saat", R.drawable.number_seven,R.raw.seven));
        number.add(new Word("Eight","Aath", R.drawable.number_eight,R.raw.eight));
        number.add(new Word("Nine","Nau", R.drawable.number_nine,R.raw.nine));
        number.add(new Word("Ten","Dus", R.drawable.number_ten,R.raw.ten));

        WordAdapter list = new WordAdapter(getActivity(), number,R.color.category_numbers);
        //change
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = number.get(position);
                releaseMediaPlayer();
                //change
                mediaPlayer = MediaPlayer.create(getActivity(), currentWord.getSong());
                mediaPlayer.start();
            }
        });

        return rootView;
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}