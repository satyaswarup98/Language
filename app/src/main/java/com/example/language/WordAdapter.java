package com.example.language;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    int activityColor;

    public WordAdapter(Context context, ArrayList<Word> words, int input_color) {
        super(context, 0, words);
        activityColor = input_color;
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

        ImageView img_view = (ImageView) listItemView.findViewById(R.id.img_view);

        if(currentWord.hasImg()) {
            img_view.setImageResource(currentWord.getImg());
            img_view.setVisibility(View.VISIBLE);
        }else{
            img_view.setVisibility(View.GONE);
        }

        RelativeLayout back = (RelativeLayout) listItemView.findViewById(R.id.mycard);

        int color = ContextCompat.getColor(getContext(), activityColor);
        back.setBackgroundColor(color);

        return listItemView;
    }


}
