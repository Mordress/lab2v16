package com.gmail.mordress.lab2.models;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private static Text instance;

    private List<Proffer> proffersList;

    private Text() {
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
        for (Proffer proffer : proffersList) {
            System.out.println(proffer);
        }
    }

    public Proffer getProfferByNumber(int number) {
        if (number < 0 || number > proffersList.size()) {
            return new Proffer("wrong index of proffers");
        }
        return proffersList.get(number);
    }

    public void setProffer(Proffer proffer, int number) {
        if (number >= 0 && number < proffersList.size()) {
            proffersList.set(number, proffer);
        }

    }

    public int getCountOfProffers() {
        return proffersList.size();
    }

}
