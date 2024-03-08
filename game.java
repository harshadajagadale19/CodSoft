import java.util.Random;
import java.util.Scanner;

public class Game 
{
    public static void main(String[] args) 
    {
       NumberGame();
    }

    private static void NumberGame() 
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int lLimit = 1;
        int uLimit = 100;
        int maximumAttempts = 3;
        int roundsPlayed = 0;
        int won = 0;

        while (true) 
        {
            int correctnumber = random.nextInt(uLimit - lLimit + 1) + lLimit;
            int attempt = 0;

            System.out.println("Guess the number between the limit " + lLimit + " and " + uLimit + ":");

            while (attempt < maximumAttempts) 
            {
                int guess = sc.nextInt();

                if (guess == correctnumber) 
                {
                    System.out.println("Congratulations! You guessed the correct number.");
                    won++;
                    break;
                }
                else if (guess < correctnumber) 
                {
                    System.out.println("Number is too low! lets Try again.");
                }
                else 
                {
                    System.out.println("Number is too high! Lets Try again.");
                }

                attempt++;
            }

            if (attempt == maximumAttempts)
            {
                System.out.println("Sorry, youve run out of attempts. The correct number was " + correctnumber + ".");
            }

            roundsPlayed++;

            System.out.println("Do you want to play again? say(yes/no):");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes"))
            {
                System.out.println("Game Over! You played " + roundsPlayed + " rounds and won " + won + " times.");
                break;
            }
        }

        sc.close();
    }
}