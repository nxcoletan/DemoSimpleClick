package sg.edu.rp.c346.id20025835.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnDisplay;
    TextView tv;
    EditText etData;
    ToggleButton tbEnabler;
    RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplay = findViewById(R.id.button);
        tv = findViewById(R.id.textViewDisplay);
        etData = findViewById(R.id.editTextInput);
        tbEnabler = findViewById(R.id.tbEnabler);
        rgGender = findViewById(R.id.rgGender);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc = etData.getText().toString();
                if (abc.isEmpty()) {
                    tv.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this,
                            "Please input something",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int checkedRB= rgGender.getCheckedRadioButtonId();
                    if (checkedRB == R.id.radioButton2) {
                        tv.setText("He said " + abc);
                    } else {
                        tv.setText("She said " + abc);
                    }
                }
            }
        });

        tbEnabler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbEnabler.isChecked()==true) {
                    etData.setEnabled(true);
                    etData.setBackgroundColor(Color.TRANSPARENT);
                }else {
                    etData.setEnabled(false);
                    etData.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
}