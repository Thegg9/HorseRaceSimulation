package HorseRaceSimulation;

public class HorseStatistics {
    private int racesParticipated;
    private int wins;
    private int falls;

    public HorseStatistics() {
        this.racesParticipated = 0;
        this.wins = 0;
        this.falls = 0;
    }

    public void incrementRaces() {
        racesParticipated++;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementFalls() {
        falls++;
    }

    public int getRacesParticipated() {
        return racesParticipated;
    }

    public int getWins() {
        return wins;
    }

    public int getFalls() {
        return falls;
    }

    public double getWinRatio() {
        if (racesParticipated == 0) {
            return 0.0;
        }
        return (double) wins / racesParticipated;
    }
}
