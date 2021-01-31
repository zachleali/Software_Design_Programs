# Software_Design_Programs
A collection of the programs written for Introduction to Software Design at The University of Iowa.

## Program 1: BankInheritance
### Problem Statement
For this problem, you must write a program that simulates a banking system that covers multiple different bank accounts.  There should be one super class and three subclasses.  The super class called Account should have instance variables for balance, account number, and account holder.  The account class should also have methods allowing for deposits and withdrawals.  The three subclasses should be a savings account, checking account, and a loan account.  The savings account must contain a method that allows the banker to add interest to the account as well as the methods of Account class.  The checking account must contain a method that prints out a message to the user when the balance of the account overdrafts as well as the methods from Account.  The loan account must contain a method that allows the banker to add interest and a method allowing the banker to make payments on the account.  The driver class should contain a main method that allows a banker to create multiple different bank accounts and use the functionality of the bank accounts.

### Developer Documentation
The Account class is the super class of SavingsAccount, CheckingAccount, and LoanAccount classes.  The Account class has a no argument constructor and a three argument constructor.  The different constructors are for the functionality of the driver class.  The methods addInterest(), printOverDraft(), and makePayment(double) are all empty due to them being overridden in the subclasses to have specific functionality.  The subclass constructors call the super constructor where all three subclasses use the three argument constructor.  The methods in the subclasses call the super classes get methods to change or obtain the values for the accounts balance, account holder, and account number.

The driver class contains a loop that prints to console a list of options to choose from and depending on the options chosen, Account objects are created that point to any of the three subclass objects.  The bank accounts are contained in an ArrayList<Account> which allows for the creation of multiple different accounts of the same type. 
  
### User Documentation
When the main program is ran, the console will prompt the user to choose from a list of options.  The options simulate a banker and allow the user to create three different bank accounts.  When you choose to create a checking, savings, or loan account you must enter a name, account number, and balance for that account.  After creating the account, the list of options will appear again and you will be able to make deposits, withdrawals, add interest, and make payments depending on which account was created.  The list of options will allow you to exit the program by entering the specified number in the options.

## Program 2: BaseChangeGUI
### Problem Statement
For this program, you must create a GUI that has three inputs and one output that can convert a number from one base to another ig.(hex to binary).  The inputs are the number, current base, and desired base, and the output is the converted number.  For the Easy portion, the program must be able to convert a number from hexadecimal to binary(base-16 to base-2) and from decimal to octal(base-10 to base-8).  For the Medium difficulty, you must allow the user to convert any two bases up to base 32.  For this program you may not use Integer class's method parseInt or anything similar. 

### Developer Documentation
This program consists of two classes, S29_BaseChangeGUI_Medium, and S29_BaseChangeGUI_Driver.  The first class extends JPanel and sets up the JPanel in its constructor.  S29_BaseChangeGUI_Medium extends JPanel, has four private JLabel's, four private JTextArea's, and one private JTextField.  There is also a List<Integer>, a List<Character>, a List<String>, and an int[] array.  The class consists of one constructor with no argument that initializes the JPanel components and adds them to the JPanel.  The constructor initializes the three List<>'s to ArrayList<>'s that are used when converting the numbers.  The constructor also creates JLabel objects and JTextArea objects for the number(input) field, the current base field, the new base field, and the output field. The output field uses setEditable(Boolean) and sets it to false so the user cannot change anything about the output. 

The class also consists of three methods.  The first method, public double convertStringToDouble(String number), takes in a String as the argument and converts the String to type double.  The method then returns a double.  The second method, public String convertDecimalToBase(String number, String base), takes two Strings as its arguments and converts the number to the specified base(String base) and returns the converted String.  This method is for converting numbers of base-10 to another base ranging from 2-32.  The third method called, public String convertBaseToDecimal(String number, String base), converts a number of any base to base-10.  The argument "String number" is the number to convert and the argument "String base" is the base of the number to be converted.  The method returns the converted base-10 number as a String.

