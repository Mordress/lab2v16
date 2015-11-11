package com.gmail.mordress.lab2.models;

import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.emails.Email;
import com.gmail.mordress.lab2.models.phones.Phone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Proffer {

    private List<Lexem> lexems;

    private List<Email> emails;

    private List<Phone> phones;

    public Proffer(String input) {
        Pattern patternEmail = Pattern.compile(Constants.emailPattern);
        Matcher matcherEmail = patternEmail.matcher(input);
        emails = new ArrayList<>();
        while (matcherEmail.find()) {
            emails.add(new Email(matcherEmail.group()));
        }
        for (Email e : emails) {
            input = input.replace(e.toString(), Constants.emailToken);
        }
        Pattern patternPhone = Pattern.compile(Constants.phonePattern);
        Matcher matcherPhone = patternPhone.matcher(input);
        phones = new ArrayList<>();
        while (matcherPhone.find()) {
            phones.add(new Phone(matcherPhone.group()));
        }
        for (Phone p : phones) {
            input = input.replace(p.toString(), Constants.phoneToken);
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



        for (int i = 0, j = 0; i < lexems.size() ; i++) {
            if (j <= emails.size()) {
                if (lexems.get(i) instanceof Word && ((Word) lexems.get(i)).getWord().equals(Constants.emailToken)) {
                    lexems.set(i, emails.get(j++));
                }
            }
        }
        for (int i = 0, j = 0; i < lexems.size() ; i++) {
            if (j <= phones.size()) {
                if (lexems.get(i) instanceof Word && ((Word) lexems.get(i)).getWord().equals(Constants.phoneToken)) {
                    lexems.set(i, phones.get(j++));
                }
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
                || c == '{' || c == '}' || c == '[' || c == ']' || c == ' ' || c == '…');
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
            //System.out.println("email.length = " + emails.size());
            //System.out.println("phone.length = " + phones.size());
        }
    }
}
