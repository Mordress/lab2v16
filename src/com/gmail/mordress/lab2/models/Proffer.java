package com.gmail.mordress.lab2.models;

import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.lexems.PunctuationMark;
import com.gmail.mordress.lab2.models.lexems.WhiteSpace;
import com.gmail.mordress.lab2.models.lexems.words.Email;
import com.gmail.mordress.lab2.models.lexems.Lexem;
import com.gmail.mordress.lab2.models.lexems.words.Word;
import com.gmail.mordress.lab2.models.lexems.words.Phone;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Proffer {

    private List<Lexem> lexems;

    public Proffer(String input) {
        lexems = new ArrayList<>();
        Pattern emailPat = Pattern.compile(Constants.emailPattern);
        Pattern phonePat = Pattern.compile(Constants.phonePattern);
        Pattern wordPat = Pattern.compile(Constants.wordPattern);
        Pattern markPat = Pattern.compile(Constants.markPattern);
        Pattern spacePat = Pattern.compile(Constants.whiteSpacePattern);

        while (!input.equals("")) {
            Matcher emailMatcher = emailPat.matcher(input);
            if (emailMatcher.find()) {
                String buffer = emailMatcher.group();
                lexems.add(new Email(buffer));
                input = input.substring(buffer.length());
                continue;
            }

            Matcher phoneMatcher = phonePat.matcher(input);
            if (phoneMatcher.find()) {
                String buffer = phoneMatcher.group();
                lexems.add(new Phone(buffer));
                input = input.substring(buffer.length());
                continue;
            }

            Matcher wordMatcher = wordPat.matcher(input);
            if (wordMatcher.find()) {
                String buffer = wordMatcher.group();
                lexems.add(new Word(buffer));
                input = input.substring(buffer.length());
                continue;
            }

            Matcher markMatcher = markPat.matcher(input);
            if (markMatcher.find()) {
                String buffer = markMatcher.group();
                lexems.add(new PunctuationMark(buffer));
                input = input.substring(buffer.length());
                continue;
            }

            Matcher spaceMatcher = spacePat.matcher(input);
            if (spaceMatcher.find()) {
                String buffer = spaceMatcher.group();
                lexems.add(new WhiteSpace(buffer));
                input = input.substring(buffer.length());
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lexem lexem : lexems) {
            builder.append(lexem);
        }
        return builder.toString();
    }
}
