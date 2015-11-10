package com.gmail.mordress.lab2.helpers;


public abstract class Constants {

    public static final String emailPattern = "[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}";

    public static final String phonePattern = "8\\(\\d{3}\\)\\d{3}\\-\\d{2}\\-\\d{2}";

    public static final String wordsSplitPattern = "[!\\?\\,\"\'\\:\\-\\/\\;\\s+]+";

    /*String, which replace some strings in proffer*/
    public static final String wordReplacer = "=)";

    public static final int wordReplaceLength = 3;

    /*Number of proffer, which needs to replace words*/
    public static final int profferNumberToReplace = 2;

    public static final String encoding = "utf-8";

}
