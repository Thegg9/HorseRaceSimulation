package HorseRaceSimulation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BettingController {

    @FXML
    private ComboBox<HorseProfile> horseComboBox;

    @FXML
    private TextField betAmountField;

    @FXML
    private Label oddsLabel;

    private Map<HorseProfile, Double> odds = new HashMap<>();
    private static HorseProfile selectedHorse;
    private static double betAmount;
    private static double selectedHorseOdds;

    @FXML
    public void initialize() {
        horseComboBox.getItems().addAll(GameData.getHorseProfiles());

        horseComboBox.setOnAction(event -> {
            selectedHorse = horseComboBox.getValue();
            if (selectedHorse != null) {
                selectedHorseOdds = generateOdds(selectedHorse);
                oddsLabel.setText("Odds for " + selectedHorse.getName() + ": " + String.format("%.2f", selectedHorseOdds) + "x");
            }
        });
    }

    @FXML
    private void confirmBet(ActionEvent event) {
        try {
            betAmount = Double.parseDouble(betAmountField.getText());
            if (selectedHorse == null || betAmount <= 0) {
                oddsLabel.setText("Please select a horse and enter a valid amount!");
                return;
            }

            // Save bet to GameData
            GameData.setBet(selectedHorse, betAmount, selectedHorseOdds);

            oddsLabel.setText("Bet confirmed: " + betAmount + " on " + selectedHorse.getName());

        } catch (NumberFormatException e) {
            oddsLabel.setText("Invalid amount!");
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/MainMenu.fxml"));
            Stage stage = (Stage) horseComboBox.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double generateOdds(HorseProfile horse) {
        Random rand = new Random();
        // Higher speed horses = lower odds (harder to win more)
        double speedFactor = 1.0 / RaceSimulationController.getSpeedMultiplier(horse);
        double randomModifier = 0.5 + rand.nextDouble(); // 0.5 to 1.5
        return Math.max(1.5, speedFactor * randomModifier * 2); // Odds between 1.5x to 4x
    }

    // Expose betting info for RaceResultController
    public static HorseProfile getSelectedHorse() {
        return selectedHorse;
    }

    public static double getBetAmount() {
        return betAmount;
    }

    public static double getSelectedHorseOdds() {
        return selectedHorseOdds;
    }
}
