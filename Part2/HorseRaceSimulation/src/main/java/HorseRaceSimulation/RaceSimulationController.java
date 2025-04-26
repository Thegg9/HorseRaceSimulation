package HorseRaceSimulation;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class RaceSimulationController {

    private Map<HorseProfile, Boolean> fallenStatus = new HashMap<>();
    private List<HorseProfile> horses;
    private Map<HorseProfile, Double> horsePositions = new HashMap<>();
    private double finishLine;

    @FXML
    private Canvas raceCanvas;

    @FXML
    private Label trackInfoLabel;

    @FXML
    private Label horseInfoLabel;

    private AnimationTimer animationTimer;

    @FXML
    public void initialize() {
        TrackSettings track = GameData.getTrackSettings();
        horses = GameData.getHorseProfiles();

        if (track != null) {
            trackInfoLabel.setText("Track: " + track.getTrackShape() + " | " +
                    track.getTrackLength() + "m | " +
                    track.getWeatherCondition());
            finishLine = track.getTrackLength();
        } else {
            trackInfoLabel.setText("No track configured.");
            finishLine = 1000;
        }

        if (horses != null && !horses.isEmpty()) {
            horseInfoLabel.setText("Horses Loaded: " + horses.size());
            for (HorseProfile horse : horses) {
                horsePositions.put(horse, 0.0);
                fallenStatus.put(horse, false);

            }
        } else {
            horseInfoLabel.setText("No horses loaded.");
        }
    }


    @FXML
    private void startRace(ActionEvent event) {
        GraphicsContext gc = raceCanvas.getGraphicsContext2D();
        double canvasWidth = raceCanvas.getWidth();

        animationTimer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate == 0) {
                    lastUpdate = now;
                    return;
                }

                double elapsedSeconds = (now - lastUpdate) / 1_000_000_000.0;
                lastUpdate = now;

                // Update horse positions
                for (HorseProfile horse : horses) {
                    if (fallenStatus.get(horse)) {
                        continue; // Skip fallen horses
                    }

                    double speedMultiplier = getSpeedMultiplier(horse);
                    double newPosition = horsePositions.get(horse) + (elapsedSeconds * 100 * speedMultiplier);
                    horsePositions.put(horse, newPosition);

                    // Random chance of falling
                    if (Math.random() < getFallChance()) {
                        fallenStatus.put(horse, true);
                        System.out.println(horse.getName() + " has fallen!");
                    }
                }

                // Clear canvas
                gc.clearRect(0, 0, canvasWidth, raceCanvas.getHeight());

                // Draw finish line
                gc.strokeLine(canvasWidth - 50, 0, canvasWidth - 50, 100);

                // Draw each horse at a different height
                int lane = 1;
                for (HorseProfile horse : horses) {
                    double horseX = (horsePositions.get(horse) / finishLine) * (canvasWidth - 50);
                    double horseY = lane * 20;
                    gc.fillText(horse.getSymbol(), horseX, horseY);
                    lane++;
                }

                // Check if any horse won
                for (HorseProfile horse : horses) {
                    if (!fallenStatus.get(horse) && horsePositions.get(horse) >= finishLine) {
                        gc.fillText("🏁", canvasWidth - 30, 20 * horses.indexOf(horse) + 20);
                        announceWinner(horse.getName());
                        stop();
                        return;
                    }
                }
            }
        };

        animationTimer.start();
    }

    @FXML
    private void goBack(ActionEvent event) {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/HorseRaceSimulation/MainMenu.fxml"));
            Stage stage = (Stage) raceCanvas.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double getSpeedMultiplier(HorseProfile horse) {
        double base = 1.0;
        if (horse.getBreed().equals("Thoroughbred")) {
            base = 1.2;
        } else if (horse.getBreed().equals("Arabian")) {
            base = 1.0;
        } else if (horse.getBreed().equals("Quarter Horse")) {
            base = 1.1;
        }

        if (horse.hasSaddle()) {
            base += 0.05;
        }
        if (horse.hasHorseshoes()) {
            base += 0.1;
        }

        return base;
    }
    private double getFallChance() {
        if (GameData.getTrackSettings() == null) {
            return 0.01; // Default very small
        }

        String weather = GameData.getTrackSettings().getWeatherCondition();
        switch (weather) {
            case "Dry":
                return 0.005; // Very rare
            case "Muddy":
                return 0.02;  // Medium chance
            case "Icy":
                return 0.05;  // High chance
            default:
                return 0.01;
        }
    }
    private void announceWinner(String winnerName) {
        System.out.println("🏆 Winner: " + winnerName);

        Stage popupStage = new Stage();
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-alignment: center; -fx-padding: 20;");
        Label label = new Label("🏆 Winner: " + winnerName + " 🏆");
        label.setStyle("-fx-font-size: 24px;");
        Button closeBtn = new Button("OK");
        closeBtn.setOnAction(e -> popupStage.close());
        vbox.getChildren().addAll(label, closeBtn);

        Scene scene = new Scene(vbox, 300, 200);
        popupStage.setTitle("Race Result");
        popupStage.setScene(scene);
        popupStage.show();
    }

}
