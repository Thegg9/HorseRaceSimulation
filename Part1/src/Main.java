import java.util.Scanner;

/**
 * The Main class runs the application
 *
 * @author Thegg
 * @version 1.0.0 April 22, 2025
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Horse Race Simulator (Console Version)!");
        System.out.println("You will now enter details for 3 horses.\n");

        Horse[] horses = new Horse[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Horse #" + (i + 1) + ":");

            System.out.print("Enter horse name: ");
            String name = scanner.nextLine();

            System.out.print("Enter a single character or emoji for the horse symbol: ");
            char symbol = scanner.nextLine().charAt(0);

            System.out.print("Enter horse confidence (between 0.0 and 1.0): ");
            double confidence = Double.parseDouble(scanner.nextLine());

            horses[i] = new Horse(symbol, name, confidence);

            System.out.println();
        }

        Race race = new Race(20); // Adjust race length to fit names

        race.addHorse(horses[0], 1);
        race.addHorse(horses[1], 2);
        race.addHorse(horses[2], 3);

        System.out.println("\nStarting the race!\n");
        race.startRace();
    }
}
