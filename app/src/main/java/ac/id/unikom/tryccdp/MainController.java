package ac.id.unikom.tryccdp;

public class MainController {
    private MainView view;
    private Celsius model;

    public MainController(MainView view) {
        this.view = view;
        this.model = Celsius.getInstance();
    }

    public void calculateTemperature() {
        String celsius = view.getCelsius();
        if (celsius.isEmpty())
            celsius = "0";

        double parsedCelsius = Double.parseDouble(celsius);
        model.setCelsius(parsedCelsius);

        model.toFahrenheit();
        model.toReamur();
    }
}
