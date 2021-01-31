// Zach Leali
// 14-21_CheckWriter_Medium
// 11/28/2020
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

/**
 * MainGUI is the main class that extends Application to create a GUI
 * where the user can enter a number and the output will show the input
 * number in words.  This program is to simulate writing the word equivalent of a
 * check amount.
 */
public class CheckWriter_GUI extends Application
{

    /** HashMap that maps an integer value to the word equivalent. */
    private HashMap<Integer,String> mapping = new HashMap<>(); // "one","two","three","four"...
    /** Hashmap that maps the integer place value to the word equivalent. */
    private HashMap<Integer,String> mapping2 = new HashMap<>(); // "hundred","thousand","million"...

    /** ArrayList containing character arrays that are used for separating the user input into sections. */
    private List<char[]> myArrayList = new ArrayList<>(); // [1,2,3] , [.,1,5]

    private TextField myField;


    /**
     * createDisplay() initializes the GUI components and the event handler for the user input field.
     * @return          Returns the Scene containing the GUI components.
     * @throws FileNotFoundException        throws if the file cannot be read.
     */
    public Scene createDisplay() throws FileNotFoundException {
        setMapping(); // sets the hashmaps
        Label directions = new Label("Example Input: '123.45' , '654.00'");
        TextArea myArea= new TextArea(); // uneditable text area(display)
        myField = new TextField(); // user input area
        myArea.setText("Output is shown here...");
        myArea.setEditable(false);
        VBox box = new VBox(directions,myField,myArea); // order(user input field, display field)
        Scene myScene = new Scene(box); // setting a new Scene with the components
        myField.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent) // user enter
            {
                myArea.clear(); // clearing display
                String myString = "";
                myArrayList.clear(); // clearing array list for new input
                char[] myChars = myField.getText().toCharArray(); // taking user input as char array
                myString = numberToString(myChars); // calling method to get string(word) equivalent of the number
                myArea.setText(myString); // setting the display
            }
        });
        return myScene;
    }

    /**
     * setMapping() method reads in from the file of numbers 1-100 and their word equivalent and adds each number
     * and it's corresponding word equivalent to the keys and values of a HashMap.
     * @throws FileNotFoundException        Throws if the file cannot be read.
     */
    private void setMapping() throws FileNotFoundException {
        File myFile = new File("myWords.txt"); // creating file
        Scanner myScanner = new Scanner(myFile); // reading file
        while(myScanner.hasNext())
        {
            mapping.putIfAbsent(myScanner.nextInt(),myScanner.next()); // creating mapping between integers and strings
        }
        mapping2.putIfAbsent(3,"hundred"); // for when the number is larger than 100
    }
    /**
     * numberToString(char[] myChars) method takes a char array as input and returns the word equivalent
     * of the String value of the char array.
     * @param myChars           char array
     * @return                  word equivalent of String value of char array.
     */
    private String numberToString(char[] myChars)
    {
        String myString = "";
        if(myChars.length >= 6) // for when the user input is greater than 100
        {
            for(int i = 0; i < myChars.length; i = i+3) // creating max two char arrays
            {
                char[] tmp = new char[3];
                tmp[0] = myChars[i];
                tmp[1] = myChars[i+1];
                tmp[2] = myChars[i+2];
                myArrayList.add(tmp);
            }
            for(char[] tmp: myArrayList)
            {
                String num1 = String.valueOf(tmp[1]);
                String num2 = String.valueOf(tmp[2]);
                if(tmp[0] == '.')
                {
                    myString = myString + " and " + num1 + num2 + "/100"; // after decimal point
                }
                else
                {
                    if((num1+num2).equals("00")) // if number is multiple of 100
                    {
                        myString = myString + mapping.get(Integer.parseInt(String.valueOf(tmp[0]))) + " " + mapping2.get(tmp.length);
                    }
                    else // if number is not multiple of 100
                    {
                        myString = myString + mapping.get(Integer.parseInt(String.valueOf(tmp[0]))) + " " + mapping2.get(tmp.length) + " ";
                        myString = myString + mapping.get(Integer.parseInt(num1 + num2));
                    }
                }
            }
        }
        else if(myChars.length > 3 && myChars.length != 4) // for when the user input is less than 100 but greater than 9
        {
            String num1 = String.valueOf(myChars[3]);
            String num2 = String.valueOf(myChars[4]);
            String num3 = String.valueOf(myChars[0]);
            String num4 = String.valueOf(myChars[1]);
            String fullNum = num3+num4;
            myString = myString + mapping.get(Integer.parseInt(fullNum)) + " and " + num1+num2 + "/100";
        }
        else // for when the user input is less than 10 such as 5.29 or 1.33
        {
            try
            {
                String num1 = String.valueOf(myChars[2]);
                String num2 = String.valueOf(myChars[3]);
                myString = myString + mapping.get(Integer.parseInt(String.valueOf(myChars[0]))) + " and " + num1+num2 + "/100";
            }
            catch(Exception e)
            {
                myField.setText("Invalid input >>> Example('123.00 or 12.29')");
            }

        }
        return myString; // the word equivalent String
    }
    /**
     * Runs the GUI.
     * @param primaryStage          Stage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setScene(createDisplay());
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}
