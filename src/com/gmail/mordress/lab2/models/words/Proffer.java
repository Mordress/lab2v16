package com.gmail.mordress.lab2.models.words;

import java.util.ArrayList;
import java.util.List;

public class Proffer {

    private String proffer;

    public Proffer(String s) {
        proffer = s;
    }

    public String getProffer() {
        return proffer;
    }

    public void setProffer(String proffer) {
        this.proffer = proffer;
    }

    @Override
    public String toString() {
        return proffer;
    }
}
