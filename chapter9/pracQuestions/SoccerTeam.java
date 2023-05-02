public class SoccerTeam {
    private int wins;
    private int losses;
    private int ties;
    private static int totalGames;
    private static int totalGoals;

    public void played(SoccerTeam other, int myScore, int otherScore) {
        if (myScore > otherScore) {
            wins++;
            other.losses++;
        } else if (myScore < otherScore) {
            losses++;
            other.wins++;
        } else {
            ties++;
            other.ties++;
        }
        totalGames++;
        totalGames = otherScore + myScore;
    }

    public int returnPoints() {
        return (wins * 2 + ties);
    }

    public void reset() {
        wins = 0;
        ties = 0;
        losses = 0;
    }

    public static void startTournament() {
        totalGoals = 0;
    }

    public static int getTotalScore() {
        return totalGoals;
    }

    public static int getTotalGames() {
        return totalGoals;
    }

}