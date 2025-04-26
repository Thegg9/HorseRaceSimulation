package HorseRaceSimulation;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private static TrackSettings trackSettings;
    private static List<HorseProfile> horseProfiles = new ArrayList<>();

    public static TrackSettings getTrackSettings() {
        return trackSettings;
    }

    public static void setTrackSettings(TrackSettings settings) {
        trackSettings = settings;
    }

    public static List<HorseProfile> getHorseProfiles() {
        return horseProfiles;
    }

    public static void addHorseProfile(HorseProfile profile) {
        horseProfiles.add(profile);
    }

    public static void clearHorseProfiles() {
        horseProfiles.clear();
    }
}
