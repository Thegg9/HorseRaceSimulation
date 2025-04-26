package HorseRaceSimulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void openTrackDesigner(ActionEvent event) {
        System.out.println("Track Designer clicked");
        // Here, later, you can load TrackDesigner.fxml
    }

    @FXML
    private void openHorseCustomizer(ActionEvent event) {
        System.out.println("Horse Customizer clicked");
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
