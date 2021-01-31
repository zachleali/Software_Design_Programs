// Zach Leali
// Date: 10/23/2020
// S21_HangmanGUI_Medium

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.security.SecureRandom;

/**
 * Hangman extends the JPanel class to create a GUI that simulates the game of Hangman.  The user is able to guess
 * letters of the word or the entire word.  If the user can only attempt to guess the entire word once per game.
 * @author Zach Leali
 */
public class S21_HangmanGUI_Medium extends JPanel
{
    /** Container for all of the possible words the game uses.*/
    private static List<String> wordList = new ArrayList<>(); // The list of words from the file we read from
    /** File object to initialize as the txt file.*/
    private static File fileOfWords; // The txt file containing the words the game uses
    /** Random number generator used to generate a random word from the list of word */
    private SecureRandom randomWord = new SecureRandom(); // The random number generator to choose a word
    /** ArrayList containing 2D lines.  The number of 2D lines is equal to the length of the random word */
    private List<Line2D> wordLines = new ArrayList<>(); // An ArrayList that contains the 2D lines for letters
    /** ArrayList containing the characters the user has guessed correctly. */
    private List<Character> foundChars = new ArrayList<>(); // An ArrayList to hold the characters guessed correctly
    /** Integer that is used to determine the number of limbs to display of the hangman */
    private int wrongChar = 0; // Variable used to determine how much of the hangman needs to be drawn.
    /** String used as the word to be guessed.*/
    private String wordToGuess;// The word for the user to guess

    /** A JButton allowing the user to restart the game.*/
    private JButton restart; // The button to restart the game
    /** A JButton allowing the user to guess the entire word once. */
    private JButton guessButton; // The button to guess the entire word from text field

    /** A JLabel used to display where the guess the full word. */
    private JLabel guessTheWordLabel; // The Label to display where to enter the entire word
    /** A JTextField where the user enters their guess for the full word. */
    private JTextField guessTheWordField; // The text field where the user tries to guess the full word

    /** A JLabel that shows the user where the incorrect guesses are located. */
    private JLabel wrongGuesses; // The label to show the user all of the wrong letters that have been guessed
    /** A JLabel showing the user where to enter the letter guess. */
    private JLabel guessLabel; // The label telling the user where to enter a single letter
    /** A JTextField where the user can enter a letter as a guess. */
    private JTextField letterGuessField; // The field to guess a letter

    // win/loss JLabels and counts
    /** JLabel displaying the number of wins. */
    private JLabel numberOfWins;
    /** The number of times the user has Won.*/
    private static int wins = 0;
    /** JLabel displaying the number of losses.*/
    private JLabel numberOfLosses;
    /** The number of times the user has lost.*/
    private static int losses = 0;

    /** A boolean used as a way to display certain graphics depending on if the user entered a guess correcly when
     *  attempting to guess the full word.*/
    private boolean userGuessedTheNumber = false; // boolean that allows the user to win when guessing the full word correctly

    public S21_HangmanGUI_Medium()
    {
        super.setBackground(new Color(32,178,170)); // setting background color to light blue.
        SpringLayout newLayout = new SpringLayout();

        wrongGuesses = new JLabel("Wrong Guesses: ");
        guessLabel = new JLabel("Guess : ");
        guessTheWordLabel = new JLabel("Guess the word: ");
        numberOfWins = new JLabel("Wins: " + wins);
        numberOfLosses = new JLabel("Losses: " + losses);

        guessTheWordField = new JTextField(10);
        letterGuessField = new JTextField(3);

        guessButton = new JButton("Guess");
        restart = new JButton("Restart");

        // positions are assigned for each component based on the location of another component using SpringLayout
        newLayout.putConstraint(SpringLayout.WEST,guessTheWordLabel,30,SpringLayout.EAST,letterGuessField);
        newLayout.putConstraint(SpringLayout.WEST,guessTheWordField,5,SpringLayout.EAST,guessTheWordLabel);
        newLayout.putConstraint(SpringLayout.WEST,guessButton,275,SpringLayout.EAST,letterGuessField);
        newLayout.putConstraint(SpringLayout.WEST,letterGuessField,5,SpringLayout.EAST,guessLabel);
        newLayout.putConstraint(SpringLayout.NORTH,wrongGuesses,5,SpringLayout.SOUTH,letterGuessField);
        newLayout.putConstraint(SpringLayout.WEST,restart,385,SpringLayout.EAST,letterGuessField);
        newLayout.putConstraint(SpringLayout.NORTH,numberOfWins,180,SpringLayout.SOUTH,wrongGuesses);
        newLayout.putConstraint(SpringLayout.NORTH,numberOfLosses,190,SpringLayout.SOUTH,wrongGuesses);

        // reading in text file consisting of a list of words
        fileOfWords = new File("wordList.txt");
        try
        {
            Scanner input = new Scanner(fileOfWords);
            while(input.hasNext())
            {
                wordList.add(input.nextLine());
            }
        }
        catch(Exception e) // Prints out that the file cannot be read if the file wasn't read properly.
        {
            System.out.println("File could not be read.");
        }
        wordToGuess = wordList.get(randomWord.nextInt(wordList.size())); // setting the String x to a random word from the wordList.

        // Creates 2D Lines and adds them to an ArrayList comprised of a number of 2D lines that equals the number
        // of letters in the random String x.
        for (int i = 0; i < wordToGuess.length(); i++)
        {
            if (wordLines.isEmpty())
            {
                Line2D line = new Line2D.Double(20, 100, 40, 100);
                wordLines.add(line);
            }
            else
            {
                wordLines.add(new Line2D.Double(wordLines.get(wordLines.size() - 1).getX2() + 20, 100, wordLines.get(wordLines.size() - 1).getX2() + 40, 100));
            }
        }

        // handler for the field the user uses to guess a letter by pressing enter after entering a letter
        TextFieldHandler handler = new TextFieldHandler();
        letterGuessField.addKeyListener(handler);

        // handlers for the restart button, button to guess the full word.
        ButtonFieldHandler handler2 = new ButtonFieldHandler();
        restart.addActionListener(handler2);
        guessButton.addActionListener(handler2);

        // Setting the JPanel layout to the SpringLayout and then adding the components to the JPanel.
        setLayout(newLayout);
        add(restart);
        add(wrongGuesses);
        add(guessLabel);
        add(letterGuessField);
        add(guessTheWordField);
        add(guessTheWordLabel);
        add(guessButton);
        add(numberOfWins);
        add(numberOfLosses);
    }

