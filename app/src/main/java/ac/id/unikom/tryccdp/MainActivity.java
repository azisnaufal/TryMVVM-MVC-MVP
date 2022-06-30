package ac.id.unikom.tryccdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText celsius;
    private EditText fahrenheit;
    private EditText reamur;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);

        initView();
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
                presenter.calculateTemperature(editable.toString());
            }
        });
    }

    @Override
    public void showReamur(String reamur) {
        this.reamur.setText(reamur);
    }

    @Override
    public void showFahrenheit(String fahrenheit) {
        this.fahrenheit.setText(fahrenheit);
    }
}