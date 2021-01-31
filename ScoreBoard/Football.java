// Zach Leali
// 10/29/2020
// S5_Scoreboard_Hard
import java.util.ArrayList;
import java.util.List;

/**
 * A class that extends class Game and overrides the classes abstract methods to create a football game.
 * @author Zach Leali
 * @see <a href="Game.html#section">Game</a>
 * @see <a href="Basketball.html#section">Basketball</a>
 * @see <a href="Hockey.html#section">Hockey</a>
 * @see <a href="Soccer.html#section">Soccer</a>
 */
public class Football extends Game
{
    /** The current quarter of the football game initialized to 1.*/
    private int currentPeriod = 1; // 4 quarters
    /** The length of the quarter.*/
    private static final float lengthOfPeriod = 15.00f; // 15 minutes per quarter
    /** The name of a Quarter as a String.*/
    private String periodName = "Quarter"; // the literal name as String
    /** The scoring methods for football stored in an ArrayList of ScoringMethod objects.*/
    private List<ScoringMethod> scoringMethodsClass = new ArrayList<>(); // ArrayList storing ScoringMethod objects.


    /**
     * Constructor that calls it's super classes constructor and then adds the scoring methods
     * to the ArrayList as ScoringMethod objects which sets up the football game.
     * @param team1         Team object team 1
     * @param team2         Team object team 2
     */
    public Football(Team team1, Team team2)
    {
        // calling super constructor and adding scoring methods to ArrayList
        super(team1,team2);
        scoringMethodsClass.add(new ScoringMethod("Touchdown",6));
        scoringMethodsClass.add(new ScoringMethod("2-point conversion",2));
        scoringMethodsClass.add(new ScoringMethod("extra point",1));
        scoringMethodsClass.add(new ScoringMethod("field goal",3));
        scoringMethodsClass.add(new ScoringMethod("safety",2));
    }

    // returns the score of the game.
    @Override
    public int[] getScoresForEachTeam()
    {
        int[] scores = {super.getTeam1().getTeamScore(),super.getTeam2().getTeamScore()};
        return scores;
    }

    @Override
    public void addScore(ScoringMethod scoringMethod,Team team)
    {
        if(scoringMethod.getScore() == 6 && scoringMethod.getName().compareToIgnoreCase("Touchdown")==0) // touchdown +6
        {
            team.addToTeamScore(6);
        }
        else if(scoringMethod.getScore() == 2 && scoringMethod.getName().compareToIgnoreCase("2-point conversion")==0)  // 2-point conversion +2
        {
            team.addToTeamScore(2);
        }
        else if(scoringMethod.getScore() == 1 && scoringMethod.getName().compareToIgnoreCase("extra point") == 0) // field goal +1
        {
            team.addToTeamScore(1);
        }
        else if(scoringMethod.getScore() == 3 && scoringMethod.getName().compareToIgnoreCase("field goal")==0) // field goal +3
        {
            team.addToTeamScore(3);
        }
        else if(scoringMethod.getScore() == 2 && scoringMethod.getName().compareToIgnoreCase("safety")==0) // safety
        {
            team.addToTeamScore(2);
        }
    }
    @Override
    public void endCurrentPeriod() // increase period by 1
    {
        currentPeriod++;
    }
    @Override
    public int getCurrentPeriod() // returns the current quarter
    {
        return currentPeriod;
    }

    @Override
    public List<ScoringMethod> getScoringMethod() // returns Football scoring methods
    {
        return scoringMethodsClass;
    }

    @Override
    public float getLengthOfPeriod() // returns length of the quarter in Football
    {
        return lengthOfPeriod;
    }

    public String getNameOfPeriod() // returns "Quarter"
    {
        return periodName;
    }
}
