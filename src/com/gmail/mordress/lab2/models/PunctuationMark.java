package com.gmail.mordress.lab2.models;

public class PunctuationMark extends Lexem{

    private Character mark;

    public PunctuationMark(Character mark) {
        this.mark = mark;
    }

    public Character getMark() {
        return mark;
    }

    public void setMark(Character mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark.toString();
    }
}
