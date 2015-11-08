package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.models.Proffer;
import com.gmail.mordress.lab2.models.Text;

public class ProfferReplacer {

    private int profferNumber;

    private int lengthOfWord;

    private String replacedProffer;

    private String replacer;

    public ProfferReplacer(int profferNumber, String replacer, int lengthOfWord) {
        this.profferNumber = profferNumber;
        this.replacer = replacer;
        this.lengthOfWord = lengthOfWord;
        replacedProffer = Text.getInstance().getProfferByNumber(profferNumber).getProffer();
    }

    public void replace() {
        String[] words = replacedProffer.split("[!\\?\\,\"\'\\:\\-\\s]");

        for (String word : words) {
            if (word.length() == lengthOfWord) {
                replacedProffer = replacedProffer.replace(word, replacer);
            }
        }
        Text.getInstance().setProffer(new Proffer(replacedProffer), profferNumber);
    }

}
