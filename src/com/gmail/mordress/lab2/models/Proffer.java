package com.gmail.mordress.lab2.models;

import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.emails.Email;
import com.gmail.mordress.lab2.models.phones.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Proffer {

    private List<Lexem> lexems;

    private List<Email> emails;

    private List<Phone> phones;

    public Proffer(String input) {
        if (input.matches(Constants.emailPattern)) {
            emails = new ArrayList<>();
            Pattern pattern = Pattern.compile(Constants.emailPattern);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                emails.add(new Email(matcher.group()));
            }
            for (Email e : emails) {
                input = input.replace(e.getWord(), Constants.emailToken);
            }
        }
        if (input.matches(Constants.phonePattern)) {
            phones = new ArrayList<>();
            Pattern pattern = Pattern.compile(Constants.phonePattern);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                phones.add(new Phone(matcher.group()));
            }
            for (Phone p : phones) {
                input = input.replace(p.getWord(), Constants.phoneToken);
            }
        }

        lexems = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        //input = input.trim();
        for (int i = 0; i < input.length() ; i++) {
            if (isPunctuationMark(input.charAt(i)) || (input.charAt(i) == '.' && i == input.length() - 1)) {
                if (buffer.length() != 0) {
                    lexems.add(new Word(buffer.toString()));
                    buffer = new StringBuilder();
                }
                lexems.add(new PunctuationMark(input.charAt(i)));
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

    public void updateLexem(int index, Lexem newLexem) {
        lexems.set(index, newLexem);
    }

    private boolean isPunctuationMark(char c) {
        return  (c == ',' || c == ';' || c == '!' || c == '?'
                || c == '-' || c == '>' || c == '<' || c == '='
                || c == '+' || c == ':' || c == '(' || c == ')'
                || c == '{' || c == '}' || c == '[' || c == ']' || c == ' ');
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lexem lexem : lexems) {
            builder.append(lexem);
        }
        return builder.toString();
    }

    public void debug() {
        for (Lexem lexem : lexems) {
            System.out.println(lexem + " - " + lexem.getClass());
            System.out.println();
        }
    }
}
