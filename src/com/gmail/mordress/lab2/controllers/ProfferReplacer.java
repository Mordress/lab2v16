package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.models.Proffer;
import com.gmail.mordress.lab2.models.Text;
import com.gmail.mordress.lab2.models.lexems.words.Word;

public class ProfferReplacer {

    private int profferNumber;

    private int lengthOfWord;

    /*заменяемое предложение*/
    private Proffer replacedProffer;

    private String replacer;

    public ProfferReplacer(int profferNumber, String replacer, int lengthOfWord) {
        if (profferNumber < 0 || profferNumber > Text.getInstance().getProffersList().size()) {
            throw new IllegalArgumentException("Wrong number of proffer");
        }
        this.profferNumber = profferNumber;
        this.replacer = replacer;
        this.lengthOfWord = lengthOfWord;
        replacedProffer = Text.getInstance().getProfferByNumber(profferNumber);
    }

    public void replace() {
        for (int i = 0; i < replacedProffer.getLexems().size() ; i++) {
            if (replacedProffer.getLexems().get(i) instanceof Word
                    && (replacedProffer.getLexems().get(i)).getValue().length() == lengthOfWord) {
                replacedProffer.updateLexem(i, new Word(replacer));
            }
        }

        Text.getInstance().setProffer(replacedProffer, profferNumber);
    }

}
