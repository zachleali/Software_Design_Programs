// Zach Leali
// 14-22_MorseCode_Medium
// 11/13/2020
import java.util.*;

/**
 * Class that initializes the mapping of morse code codes to letters of the english alphabet
 * plus some punctuation.  Using the mapping, the two methods in this class convert a java String in english
 * to morse code and vice versa.
 * @author Zachary Leali
 * @see <a href="MorseCode_Medium.html#section">MorseCode_Medium</a>
 */
public class MorseCode
{
    /** A HashMap for mapping a given character to a specific string.(English to Morse Code)*/
    private final static HashMap<Character,String> morseToEnglishHashMap = new HashMap<>(); // english to morse code
    /** A HashMap for mapping a given String to a specific Character.(Morse to English)*/
    private final static HashMap<String,Character> englishToMorseHashMap = new HashMap<>(); // morse code to english

    /**
     * Class constructor that sets the mapping for both HashMaps that are used to convert
     * morse code to english and english to morse code.
     */
    public MorseCode()
    {
        // adding all of the mapping
        morseToEnglishHashMap.putIfAbsent('a',".-");
        morseToEnglishHashMap.putIfAbsent('b',"-...");
        morseToEnglishHashMap.putIfAbsent('c',"-.-.");
        morseToEnglishHashMap.putIfAbsent('d',"-..");
        morseToEnglishHashMap.putIfAbsent('e',".");
        morseToEnglishHashMap.putIfAbsent('f',"..-.");
        morseToEnglishHashMap.putIfAbsent('g',"--.");
        morseToEnglishHashMap.putIfAbsent('h',"....");
        morseToEnglishHashMap.putIfAbsent('i',"..");
        morseToEnglishHashMap.putIfAbsent('j',".---");
        morseToEnglishHashMap.putIfAbsent('k',"-.-");
        morseToEnglishHashMap.putIfAbsent('l',".-..");
        morseToEnglishHashMap.putIfAbsent('m',"--");
        morseToEnglishHashMap.putIfAbsent('n',"-.");
        morseToEnglishHashMap.putIfAbsent('o',"---");
        morseToEnglishHashMap.putIfAbsent('p',".--.");
        morseToEnglishHashMap.putIfAbsent('q',"--.-");
        morseToEnglishHashMap.putIfAbsent('r',".-.");
        morseToEnglishHashMap.putIfAbsent('s',"...");
        morseToEnglishHashMap.putIfAbsent('t',"-");
        morseToEnglishHashMap.putIfAbsent('u',"..-");
        morseToEnglishHashMap.putIfAbsent('v',"...-");
        morseToEnglishHashMap.putIfAbsent('w',".--");
        morseToEnglishHashMap.putIfAbsent('x',"-..-");
        morseToEnglishHashMap.putIfAbsent('y',"-.--");
        morseToEnglishHashMap.putIfAbsent('z',"--..");
        morseToEnglishHashMap.putIfAbsent(' ',"   ");
        morseToEnglishHashMap.putIfAbsent('1',".----");
        morseToEnglishHashMap.putIfAbsent('2',"..---");
        morseToEnglishHashMap.putIfAbsent('3',"...--");
        morseToEnglishHashMap.putIfAbsent('4',"....-");
        morseToEnglishHashMap.putIfAbsent('5',".....");
        morseToEnglishHashMap.putIfAbsent('6',"-....");
        morseToEnglishHashMap.putIfAbsent('7',"--...");
        morseToEnglishHashMap.putIfAbsent('8',"---..");
        morseToEnglishHashMap.putIfAbsent('9',"----.");
        morseToEnglishHashMap.putIfAbsent('0',"-----");
        morseToEnglishHashMap.putIfAbsent('.',".-.-.-");
        morseToEnglishHashMap.putIfAbsent('?',"..--..");
        morseToEnglishHashMap.putIfAbsent(',',"--..--");
        Set<Character> lettersAndNumbers = morseToEnglishHashMap.keySet(); // a Set of characters containing the key set from morseMapping
        Collection<String> morseCodes = morseToEnglishHashMap.values(); // a Collection of Strings containing the collection of values from morseMapping
        String[] morseCodeStrings =  morseCodes.toArray(new String[0]); // dumping collection of Strings into new String array
        Character[] lettersAndNumbersString = lettersAndNumbers.toArray(new Character[0]); // dumping set of Characters into new Character array
        for(int i = 0; i < morseCodeStrings.length-1; i++)
        {
            // adding keys and their values to HashMap for english to morse code
            englishToMorseHashMap.putIfAbsent(morseCodeStrings[i],lettersAndNumbersString[i]);
        }
    }


    /**
     * Method convertEnglishToMorse(String myString) takes a String in as the argument and
     * returns a StringBuilder containing the argument String in morse code.
     * @param myString      input String(english)
     * @return              StringBuilder containing morse code
     */
    public StringBuilder convertEnglishToMorse(String myString)
    {
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i <= myString.length()-1;i++)
        {
            // converting each character to lower case, if not already, getting the value from hashmap
            char tmp = myString.charAt(i);
            String tmpString = String.valueOf(tmp).toLowerCase();
            newString.append(morseToEnglishHashMap.get(tmpString.charAt(0))).append("  ");
        }
        return newString; // Morse code
    }

    /**
     * Method convertMorseToEnglish(String myMorse) takes a String in as the argument and returns a
     * StringBuilder containing the argument String in English.
     * @param myMorse       input String(Morse Code)
     * @return              StringBuilder containing english
     */
    public StringBuilder convertMorseToEnglish(String myMorse)
    {
        StringBuilder newString = new StringBuilder();
        char[] morseTicks = new char[myMorse.length()];
        List<Character> myCharacters = new ArrayList<>(); // to hold the value of the mapped keys
        String morseWords = "";
        for (int i = 0; i < myMorse.length(); i++) // setting up char[] from input string
        {
            morseTicks[i] = myMorse.charAt(i);
        }
        for (int i = 0; i < morseTicks.length; i++)
        {
            if (morseTicks[i] != ' ') // adding to the string from char[] values that aren't spaced
            {
                morseWords += morseTicks[i];
            }
            else if (morseTicks[i] == ' ') // if there is a space then add the mapped value of the string to the Character arraylist
            {
                myCharacters.add(englishToMorseHashMap.get(morseWords));
                morseWords = "";
            }
        }
        for (Character word : myCharacters) // inserting the Characters from arraylist into StringBuilder
        {
            if(word != null)
            {
                newString.insert(newString.length(), word);
            }
            if(word == null)
            {
                newString.insert(newString.length()," ");
            }
        }
        return newString;
    }
}
