import static org.junit.jupiter.api.Assertions.*;

// Junit testing for the Computus class.
// Number of tests: 20
// Dates found at: https://www.census.gov/srd/www/genhol/easter500.html
// Zachary Leali
// 9/9/2020
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class to test 20 different years with known answers of when Easter was in that year.
 * @see <a href="Node.html#section">Node</a>
 * @see <a href="S1_Computus_Hard.html#section">S1_Computus_Hard</a>
 * @see <a href="S1_Computus_Hard_Test.html#section">S1_Computus_Hard_Test</a>
 * @see <a href="LinkedList.html#section">LinkedList</a>
 */

class S1_Computus_Hard_JUnit_Test {

    // creating 20 different objects of Computus class
    // where the dates are previously known.
    /** Test case object for year 1700 */
    S1_Computus_Hard testing1 = new S1_Computus_Hard(1700);
    /** Test case object for year 1710 */
    S1_Computus_Hard testing2 = new S1_Computus_Hard(1710);
    /** Test case object for year 1720 */
    S1_Computus_Hard testing3 = new S1_Computus_Hard(1720);
    /** Test case object for year 1730 */
    S1_Computus_Hard testing4 = new S1_Computus_Hard(1730);
    /** Test case object for year 1745 */
    S1_Computus_Hard testing5 = new S1_Computus_Hard(1745);
    /** Test case object for year 1805 */
    S1_Computus_Hard testing6 = new S1_Computus_Hard(1805);
    /** Test case object for year 1832 */
    S1_Computus_Hard testing7 = new S1_Computus_Hard(1832);
    /** Test case object for year 1847 */
    S1_Computus_Hard testing8 = new S1_Computus_Hard(1847);
    /** Test case object for year 1856 */
    S1_Computus_Hard testing9 = new S1_Computus_Hard(1856);
    /** Test case object for year 1892 */
    S1_Computus_Hard testing10 = new S1_Computus_Hard(1892);
    /** Test case object for year 1907 */
    S1_Computus_Hard testing11 = new S1_Computus_Hard(1907);
    /** Test case object for year 1917 */
    S1_Computus_Hard testing12 = new S1_Computus_Hard(1917);
    /** Test case object for year 1927 */
    S1_Computus_Hard testing13 = new S1_Computus_Hard(1927);
    /** Test case object for year 1943 */
    S1_Computus_Hard testing14 = new S1_Computus_Hard(1943);
    /** Test case object for year 1998 */
    S1_Computus_Hard testing15 = new S1_Computus_Hard(1998);
    /** Test case object for year 2002 */
    S1_Computus_Hard testing16 = new S1_Computus_Hard(2002);
    /** Test case object for year 2009 */
    S1_Computus_Hard testing17 = new S1_Computus_Hard(2009);
    /** Test case object for year 2062 */
    S1_Computus_Hard testing18 = new S1_Computus_Hard(2062);
    /** Test case object for year 2072 */
    S1_Computus_Hard testing19 = new S1_Computus_Hard(2072);
    /** Test case object for year 2081 */
    S1_Computus_Hard testing20 = new S1_Computus_Hard(2081);



    // Assertions using the 20 objects to test whether
    // the date from the object matches to correct date for the specific year.
    /**
     * A JUnit test for method printDate() checking whether or not the created objects year printed correct results.
     */
    @Test
    void printDate()
    {
        Assertions.assertAll(
                () -> Assertions.assertEquals("April 11, 1700",testing1.printDate()),
                () -> Assertions.assertEquals("April 20, 1710",testing2.printDate()),
                () -> Assertions.assertEquals("March 31, 1720",testing3.printDate()),
                () -> Assertions.assertEquals("April 9, 1730",testing4.printDate()),
                () -> Assertions.assertEquals("April 18, 1745",testing5.printDate()),
                () -> Assertions.assertEquals("April 14, 1805",testing6.printDate()),
                () -> Assertions.assertEquals("April 22, 1832",testing7.printDate()),
                () -> Assertions.assertEquals("April 4, 1847",testing8.printDate()),
                () -> Assertions.assertEquals("March 23, 1856",testing9.printDate()),
                () -> Assertions.assertEquals("April 17, 1892",testing10.printDate()),
                () -> Assertions.assertEquals("March 31, 1907",testing11.printDate()),
                () -> Assertions.assertEquals("April 8, 1917",testing12.printDate()),
                () -> Assertions.assertEquals("April 17, 1927",testing13.printDate()),
                () -> Assertions.assertEquals("April 25, 1943",testing14.printDate()),
                () -> Assertions.assertEquals("April 12, 1998",testing15.printDate()),
                () -> Assertions.assertEquals("March 31, 2002",testing16.printDate()),
                () -> Assertions.assertEquals("April 12, 2009",testing17.printDate()),
                () -> Assertions.assertEquals("March 26, 2062",testing18.printDate()),
                () -> Assertions.assertEquals("April 10, 2072",testing19.printDate()),
                () -> Assertions.assertEquals("March 30, 2081",testing20.printDate()));

    }
}
