package com.byu.number_game;

public class GuessResult {
    private String guess;
    private String result;

    public GuessResult(String guess, String result)
    {
        this.guess = guess;
        this.result = result;

    }


    public String getGuess()
    {
        return guess;
    }

    public String getResult()
    {
        return result;
    }



}
