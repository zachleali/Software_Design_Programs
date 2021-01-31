// Zach Leali
// 10/29/2020
// S5_Scoreboard_Hard

import java.util.ArrayList;
import java.util.List;

/**
 * A class that extends class Game and overrides the classes abstract methods to create a hockey game.
 * @author Zach Leali
 * @see <a href="Game.html#section">Game</a>
 * @see <a href="Basketball.html#section">Basketball</a>
 * @see <a href="Football.html#section">Football</a>
 * @see <a href="Soccer.html#section">Soccer</a>
 */
public class Hockey extends Game
{
    /** The current period of the hockey game.*/
    private int currentPeriod = 1; // 3 periods
    /** The length of each period in hockey.*/
    private static final float lengthOfPeriod = 20.00f; // 20 minutes each period
    /** Period as a string.*/
    private String periodName = "Period";
    /** An ArrayList of ScoringMethod objects.*/
    private List<ScoringMethod> scoringMethodsClass = new ArrayList<>();

    /**
     * Constructor that calls it's super classes constructor and then adds the scoring methods
     * to the ArrayList as ScoringMethod objects which sets up the hockey game.
     * @param team1         Team object team 1
     * @param team2         Team object team 2
     */
    public Hockey(Team team1,Team team2)
    {
        // calling super constructor and adding scoring methods to ArrayList
        super(team1,team2);
        scoringMethodsClass.add(new ScoringMethod("Goal",1));
        scoringMethodsClass.add(new ScoringMethod("Penalty Shot",1));
    }

    @Override
    public int[] getScoresForEachTeam()
    {
        int[] scores = {super.getTeam1().getTeamScore(),super.getTeam2().getTeamScore()};
        return scores;
    }

    @Override
    public void addScore(ScoringMethod scoringMethod, Team team)
    {
        if(scoringMethod.getScore() == 1 && scoringMethod.getName().compareToIgnoreCase("Goal")==0) // goal +1
        {
            team.addToTeamScore(1);
        }
        else if(scoringMethod.getScore() == 1 && scoringMethod.getName().compareToIgnoreCase("Penalty Shot")==0) // penalty shot
        {
            team.addToTeamScore(1);
        }
    }

    @Override
    public void endCurrentPeriod()
    {
        currentPeriod++;
    }

    @Override
    public int getCurrentPeriod()
    {
        return currentPeriod;
    }
    @Override
    public List<ScoringMethod> getScoringMethod()
    {
        return scoringMethodsClass;
    }

    @Override
    public float getLengthOfPeriod()
    {
        return lengthOfPeriod;
    }
    public String getNameOfPeriod()
    {
        return periodName;
    }
}
