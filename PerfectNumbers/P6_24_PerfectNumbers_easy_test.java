import java.lang.*;
import java.util.*;

public class P6_24_PerfectNumbers_easy_test
{
    public static void main(String[] args)
    {
        P6_24_PerfectNumbers_easy test = new P6_24_PerfectNumbers_easy();
        for(int i = 0; i < 1000; i++)
        {
            if(test.isPerfect(i))
            {
                if(i != 6)
                {
                    System.out.print(i + " = ");
                    System.out.print(test.printFactors(i) + '\n');
                }
                else
                {
                    System.out.println(i);
                }
            }
        }
    }
}
