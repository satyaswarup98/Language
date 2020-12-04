package com.example.language;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ArrayList<Word> number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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

        WordAdapter list = new WordAdapter(this, number,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = number.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, currentWord.getSong());
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
