import java.lang.*;

// The Computus class is used to create an object where the attributes are
// show, given a year, what day and month Easter fell on in that year.
/**
 * Computus is a class to calculate the exact month and day of Easter given any year as input
 * @see <a href="Node.html#section">Node</a>
 * @see <a href="LinkedList.html#section">LinkedList</a>
 * @see <a href="S1_Computus_Hard_Test.html#section">S1_Computus_Hard_Test</a>
 * @see <a href="S1ComputusHardJUnitTest.html#section">S1ComputusHardJUnitTest</a>
 * @author Zach Leali
 */
public class S1_Computus_Hard
{
    // An array of months
    /** A final array of strings containing the months of the year */
    private final String months[] = {"January", "February","March","April","May","June",
            "July","August","September","October","November","December"};
    /** private integer representing input year from user */
    private int year; // The objects year of Easter
    /** private integer representing the month of Easter */
    private int easterMonth; // The objects month of Easter
    /** private integer representing the day of Easter */
    private int easterDay; // The objects day of Easter

    // A class constructor that computes the month and day of Easter given a year.
    /**
     * Class constructor that takes the user input and sets the created objects Easter day and month
     * @param year          The year for the calculation of month and day of Easter
     */
    S1_Computus_Hard(int year)
    {
        this.year = year;
        int a = year % 19; // Anonymous Gregorian algorithm
        int b = year / 100; // Anonymous Gregorian algorithm
        int c = year % 100; // Anonymous Gregorian algorithm
        int d = b / 4; // Anonymous Gregorian algorithm
        int e = b % 4; // Anonymous Gregorian algorithm
        int f = (b + 8) / 25; // Anonymous Gregorian algorithm
        int g = (b - f + 1) / 3; // Anonymous Gregorian algorithm
        int h = ((19*a) + b - d - g + 15) % 30; // Anonymous Gregorian algorithm
        int i = c / 4; // Anonymous Gregorian algorithm
        int k = c % 4; // Anonymous Gregorian algorithm
        int lambda = (32 + (2*e) + (2*i) - h - k) % 7; // Anonymous Gregorian algorithm
        int m = (a + (11*h) + (22*lambda)) / 451; // Anonymous Gregorian algorithm
        int month = (h + lambda - (7*m) + 114) / 31; // Anonymous Gregorian algorithm
        int day = ((h + lambda - (7*m) + 114) % 31) + 1; // Anonymous Gregorian algorithm
        easterMonth = month; // setting objects Month to the computed month.
        easterDay = day; // setting objects Day to computed day.
    }

    // A public method to create a linked list of nodes from March 22nd to April 25
    // and then iterates a specific number of times to find the number of times easter occurred on each day.
    /**
     * Class method that calculates and prints the number of times a
     * day and month of Easter repeated generated from 0 to 5700000 years for all days and months of Easter found
     *
     */
    public void findTotalDates()
    {
        LinkedList totalList = new LinkedList(); //
        // Create March nodes
        for(int j = 22; j <= 31; j++)
        {
            totalList.addNode(totalList, "March", j);
        }
        // Creates April nodes
        for(int z = 1; z <= 25; z++)
        {
            totalList.addNode(totalList,"April", z);
        }
        // Iterates through 5700000 years and finds the total number of occurrences for each node date.
        for(int i = 0; i <= 5700000; i++)
        {
            S1_Computus_Hard date = new S1_Computus_Hard(i);
            Node currentNode = totalList.headPointer;
            while (currentNode != null)
            {
                if(currentNode.getMonth() == date.months[date.easterMonth - 1] && currentNode.getDay() == date.easterDay)
                {
                    currentNode.incrementEasterDay();
                }
                currentNode = currentNode.nextPointer;

            }
        }
        totalList.printList(totalList);
    }

    // public method to print the date from the original user input in main program.
    /**
     * Class method that prints out the month day and year of the calculated date from class method Computus()
     * @return          A string that shows the month, day and year in (Month Day, Year) format
     */
    public String printDate()
    {
        return months[easterMonth-1] + " " + easterDay + ", " + year;
    }
}
