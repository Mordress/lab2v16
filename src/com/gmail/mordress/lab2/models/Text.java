package com.gmail.mordress.lab2.models;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private static Text instance;

    private List<Proffer> proffersList;

    private Text() {
        //TODO LOGIC HERE TO CREATE TEXT FROM FILE
        proffersList = new ArrayList<>();
    }

    public static Text getInstance() {
        if (instance == null) {
            instance = new Text();
        }
        return instance;
    }

    public List<Proffer> getProffersList() {
        return proffersList;
    }

    public void setProffersList(List<Proffer> proffersList) {
        this.proffersList = proffersList;
    }

    public void addProffer(String input) {
        proffersList.add(new Proffer(input));
    }

    public void printText() {

    }

}
