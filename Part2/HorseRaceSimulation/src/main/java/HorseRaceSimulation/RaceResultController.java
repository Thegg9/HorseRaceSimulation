package HorseRaceSimulation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.*;

public class RaceResultController {

    @FXML
    private VBox resultBox;

    private List<HorseProfile> horses;
    private Map<HorseProfile, Double> horsePositions;
    private Map<HorseProfile, Boolean> fallenStatus;

    @FXML
    public void initialize() {
        // Get data from static memory
        horses = RaceSimulationController.getHorses();
        horsePositions = RaceSimulationController.getHorsePositions();
        fallenStatus = RaceSimulationController.getFallenStatus();

        // Sort horses by distance traveled (descending)
        horses.sort((h1, h2) -> Double.compare(
                horsePositions.getOrDefault(h2, 0.0),
                horsePositions.getOrDefault(h1, 0.0))
        );

        int rank = 1;
        for (HorseProfile horse : horses) {
            String status = fallenStatus.get(horse) ? "❌ Fallen" : "✅ Finished";
            double distance = horsePositions.getOrDefault(horse, 0.0);

            Label label = new Label(rank + ". " + horse.getName() +
                    " (" + horse.getSymbol() + ") - " +
                    status + " - " +
                    String.format("%.1f", distance) + " meters");

            label.setStyle("-fx-font-size: 16px;");
            resultBox.getChildren().add(label);

            rank++;
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/MainMenu.fxml"));
            Stage stage = (Stage) resultBox.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void viewBettingResult(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/BettingResult.fxml"));
            Stage stage = (Stage) resultBox.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
