package HorseRaceSimulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;

public class HorseCustomizerController {

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> breedComboBox;

    @FXML
    private ComboBox<String> colorComboBox;

    @FXML
    private ComboBox<String> symbolComboBox;

    @FXML
    private CheckBox saddleCheckBox;

    @FXML
    private CheckBox horseshoeCheckBox;

    @FXML
    private CheckBox accessoryCheckBox;

    @FXML
    public void initialize() {
        breedComboBox.getItems().addAll("Thoroughbred", "Arabian", "Quarter Horse");
        colorComboBox.getItems().addAll("Brown", "Black", "White", "Grey");
        symbolComboBox.getItems().addAll("♘", "♞", "🐎", "🏇");
    }

    @FXML
    private void saveHorse(ActionEvent event) {
        String name = nameField.getText();
        String breed = breedComboBox.getValue();
        String color = colorComboBox.getValue();
        String symbol = symbolComboBox.getValue();
        boolean hasSaddle = saddleCheckBox.isSelected();
        boolean hasHorseshoes = horseshoeCheckBox.isSelected();
        boolean hasAccessories = accessoryCheckBox.isSelected();

        HorseProfile profile = new HorseProfile(name, breed, color, symbol,
                hasSaddle, hasHorseshoes, hasAccessories);
        GameData.addHorseProfile(profile);

        System.out.println("Saved: " + profile);
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/MainMenu.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
