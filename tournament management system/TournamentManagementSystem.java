package projects.tournify;

import java.io.IOException;
import java.util.ArrayList;

public class TournamentManagementSystem {

    static PlayerCollection pc;
    static MatchSchedule ms;
    private static final String file = "History.dat";

    public TournamentManagementSystem(int flag) {
        pc = new PlayerCollection();
        ms = new MatchSchedule();
    }

    public TournamentManagementSystem() {
    }

    public TournamentManagementSystem(String f) {

        pc = new PlayerCollection();
        try {
            pc.loadPlayers(file);
        } catch (java.io.FileNotFoundException exp) {
            System.out.println("The data file, 'History.dat' doesn't exist. Please create an empty file named 'History.dat'");
            System.exit(0);
        } catch (java.io.EOFException exp) {
            // empty cars.dat file, this error should be ignored
        } catch (java.io.IOException exp) {
            System.out.println("The data file, 'History.dat' is possibly corrupted. Please delete it and create a new empty data file named History.dat");
            System.exit(0);
        } catch (Exception exp) {
            System.out.println("There was an error loading 'History.dat'. Try deleting and creating a new empty file named 'History.dat'");
            exp.printStackTrace();
            ms = new MatchSchedule();
            return;
        }

        ms = new MatchSchedule(pc.getAllTeams());
    }

    public void addNewPlayer(Player p) throws SameTeamException {
        if (pc.getTeamIndex(p.getTeamName()) == -1) {
            System.out.println("There is no team with the name " + p.getTeamName());
        }
        pc.addPlayer(p);
    }

    public void addNewTeam(Team t) throws SameTeamException {
        pc.addTeam(t);
    }

    public void addNewMatch(String team1, String team2, int team1Points, int team2Points) {
        ArrayList<Team> allTeams = pc.getAllTeams();
        int index1 = pc.getTeamIndex(team1);
        int index2 = pc.getTeamIndex(team2);
        if (index1 == -1 || index2 == -1) {
            System.out.println("Invalid team name");
            System.exit(0);
        }
        ms.addMatch(new Match(allTeams.get(index1), allTeams.get(index2), team1Points, team2Points));
    }

    public ArrayList<Team> getLeaderboards() {
        return pc.getLeaderboards();
    }

    public ArrayList<Match> getMatchSchedule() {
        return ms.getMatches();
    }

    public ArrayList<Team> getAllTeams() {

        ArrayList<Team> temp;
        temp = new ArrayList<>(pc.getAllTeams());
        return temp;
    }

    public ArrayList<Team> getDummyLeaderboards() throws SameTeamException {
        System.out.println("Test Of Player Collection ");

        Player p1 = new Player("name1", "height", "experience", "position", 1, 1, 1,
                "team", 1);
        Player p2 = new Player("name2", "height", "experience", "position", 2, 1, 1,
                "team", 1);
        Player p3 = new Player("name3", "height", "experience", "position", 3, 1, 1,
                "team", 1);

        Team t1 = new Team("TeamName1", p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);

        Player p4 = new Player("name4", "height", "experience", "position", 4, 4, 4,
                "team", 4);
        Player p5 = new Player("name5", "height", "experience", "position", 5, 5, 5,
                "team", 5);
        Player p6 = new Player("name6", "height", "experience", "position", 6, 6, 6,
                "team", 6);

        Team t2 = new Team("TeamName2", p4);
        t2.addPlayer(p5);
        t2.addPlayer(p6);
        t1.updatePoints(2);
        t1.updatePoints(2);
        t1.updatePoints(1);
        t2.updatePoints(2);
        t2.updatePoints(2);
        t2.updatePoints(2);
        t2.updatePoints(2);

        PlayerCollection dummy = new PlayerCollection(t1);

        dummy.addTeam(t2);
        return dummy.getLeaderboards();

    }

    public ArrayList<Team> getAllDummyTeams() throws SameTeamException {
        System.out.println("Test Of Player Collection ");

        Player p1 = new Player("name1", "height", "experience", "position", 1, 1, 1,
                "team", 1);
        Player p2 = new Player("name2", "height", "experience", "position", 2, 1, 1,
                "team", 1);
        Player p3 = new Player("name3", "height", "experience", "position", 3, 1, 1,
                "team", 1);

        Team t1 = new Team("TeamName1", p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);

        Player p4 = new Player("name4", "height", "experience", "position", 4, 4, 4,
                "team", 4);
        Player p5 = new Player("name5", "height", "experience", "position", 5, 5, 5,
                "team", 5);
        Player p6 = new Player("name6", "height", "experience", "position", 6, 6, 6,
                "team", 6);

        Team t2 = new Team("TeamName2", p4);
        t2.addPlayer(p5);
        t2.addPlayer(p6);

        PlayerCollection dummy = new PlayerCollection(t1);

        dummy.addTeam(t2);

        return dummy.getAllTeams();
    }

    public ArrayList<Player> getAllPlayers() {
        return pc.getAllPlayers();
    }

    public ArrayList<Player> getAllDummyPlayers() throws SameTeamException {
        System.out.println("Test Of Player Collection ");

        Player p1 = new Player("name1", "height", "experience", "position", 1, 1, 1,
                "team", 1);
        Player p2 = new Player("name2", "height", "experience", "position", 2, 1, 1,
                "team", 1);
        Player p3 = new Player("name3", "height", "experience", "position", 3, 1, 1,
                "team", 1);

        Team t1 = new Team("TeamName1", p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);

        Player p4 = new Player("name4", "height", "experience", "position", 4, 4, 4,
                "team", 4);
        Player p5 = new Player("name5", "height", "experience", "position", 5, 5, 5,
                "team", 5);
        Player p6 = new Player("name6", "height", "experience", "position", 6, 6, 6,
                "team", 6);

        Team t2 = new Team("TeamName2", p4);
        t2.addPlayer(p5);
        t2.addPlayer(p6);

        PlayerCollection dummy = new PlayerCollection(t1);

        dummy.addTeam(t2);

        return dummy.getAllPlayers();
    }

    public ArrayList<Player> getTeamPlayers(String team) {
        ArrayList<Team> allTeams = pc.getAllTeams();
        int index = pc.getTeamIndex(team);
        if (index == -1) {
            System.out.println("Invalid team name");
            System.exit(0);
        }
        return allTeams.get(index).getAllPlayers();
    }

    public boolean savePlayers() throws IOException {
        try {
            pc.savePlayers(file);
            return true;
        } catch (java.io.IOException exp) {
            return false;
        }
    }

    public void saveAndClose() throws IOException {
        pc.savePlayers(file);
        System.exit(0);
    }

}
