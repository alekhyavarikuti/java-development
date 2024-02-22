package topperworld.numberguessgame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int mini_range = 1;
    private static final int maxi_range = 100;
    private static final int max_attempts = 5;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Welcome to Guess Number Game:");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("You Will Be Asked To Guess A Number To Win The Game:");
        System.out.println("ATTEMPTS TO GUESS THE NUMBER IS: 5");
        int number = random.nextInt(maxi_range) + mini_range;
        int attempts = 0;
        System.out.println("generated random number: " + number);
        System.out.println("Guess the number between " + mini_range + " and " + maxi_range + " in " + max_attempts + " attempts");

        while (attempts < max_attempts) {
            System.out.println("ENTER YOUR GUESS:");
            try {
                attempts = attempts + 1;
                int guess_number = scanner.nextInt();
                if (guess_number > maxi_range || guess_number < mini_range) {
                    attempts = attempts - 1;
                    System.out.println("Bad input: " + guess_number);
                    System.out.println("please enter valid number between 1 to 100  in " + max_attempts + " attempts");

                } else if (guess_number == number) {
                    System.out.println("Ooh.....ooooooo.. Your number is correct. You win the game. Congrats");
                    break;
                } else if (guess_number < number) {
                    int remaining_attempts = max_attempts - attempts;
                    System.out.println("THE GUESS NUMBER IS LESSER, ATTEMPTS LEFT=" + remaining_attempts);
                } else if (guess_number > number) {
                    int remaining_attempts = max_attempts - attempts;
                    System.out.println("THE GUESS NUMBER IS GREATER, ATTEMPTS LEFT=" + remaining_attempts);
                }
            } catch (InputMismatchException ime) {
                attempts = attempts - 1;
                String bad_input = scanner.next();
                System.out.println("Bad input: " + bad_input);
                System.out.println("please enter valid number between 1 to 100 in " + max_attempts + " attempts");
            }

        }
        if (attempts == max_attempts) {

            System.out.println("Your Attempts are exhausted");
            System.out.println("and actual number is:" + number);
        }
        System.out.println("---GAME OVER---");
    }
}