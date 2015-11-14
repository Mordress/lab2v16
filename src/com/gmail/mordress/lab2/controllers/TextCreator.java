package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.models.Text;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TextCreator {

    private InputStreamReader reader;

    private List<String> listOfWords;

    private List<String> listOfProffers;

    public TextCreator(InputStreamReader reader) {
        this.reader = reader;
        listOfWords = new ArrayList<>();
        listOfProffers = new ArrayList<>();
    }

    public void createText() {
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split("\\s+");
            Collections.addAll(listOfWords, s);
        }

        try {
            scanner.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String temp = new String();
        for (String iter : listOfWords) {
            temp += " " + iter;
            if (temp.charAt(temp.length() - 1) == '.' || temp.charAt(temp.length() - 1) == '?' || temp.charAt(temp.length() - 1) == '!') {
                listOfProffers.add(temp.trim());
                temp = "";
            }
        }
        for (String s : listOfProffers) {
            Text.getInstance().addProffer(s);
        }
    }
}
