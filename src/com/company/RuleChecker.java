package com.company;


public class RuleChecker {

    public static void ReturnRule(){

        int countMethods=0;
        int countReturns=0;
        for(int i=0; i<CodeAnalyzer.numberOfElements;i++){

            if(CodeAnalyzer.elements[i].equals("METHOD")){
                countMethods++;
            }

            if(CodeAnalyzer.elements[i].equals("RETURN")){
                countReturns++;
            }


        }

        if(countReturns<1+(countMethods/2)){
            System.out.println("No of methods is : "+countMethods);
            System.out.println("No of returns is : "+countReturns);
            SuggestionBuilder.SuggestionForReturnRule();
        }

    }

}
