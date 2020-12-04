package com.example.language;

public class Word {

    private String eng;
    private String hin;
    private  int img;
    private  int song;


    public Word(String input_eng, String input_hin, int input_img, int input_song) {
        eng = input_eng;
        hin = input_hin;
        img = input_img;
        song = input_song;
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

    public int getSong() {
        return song;
    }
}
