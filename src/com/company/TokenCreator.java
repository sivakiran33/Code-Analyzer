package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class TokenCreator {
    public static String token;

    public static void createTokens()
    {

        File inputFile = new File("test.java");
        FileInputStream fileInputStream;
        String sourceContent=null;

        try {
            fileInputStream = new FileInputStream(inputFile);
            byte[] buffer = new byte[(int) inputFile.length()];
            new DataInputStream(fileInputStream).readFully(buffer);
            fileInputStream.close();
            sourceContent = new String(buffer, "UTF-8");
        }

        catch (FileNotFoundException e) {
            System.out.println("Error in retrieving the file.");
            e.printStackTrace();
            System.exit(0);
        }

        catch (UnsupportedEncodingException e) {
            System.out.println("Error in retrieving the file.");
            e.printStackTrace();
            System.exit(0);
        }

        catch (IOException e) {
            System.out.println("Error in retrieving the file.");
            e.printStackTrace();
            System.exit(0);
        }


        String source=sourceContent;
        ArrayList<TokenData> dataArrayList=new ArrayList<>();

        //Add the elements which are required to work with the defined rules.
        //Currently, only those elements which are required with the 2 specified rules are added.


        dataArrayList.add(new TokenData(Pattern.compile("^(.)"),TokenType.KEYWORD));
        dataArrayList.add(new TokenData(Pattern.compile("^(return)"),TokenType.RETURN));
        dataArrayList.add(new TokenData(Pattern.compile("^([A-Z][a-zA-Z0-9]*)"),TokenType.FUNCTION));
        dataArrayList.add(new TokenData(Pattern.compile("^([a-z][a-zA-Z0-9]*)"),TokenType.VARIABLE));
        dataArrayList.add(new TokenData(Pattern.compile("^([a-z][a-zA-Z0-9]* \\()"),TokenType.METHOD));


        int i=0;
        int j=0;
        int k=0;

        while(!source.isEmpty()){


            if(source.startsWith(" ")){
                source=source.trim();
            }


            source = source.replaceAll("\\r|\\n|\\t", "");

            Matcher compare=null;
            int max_len=0;
            TokenData tokenData=null;


            for(TokenData data : dataArrayList){

                Matcher matcher=data.getTokenWords().matcher(source);

                if(matcher.find()){

                    token = matcher.group().trim();
                    CodeAnalyzer.elementsValues[k]=token;
                    //System.out.println(CodeAnalyzer.elementsValues[i]); // can be used to understand the working of this module
                    //System.out.println(token);
                    j++;
                    int len=token.length();

                    if(len>max_len){
                        max_len=len;
                        compare=matcher;
                        tokenData=data;
                        //System.out.println();
                    }
                }
                k++;
            }

            if(compare!=null){

                //System.out.println(tokenData.typeOfToken().name()+" : "); //can be used to test

                CodeAnalyzer.elements[i]=tokenData.typeOfToken().name();
                source=compare.replaceFirst("");
            }

            else{
                break;
            }


        i++;
        }

        // System.out.println(i);  //Can be used to check how the loop is working.
        // System.out.println(j);
        CodeAnalyzer.numberOfElementsValues=j;
        // System.out.println(CodeAnalyzer.numberOfElementsValues);
    }

}
