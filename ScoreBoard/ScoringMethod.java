// Zach Leali
// 10/29/2020
// S5_Scoreboard_Hard

/**
 * Class that is used to create an object that has a String instance variable that holds the
 * name of the object scoring method and an integer that holds the score associated with that scoring method.
 * @see <a href="Game.html#section">Game</a>
 * @see <a href="Basketball.html#section">Basketball</a>
 * @see <a href="Hockey.html#section">Hockey</a>
 * @see <a href="Football.html#section">Football</a>
 * @see <a href="Soccer.html#section">Soccer</a>
 * @see <a href="Team.html#section">Team</a>
 */
public class ScoringMethod
{
    /** The name of a scoring method for a specific sport.*/
    private String methodName; // the name of the scoring method as String
    /** The score that is associated with the scoring method for a specific sport.*/
    private int addedScore; // the number that scoring method increases the total score by

    /**
     * Class constructor that creates a ScoringMethod object and sets the name and associated score of the ScoringMethod
     * object.
     * @param methodName        name of scoring method as String
     * @param addedScore        score associated with the scoring method as Integer
     */
    public ScoringMethod(String methodName,int addedScore)
    {
        this.methodName = methodName;
        this.addedScore = addedScore;
    }

    /**
     * Method to returns the associated score of the object.
     * @return          associated score as Integer
     */
    public int getScore() // returns the score to be added
    {
        return addedScore;
    }

    /**
     * Method that returns the name of the scoring method.
     * @return      name of scoring method as String
     */
    public String getName() // returns the name of the scoring method
    {
        return methodName;
    }
}
