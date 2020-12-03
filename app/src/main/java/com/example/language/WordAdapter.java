package com.example.language;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView eng_tv = (TextView) listItemView.findViewById(R.id.eng_tv);

        eng_tv.setText(currentWord.getEng());

        TextView hin_tv = (TextView) listItemView.findViewById(R.id.hin_tv);

        hin_tv.setText(currentWord.getHin());

        return listItemView;
    }


}
