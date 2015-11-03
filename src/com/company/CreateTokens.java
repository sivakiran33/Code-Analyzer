package com.company;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateTokens {
    public static void createTokens()
    {

        //accepting file path from the user
        //System.out.println(" enter complete path:  ");
        //Scanner user_input=new Scanner(System.in);
        //String filePath=user_input.next();


        //A SAMPLE PATH is -> D:\\code.txt

        //Extracting data from the file in string format
        //File file = new File(filePath);
        File inputfile = new File("file.txt");
        FileInputStream fileInputStream = null;
        String dataFromFile=null;
        try {
            fileInputStream = new FileInputStream(inputfile);
            byte[] buffer = new byte[(int)inputfile.length()];
            new DataInputStream(fileInputStream).readFully(buffer);
            fileInputStream.close();
            dataFromFile =new String(buffer, "UTF-8");

            System.out.println("The input code is as follows: \n"+dataFromFile+"\n");
        }
        catch(IOException e)
        {
            System.out.println("Error in retrieving the file.");
            e.printStackTrace();
            System.exit(0);

        }


        ArrayList<Token> tokenList=new ArrayList<Token>();


        System.out.println("\nToken List Of Given File \n");
        String code=dataFromFile;


        //Following Array list will contain all the regular expressions for the Tokens used the our Language


        ArrayList<TokenData> dataArrayList=new ArrayList<TokenData>();


        //List of keywords

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
        dataArrayList.add(new TokenData(Pattern.compile("^(.)"),TokenType.KEYWORD_DOT));



        dataArrayList.add(new TokenData(Pattern.compile("^(if)"),TokenType.KEYWORD_IF));
        dataArrayList.add(new TokenData(Pattern.compile("^(while)"),TokenType.KEYWORD_WHILE));
        dataArrayList.add(new TokenData(Pattern.compile("^(return)"),TokenType.KEYWORD_RETURN));
        dataArrayList.add(new TokenData(Pattern.compile("^(else)"),TokenType.KEYWORD_ELSE));
        dataArrayList.add(new TokenData(Pattern.compile("^(do)"),TokenType.KEYWORD_DO));
        dataArrayList.add(new TokenData(Pattern.compile("^(for)"),TokenType.KEYWORD_FOR));

        //Datatypes

        dataArrayList.add(new TokenData(Pattern.compile("^(int)"),TokenType.INT_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(char)"),TokenType.CHAR_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(String)"),TokenType.STRING_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(bool)"),TokenType.BOOL_DATATYPE));
        dataArrayList.add(new TokenData(Pattern.compile("^(array)"),TokenType.ARRAY_DATATYPE));


        //Methods of Array Class


        dataArrayList.add(new TokenData(Pattern.compile("^(equals)"),TokenType.ARRAYMETHOD_EQUALS));
        dataArrayList.add(new TokenData(Pattern.compile("^(fill)"),TokenType.ARRAYMETHOD_FILL));
        dataArrayList.add(new TokenData(Pattern.compile("^(sort)"),TokenType.ARRAYMETHOD_SORT));
        dataArrayList.add(new TokenData(Pattern.compile("^(toString)"),TokenType.ARRAYMETHOD_TOSTRING));





        //Variables and methods

        dataArrayList.add(new TokenData(Pattern.compile("^([A-Z][a-zA-Z0-9]*)"),TokenType.VARIABLE_IDENTIFIER));
        dataArrayList.add(new TokenData(Pattern.compile("^([a-z][a-zA-Z0-9]*)"),TokenType.FUNCTION_IDENTIFIER));

        dataArrayList.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"),TokenType.INTEGER_LITERAL));
        dataArrayList.add(new TokenData(Pattern.compile("^(\".*\")"),TokenType.STRING_LITERAL));
        dataArrayList.add(new TokenData(Pattern.compile("^('.')"),TokenType.CHAR_LITERAL));

        //Symbols


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
        dataArrayList.add(new TokenData(Pattern.compile("^(|)"),TokenType.PIPE_SYMBOL));
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







        //erroneousString will contain the part of the code which is erroneous and can not be parsed
        String erroneousString=null;

        //Parse until no string remains to be parsed
        while(!code.isEmpty())
        {
            if(code.startsWith(" "))
            {
                code=code.trim();//removing blank spaces from code
            }


            //removing \n, \r, \t from  code
            code = code.replaceAll("\\r|\\n|\\t", "");

            //By the end of trying all the regular expression , the matcherMax object will hold the data of the
            //match of maximum length .
            Matcher matcherMax=null;
            int max_len=0;//this will hold the length of the match of maximum length
            TokenData tokenDataMax=null;//This is token data for the maximum match

            //Now following loop will try all the regular expressions present in the dataArrayList list .
            for(TokenData data : dataArrayList)
            {
                Matcher matcher=data.getPattern().matcher(code);

                if(matcher.find())
                {
                    String token=matcher.group().trim();
                    int len=token.length();
                    if(len>max_len)//if this match is greater than maximum match till now, then set this as the maximum match
                    {
                        max_len=len;
                        matcherMax=matcher;
                        tokenDataMax=data;
                    }
                }

            }//end of iteration over dataArrayList list

            //condition when some match is found
            if(matcherMax!=null)
            {
                String token=matcherMax.group().trim();
                System.out.println("Token type- "+tokenDataMax.getType().name()+"  Token is-  "+ token);

                //Removing the matched string from the code
                code=matcherMax.replaceFirst("");

                //adding this token in the list
                Token tempToken=new Token(tokenDataMax.getType().name(),token);
                tokenList.add(tempToken);
            }
            else
            {
                //setting the erroneousString in case no match is found
                erroneousString=code;
                break;
            }


        }//end of while

        if(erroneousString!=null)
        {
            System.out.println("Code with error is -> "+ erroneousString);
            System.out.println("\n Parsing aborted !! Please fix this error.");
            Token tempToken=new Token("Error","Error");
            tokenList.add(tempToken);
        }


    }//end of function createTokens

}
