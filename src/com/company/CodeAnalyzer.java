package com.company;


public class CodeAnalyzer {

    static String[]  elements = new String[10000];
    static int numberOfElements = 0;


    public static void main(String[] args) {
        // TODO Auto-generated method stub


        TokenCreator.createTokens();

        for (int i=0;i<10000;i++) {
            if(elements[i]!=null) {
               // System.out.println(elements[i]);
                numberOfElements++;
            }

        }
        System.out.println(numberOfElements);
        RuleChecker.ReturnRule();

        System.out.println("The code does not follow Secure Coding Standards.\n" +
                "Guideline : EXP00-J. Do not ignore values returned by methods\n" +
                "Go to the link to learn more about the this:\n" +
                "https://www.securecoding.cert.org/confluence/display/java/EXP00-J.+Do+not+ignore+values+returned+by+methods");



        System.out.println("The code does not follow Secure Coding Standards.\n" +
                "Guideline : DCL01-J. Do not reuse public identifiers from the Java Standard Library\n" +
                "Go to the link to learn more about the this:\n" +
                "https://www.securecoding.cert.org/confluence/display/java/DCL01-J.+Do+not+reuse+public+identifiers+from+the+Java+Standard+Library");



    }


}

