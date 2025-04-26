package HorseRaceSimulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameData {
    private static TrackSettings trackSettings;
    private static List<HorseProfile> horseProfiles = new ArrayList<>();
    private static HorseProfile betHorse;
    private static double betAmount;
    private static double odds;
    private static double balance = 1000.0; // Starting balance
    private static Map<HorseProfile, HorseStatistics> horseStats = new HashMap<>();


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
    public static void setBet(HorseProfile horse, double amount, double horseOdds) {
        betHorse = horse;
        betAmount = amount;
        odds = horseOdds;
    }

    public static HorseProfile getBetHorse() {
        return betHorse;
    }

    public static double getBetAmount() {
        return betAmount;
    }

    public static double getOdds() {
        return odds;
    }
    public static double getBalance() {
        return balance;
    }

    public static void addBalance(double amount) {
        balance += amount;
    }

    public static void updateHorseRace(HorseProfile horse) {
        horseStats.computeIfAbsent(horse, k -> new HorseStatistics()).incrementRaces();
    }

    public static void updateHorseWin(HorseProfile horse) {
        horseStats.computeIfAbsent(horse, k -> new HorseStatistics()).incrementWins();
    }

    public static void updateHorseFall(HorseProfile horse) {
        horseStats.computeIfAbsent(horse, k -> new HorseStatistics()).incrementFalls();
    }

    public static Map<HorseProfile, HorseStatistics> getHorseStats() {
        return horseStats;
    }


}
