package com.company;


public class CodeAnalyzer {

    static String[]  elements = new String[10000];


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TokenCreator create = new TokenCreator();
        create.createTokens();

        for (int i=0;i<10000;i++) {
            if(elements[i]!=null)
            System.out.println(elements[i]);
        }



    }






}

