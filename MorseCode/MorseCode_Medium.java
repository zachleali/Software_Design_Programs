// Zach Leali
// 14-22_MorseCode_Medium
// 11/13/2020

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class MorseCode_Medium extends JPanel sets up the JPanel for the GUI.  Allows the user to type in a string
 * in morse code or in english to convert one to the other.
 * @author Zachary Leali
 * @see <a href="MorseCode.html#section">MorseCode</a>
 */
public class MorseCode_Medium extends JPanel
{
    /** MorseCode object for converting user input strings. */
    private MorseCode converter; // for converting user inputs

    /** JTextField for entering an english String to convert to morse code. */
    private JTextField morseTextField; // converting to morse code from english
    /** JTextField for entering a morse code String to convert to english */
    private JTextField englishTextField; // converting to english from morse code
    /** JTextArea for displaying the results of the conversions. */
    private JTextArea outputText; // displays output results.

    public MorseCode_Medium()
    {
        // initializing GroupLayout
        GroupLayout myLayout = new GroupLayout(this);
        myLayout.setAutoCreateGaps(true);
        myLayout.setAutoCreateContainerGaps(true);

        converter = new MorseCode();

        // JLabels for the JTextFields
        JLabel morseTextLabel = new JLabel("Morse Code to English Text Box:");
        JLabel englishTextLabel = new JLabel("English to Morse Code Text Box:");

        // initializing JTextFields and the JTextArea
        morseTextField = new JTextField(20);
        englishTextField = new JTextField(20);
        outputText = new JTextArea(20,20);
        outputText.setEditable(false); // user shouldn't be able to edit results
        outputText.setLineWrap(true); // wraps if the string is too long

        // setting horizontal and vertical groups of GroupLayout and adding the components
        myLayout.setHorizontalGroup(myLayout.createParallelGroup()
                .addComponent(outputText,0,GroupLayout.DEFAULT_SIZE/2,Short.MAX_VALUE/2)
                .addComponent(englishTextLabel,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(morseTextField,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(morseTextLabel,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(englishTextField,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
        );
        myLayout.setVerticalGroup(myLayout.createSequentialGroup()
                .addComponent(outputText,0,GroupLayout.DEFAULT_SIZE/2,Short.MAX_VALUE/2)
                .addComponent(englishTextLabel,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(morseTextField,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(morseTextLabel,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(englishTextField,0,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
        );
        // adding key listener to morse to english text field
        morseTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
            @Override
            public void keyPressed(KeyEvent e)
            {
                // display results if user presses enter
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    outputText.setText(converter.convertEnglishToMorse(morseTextField.getText()).toString());
                }

            }
            @Override
            public void keyReleased(KeyEvent e) { }
        });
        // adding key listener to english to morse text field
        englishTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
            @Override
            public void keyPressed(KeyEvent e)
            {
                // display results if user presses enter
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    outputText.setText(converter.convertMorseToEnglish(englishTextField.getText()).toString());
                }
            }
            @Override
            public void keyReleased(KeyEvent e) { }
        });

        this.setLayout(myLayout); // setting super Layout to GroupLayout
    }
}