    /**
     * Overriding the super classes paintComponent(Graphics g) so that specific graphics can be drawn.  This overridden
     * method also displays the hangman, 2D lines for each letter of the word, and a win/lose display.
     * @param g         Graphics
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < wordLines.size(); i++) // drawing the 2D lines from wordLines.
        {
            g2d.draw(wordLines.get(i));
        }
        if(wrongChar != 6) // if the hangman graphic isn't a full body then the correct guesses are drawn to the panel.
        {
            for(int i = 0; i < foundChars.size(); i++) // displaying out all of the corrects that have been correct
            {
                for(int j = 0; j < wordToGuess.length(); j++)
                {
                    if(foundChars.get(i) == wordToGuess.charAt(j))
                    {
                        g2d.drawString(String.valueOf(wordToGuess.charAt(j)),(int) wordLines.get(j).getX1()+6, (int) wordLines.get(j).getY1()-10);
                    }
                }
            }
        }

        /*These are the coordinates for the graphics to show the hangman.*/
        g2d.drawLine(275,320,325,320); // base
        g2d.drawLine(300,240,300,320); // bar
        g2d.drawLine(250,240,300,240);// top
        g2d.drawLine(250,240,250,250); // noose

        // Drawing the head of the hangman(1 guess wrong)
        if(wrongChar == 1)
        {
            g2d.drawOval(240,250,20,20); // head
        }
        // drawing the head and body(2 guesses wrong)
        if(wrongChar == 2)
        {
            g2d.drawOval(240,250,20,20); // head
            g2d.drawLine(250,270,250,300); // body
        }
        // drawing head,body,right arm(3 guesses wrong)
        if(wrongChar == 3)
        {
            g2d.drawOval(240,250,20,20); // head
            g2d.drawLine(250,270,250,300); // body
            g2d.drawLine(250,280,235,270); // right arm
        }
        // drawing head, body, right arm, left arm(4 guesses wrong)
        if(wrongChar == 4)
        {
            g2d.drawOval(240,250,20,20); // head
            g2d.drawLine(250,270,250,300); // body
            g2d.drawLine(250,280,235,270); // right arm
            g2d.drawLine(250,280,265,270); // left arm
        }
        // drawing head, body, right arm, left arm, left leg(5 guesses wrong)
        if(wrongChar == 5)
        {
            g2d.drawOval(240,250,20,20); // head
            g2d.drawLine(250,270,250,300); // body
            g2d.drawLine(250,280,235,270); // right arm
            g2d.drawLine(250,280,265,270); // left arm
            g2d.drawLine(250,300,265,310); // left leg
        }
        // drawing head, body, right arm, left arm, left leg(6 guess wrong), user loses.
        if(wrongChar == 6)
        {
            g2d.drawOval(240,250,20,20); // head
            g2d.drawLine(250,270,250,300); // body
            g2d.drawLine(250,280,235,270); // right arm
            g2d.drawLine(250,280,265,270); // left arm
            g2d.drawLine(250,300,265,310); // left leg
            g2d.drawLine(250,300,235,310); // right leg
            g2d.setFont(new Font("Helvetica",Font.BOLD,25));
            g2d.drawString("YOU LOSE!",220,400);
            for(int j = 0; j < wordToGuess.length(); j++)
            {
                g2d.drawString(String.valueOf(wordToGuess.charAt(j)),(int) (wordLines.get(j).getX1()+(wordLines.get(j).getX2()-wordLines.get(j).getX1())/2.0)-4, (int) wordLines.get(j).getY1()-10);
            }

            if(letterGuessField.isEditable())
            {
                losses += 1;
                numberOfLosses.setText("Losses: " + losses);
            }
            letterGuessField.setEditable(false);// setting these to false forces the user to restart game.
            guessButton.setEnabled(false);
            guessTheWordField.setEditable(false);
        }
        if(foundChars.size() == wordToGuess.length() || userGuessedTheNumber)
        {
            if(letterGuessField.isEditable())
            {
                wins += 1;
                numberOfWins.setText("Wins: " + wins);
            }
            g2d.setFont(new Font("Helvetica",Font.BOLD,25));
            g2d.drawString("YOU WIN!",220,400);
            letterGuessField.setEditable(false); // setting these to false forces the user to restart game.
            guessButton.setEnabled(false);
            guessTheWordField.setEditable(false);
        }
    }

    /** Private class that implements a KeyListener that waits for the user to press enter on the keyboard
     *  when the focus is in either text field.  The letter the user enters as a guess is checked here and specific
     *  operations are performed based on whether the guess is correct or not.
     */
    private class TextFieldHandler implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                int numToCheckEqualGuess = 0;
                String userGuess = letterGuessField.getText().toLowerCase(); // the guess from the user
                boolean updateWrongGuesses = true;
                for(int i = 0; i < wordToGuess.length(); i++) // checking if the letter guess was a correct guess
                {
                    if(wordToGuess.charAt(i) == userGuess.charAt(0))
                    {
                        foundChars.add(userGuess.charAt(0));
                        numToCheckEqualGuess += 1;
                    }
                }
                if(numToCheckEqualGuess == 0)
                {
                    // checks to see if a guessed letter has already been guessed
                    for(int i = 13; i < wrongGuesses.getText().length(); i++)
                    {
                        if(wrongGuesses.getText().charAt(i) == userGuess.charAt(0))
                        {
                            updateWrongGuesses = false;
                        }
                    }
                    if(!updateWrongGuesses) // repeated wrong guess
                    {
                        wrongGuesses.setText(wrongGuesses.getText());
                    }
                    if(updateWrongGuesses) // new wrong guess
                    {
                        wrongChar += 1;
                        wrongGuesses.setText(wrongGuesses.getText() + " " + userGuess.charAt(0)); // I can use an ArrayList and just add the wrong guess to the list and print the list out by setting the label to the array
                    }
                }
                letterGuessField.setText("");
                repaint();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) { }
    }

    /**
     * A private class that implements ActionListener and waits for the user to click on any of the buttons.
     * The buttons that restart the game and guess the full word are the only two components that listen
     * for an action.
     */
    private class ButtonFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // restarts the game with a new word and a new number of 2D lines to match the new word
            if(e.getSource() == restart)
            {
                wordToGuess = wordList.get(randomWord.nextInt(wordList.size())); // random new word
                wordLines.clear();
                wrongChar = 0;
                foundChars.clear();
                wrongGuesses.setText("Wrong Guesses: ");
                guessTheWordField.setText("");
                userGuessedTheNumber = false;
                letterGuessField.setEditable(true);
                guessButton.setEnabled(true);
                guessTheWordField.setEditable(true);
                // creating line graphics for the new word
                for (int i = 0; i < wordToGuess.length(); i++)
                {
                    if (wordLines.isEmpty())
                    {
                        Line2D line = new Line2D.Double(20, 100, 40, 100);
                        wordLines.add(line);
                    }
                    else
                    {
                        wordLines.add(new Line2D.Double(wordLines.get(wordLines.size() - 1).getX2() + 20, 100, wordLines.get(wordLines.size() - 1).getX2() + 40, 100));
                    }
                }
            }
            // checking if user guessed full word and disables the button after.
            if(e.getSource() == guessButton)
            {
                guessButton.setEnabled(false);
                String compare = guessTheWordField.getText();
                if(compare.compareToIgnoreCase(wordToGuess) == 0)
                {
                    foundChars.clear();
                    for(int i = 0; i < wordToGuess.length(); i++)
                    {
                        foundChars.add(wordToGuess.charAt(i));
                    }
                    userGuessedTheNumber = true;
                }
            }
            repaint();
        }
    }
}