Inside class S29_BaseChangeGUI_Medium, there is a private class KeyListenerText that implements KeyListener and overrides Keylisteners public method keyPressed.  The method keyPressed is set to be called when the user presses the enter key on the keyboard.  When the enter key is pressed, the output field text is set by calling convertDecimalToBase and convertBaseToDecimal.  The output field is set to an error message and the two converting methods are not called if any of the input values from the user are invalid.

The driver class then creates a JFrame object, creates a S29_BaseChangeGUI_Medium object, and adds the S29_BaseChangeGUI_Medium object to the JFrame.  The JFrame window is then set to un-editable as to keep the layout of the JPanel components clean.

### User Documentation
When S29_BaseChangeGUI_Driver is ran, a window will appear with three input boxes labeled, "number", "current base", "new base" and a field that is greyed out labeled "output".  Then, choose a number to convert along with the base of the number and then choose a base to convert to.  After entering the numbers, make sure the mouse cursor is in any of the three boxes and press enter on the keyboard.  If the current base does not match the number, an error message will appear in the output box as well as when the new base is incorrect.  The program allows the base to base conversion of any two bases from base-2 to base-32.  

## Program 3: Computus
### Problem Statement
Computus is the calculation of the date of Easter in the Christian calendar.  For this program, you must write a Java class that can calculate the month and day of Easter when given a year in the Gregorian calendar.  This program should be able to calculate the dates of Easter over an entire cycle, and display the number of times Easter occurred on each calendar day.  The cycle should be from 0 to 5,700,000 years.  In addition, create a JUnit class to test the Computus program.  The test should include at least 20 entries and the dates must be known prior to testing.  

### Developer Documentation
This program consists of four classes and a JUnit class.  S1Computus_Hard has one constructor with no arguments that takes in an integer year and computes the month and day of Easter in that year.  The two classes, Node and LinkedList, are used to create a linked list of nodes, and the nodes have two children, which are the month and day, and a pointer which points to the next node which would be the next closest possible day of Easter.  The method findTotalDates() uses the LinkedList class and Node class to iterate from 0 to 5,700,000 and each node is a month and day of Easter.  After the method is finished the linked list is printed to the console.  The method printDate() returns a String in (month day, year) format.

The linked list class creates the linked list of nodes by using a method that returns a linked list.  There is also a method printList that takes in a LinkedList object as its argument and prints out each node of the LinkedList.

The node class has a method to obtain the nodes month, day, and number of times the day came up after iterating through a number of years.

The JUnit class tests the method printDate() to test 20 different cases with known dates of a given year.
### User Documentation
When the user runs S1Computus_Hard_Test, the console will prompt the user to type a number into the console.  After the user enters the number, the console will print out the month and day that Easter fell on in that year.  The console will then prompt the user again and ask if the user would like to cycle through 5,700,000 years to see how many times each Easter date occurred.  If the input is 1, then the console prints out the dates, if the input is 2 then the program exits, and if the input is something other than 1 or 2, the console will print out an error message and allow the user to try again.

## Program 4: ImageRotator
### Problem Statement
For this problem, you are to write a program that lets you rotate an image through some number of degrees(0 to 360).  The program should also let the user specify that they want to spin the image continuously.  The speed of the spinning image should be able to be adjusted dynamically. 

### Developer Documentation
This program has one main class that creates the functionality of the GUI.  The public class, S22_ImageRotator_Hard extends JPanel, has a no argument constructor that initializes and adds buttons, text fields, text areas, and a slider.  The constructor also adds an action listener to the three buttons and a slider listener to the slider.  The class overrides JPanel's paintComponent to rotate the image using Graphics2D and AffineTransform.  The overridden method rotates the area where the image is and then draws the image back onto the transformed area.  The private class ButtonFieldHandler calls the classes method setTheta to set the angle of the image.  A timer is used to rotate the image dynamically and also is used to change the speeds of the spinning image by adjusting the delay of the timer. 

