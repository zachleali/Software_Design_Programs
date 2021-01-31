// Zach Leali
// 10/29/2020
// S5_Scoreboard_Hard
import java.util.ArrayList;
import java.util.List;

/**
 * A class that extends class Game and overrides the classes abstract methods to create a Basketball game.
 * @author Zach Leali
 * @see <a href="Game.html#section">Game</a>
 * @see <a href="Football.html#section">Football</a>
 * @see <a href="Hockey.html#section">Hockey</a>
 * @see <a href="Soccer.html#section">Soccer</a>
 */
public class Basketball extends Game
{
    /** The current quarter in the basketball game.*/
    private int currentPeriod = 1; // 4 quarters
    /** The length of each quarter in basketball.*/
    private static final float lengthOfPeriod = 12.00f; // 12 minutes per quarter
    /** Quarter as a String.*/
    private String periodName = "Quarter";
    /** An ArrayList of ScoringMethod objects.*/
    private List<ScoringMethod> scoringMethodsClass = new ArrayList<>();

    /**
     * Constructor that calls it's super classes constructor and then adds the scoring methods
     * to the ArrayList as ScoringMethod objects which sets up the basketball game.
     * @param team1         Team object team 1
     * @param team2         Team object team 2
     */
    public Basketball(Team team1,Team team2)
    {
        // calling super constructor and adding scoring methods to ArrayList
        super(team1,team2);
        scoringMethodsClass.add(new ScoringMethod("Free Throw",1));
        scoringMethodsClass.add(new ScoringMethod("2-point shot",2));
        scoringMethodsClass.add(new ScoringMethod("3-point shot",3));
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
        if(scoringMethod.getScore() == 1 && scoringMethod.getName().compareToIgnoreCase("Free Throw")==0) // free throw
        {
            team.addToTeamScore(1);
        }
        else if(scoringMethod.getScore() == 2 && scoringMethod.getName().compareToIgnoreCase("2-point shot")==0) // 2-point shot
        {
            team.addToTeamScore(2);
        }
        else if(scoringMethod.getScore() == 3 && scoringMethod.getName().compareToIgnoreCase("3-point shot")==0)  // 3-point shot
        {
            team.addToTeamScore(3);
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
