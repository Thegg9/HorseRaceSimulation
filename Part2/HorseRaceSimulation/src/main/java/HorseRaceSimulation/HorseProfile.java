package HorseRaceSimulation;

public class HorseProfile {
    private String name;
    private String breed;
    private String color;
    private String symbol;
    private boolean hasSaddle;
    private boolean hasHorseshoes;
    private boolean hasAccessories;

    public HorseProfile(String name, String breed, String color, String symbol,
                        boolean hasSaddle, boolean hasHorseshoes, boolean hasAccessories) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.symbol = symbol;
        this.hasSaddle = hasSaddle;
        this.hasHorseshoes = hasHorseshoes;
        this.hasAccessories = hasAccessories;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean hasSaddle() {
        return hasSaddle;
    }

    public boolean hasHorseshoes() {
        return hasHorseshoes;
    }

    public boolean hasAccessories() {
        return hasAccessories;
    }

    @Override
    public String toString() {
        return "HorseProfile{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", symbol='" + symbol + '\'' +
                ", hasSaddle=" + hasSaddle +
                ", hasHorseshoes=" + hasHorseshoes +
                ", hasAccessories=" + hasAccessories +
                '}';
    }
}