The image that rotates in this program is read in using ImageIO to allow for the usage of Graphics2D and AffineTransform on the image.
### User Documentation
When the driver is ran, a window will appear with three buttons, an image in the middle of the window, and a field where you can enter a number.  When you enter a number, the number should be in degrees and the button "Specified Degree" should be pressed to rotate the image the specified number of degrees.  To rotate the image continuously, you must press the start button.  After pressing the start button, you can adjust the speed of the spinning image by moving the slider from left to right or right to left.  The reset button is for stopping the image from spinning and to reset it back to its original position.

## Program 5: PerfectNumbers
### Problem Statement
For this program, you must create a java class that has a class method called isPerfect that can determine whether the number argument is a perfect number.  Using this method, display all of the perfect numbers between 1 and 1000 while also displaying the factors of each perfect number as to confirm that the number is perfect.  

### Developer Documentation
P6_24_PerfectNumbers_easy has a default constructor.  The class has three methods.  The first method takes an integer as input and checks to see if the input number is a perfect number and then returns a boolean.  The second method, printFactors(int), takes an integer as input and returns a String of the factors of that number.  The third method, isPrime(int), takes an integer is input and returns a boolean of false if the input number isn't a prime number, otherwise it returns true.  The method to check to see if the number is prime is used to check if a number is perfect.  The driver class then creates an object of the previous class and prints out all of the numbers between 1 and 1000 that are perfect numbers along with their factors.
### User Documentation
When the program is ran, all of the perfect number and their factors between 1 and 1000 are printed to the console.

