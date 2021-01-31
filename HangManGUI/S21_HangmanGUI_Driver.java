// Zach Leali
// Date: 10/23/2020
// S21_HangmanGUI_Medium Driver

import javax.swing.*;

public class S21_HangmanGUI_Driver
{
    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        S21_HangmanGUI_Medium game = new S21_HangmanGUI_Medium();
        main.add(game);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(600,500);
        main.setTitle("Hangman");
        main.setVisible(true);
        main.setResizable(false);
    }
}
