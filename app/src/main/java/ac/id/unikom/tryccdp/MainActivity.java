package ac.id.unikom.tryccdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText celsius;
    private EditText fahrenheit;
    private EditText reamur;
    private MainController controller;
    private Celsius model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this);
        model = Celsius.getInstance();

        initView();
        observeModel();
    }

    private void observeModel() {
        model.getFahrenheit().observe(this, fahrenheit -> {
            this.fahrenheit.setText(fahrenheit);
        });

        model.getReamur().observe(this, reamur -> {
            this.reamur.setText(reamur);
        });
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
                controller.calculateTemperature();
            }
        });
    }

    @Override
    public String getCelsius() {
        return celsius.getText().toString();
    }
}