package HorseRaceSimulation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class BettingResultController {

    @FXML
    private Label resultLabel;

    @FXML
    private Label balanceLabel;

    @FXML
    public void initialize() {
        HorseProfile betHorse = GameData.getBetHorse();
        double betAmount = GameData.getBetAmount();
        double odds = GameData.getOdds();
        double winnings = 0.0;

        HorseProfile winnerHorse = RaceSimulationController.getWinningHorse();

        if (betHorse == null || winnerHorse == null) {
            resultLabel.setText("No bet was placed or no winner found!");
        } else {
            if (betHorse.equals(winnerHorse)) {
                winnings = betAmount * odds;
                resultLabel.setText("Congratulations! You won: $" + String.format("%.2f", winnings));
            } else {
                winnings = -betAmount;
                resultLabel.setText("Sorry, you lost: $" + String.format("%.2f", -winnings));
            }
            GameData.addBalance(winnings);
        }

        balanceLabel.setText("Your new balance: $" + String.format("%.2f", GameData.getBalance()));
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/MainMenu.fxml"));
            Stage stage = (Stage) resultLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
