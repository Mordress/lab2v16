package com.gmail.mordress.lab2.models.lexems;

public abstract class Lexem {

    protected String value;

    public Lexem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
