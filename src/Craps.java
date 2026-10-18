import java.util.Scanner;
import java.util.Random;
public class Craps
{
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        Random rnd = new Random();
        int die1 = 0;
        int die2 = 0;
        int sum = 0;
        int point = 0;
        boolean playAgain = false;
        boolean done = false;
        do {
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            sum = die1 + die2;
            System.out.println("\nYou rolled " + die1 + " and " + die2 + " for a sum of " + sum);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("You got a natural win!");
            } else {
                point = sum;
                done = false;
                System.out.println("The point is now " + point + " keep rolling!");
                do {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled " + die1 + " and " + die2 + " for a sum of " + sum);
                    if (sum == point) {
                        System.out.println("You made the point, you win!");
                        done = true;
                    } else if (sum == 7) {
                        System.out.println("You got a seven and lost");
                        done = true;
                    } else {
                        System.out.println("Roll again for point");
                    }
                } while (!done);
            }
            playAgain = SafeInput.getYNConfirm(in, "Play again?");
        } while (playAgain);
    }
}
