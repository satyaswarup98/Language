package com.example.language;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ArrayList<Word> number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        number = new ArrayList<Word>();

        number.add(new Word("One", "ek", R.mipmap.ic_launcher,R.raw.song));
        number.add(new Word("Two", "do", R.mipmap.ic_launcher,R.raw.song));
        number.add(new Word("Three", "teen", R.mipmap.ic_launcher,R.raw.song));
        number.add(new Word("Four","char", R.mipmap.ic_launcher,R.raw.song));
        number.add(new Word("Five","panch", R.mipmap.ic_launcher,R.raw.song));

        WordAdapter list = new WordAdapter(this, number,R.color.teal_200);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = number.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, currentWord.getSong());
                mediaPlayer.start();
            }
        });
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}
