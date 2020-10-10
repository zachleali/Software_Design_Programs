import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseChangeGUI_Medium is a class that extends JPanel and when put into a JFrame allows
 * the user to input a number, choose the base of that number and a new base, and the GUI will
 * output the correct number associated with the new base.
 */
public class BaseChangeGUI_Medium extends JPanel
{
    // stringArray and intArray both contain 36 elements but not all 36 elements matter.
    // There are 36 elements so that we can iterate through multiple arrays.
    /** Integer array containing 10 elements 0-9 */
    private int[] intNumbers = {0,1,2,3,4,5,6,7,8,9};
    /** Character ArrayList that will contain numbers 0-9 and letters A-Z as chars */
    private List<Character> charArray;
    /**String ArrayList that will contain numbers 0-35 as strings */
    private List<String> stringArray;
    /**Integer ArrayList that will contain numbers 0-35 as integers */
    private List<Integer> intArray;

    /**Label for the currentBase field*/
    private JLabel currentBaseLabel;
    /**Label for the newBase field*/
    private JLabel newBaseLabel;

    /**Text field for the current base that allows a user to enter the current base.*/
    private JTextField currentBase;
    /**Text field for the new base that allows a user to enter a new base.*/
    private JTextField newBase;

    /**Label for the number field which is the number to convert*/
    private JLabel numberLabel;
    /**Text field for the number the user enters to convert to a new base*/
    private JTextField numberField;

    /**Label for the output field*/
    private JLabel outputLabel;
    /**Text field for the results of the number to be converted to the new base.*/
    private JTextField outputField;

    // The only purpose of this is to let the user know to press enter when the mouse cursor is in
    // the number field.
    /**An uneditable text area for directions*/
    private JTextArea directions;

    /**
     * BaseChangeGUI Constructor that sets up the JPanel for the JFrame.
     * The constructor creates the labels, text areas, and sets up the three
     * ArrayLists.  This is also where the key listener handler is created.
     */
    public BaseChangeGUI_Medium()
    {
        super.setBackground(Color.LIGHT_GRAY);
        numberLabel = new JLabel("Number");
        numberField = new JTextField(20);

        currentBaseLabel = new JLabel("Current Base");
        newBaseLabel = new JLabel("New Base");
        currentBase = new JTextField(20);
        newBase = new JTextField(20);

        currentBaseLabel.setLabelFor(currentBase);
        newBaseLabel.setLabelFor(newBase);

        outputLabel = new JLabel("Output");
        outputField = new JTextField(20);
        outputField.setEditable(false); // set this to false so user can't edit it.

        directions = new JTextArea(2,5);
        directions.setText("Press ENTER for Output.");
        directions.setEditable(false);

        // adding a key listener to the three input fields to allow user to press enter for results.
        KeyListenerText keyHandler = new KeyListenerText();
        numberField.addKeyListener(keyHandler);
        currentBase.addKeyListener(keyHandler);
        newBase.addKeyListener(keyHandler);

        // These three arrays are used to to check the input values from the user and perform whatever operation
        // necessary.  They are also used for checking whether an input from user is a valid input.
        charArray = new ArrayList<>();
        stringArray = new ArrayList<>();
        intArray = new ArrayList<>();
        for(int i = 0; i <= 9; i++)
        {
            String s = String.valueOf(i);
            charArray.add(s.charAt(0));
        }
        for(int i = 65; i <= 90; i++)
        {
            charArray.add((char)i);
        }
        for(int i = 0; i <= 35; i++)
        {
            String s = String.valueOf(i);
            stringArray.add(s);
            intArray.add(i);
        }

        // adding JLabels, JTextFields, and JTextArea to JPanel.
        add(numberLabel);
        add(numberField);
        add(currentBaseLabel);
        add(currentBase);
        add(newBaseLabel);
        add(newBase);
        add(outputLabel);
        add(outputField);
        add(directions);
    }

    /**
     * Class method that takes an input String and converts it to a double.
     * The output is then the converted number.
     * @param number        String to be converted
     * @return              converted String of type double
     */
    public double convertStringToDouble(String number) // This is handy so that parseInt or parseDouble is not needed.
    {
        double x = 0;
        for(int i = 0; i < number.length(); i++)
        {
            for(int j = 0; j < charArray.size(); j++)
            {
                if(number.charAt(i) == charArray.get(j))
                {
                    x += intNumbers[j] * (Math.pow(10,number.length()-i));
                }
            }
        }
        x = x / 10.0;
        return x;
    }

