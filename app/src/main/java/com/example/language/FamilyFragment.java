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

public class FamilyFragment extends Fragment {
    MediaPlayer mediaPlayer;
    ArrayList<Word> number;

    public FamilyFragment() {
        // Required empty public constructor
    }

    //change
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.word_list, container, false);

        number = new ArrayList<Word>();

        number.add(new Word("Father", "Pita Jee", R.drawable.family_father,R.raw.song));
        number.add(new Word("Mother", "Maan", R.drawable.family_mother,R.raw.song));
        number.add(new Word("Son", "Beta", R.drawable.family_son,R.raw.song));
        number.add(new Word("Older Brother", "Bada Bhaee", R.drawable.family_older_brother,R.raw.song));
        number.add(new Word("Younger Brother", "Chota Bhaee", R.drawable.family_younger_brother,R.raw.song));
        number.add(new Word("Older Sister","Badee Bahan", R.drawable.family_older_sister,R.raw.song));
        number.add(new Word("Younger Sister","Chotee Bahan", R.drawable.family_younger_sister,R.raw.song));
        number.add(new Word("Grandfather","Daada", R.drawable.family_grandfather,R.raw.song));
        number.add(new Word("Grandmother","Daadee Ma", R.drawable.family_grandmother,R.raw.song));

        WordAdapter list = new WordAdapter(getActivity(), number,R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
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

        return rootView;
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}
