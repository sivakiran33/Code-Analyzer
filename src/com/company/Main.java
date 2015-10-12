package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)throws IOException{

        BufferedReader bReader=new BufferedReader(new FileReader("file.txt"));
        ArrayList<Word> wordList= new ArrayList<Word>();

        String line = null;
        while ((line=bReader.readLine())!=null){

            String[] wordInfo = line.split(";");

            String firstword = wordInfo[0];
            String secondword = wordInfo[1];
            String thirdword = wordInfo[2];

            wordList.add(new Word(firstword,secondword,thirdword));

        }

        for (Word p: wordList){
            System.out.println(p);
        }

    }
}
