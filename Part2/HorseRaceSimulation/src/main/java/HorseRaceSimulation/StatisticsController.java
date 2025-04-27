package HorseRaceSimulation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.Map;

public class StatisticsController {

    @FXML
    private VBox statsBox;

    @FXML
    public void initialize() {
        Map<HorseProfile, HorseStatistics> stats = GameData.getHorseStats();

        if (stats.isEmpty()) {
            statsBox.getChildren().add(new Label("No race data available."));
            return;
        }

        for (Map.Entry<HorseProfile, HorseStatistics> entry : stats.entrySet()) {
            HorseProfile horse = entry.getKey();
            HorseStatistics stat = entry.getValue();

            Label label = new Label(horse.getName() + " (" + horse.getSymbol() + ")\n" +
                    "- Races: " + stat.getRacesParticipated() + "\n" +
                    "- Wins: " + stat.getWins() + "\n" +
                    "- Falls: " + stat.getFalls() + "\n" +
                    "- Win Ratio: " + String.format("%.2f", stat.getWinRatio() * 100) + "%");

            label.setStyle("-fx-font-size: 16px;");
            statsBox.getChildren().add(label);
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/MainMenu.fxml"));
            Stage stage = (Stage) statsBox.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
