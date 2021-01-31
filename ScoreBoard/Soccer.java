// Zach Leali
// 10/29/2020
// S5_Scoreboard_Hard

import java.util.ArrayList;
import java.util.List;

/**
 * A class that extends class Game and overrides the classes abstract methods to create a Soccer game.
 * @author Zach Leali
 * @see <a href="Game.html#section">Game</a>
 * @see <a href="Basketball.html#section">Basketball</a>
 * @see <a href="Hockey.html#section">Hockey</a>
 * @see <a href="Football.html#section">Football</a>
 */
public class Soccer extends Game
{
    /** The current half of the game*/
    private int currentHalf = 1; // 2 halves
    /** The length of each half in a soccer game.*/
    private static final float lengthOfHalf = 45.00f; // each half is 45 minutes long
    /** Period as a string.*/
    private String periodName = "Half";
    /** An ArrayList of ScoringMethod objects.*/
    private List<ScoringMethod> scoringMethodsClass = new ArrayList<>();

    /**
     * Constructor that calls it's super classes constructor and then adds the scoring methods
     * to the ArrayList as ScoringMethod objects which sets up the soccer game.
     * @param team1         Team object team 1
     * @param team2         Team object team 2
     */
    public Soccer(Team team1,Team team2)
    {
        // calling super constructor and adding scoring methods to ArrayList
        super(team1,team2);
        scoringMethodsClass.add(new ScoringMethod("Goal",1));
        scoringMethodsClass.add(new ScoringMethod("Penalty Kick",1));
    }


    @Override
    public int[] getScoresForEachTeam()
    {
        int[] scores = {super.getTeam1().getTeamScore(),super.getTeam2().getTeamScore()};
        return scores;
    }

    @Override
    public void addScore(ScoringMethod scoringMethod, Team team) // Goal,Penalty shot
    {
        if(scoringMethod.getScore() == 1 && scoringMethod.getName().compareToIgnoreCase("Goal")==0) // goal
        {
            team.addToTeamScore(1);
        }
        else if(scoringMethod.getScore() == 1 && scoringMethod.getName().compareToIgnoreCase("Penalty Kick")==0) // penalty kick
        {
            team.addToTeamScore(1);
        }
    }

    @Override
    public void endCurrentPeriod()
    {
        currentHalf++;
    }

    @Override
    public int getCurrentPeriod()
    {
        return currentHalf;
    }

    @Override
    public List<ScoringMethod> getScoringMethod()
    {
        return scoringMethodsClass;
    }

    @Override
    public float getLengthOfPeriod()
    {
        return lengthOfHalf;
    }

    public String getNameOfPeriod()
    {
        return periodName;
    }
}
