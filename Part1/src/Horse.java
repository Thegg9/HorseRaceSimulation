
/**
 * The Horse class represents a single race participant in the textual horse race simulation.
 *@author thegg9
 *
 * @version 1.0.0 April 13, 2025
 */
public class Horse
{
    //Fields of class Horse for encapsulation
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;


    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse.
     *
     * @param horseSymbol the character symbol representing the horse on track
     * @param horseName the name of the horse
     * @param horseConfidence the confidence rating (0 to 1)
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.symbol = horseSymbol;
        this.name = horseName;
        this.confidence = Math.max(0.0, Math.min(1.0, horseConfidence)); // Clamp to [0,1]
        this.distanceTravelled = 0;  // initialiazing with zero.
        this.hasFallen = false;
    }

    public void fall() {
        this.hasFallen = true;
        this.confidence = Math.max(0.0, this.confidence - 0.05);
    }

    public double getConfidence() {
        return this.confidence;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public boolean hasFallen() {
        return this.hasFallen;
    }

    public void moveForward() {
        this.distanceTravelled++;
    }

    public void setConfidence(double newConfidence) {
        this.confidence = Math.max(0.0, Math.min(1.0, newConfidence));
    }

    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
}


