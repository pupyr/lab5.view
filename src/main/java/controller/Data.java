package controller;

import java.util.Scanner;

public class Data {

    private static Data Instance;

    public static Data getInstance() {
        if (Instance == null) {
            Instance = new Data();
        }
        return Instance;
    }
    private String secondWord;

    private boolean MinMax;

    private Scanner scanner;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean isMinMax() {
        return MinMax;
    }

    public void setMinMax(boolean minMax) {
        MinMax = minMax;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }
}