## Program 6: HangmanGUI
### Problem Statement
For this problem, create a GUI that implements the game "Hangman" that  refers to these rules [https://en.wikipedia.org/wiki/Hangman_(game)#Overview](https://en.wikipedia.org/wiki/Hangman_(game)#Overview).  The GUI must include the following:
* A place for the word to be guessed and must be hidden so the user cannot see it.
* Number of guesses the guesser has left.
* A display of the users incorrect guesses.
* An area for the user to enter a letter to guess.
* A readout for displaying the number of characters in the word and which ones the guesser has guessed.
* Display of game being over.

Throughout the game, you must also draw a part of the hangman for each incorrect guess from the user.  You must use Graphics or Graphics2D to implement the hangman.
### Developer Documentation
The program consists of two classes.  The main class called S21_HangmanGUI_Medium that extends JPanel and the driver class that initializes a JFrame and adds a S21_HangmanGUI_Medium object.  The main class simulates the hangman GUI.  A file called wordList.txt contains a number of words and each word is added to an ArrayList called wordList.  The constructor initializes the JPanels components which consists of five JLabels, two JTextFields, and two JButtons.  These components are then added to a new layout called newLayout that is a SpringLayout.  The text field letterGuessField and buttons restart and guessButton have action listeners added to them for when the user enters a letter to guess.  The constructor is also where the first word to guess is set and the lines for each letter of the word are added to an ArrayList wordLines that is a container for Line2D objects.  The method paintComponent is overridden to draw the hangman and the amount of the hangman is determined by the number of wrong characters the user has guessed.  There are two action listeners created as private classes.  The first is a KeyListener that waits for the user to press enter on their keyboard and it checks to see if the character is in the word to guess.  If it is not, than the number of wrong characters is incremented.  The repaint() method is then called and paintComponent(...) paints the correct amount of the hangman.  The second action listener implements ActionListener and allows the user to guess the entire word by entering it in the field corresponding to the button and restart the game.  The user can only guess the entire word once and if guess incorrectly the guess button's method setEnabled(Boolean) is set to false.  If the user guesses all of the letters correctly a message is displayed that they won, otherwise when the hangman is fully drawn to the panel, the panel displays game over.
### User Documentation
Start the game by running the driver class S21_HangmanGUI_Driver.java.  The GUI that appears will display and simulate the game Hangman.  To enter a letter to guess you must enter where letters guesses go and press enter on the keyboard.  If you think you know the entire word, you can enter the full word in the field next to the guess button.  You are only allowed one full guess per game.  If the letter guessed is incorrect, the game will add another limb to the hangman starting with the head.  The game will also display the letters you have guessed incorrectly and the number of wins/losses you have acquired.  If the hangman reaches a full body, the game will end and a game over message will be displayed.  If you win, a winning message will be displayed.  The restart button restarts the game and changes the word and can be pressed at any moment of the game.
## Program 7: Scoreboard
### Problem Statement
For this problem, design a software scoreboard systems that can handle the following sports:
* Football
* Basketball
* Hockey
* Soccer

Create a command line interface that allows the user to select a game from the list above and simulate a full game.  Each game must interactively keep score and the interface should be written in a generic way using polymorphism.  Game-specific code in interface is prohibited.  Each game must have there own scoring methods as well as functions for the user to set the names of the home and away teams for the game.  After the game is over, the output must show that the game is in fact over and must show the results.
### Developer Documentation
Each sport has its own class that extends the abstract class Game.  Abstract class game uses to instance variables that are class Team objects.  Each sport extending the class Game calls the super constructor inside its own to initialize the teams.  Each sport class must override the abstract methods from the abstract class and the methods are for getting the score, adding a score, ending current period, getting current period, getting scoring method, and returning the length and name of the period for the specific game.  Each addScore method takes in a ScoringMethod object and Team object as its arguments and uses these to add the specific score from the specific scoring method to the specific team.  The scoring methods are stored in an ArrayList that contains ScoringMethod objects.

The ScoringMethod class contains only two instance variables, the method name and the score associated with that method name.  The class also has two public methods that are used to get the score of that method and get the name of the method.  Each sport class uses an ArrayList containing ScoringMethod objects.

The main method S5_Scoreboard_Hard contains the interface where the user interacts.  The drivers method main simulates a game by using a series of while loops to set the current menu for the user.
### User Documentation
Start the game by running the S5_Scoreboard_Hard program.  The command line interface will then display the first menu.  From the list of sports displayed in the menu, type the number corresponding to the sport choice and press enter.  The game will then ask for team names for the home and away teams.  After entering the names, the game will start and a menu with a series of options will be displayed.  Each teams options are displayed and either team's options can be chosen.  After the user has chosen the end period option the number of times the game allows, the game will be over and the results will be displayed to the window.  To restart the game, run the program again.
## Program 8: OrbitingPlanets
### Problem Statement
For this multithreading problem, create a GUI that allows a user to create a planet orbiting the center star.  A planet is added to the screen when the user left-clicks the screen.  Each planet must be its own thread.  The user must also be able to press keys 1-8 on the keyboard and for each key a moon begins to rotate around the planet.  Each planet can have no more than two moons and each moon must be its own thread.  

### Developer Documentation
The program consists of four classes:  Driver class, Moons class, Planets class, and S19_OrbitingPlanets_Hard class.
S19_OribitingPlanets_Hard extends JPanel and implements Runnable.  The class implements Runnable so the event dispatch thread can wait for the moon and planet threads to update their positions on the screen.  The class uses ArrayLists to hold the Planet objects and Moon objects.  ExecutorService is initialized as a private instance variable and creates a new cached thread pool.  The executorService is used to execute a Planet object thread or a Moon object thread when the specific event is fired.  The distance of each planet thread is set as well as the moon distance from the planets.  A Timer is initialized and started in the constructor.  The private class MyKeyListener is implemented to allow the user to press any keys 1-8 and add up to two moons to a planet thread.  The number of moons per planet are kept track of by using two HashMaps that map the key on the key board to a moon thread.  The classes overridden method run() is used to synchronize the planet threads with the EDT and waits for the planet threads to notify the EDT.  The classes overridden paintComponent creates new Shapes for each planet/moon thread with the calculated position.  The threads notify the EDT when these values are updated so to smooth the simulation in the GUI.

The Planet class implements Runnable.  The classes overridden run() method runs through a while loop that loops as long as the thread is running.  The x and y points are calculated and then the classes public methods setXpoint(..) and setYpoint(..) are called to set the x and y position.  The thread sleeps for 60ms so the GUI has time to process the events.  When the notify() method is called, the EDT than use the get methods for each planet threads x and y location and sets the location of that thread.

The Moon class implements Runnable and calculates its x and y positions relative the the planet it is suppose to rotate.
## User Documentation
Run the program Driver.java.  A GUI will appear with a Star in the center of the screen.  By left-clicking with the mouse on the screen, you can add a planet to the screen that rotates the center star.  The maximum number of planets is equal to eight.  By using keys 1-8 on the keyboard, you can add up to two moons to each planet where the moons rotate the planets while the planets rotate the center star.

Note: Moons cannot be created unless the corresponding planet is created first.
## Program 9: MorseCode
### Problem Statement
For this problem, write an application that reads an English-language statement and converts it to Morse code.  The application must also be able to convert a Morse code statement back into an English-language statement.  Use one blank between each Morse-coded letter and three blanks between each Morse-coded word.


### Developer Documentation
The program consists of a driver class and two other classes.  The first class, MorseCode.java, has two private final static HashMap containers.  The first HashMap called morseToEnglishHashMap has Character as its keys and String as its values. This map is for mapping English letters to its Morse-code equivalent.  The second map is has String keys and Character values and is used for mapping Morse-code letters to the English-language equivalent.  The class constructor adds all of the keys/values to the HashMaps.  The class also has public methods that return a StringBuilder object.  The first method, convertEnglishToMorse(..) takes a String as input and returns a StringBuilder containing the Morse-code equivalent.  The second method, convertMorseToEnglish(..) takes a String as input and returns a StringBuilder containing the English-language equivalent.

MorseCode_Medium extends JPanel and initializes the main components of the GUI.  The constructor initializes the components and adds them to a custom GroupLayout.  The method also creates a MorseCode object to convert the user input.  There is one JTextField for converting Morse-code to English and one JTextField for converting English to Morse-code.  Both fields have Keylisteners and when the user presses enter the outputText and set to the return value of the MorseCode() object variable converter's method call.
### User Documentation
To start the program run the Driver class.  When the GUI appears, there will be two boxes to enter text.  The boxes are labeled with the label just above each box.  To convert English-language text to Morse-code you must type into the field some English text and then press enter on the keyboard.  To convert a Morse-code text to English use the box with the correct label.  The conversion will appear above both of the boxes.
## Program 10: CheckWriter
### Problem Statement
For this program, create an application where a user can input a numeric check amount that's less than 1000 dollars and displays the word equivalent of the amount (i.e. 123.45 or 829.40).

### Developer Documentation
This is a JavaFX program.  The class CheckWriter_GUI extends Application is the main class.  The class has two HashMap containers, an ArrayList, and a TextField.  There is also a file called myWords.txt that have the numbers 1-100 and their word equivalents.  HashMap one and two are both filled in the setMapping() method.  The file of numbers and their word equivalents are read in and set as the keys and values of the first HashMap called mapping.  The second HashMap, mapping2, only has one key and one value and is for allowing inputs such as 800.00 or 200.33 to print out correctly.  The createDisplay() method initializes TextField and a TextArea and adds these to a new VBox for display purposes.  The VBox is then added to a new Scene.  The method then returns the new Scene.  

The method numberToString(char[] myChars) is the method that converts the user input number to the word equivalent.  The input character array gets iterated by multiples of three to create new character arrays with values equal to the original arrays multiple of three positions.  These character arrays are then added to an ArrayList that contains character arrays.  Each array is then iterated through and the values are mapped to the correct word equivalent and added to a string.  The string is then returned and used as the value to set the TextArea of the GUI.   

In the overrideen start method, the primaryStage argument calls the setScene(..) method and sets the Stages scene to the return value of method createDisplay().  The stage then calls the show() method to start the display the GUI.  The main method is used to launch the application.
### User Documentation
To run this program, run CheckWriter_GUI.  Once the GUI appears, you can enter a number in the field.  The number must be in a specific format. 

Acceptable formats ("123.00" , "423.55").

Unacceptable formats("112", "39").



