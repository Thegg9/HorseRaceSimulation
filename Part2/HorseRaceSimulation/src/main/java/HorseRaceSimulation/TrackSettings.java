package HorseRaceSimulation;

public class TrackSettings {
    private int laneCount;
    private int trackLength;
    private String trackShape;
    private String weatherCondition;

    public TrackSettings(int laneCount, int trackLength, String trackShape, String weatherCondition) {
        this.laneCount = laneCount;
        this.trackLength = trackLength;
        this.trackShape = trackShape;
        this.weatherCondition = weatherCondition;
    }

    public int getLaneCount() {
        return laneCount;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public String getTrackShape() {
        return trackShape;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    @Override
    public String toString() {
        return "TrackSettings{" +
                "laneCount=" + laneCount +
                ", trackLength=" + trackLength +
                ", trackShape='" + trackShape + '\'' +
                ", weatherCondition='" + weatherCondition + '\'' +
                '}';
    }
}
