// Zach Leali
// 14-22_MorseCode_Medium
// 11/13/2020

import javax.swing.*;

public class Driver
{
    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        MorseCode_Medium conversion = new MorseCode_Medium();
        main.add(conversion);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setSize(1000,500);
        main.setVisible(true);
    }
}
