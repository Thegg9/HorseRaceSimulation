//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * The Main class runs the application
 *
 * @author Thegg
 * @version 1.0.0 April 22, 2025
 */
public class Main {
    public static void main(String[] args) {


/*

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
 */
        // to see how IntelliJ IDEA suggests fixing it.
        Horse h = new Horse('♞', "Shadowfax", 0.75);
        System.out.println(h.getName());             // Output: Shadowfax
        System.out.println(h.getSymbol());           // Output: ♞
        System.out.println(h.getConfidence());       // Output: 0.75
        System.out.println(h.getDistanceTravelled()); // Output: 0
        System.out.println(h.hasFallen());           // Output: false

        h.moveForward();
        h.moveForward();
        System.out.println(h.getDistanceTravelled()); // Output: 2


        Race race = new Race(20); // Adjust race length to fit names
        race.addHorse(new Horse('♘', "PIPPI LONGSTOCKING", 0.6), 1);
        race.addHorse(new Horse('♞', "KOKOMO", 0.6), 2);
        race.addHorse(new Horse('2', "EL JEFE", 0.4), 3);  // Use 2 or any symbol

        race.startRace();
    }
}