package ac.id.unikom.trymvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Celsius> celsius;

    public MainViewModel() {
        celsius = new MutableLiveData<>();
    }

    public LiveData<Celsius> getCelsius() {
        return celsius;
    }

    public void setCelsius(String stringCelsius) {
        if (stringCelsius.isEmpty())
            stringCelsius = "0";

        double parsedCelsius = Double.parseDouble(stringCelsius);

        Celsius celsius = new Celsius();
        celsius.setCelsius(parsedCelsius);

        this.celsius.setValue(celsius);
    }
}
