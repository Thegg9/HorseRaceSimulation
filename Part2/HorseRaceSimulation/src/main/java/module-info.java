module HorseRaceSimulation {
    requires javafx.controls;
    requires javafx.fxml;

    opens HorseRaceSimulation to javafx.fxml;
    exports HorseRaceSimulation;
}
