import java.lang.*;

public class P6_24_PerfectNumbers_easy
{
    /**
     * Takes a type double number as input and returns true if the number is a perfect number.
     * @param number        The number to test
     * @return
     */
    public boolean isPerfect(int number)
    {
        boolean perfect = false;
        for (int i = 1; i <= number; i++)
        {
            int total = (int) (Math.pow(2, i) * (Math.pow(2, i + 1) - 1));
            if (isPrime((int) ((Math.pow(2, (i + 1))) - 1)) && total == number)
            {
                perfect = true;
                i = number + 1;
            }
        }

        return perfect;
    }

    /**
     * Takes a type double number as input and returns a string representing that numbers prime factors
     * adding up to the number itself.
     * @param number        The number to factor
     * @return
     */
    public String printFactors(int number)
    {
        String x = "";
        int total = 0;
        for(int i = 0; i < number; i++)
        {
            if(i % 2 != 0)
            {
                total += Math.pow(i,3);
                if(total == number)
                {
                    x = x + + i + "\u00B3";
                }
                else
                {
                    x = x + i + "\u00B3" + " + ";
                }
            }
            if(total == number)
            {
                i = number;
            }
        }
        return x;
    }

    /**
     * Takes a type double number as input and returns true if the number is prime and false otherwise.
     * @param number        The number to be tested
     * @return
     */
    public boolean isPrime(int number)
    {
        boolean prime = false;
        if(number == 2)
        {
            prime = true;
        }
        else if(number == 1)
        {
            prime = false;
        }
        else if(number % 2 == 0 && number != 2)
        {
            prime = false;
        }
        else if(number % 3 == 0 && number != 3)
        {
            prime = false;
        }
        else if(number % 5 == 0 && number != 5)
        {
            prime = false;
        }
        else if(number % 7 == 0 && number != 7)
        {
            prime = false;
        }
        else if(number % 9 == 0)
        {
            prime = false;
        }
        else if(number % 11 == 0 && number != 11)
        {
            prime = false;
        }
        else
        {
            prime = true;
        }
        return prime;
    }
}
