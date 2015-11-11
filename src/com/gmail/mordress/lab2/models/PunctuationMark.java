package com.gmail.mordress.lab2.models;

public class PunctuationMark extends Lexem{

    private String mark;

    public PunctuationMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark.toString();
    }
}
