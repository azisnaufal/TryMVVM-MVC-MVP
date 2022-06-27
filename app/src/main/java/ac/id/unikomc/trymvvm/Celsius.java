package ac.id.unikomc.trymvvm;

public class Celsius {
    private double celsius;

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double toReamur() {
        return 0.8 * celsius;
    }

    public double toFahrenheit() {
        return (1.8 * celsius) + 32;
    }
}
