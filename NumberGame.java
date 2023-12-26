import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    int score = 0;

    public int generateNumber() {
        Random rand = new Random();
        int random = rand.nextInt(100);
        return random;
    }

    public int guessNum() {
        Scanner sc = new Scanner(System.in);
        NumberGame obj = new NumberGame();
        int num = obj.generateNumber();
        int count = 1;

        int guess;
        System.out.println("guess the generated number(within 5 times)");

        while (count <= 5) {
            guess = sc.nextInt();

            if (guess == num) {
                System.out.println("correct number");
                if (count == 1) {
                    score = score + 20;
                } else if (count < 4 && count > 1) {
                    score = score + 15;
                } else {
                    score += 10;
                }
                System.out.println("score: " + score);
                break;
            } else if (guess > num && guess - num > 20 && count < 5) {

                System.out.println("guessed number is too high");

            } else if (guess < num && num - guess > 20 && count < 5) {
                System.out.println("guessed number is too low");

            } else if (guess > num && count < 5) {
                System.out.println("you are close!!");
                System.out.println("guess a lower number");
            } else if (guess < num && count < 5) {
                System.out.println("you are close!!");
                System.out.println("guess a higher number");
            }
            count++;

        }
        if (count > 5) {
            System.out.println("!!BETTER LUCK NEXT TIME !!");
            System.out.println("the number is " + num);
        }
        System.out.println("* enter 2 to play again *");
        System.out.println("* enter any other number to exit *");
        int option = sc.nextInt();
        return option;
    }

    public static void main(String args[]) {
        NumberGame obj = new NumberGame();
        Scanner sc = new Scanner(System.in);
        System.out.println("!!WELCOME!!");
        System.out.println("*Enter 2 to start playing*");
        int a = sc.nextInt();
        while (a == 2) {
            a = obj.guessNum();
        }
    }

}
