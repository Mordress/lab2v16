package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.models.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextCreator {

    private File txtFile;

    private List<String> listOfWords;

    private List<String> listOfProffers;




    public TextCreator(File txtFile) {
        this.txtFile = txtFile;
        listOfWords = new ArrayList<>();
        listOfProffers = new ArrayList<>();
    }

    public void createText() throws FileNotFoundException {
        Scanner scanner = new Scanner(txtFile);
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split("\\s+");
            for (String iter : s) {
                listOfWords.add(iter);
            }
        }
        scanner.close();

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
