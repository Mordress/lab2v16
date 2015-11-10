package com.gmail.mordress.lab2.models;

import java.util.ArrayList;
import java.util.List;

public class Proffer {

    private List<Lexem> lexems;

    public Proffer(String input) {
        lexems = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        input = input.trim();
        for (int i = 0; i < input.length() ; i++) {
            if (isPunctuationMark(input.charAt(i))) {
                lexems.add(new PunctuationMark(input.charAt(i)));
            } else if (input.charAt(i) == ' ') {
                lexems.add(new Word(buffer.toString()));
                lexems.add(new WhiteSpace());
            } else {
                buffer.append(input.charAt(i));
            }
        }
    }

    public List<Lexem> getLexems() {
        return lexems;
    }

    public void setLexems(List<Lexem> lexems) {
        this.lexems = lexems;
    }

    private boolean isPunctuationMark(char c) {
        return  (c == ',' || c == ';' || c == '!' || c == '?'
                || c == '-' || c == '>' || c == '<' || c == '='
                || c == '+' || c == ':');
    }

}
