import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BaseChangeGUI_Medium extends JPanel
{
    private char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private String[] numberString = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","X","Y","Z"};
    private int[] integers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
    private final int[] intNumbers = {0,1,2,3,4,5,6,7,8,9};

    JLabel currentBaseLabel;
    JLabel newBaseLabel;
    JTextField currentBase;
    JTextField newBase;


    JLabel numberLabel;
    JTextField numberField;

    JLabel decimalLabel;
    JTextField decimalField;

    JTextArea directions;

    public double convertStringToDouble(String number)
    {
        double x = 0;
        for(int i = 0; i < number.length(); i++)
        {
            for(int j = 0; j < numbers.length; j++)
            {
                if(number.charAt(i) == numbers[j])
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
                    output = numbers[i] + output;
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
        for(int i = 0; i < numbers.length; i++)
        {
            if(base.equals(numberString[i]))
            {
                integerBase = integers[i];
            }
        }
        for(int i = 0; i < number.length(); i++)
        {
            for(int j = 0; j < numbers.length; j++)
            {
                if(number.charAt(i) == numbers[j])
                {
                    x += Math.pow(integerBase,number.length()-i) * integers[j];
                }
            }
        }
        x = x / integerBase;
        convertedToDecimal = String.format("%.0f",x);
        return convertedToDecimal;
    }

    public BaseChangeGUI_Medium()
    {
        super.setBackground(Color.LIGHT_GRAY);
        numberLabel = new JLabel("Number");
        numberField = new JTextField(20);
        add(numberLabel);
        add(numberField);


        currentBaseLabel = new JLabel("Current Base");
        newBaseLabel = new JLabel("New Base");
        currentBase = new JTextField(20);
        newBase = new JTextField(20);

        currentBaseLabel.setLabelFor(currentBase);
        newBaseLabel.setLabelFor(newBase);

        add(currentBaseLabel);
        add(currentBase);

        add(newBaseLabel);
        add(newBase);

        decimalLabel = new JLabel("Output");
        decimalField = new JTextField(20);
        decimalField.setEditable(false);
        add(decimalLabel);
        add(decimalField);

        directions = new JTextArea(2,5);
        directions.setText("Press ENTER with cursor in \n'Number' input box.");
        directions.setEditable(false);
        add(directions);


        KeyListenerText keyHandler = new KeyListenerText();
        numberField.addKeyListener(keyHandler);
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
                for(int i = 0; i < numberString.length; i++)
                {
                    if(newBase.getText().equals(numberString[i]))
                    {
                        for(int j = 0; j < numberField.getText().length(); j++)
                        {
                            z = convertStringToDouble(currentBase.getText());
                            for(double k = z; k < numberString.length; k++)
                            {
                                int doubleToInt = (int) k;
                                if(numberField.getText().charAt(j) == numbers[doubleToInt])
                                {
                                    correctNumber += 1;
                                }
                            }
                        }
                    }
                }
                if(correctNumber == 0 && !newBase.getText().equals("10"))
                {
                    decimalField.setText(convertDecimalToBase(convertBaseToDecimal(numberField.getText(),currentBase.getText()),newBase.getText()));
                }
                if(correctNumber == 0 && newBase.getText().equals("10"))
                {
                    decimalField.setText(convertBaseToDecimal(numberField.getText(),currentBase.getText()));
                }
                if(correctNumber != 0)
                {
                    decimalField.setText("INVALID INPUT FOR CURRENT BASE.");
                }
            }
        }
    }
}
