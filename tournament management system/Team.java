package projects.tournify;


import java.util.ArrayList;

/**
 * Stores, sorts and searches Player objects
 * <p>
 * Parameters
 * <ul>
 *  <li> String <b> name </b> -Team name
 *  <li> String <b> TeamImg </b> - Path to the image of team
 *  <li> String <b> description< /b> - Team description
 *  <li> int <b> matchesWon </b> - Matches won by team
 *  <li> int <b> matchesDraw </b> - Matches draw by team
 *  <li> int <b> matchesLost </b> - Matches lost by team
 *  <li> int <b> points </b> - Total points of a team
 * </ul>
 *
 * <p>
 * Constructors:
 * <ul>
 *  <li>public Team(String name, String description)
 *  <li>public Team(String name, Player p)
 * </ul>
 * <p>
 * <p>
 * Methods
 * <ul>
 *  <li>public int addPlayer(Player p)
 *  <li>public int playerCount()
 *  <li>public ArrayList<Player> getAllPlayers()
 *  <li>public String getTeamName()
 *  <li>public void updatePoints(int point)
 *  <li>public ArrayList<String> matchHistory()
 *  <li>public void savePlayers(String file)
 * </ul>
 * <p>
 * <p>
 * COLLABORATORS: Player
 *
 * @author Vishal Singh Rajput
 */

public class Team implements java.io.Serializable {
    private String name;
    private String description;
    private String TeamImg = "";
    private int matchesWon = 0;
    private int matchesDraw = 0;
    private int matchesLost = 0;
    private int points = 0;

    private final ArrayList<Player> player = new ArrayList<>();
    private final ArrayList<String> result = new ArrayList<>();


    /**
     * Construct a team object with the name and description
     */
    public Team(String name, String description) {
        this.name = name.toUpperCase();
        this.description = description;
    }

    public Team(String name, String description, String TeamImg) {
        this.name = name.toUpperCase();
        this.description = description;
        this.TeamImg = TeamImg;
    }

    /**
     * Construct a team object and add a player to it
     */
    public Team(String name, Player p) {
        this.name = name.toUpperCase();
        p.setTeamName(this.name);
        this.player.add(p);
    }

    /**
     * Add a player p to the team
     */
    public void addPlayer(Player p) {
        p.setTeamName(this.getName());
        this.player.add(p);
    }

    /**
     * returns the number of players
     */
    public final int playerCount() {
        return player.size();
    }

    /**
     * return a ArrayList of all players in the team
     */
    public ArrayList<Player> getAllPlayers() {
        return player;
    }

    public final String getTeamName() {
        return getName();
    }

    /**
     * update the team points and the match stats
     *
     * @param point
     */
    public void updatePoints(int point) {
        if (point == 2) {
            result.add("Won");
            matchesWon++;
        } else if (point == 1) {
            result.add("Draw");
            matchesDraw++;
        } else {
            result.add("Lost");
            matchesLost++;
        }
        points += point;
    }

    /**
     * returns a ArrayList of results of matches played by the team
     */
    public ArrayList<String> matchHistory() {
        return result;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public int getMatchesDraw() {
        return matchesDraw;
    }

    public int getPoints() {
        return points;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return (getName() + " ");
    }

    public static void main(String[] args) {
        System.out.println("Team Test");

        Player p1 = new Player("name1", "height", "experience", "position", 1, 1, 1, "team", 1);
        Player p2 = new Player("name2", "height", "experience", "position", 2, 1, 1, "team", 1);
        Player p3 = new Player("name3", "height", "experience", "position", 3, 1, 1, "team", 1);

        Team t = new Team("TeamName", p1);
        ArrayList<Player> tl = t.getAllPlayers();
        t.addPlayer(p2);
        t.addPlayer(p3);
        for (Player piter : tl) {

            System.out.println(piter);
        }

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the TeamImg
     */
    public String getTeamImg() {
        return TeamImg;
    }

    /**
     * @param TeamImg the TeamImg to set
     */
    public void setTeamImg(String TeamImg) {
        this.TeamImg = TeamImg;
    }

}