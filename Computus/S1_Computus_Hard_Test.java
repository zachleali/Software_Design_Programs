//  Zachary Leali
//  9/9/2020

import java.util.*;

// Main program that allows the user to enter a year and it will print out
// the Month and Day Easter falls on in that year.
/**
 * The driver class that allows the user to enter a specific year and find out when Easter was in that year.
 * It also allows the user to see a full list and count from 0 to 5700000 years of Easter dates
 * @see <a href="Node.html#section">Node</a>
 * @see <a href="S1_Computus_Hard.html#section">S1_Computus_Hard</a>
 * @see <a href="LinkedList.html#section">LinkedList</a>
 * @see <a href="S1ComputusHardJUnitTest.html#section">S1ComputusHardJUnitTest</a>
 * @author Zachary Leali
 *
 */
public class S1_Computus_Hard_Test
{
    public static void main(String [] args)
    {
        boolean continueCycle = false; // variable to make sure the user enters the correct choices.

        Scanner user_input = new Scanner(System.in); // user input for the year.
        System.out.print("Enter Year: ");

        String user_year = user_input.nextLine();
        int year = Integer.parseInt(user_year);

        S1_Computus_Hard e = new S1_Computus_Hard(year); // object of Computus class created with the year from user.
        System.out.println("Easter: " + e.printDate()); // prints out the Easter date using method from Computus class.

        // loops through until the user enters 1 or 2 to print out the number
        // of times an Easter date repeated from years 0 to 5,700,000.
        while(!continueCycle)
        {
            Scanner user_continue = new Scanner(System.in);
            System.out.print("Would you like to cycle through 5,700,000 years " +
                    "and see how many time each day for easter occurred? Press(1/yes)(2/no): ");
            String user_ans = user_continue.nextLine();

            int answer = Integer.parseInt(user_ans);
            if(answer == 1)
            {
                e.findTotalDates();
                continueCycle = true;
            }
            else if(answer == 2)
            {
                System.out.println("Okay!");
                continueCycle = true;
            }
            else
            {
                System.out.println("Wrong input, please try again."); // prints out if the user doesn't enter 1 or 2.
            }
        }
    }
}
