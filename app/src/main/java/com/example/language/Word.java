package com.example.language;

public class Word {

    private String eng;
    private String hin;
    private  int img;

    public Word(String input_eng, String input_hin, int input_img) {
        eng = input_eng;
        hin = input_hin;
        img = input_img;
    }

    public String getEng() {
        return eng;
    }

    public String getHin() {
        return hin;
    }

    public int getImg() {
        return img;
    }
}
