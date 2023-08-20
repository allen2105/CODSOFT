//                   NUMBER GUESSING GAME

package com.codesoft.numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
	    Random rand = new Random();

	    int maxNumber = 100; // maximum number to guess
	    int maxAttempts = 7; // maximum number of attempts

	    System.out.println("Welcome to the Number Guessing Game!");

	    int totalScore = 0;
	    boolean playAgain = true;

	    while(playAgain){
	        int randomNumber = rand.nextInt(maxNumber) + 1;
	        //System.out.println(randomNumber);
	        System.out.println("I thought of a number between 1 and " + maxNumber + ". Can you guess the Number?");

	        int attempts = 0;
	        boolean guessedCorrectly = false;

	        while(attempts < maxAttempts){
	            System.out.println("Attempt " + (attempts + 1) + ": Enter your guess: ");
	            int userGuess = scn.nextInt();

	            if(userGuess == randomNumber){
	                System.out.println("Congratulations! You guessed the correct number " + randomNumber + " in " + (attempts + 1) + " attempts.");
	                guessedCorrectly = true;
	                break;
	            }
	            else if (userGuess < randomNumber){
	                 System.out.println("Nope! The number is Higher. Try Again!");
	            }
	            else{
	                System.out.println("Nope! The number is lower. Try Again! ");
	            } 

	            attempts++;
	        }

	        if(!guessedCorrectly){
	            System.out.println("Sorry, you couldn't guess the number. It was " + randomNumber + ".");
	        }

	        totalScore += maxAttempts - attempts;

	        System.out.println("Do you want to play again? (yes/no): ");
	        String playAgainInput = scn.next();
	        playAgain = playAgainInput.equalsIgnoreCase("yes");
	    }

	    System.out.println("Thanks for playing! Your total score (out of 7) is: " + totalScore);
	    scn.close();
	}

}
