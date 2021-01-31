// Zach Leali
// 10/29/2020
// S5_Scoreboard_Hard

/**
 * Class Team is used to create team objects that are used as the arguments when calling a Game class constructor
 * to start a new game.
 * @see <a href="Game.html#section">Game</a>
 * @see <a href="Basketball.html#section">Basketball</a>
 * @see <a href="Hockey.html#section">Hockey</a>
 * @see <a href="Football.html#section">Football</a>
 * @see <a href="Soccer.html#section">Soccer</a>
 * @see <a href="ScoringMethod.html#section">ScoringMethod</a>
 */
public class Team
{
    /** The name of the team.*/
    private String teamName; // the name of the team
    /** The teams score set to zero.*/
    private int teamScore = 0; // setting the teams score to zero

    /**
     * Class constructor is used to create a Team object and set its name.
     * @param teamName      the team name as String
     */
    public Team(String teamName)
    {
        this.teamName = teamName;
    }

    /**
     * Class method that sets the team name.
     * @param teamName      team name as String
     */
    public void setTeams(String teamName) // method to set a Team objects team name
    {
        this.teamName = teamName;
    }

    /**
     * Class method that returns the team name.
     * @return      team name as String
     */
    public String getTeams() // returns the team's name
    {
        return this.teamName;
    }

    /**
     * Class method that returns the score of the team.
     * @return      team score as Integer
     */
    public int getTeamScore() // returns the team's score
    {
        return this.teamScore;
    }

    /**
     * Class method that adds to the team's score.
     * @param add       number to add
     */
    public void addToTeamScore(int add) // adds a score to the team score's total
    {
        teamScore = teamScore + add;
    }

    /**
     * Overridden toString() method to format the team names and team scores.
     * @return      Formatted String
     */
    @Override
    public String toString()
    {
        return String.format("%s:  %d",teamName,teamScore);
    }
}

