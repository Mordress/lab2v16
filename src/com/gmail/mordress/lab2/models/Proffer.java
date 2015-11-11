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
            if (!isPunctuationMark(input.charAt(i))) {
                buffer.append(input.charAt(i));
            } else {
                if (buffer.length() != 0) {
                    lexems.add(new Word(buffer.toString()));
                    buffer = new StringBuilder();
                }
                lexems.add(new PunctuationMark(input.charAt(i)));
            }
        }

    }

    public List<Lexem> getLexems() {
        return lexems;
    }

    public void setLexems(List<Lexem> lexems) {
        this.lexems = lexems;
    }

    public void updateLexem(int index, Lexem newLexem) {
        lexems.set(index, newLexem);
    }

    private boolean isPunctuationMark(char c) {
        return  (c == ',' || c == ';' || c == '!' || c == '?'
                || c == '-' || c == '>' || c == '<' || c == '='
                || c == '+' || c == ':' || c == '(' || c == ')'
                || c == '{' || c == '}' || c == '[' || c == ']' || c == ' ' || c == '.');
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lexem lexem : lexems) {
            builder.append(lexem);
        }
        return builder.toString();
    }
}
