package com.company;


public class SuggestionBuilder {

    public static void SuggestionForReturnRule(){
        System.out.println("The code does not follow Secure Coding Standards.\n" +
                "Guideline : EXP00-J. Do not ignore values returned by methods\n" +
                "Go to the link to learn more about the this:\n" +
                "https://www.securecoding.cert.org/confluence/display/java/EXP00-J.+Do+not+ignore+values+returned+by+methods");
    }

    public static void SuggestionForIdentifierReuseRule(){
        System.out.println("The code does not follow Secure Coding Standards.\n" +
                "Guideline : DCL01-J. Do not reuse public identifiers from the Java Standard Library\n" +
                "Go to the link to learn more about the this:\n" +
                "https://www.securecoding.cert.org/confluence/display/java/DCL01-J.+Do+not+reuse+public+identifiers+from+the+Java+Standard+Library");

    }
}
