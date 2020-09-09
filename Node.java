// Zachary Leali
// 9/9/2020
// Class Node that creates a node object with three different attributes and points to the next node if not null.

/**
 * Node is a class that is used to create new nodes for
 * @see <a href="LinkedList.html#section">LinkedList</a>
 * @see <a href="S1_Computus_Hard.html#section">S1_Computus_Hard</a>
 * @see <a href="S1_Computus_Hard_Test.html#section">S1_Computus_Hard_Test</a>
 * @see <a href="S1ComputusHardJUnitTest.html#section">S1ComputusHardJUnitTest</a>
 * @author Zach Leali
 */
public class Node
{
    /** The data stored in an object of Node representing the month of Easter. */
    private String nodeMonth; // The specified month computed from the Computus class
    /** The data stored in an object of Node representing the day of Easter. */
    private int nodeDay; // The specified day computud from the Computus class
    /** The data stored in an object of Node representing the number of times the Nodes day and month repeated. */
    private int easterDayRepeat = 0; // A counter for the number of repeated easter dates for one node.
    /** A reference to Node object as a pointer. */
    Node nextPointer;

    // Class constructor setting the objects nextPointer to null
    /**
     * Class constructor that makes the object point to null.
     */
    Node()
    {
        nextPointer = null;
    }
    // get methods for the three private instance variables
    /**
     * The get method for an objects month
     * @return          The Objects month
     */
    public String getMonth()
    {
        return nodeMonth;
    }
    /**
     * The get method for an objects day
     * @return          The objects day
     */
    public int getDay()
    {
        return nodeDay;
    }
    /**
     * The get method for an objects number of Easter days repeated
     * @return          The number of times the month and day repeated
     */
    public int getEasterDayCount()
    {
        return easterDayRepeat;
    }

    // set methods for the month and day instance variables.
    /*
       There is not a set method for the easterDayRepeat because
       there is no need to reset or change easterDayRepeat other
       incrementing.
    */

    /**
     * The set method for the objects month
     * @param nodeMonth     The month of Easter
     */
    public void setMonth(String nodeMonth)
    {
        this.nodeMonth = nodeMonth;
    }
    /**
     * The set method for the objects day
     * @param nodeDay       The day of Easter
     */
    public void setDay(int nodeDay)
    {
        this.nodeDay = nodeDay;
    }

    // void method to increment the number of repeats for the specific month and day.
    /**
     * Void function that increments the objects Easter day Repeat
     */
    public void incrementEasterDay()
    {
        easterDayRepeat += 1;
    }
}
