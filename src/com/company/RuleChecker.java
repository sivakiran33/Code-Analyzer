package com.company;


public class RuleChecker {

    public static boolean needsImprovement=false;

    //If there is no correction needed, there is no suggestion.

    public static void NoImprovementsNeeded(){

        if(!needsImprovement){
            SuggestionBuilder.NoSuggestion();
        }
    }

    //check if the Return Guideline is followed by the code or not.

    public static void ReturnRule(){

        int countMethods=0;
        int successiveMethods=0;
        int countReturns=0;
        boolean isMethod=false;     //Can be used to improve accuracy of the rule test.
        boolean isReturn=false;

        for(int i=0; i<CodeAnalyzer.numberOfElements;i++){

            if(CodeAnalyzer.elements[i].equals("METHOD")){
                countMethods++;
                isMethod=true;
                isReturn=false;

            }

            if(CodeAnalyzer.elements[i].equals("RETURN")){
                countReturns++;
                isMethod=false;
                isReturn=true;
            }


        }

        if(countMethods<countReturns*2){
            System.out.println("No of methods is : "+countMethods);
            System.out.println("No of returns is : "+countReturns);
            SuggestionBuilder.SuggestionForReturnRule();
            needsImprovement=true;
        }

    }

    //Check if the Reuse Guideline is followed by the code or not.

    public static void IdentifierReuseRule(){

        int numberOfOccurrences=0;
        boolean identifierBad=false;

        String[] wordList= {"Collection", "Comparator", "Deque", "Enumeration",
                "EventListener","Formattable","Iterator", "List", "ListIterator",
                "ListIterator","Map","Entry","NavigableMap","NavigableSet","Observer",
                "Queue","RandomAccess", "Set", "SortedMap", "SortedSet"};


        for (String elements : CodeAnalyzer.elementsValues){

            for (String defined : wordList){

                if(defined.equals(elements)){

                    numberOfOccurrences++;
                    System.out.println("Using "+ "\"" + elements + "\"" + " is not secure");
                    needsImprovement=true;
                    identifierBad=true;
                }

            }

        }

        if (identifierBad) {

            System.out.println("Number of bad occurrences : " + numberOfOccurrences);
            SuggestionBuilder.SuggestionForIdentifierReuseRule();
        }

    }

}
