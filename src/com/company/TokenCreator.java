package com.company;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenCreator {
    //static int numberOfTokens=0;
    public static void createTokens()
    {

        File inputFile = new File("test.java");
        FileInputStream fileInputStream;
        String sourceContent=null;

        try {
            fileInputStream = new FileInputStream(inputFile);
            byte[] buffer = new byte[(int)inputFile.length()];
            new DataInputStream(fileInputStream).readFully(buffer);
            fileInputStream.close();
            sourceContent =new String(buffer, "UTF-8");
        }
        catch(IOException e)
        {
            System.out.println("Error in retrieving the file.");
            e.printStackTrace();
            System.exit(0);
        }


        ArrayList<Token> tokenList=new ArrayList<Token>();


        System.out.println("\n Token List Of Given File \n");
        String source=sourceContent;
        ArrayList<TokenData> dataArrayList=new ArrayList<TokenData>();


        dataArrayList.add(new TokenData(Pattern.compile("^(public)"),TokenType.KEYWORD_PUBLIC));
        dataArrayList.add(new TokenData(Pattern.compile("^(static)"),TokenType.KEYWORD_STATIC));
        dataArrayList.add(new TokenData(Pattern.compile("^(void)"),TokenType.KEYWORD_VOID));
        dataArrayList.add(new TokenData(Pattern.compile("^(main)"),TokenType.KEYWORD_MAIN));
        dataArrayList.add(new TokenData(Pattern.compile("^(System)"),TokenType.KEYWORD_SYSTEM));
        dataArrayList.add(new TokenData(Pattern.compile("^(out)"),TokenType.KEYWORD_OUT));
        dataArrayList.add(new TokenData(Pattern.compile("^(print)"),TokenType.KEYWORD_PRINT));
        dataArrayList.add(new TokenData(Pattern.compile("^(println)"),TokenType.KEYWORD_PRINTLN));
        dataArrayList.add(new TokenData(Pattern.compile("^(Scanner)"),TokenType.KEYWORD_SCANNER));
        dataArrayList.add(new TokenData(Pattern.compile("^(new)"),TokenType.KEYWORD_NEW));
        dataArrayList.add(new TokenData(Pattern.compile("^(import)"),TokenType.KEYWORD_IMPORT));
        dataArrayList.add(new TokenData(Pattern.compile("^(.)"),TokenType.KEYWORD));



        dataArrayList.add(new TokenData(Pattern.compile("^(if)"),TokenType.KEYWORD_IF));
        dataArrayList.add(new TokenData(Pattern.compile("^(while)"),TokenType.KEYWORD_WHILE));
        dataArrayList.add(new TokenData(Pattern.compile("^(return)"),TokenType.RETURN));
        dataArrayList.add(new TokenData(Pattern.compile("^(else)"),TokenType.KEYWORD_ELSE));
        dataArrayList.add(new TokenData(Pattern.compile("^(do)"),TokenType.KEYWORD_DO));
        dataArrayList.add(new TokenData(Pattern.compile("^(for)"),TokenType.KEYWORD_FOR));



        dataArrayList.add(new TokenData(Pattern.compile("^(int)"),TokenType.INT_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(char)"),TokenType.CHAR_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(String)"),TokenType.STRING_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(bool)"),TokenType.BOOL_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(array)"),TokenType.ARRAY_DATATYPE));





        dataArrayList.add(new TokenData(Pattern.compile("^(equals)"),TokenType.ARRAYMETHOD_EQUALS));
        dataArrayList.add(new TokenData(Pattern.compile("^(fill)"),TokenType.ARRAYMETHOD_FILL));
        dataArrayList.add(new TokenData(Pattern.compile("^(sort)"),TokenType.ARRAYMETHOD_SORT));
        dataArrayList.add(new TokenData(Pattern.compile("^(toString)"),TokenType.ARRAYMETHOD_TOSTRING));







        dataArrayList.add(new TokenData(Pattern.compile("^([A-Z][a-zA-Z0-9]*)"),TokenType.FUNCTION));
        dataArrayList.add(new TokenData(Pattern.compile("^([a-z][a-zA-Z0-9]*)"),TokenType.VARIABLE));
        dataArrayList.add(new TokenData(Pattern.compile("^([a-z][a-zA-Z0-9]* \\()"),TokenType.METHOD));

        dataArrayList.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"),TokenType.INTEGER_LITERAL));
        dataArrayList.add(new TokenData(Pattern.compile("^(\".*\")"),TokenType.STRING_LITERAL));
        dataArrayList.add(new TokenData(Pattern.compile("^('.')"),TokenType.CHAR_LITERAL));




        dataArrayList.add(new TokenData(Pattern.compile("^(;)"),TokenType.SEMICOLON));
        dataArrayList.add(new TokenData(Pattern.compile("^(')"),TokenType.QUOTE));
        dataArrayList.add(new TokenData(Pattern.compile("^(,)"),TokenType.COMMA));
        dataArrayList.add(new TokenData(Pattern.compile("^(<)"),TokenType.LEFT_ANGULAR_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(>)"),TokenType.RIGHT_ANGULAR_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\{)"),TokenType.LEFT_CURLY_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\})"),TokenType.RIGHT_CURLY_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\()"),TokenType.LEFT_ROUND_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\))"),TokenType.RIGHT_ROUND_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\[)"),TokenType.LEFT_SQUARE_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\])"),TokenType.RIGHT_SQUARE_BRACKET));
        dataArrayList.add(new TokenData(Pattern.compile("^(:=)"),TokenType.ASSIGNMENT_OPERATOR));
        dataArrayList.add(new TokenData(Pattern.compile("^(&)"),TokenType.AND_SYMBOL));
        dataArrayList.add(new TokenData(Pattern.compile("^(>)"),TokenType.SYMBOL_MORE_THAN));
        dataArrayList.add(new TokenData(Pattern.compile("^(<)"),TokenType.SYMBOL_LESS_THAN));
        dataArrayList.add(new TokenData(Pattern.compile("^(=)"),TokenType.SYMBOL_EQUAL_TO));
        dataArrayList.add(new TokenData(Pattern.compile("^(!=)"),TokenType.SYMBOL_NOT_EQUAL_TO));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\+)"),TokenType.SYMBOL_PLUS));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\-)"),TokenType.SYMBOL_MINUS));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\*)"),TokenType.SYMBOL_MULTIPLY));
        dataArrayList.add(new TokenData(Pattern.compile("^(\\/)"),TokenType.SYMBOL_DIVISION));
        dataArrayList.add(new TokenData(Pattern.compile("^(%)"),TokenType.SYMBOL_PERCENTAGE));
        dataArrayList.add(new TokenData(Pattern.compile("^(^)"),TokenType.SYMBOL_POWER));
        dataArrayList.add(new TokenData(Pattern.compile("^(->)"),TokenType.ARROW_SYMBOL));



        String erroneousString=null;
        //int counterMethods = 0;
        //int counterReturns = 0;
        int i=0;

        while(!source.isEmpty())
        {
            if(source.startsWith(" "))
            {
                source=source.trim();
            }


            source = source.replaceAll("\\r|\\n|\\t", "");

            Matcher compare=null;
            int max_len=0;
            TokenData tokenData=null;


            for(TokenData data : dataArrayList)
            {
                Matcher matcher=data.getPattern().matcher(source);

                if(matcher.find())
                {
                    String token=matcher.group().trim();
                    int len=token.length();
                    if(len>max_len)
                    {
                        max_len=len;
                        compare=matcher;
                        tokenData=data;
                    }
                }

            }

            if(compare!=null)
            {
                String token=compare.group().trim();
                System.out.println(tokenData.typeOfToken().name()+" : "+ token);

               // numberOfTokens++;


                    CodeAnalyzer.elements[i]=tokenData.typeOfToken().name();




               // if(tokenData.typeOfToken().name()=="METHOD"){
                 //   counterMethods++;
                   // System.out.println(counterMethods);
                //}
                //if(tokenData.typeOfToken().name()=="RETURN"){
                  //  counterReturns++;
                    //System.out.println(counterReturns);
                //}


                source=compare.replaceFirst("");

                Token tempToken=new Token(tokenData.typeOfToken().name(),token);
                tokenList.add(tempToken);



            }
            else
            {
                erroneousString=source;
                break;
            }


        i++;
        }


        if(erroneousString!=null)
        {
            System.out.println("Code with error is -> "+ erroneousString);
            System.out.println("\n Parsing aborted !! Please fix this error.");
            Token tempToken=new Token("Error","Error");
            tokenList.add(tempToken);
        }
        //if(counterReturns<counterMethods){
          //  System.out.println("CHECK CODE! NOT ALL RETURNING METHODS ARE BEING USED!");
        //}


    }

}
