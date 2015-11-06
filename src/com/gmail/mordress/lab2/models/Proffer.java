package com.gmail.mordress.lab2.models;

import java.util.ArrayList;
import java.util.List;

public class Proffer {

    private List<String> lexems;

    public Proffer(String s) {
        lexems = new ArrayList<>();
        String[] offset = s.split("\\s");
        for (String iter : offset) {
            //TODO LOGIC HERE FOR CHECK WORDS AND MARKS
        }
    }

    public List<String> getLexems() {
        return lexems;
    }

    public void setLexems(List<String> lexems) {
        this.lexems = lexems;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