    /**
     * Class method that takes a number of base 10 and converts it to any other base from 2-32.
     * @param number        base-10 number to be converted
     * @param base          base of the number to be converted to.
     * @return              The converted number with the new base.
     */
    public String convertDecimalToBase(String number, String base)
    {
        // String number is a decimal of base-10 and String base is the base to convert the decimal to.
        String output = "";
        double remainder = 0;
        double num = convertStringToDouble(number); // converting String argument to double
        double divisor = convertStringToDouble(base); // converting String argument to double
        while(num >= 1)
        {
            num = num / divisor;
            double round = Math.round((num*100.0))/100.0;
            for(int i = 0; i < divisor; i++)
            {
                remainder =  i/divisor;
                double roundRemainder = Math.round((remainder*100))/100.0; // needed because of rounding errors.
                // adding 0.000000000000001 in this if statements gets rid of some rounding errors.
                if(((round - roundRemainder)) % 1 == 0 || (((round-roundRemainder)+0.000000000000001)) % 1 == 0)
                {
                    output = charArray.get(i) + output;
                    num = round - roundRemainder;
                    i = (int) divisor;
                }
            }
        }
        return output;
    }

    /**
     * Class method that converts a number of specific base to base-10.
     * @param number        number to be converted
     * @param base          the base of the number to be converted
     * @return              the converted number as base-10
     */
    public String convertBaseToDecimal(String number,String base)
    {
        // String base is the base of String number and the method converts it to base-10.
        double x = 0;
        double integerBase = 0;
        String convertedToDecimal = "";
        for(int i = 0; i < charArray.size(); i++)
        {
            if(base.equals(stringArray.get(i)))
            {
                integerBase = intArray.get(i);
            }
        }
        for(int i = 0; i < number.length(); i++)
        {
            for(int j = 0; j < charArray.size(); j++)
            {
                if(number.charAt(i) == charArray.get(j))
                {
                    x += Math.pow(integerBase,number.length()-i) * intArray.get(j);
                }
            }
        }
        x = x / integerBase;
        convertedToDecimal = String.format("%.0f",x);
        return convertedToDecimal;
    }

    /**
     * Private class KeyListenerText used for implementing a key listener that sets the
     * output field as the results of the base conversion when the user presses enter.
     */
    private class KeyListenerText implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyReleased(KeyEvent e) { }

        /**
         * When the user presses enter when the cursor is in the number field, the output field's text will be
         * set as the result.  The output text depends the correctness of the inputs from the number field as well
         * as the base fields.
         * @param e         key event
         */
        @Override
        public void keyPressed(KeyEvent e)  // when the user presses enter on the keyboard
        {
            int correctNumber = 0; // set to 0 every time enter is pressed as a way to choose correct output for output field.
            double z = 0; // set to 0 every time enter is pressed to set z to the currentBase fields value as a double.
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                outputField.setText(""); // set this to an empty string to reset the output field's text.
                for(int i = 0; i < stringArray.size(); i++)
                {
                    if(newBase.getText().equals(stringArray.get(i)))
                    {
                        for(int j = 0; j < numberField.getText().length(); j++)
                        {
                            z = convertStringToDouble(currentBase.getText());
                            for(double k = z; k < stringArray.size(); k++)
                            {
                                int doubleToInt = (int) k;
                                if(numberField.getText().charAt(j) == charArray.get(doubleToInt))
                                {
                                    correctNumber += 1;
                                }
                            }
                        }
                    }
                }

                // sets output field when the new base is NOT equal to 10
                if(correctNumber == 0 && !newBase.getText().equals("10") && ((convertStringToDouble(newBase.getText()) <= 32) || (convertStringToDouble(currentBase.getText())) <= 32))
                {
                    outputField.setText(convertDecimalToBase(convertBaseToDecimal(numberField.getText().toUpperCase(),currentBase.getText()),newBase.getText()));
                }

                // sets output field when the new base IS equals to 10
                if(correctNumber == 0 && newBase.getText().equals("10") && ((convertStringToDouble(newBase.getText()) <= 32) || (convertStringToDouble(currentBase.getText())) <= 32))
                {
                    outputField.setText(convertBaseToDecimal(numberField.getText().toUpperCase(),currentBase.getText()));
                }

                // prints off different information based on which field had an incorrect input.
                if(correctNumber != 0 || convertStringToDouble(newBase.getText())  > 32 || convertStringToDouble(currentBase.getText()) > 32)
                {
                    if(convertStringToDouble(newBase.getText()) > 32 && convertStringToDouble(currentBase.getText()) <= 32)
                    {
                        outputField.setText("NEW BASE IS INVALID.");
                    }
                    else if(convertStringToDouble(currentBase.getText()) > 32 && convertStringToDouble(newBase.getText()) <= 32)
                    {
                        outputField.setText("INVALID INPUT FOR CURRENT BASE.");
                    }
                    else if(convertStringToDouble(newBase.getText()) > 32 && convertStringToDouble(currentBase.getText()) > 32)
                    {
                        outputField.setText("NEW AND CURRENT BASE INVALID.");
                    }
                    else
                    {
                        outputField.setText("INVALID NUMBER INPUT.");
                    }
                }
            }
        }
    }
}
