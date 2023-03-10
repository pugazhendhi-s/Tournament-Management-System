package projects.tournify;


/**
 * Class that holds references to team and their points to keep track of them
 */
public class Match {
    private final Team team1;
    private final Team team2;
    private final int team1Points;
    private final int team2Points;
    private final int diff;

    /**
     * Makes a Match object with the parameters
     *
     * @param team1       Object Reference to the team 1
     * @param team2       Object Reference to the team 2
     * @param team1Points Points gained by Team 1
     * @param team2Points Points gained by Team 2
     */
    public Match(Team team1, Team team2, int team1Points, int team2Points) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Points = team1Points;
        this.team2Points = team2Points;
        diff = team1Points - team2Points;
        if (diff > 0) {
            this.team1.updatePoints(2);
            this.team2.updatePoints(0);
        } else if (diff == 0) {
            this.team2.updatePoints(1);
            this.team1.updatePoints(1);
        } else {
            this.team2.updatePoints(2);
            this.team1.updatePoints(0);
        }
    }

    /**
     * utility function that give the difference of points
     *
     * @return difference in points of the two teams
     */
    public final int getDiff() {
        return diff;
    }

    /**
     * @return returns the reference to Team 1
     */
    public final Team getTeam1() {
        return team1;
    }

    /**
     * @return returns the reference to Team 2
     */
    public final Team getTeam2() {
        return team2;
    }

    /**
     * @return returns the points of Team 1
     */
    public final int getTeam1Points() {
        return team1Points;
    }

    /**
     * @return returns the points of Team 2
     */
    public final int getTeam2Points() {
        return team2Points;
    }

}
