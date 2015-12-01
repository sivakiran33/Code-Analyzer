package com.company;

import java.util.regex.Pattern;


public class TokenData {


    private Pattern tokenWords;
    private TokenType tokenType;

    public TokenData(Pattern tokenWords, TokenType tokenType)
    {
        this.tokenWords = tokenWords;
        this.tokenType = tokenType;
    }

    public Pattern getTokenWords()
    {
        return tokenWords;
    }

    public TokenType typeOfToken()
    {
        return tokenType;
    }

}
