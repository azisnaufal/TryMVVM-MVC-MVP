package ac.id.unikom.tryccdp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Celsius {
    private double celsius;

    private MutableLiveData<Double> reamur;
    private MutableLiveData<Double> fahrenheit;

    public Celsius() {
        this.celsius = 0;
        this.reamur = new MutableLiveData<>();
        this.fahrenheit = new MutableLiveData<>();
    }

    public LiveData<Double> getReamur() {
        return reamur;
    }

    public LiveData<Double> getFahrenheit() {
        return fahrenheit;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void toReamur() {
        double reamur = 0.8 * celsius;
        this.reamur.setValue(reamur);
    }

    public void toFahrenheit() {
        double fahrenheit = (1.8 * celsius) + 32;
        this.fahrenheit.setValue(fahrenheit);
    }
}
