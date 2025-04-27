package HorseRaceSimulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TrackDesignerController {

    @FXML
    private Spinner<Integer> laneSpinner;

    @FXML
    private Spinner<Integer> lengthSpinner;

    @FXML
    private ComboBox<String> shapeComboBox;

    @FXML
    private ComboBox<String> weatherComboBox;

    @FXML
    public void initialize() {
        // Initialize lane spinner (1 to 10 lanes)
        laneSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 3));

        // Initialize length spinner (100 to 5000 meters)
        lengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(100, 5000, 1000));

        // Populate track shapes
        shapeComboBox.getItems().addAll("Oval", "Figure Eight", "Zigzag");

        // Populate weather options
        weatherComboBox.getItems().addAll("Dry", "Muddy", "Icy");
    }

    @FXML
    private void saveTrack(ActionEvent event) {
        int lanes = laneSpinner.getValue();
        int length = lengthSpinner.getValue();
        String shape = shapeComboBox.getValue();
        String weather = weatherComboBox.getValue();

        TrackSettings settings = new TrackSettings(lanes, length, shape, weather);
        GameData.setTrackSettings(settings);
        System.out.println("Saved: " + settings);
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/MainMenu.fxml"));
            Stage stage = (Stage) laneSpinner.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
