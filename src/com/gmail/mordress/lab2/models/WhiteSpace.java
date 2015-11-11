package com.gmail.mordress.lab2.models;

public class WhiteSpace extends Lexem {

    private final String space = " ";

    public String getSpace() {
        return space;
    }

    @Override
    public String toString() {
        return space.toString();
    }
}
