package com.company;


public class CodeAnalyzer {

    static String[] elements = new String[10000];
    static String[] elementsValues = new String[10000];
    static String[] itemValues;
    static int numberOfElements = 0;
    static int numberOfElementsValues = 0;
    static int numberOfItemValues=0;


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TokenCreator creator = new TokenCreator(); //for future use

        TokenCreator.createTokens();



        for (int i=0; i<10000;i++){

            if(elementsValues[i]!=null){
                //System.out.println(elementsValues[i]);        //Can uncomment this line of code to test the working of this particular module.
                numberOfItemValues++;

            }
        }

        /* Attempt to Optimize the code by avoiding the null values
        If optimised, the arrays in RuleChecker.java must be 'itemValues' not 'elementValues'
        The optimisation resulted in some exceptions, so we are not using it


        itemValues=new String[numberOfItemValues];

        for (int i=0; i<10000;i++){

            if(elementsValues[i]!=null){

                itemValues[i]=elementsValues[i];
                System.out.println(elementsValues[i]);


            }
        }             */




        for (int i=0;i<10000;i++) {

            if(elements[i]!=null) {

               // System.out.println(elements[i]);
               // System.out.println(elementsValues[i]);
                numberOfElements++;
            }

        }
        //System.out.println(numberOfElements);

        RuleChecker checker = new RuleChecker(); //for future use

        RuleChecker.ReturnRule();
        RuleChecker.IdentifierReuseRule();
        RuleChecker.NoImprovementsNeeded();


    }


}

