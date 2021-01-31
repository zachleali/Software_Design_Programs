// Zach Leali
// 10/29/2020
// S5_Scoreboard_Hard
import java.util.List;

/**
 * This abstract class is used to create multiple different objects from different classes with class Game
 * as their super class.  These games are Football, Basketball, Soccer, and Hockey.
 * @author Zach Leali
 * @see <a href="Football.html#section">Football</a>
 * @see <a href="Basketball.html#section">Basketball</a>
 * @see <a href="Hockey.html#section">Hockey</a>
 * @see <a href="Soccer.html#section">Soccer</a>
 */
public abstract class Game
{
    /** Team object used in the constructor to create a game and set team 1 */
    private Team team1; // Team object for team 1
    /** Team object used in the constructor to create a game and set team 2 */
    private Team team2; // Team object for team 2

    /**
     * Class constructor that takes two object references as arguments and sets the teams.
     * @param team1         class Team object reference.
     * @param team2         class Team object reference.
     */
    public Game(Team team1, Team team2)
    {
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * Method used to return a team 1 object.
     * @return      Team object
     */
    public Team getTeam1() // method to use team1
    {
        return team1;
    }

    /**
     * Method used to return a team 2 object.
     * @return      Team object
     */
    public Team getTeam2() // method to use team2
    {
        return team2;
    }

    /**
     * Abstract method to get the scores of each team playing the given sport.  The scores are stored in
     * an integer array.
     * @return      array of integers
     */
    // the array has two elements, [team1 score,team2 score]
    public abstract int[] getScoresForEachTeam();

    /**
     * Abstract method to add to a teams score given a specific scoring method.
     * @param scoringMethod     ScoringMethod object
     * @param team              Team object
     */
    // use to add score to a specific team
    public abstract void addScore(ScoringMethod scoringMethod,Team team);

    /**
     * Abstract method that ends the current period/quarter/half of the game
     */
    public abstract void endCurrentPeriod(); // used for game progression

    /**
     * Abstract method that returns the current period of the game.
     * @return      the current period as an integer
     */
    public abstract int getCurrentPeriod(); // returns the games current period

    /**
     * Abstract method that returns the games scoring methods as an ArrayList.
     * @return      ArrayList of ScoringMethod objects
     */
    public abstract List<ScoringMethod> getScoringMethod(); // ArrayList contains sports scoring methods

    /**
     * Abstract method that returns the length of a period in the particular sport.
     * @return          length of period as a float
     */
    public abstract float getLengthOfPeriod();

    /**
     * Abstract method that returns the name of the sports period name(half,period,quarter...)
     * @return      String
     */
    public abstract String getNameOfPeriod();
}
