package HorseRaceSimulation;

public class GameData {
    private static TrackSettings trackSettings;
    private static HorseProfile horseProfile;

    public static TrackSettings getTrackSettings() {
        return trackSettings;
    }

    public static void setTrackSettings(TrackSettings settings) {
        trackSettings = settings;
    }

    public static HorseProfile getHorseProfile() {
        return horseProfile;
    }

    public static void setHorseProfile(HorseProfile profile) {
        horseProfile = profile;
    }
}
