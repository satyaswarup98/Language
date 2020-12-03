package com.example.language;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

//        LinearLayout myLin   = (LinearLayout) findViewById(R.id.mylayout);

        ArrayList<Word> number = new ArrayList<Word>();

        number.add(new Word("One", "ek"));
        number.add(new Word("Two", "do"));
        number.add(new Word("Three", "teen"));
        number.add(new Word("Four","char"));
        number.add(new Word("Five","panch"));

        WordAdapter list = new WordAdapter(this, number);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
