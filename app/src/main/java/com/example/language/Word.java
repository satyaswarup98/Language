package com.example.language;

public class Word {

    private String eng;
    private String hin;

    public Word(String input_eng, String input_hin) {
        eng = input_eng;
        hin = input_hin;
    }

    public String getEng() {
        return eng;
    }

    public String getHin() {
        return hin;
    }
}
