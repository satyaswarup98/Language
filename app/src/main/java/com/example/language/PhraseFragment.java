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

public class PhraseFragment extends Fragment {

    MediaPlayer mediaPlayer;
    ArrayList<Word> number;

    public PhraseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.word_list, container, false);

        number = new ArrayList<Word>();

        number.add(new Word("Where are you going?", "Aap kahaan ja rahe hain?",R.raw.phrases_1));
        number.add(new Word("What is your name?", "Aapaka naam kya hai?", R.raw.phrases_2));
        number.add(new Word("My name is...", "Mera naam hai ...", R.raw.phrases_3));
        number.add(new Word("How are you feeling?","Aap kaisa mahasoos kar rahe hain?", R.raw.phrases_4));
        number.add(new Word("I'm feeling good.","Main achchha mahasoos kar raha hoon", R.raw.phrases_5));
        number.add(new Word("Are you coming?","Kya aap aa rahe hain?", R.raw.phrases_6));
        number.add(new Word("Yes, I'm coming.","Haan, main aa raha hoon", R.raw.phrases_7));
        number.add(new Word("I'm coming","Main aa raha hoon", R.raw.phrases_8));
        number.add(new Word("Let's go","Chalo chalen", R.raw.phrases_9));
        number.add(new Word("Come here","Yahaan aao",R.raw.phrases_10));

        WordAdapter list = new WordAdapter(getActivity(), number,R.color.category_phrases);
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