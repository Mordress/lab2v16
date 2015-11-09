package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.models.Proffer;
import com.gmail.mordress.lab2.models.Text;

import java.util.Iterator;

public abstract class Parser {

    public void parse(Text txt) {
        Iterator<Proffer> iterator = txt.getProffersList().iterator();
        while (iterator.hasNext()) {
            parseProffer(iterator.next());
        }
    }

    protected abstract void parseProffer(Proffer proffer);

}
