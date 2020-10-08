import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class BaseChangeGUI_Medium extends JPanel
{
    private int[] intNumbers = {0,1,2,3,4,5,6,7,8,9};
    private List<Character> charArray;
    private List<String> stringArray;
    private List<Integer> intArray;

    private JLabel currentBaseLabel;
    private JLabel newBaseLabel;

    private JTextField currentBase;
    private JTextField newBase;

    private JLabel numberLabel;
    private JTextField numberField;

    private JLabel decimalLabel;
    private JTextField decimalField;

    private JTextArea directions;

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

        decimalLabel = new JLabel("Output");
        decimalField = new JTextField(20);
        decimalField.setEditable(false);

        directions = new JTextArea(2,5);
        directions.setText("Press ENTER with cursor in \n'Number' input box.");
        directions.setEditable(false);

        KeyListenerText keyHandler = new KeyListenerText();
        numberField.addKeyListener(keyHandler);

        // Character array and String array are used to check input for correct/possible base.
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

        add(numberLabel);
        add(numberField);
        add(currentBaseLabel);
        add(currentBase);
        add(newBaseLabel);
        add(newBase);
        add(decimalLabel);
        add(decimalField);
        add(directions);
    }

    public double convertStringToDouble(String number)
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

    public String convertDecimalToBase(String number, String base)
    {
        String output = "";
        double remainder = 0;
        double num = convertStringToDouble(number);
        double divisor = convertStringToDouble(base);
        while(num >= 1)
        {
            num = num / divisor;
            double round = Math.round((num*100.0))/100.0;
            for(int i = 0; i < divisor; i++)
            {
                remainder =  i/divisor;
                double roundRemainder = Math.round((remainder*100))/100.0;
                if(((round - roundRemainder)) % 1 == 0)
                {
                    output = charArray.get(i) + output;
                    num = round - roundRemainder;
                    i = (int) divisor;
                }
            }
        }
        return output;
    }

    public String convertBaseToDecimal(String number,String base)
    {
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

    private class KeyListenerText implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyReleased(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e)
        {
            int correctNumber = 0;
            double z = 0;
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                decimalField.setText("");
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
                if(correctNumber == 0 && !newBase.getText().equals("10"))
                {
                    decimalField.setText(convertDecimalToBase(convertBaseToDecimal(numberField.getText().toUpperCase(),currentBase.getText()),newBase.getText()));
                }
                if(correctNumber == 0 && newBase.getText().equals("10"))
                {
                    decimalField.setText(convertBaseToDecimal(numberField.getText().toUpperCase(),currentBase.getText()));
                }
                if(correctNumber != 0)
                {
                    decimalField.setText("INVALID INPUT FOR CURRENT BASE.");
                }
            }
        }
    }
}
