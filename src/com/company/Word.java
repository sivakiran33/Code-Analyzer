package com.company;


public class Word {
    private String firstword;
    private String secondword;
    private String thirdword;

    public Word(String firstword, String secondword, String thirdword){

        this.firstword=firstword;
        this.secondword=secondword;
        this.thirdword=thirdword;

    }

    public String toString(){

        String word= "First word: " + firstword + "\tSecond word: " + secondword + "\tThird word: " + thirdword;
        return word;
    }
}
