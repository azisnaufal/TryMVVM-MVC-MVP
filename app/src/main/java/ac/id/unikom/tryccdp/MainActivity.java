package ac.id.unikom.tryccdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText celsius;
    private EditText fahrenheit;
    private EditText reamur;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initViewModel();
        observeTemperature();
    }

    private void observeTemperature() {
        viewModel.getCelsius().observe(this, celsius -> {
            String parsedReamur = getString(R.string.float_to_string, celsius.toReamur());
            String parsedFahrenheit = getString(R.string.float_to_string, celsius.toFahrenheit());

            reamur.setText(parsedReamur);
            fahrenheit.setText(parsedFahrenheit);
        });
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void initView() {
        celsius = findViewById(R.id.celsius);
        fahrenheit = findViewById(R.id.fahrenheit);
        reamur = findViewById(R.id.reamur);

        celsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String celsius = editable.toString();
                viewModel.setCelsius(celsius);
            }
        });
    }
}