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


