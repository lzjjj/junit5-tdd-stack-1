package com.thoughtworks.tdd;

import java.util.Scanner;

public class ScannerStr {
    private String inputStr;
    public ScannerStr() {
    }

    public String getStr() {
        Scanner sc = new Scanner( System.in );
        String outputStr = sc.nextLine();
        return outputStr ;
    }
}
