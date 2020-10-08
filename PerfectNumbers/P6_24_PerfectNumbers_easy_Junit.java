import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class P6_24_PerfectNumbers_easy_Junit {

    P6_24_PerfectNumbers_easy numberToTest = new P6_24_PerfectNumbers_easy();

    @Test
    void isPerfect()
    {
        assertEquals(true,numberToTest.isPerfect(6));
        assertEquals(false,numberToTest.isPerfect(26));
        assertEquals(false,numberToTest.isPerfect(66));
        assertEquals(true,numberToTest.isPerfect(8128));
        assertEquals(false,numberToTest.isPerfect(33550335));
        assertEquals(true,numberToTest.isPerfect(33550336));
        assertEquals(false,numberToTest.isPerfect(85898690));
    }

    @Test
    void isPrime()
    {
        assertEquals(true,numberToTest.isPrime(2));
        assertEquals(true,numberToTest.isPrime(13));
        assertEquals(true,numberToTest.isPrime(19));
        assertEquals(false,numberToTest.isPrime(21));
        assertEquals(true,numberToTest.isPrime(67));
        assertEquals(true,numberToTest.isPrime(71));
        assertEquals(true,numberToTest.isPrime(79));
        assertEquals(true,numberToTest.isPrime(83));
        assertEquals(true,numberToTest.isPrime(97));
    }
}
