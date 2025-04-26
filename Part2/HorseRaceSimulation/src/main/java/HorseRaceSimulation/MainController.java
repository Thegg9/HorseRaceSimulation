package HorseRaceSimulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private void openTrackDesigner(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/TrackDesignerController.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openHorseCustomizer(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/HorseCustomizer.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void startRace(ActionEvent event) {
        System.out.println("Start Race clicked");
    }

    @FXML
    private void viewStatistics(ActionEvent event) {
        System.out.println("View Statistics clicked");
    }

    @FXML
    private void openBettingSystem(ActionEvent event) {
        System.out.println("Open Betting System clicked");
    }
}
