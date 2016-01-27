package com.example.lasek.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText textKwota,textKurs;
    private Button button1,button2;
    Spinner spinnerWaluty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textKwota = (EditText) findViewById(R.id.kwotaValue);
        textKurs = (EditText) findViewById(R.id.kursValue);
       // addListenerOnSpinnerItemSelection();
    }

    public void addListenerOnSpinnerItemSelection() {
        spinnerWaluty = (Spinner) findViewById(R.id.spinnerWaluty);
        spinnerWaluty.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                RadioButton zlotyButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton bitcoinButton = (RadioButton) findViewById(R.id.radio1);
              //  Toast.makeText(MainActivity.this,
               //        "OnClickListener : " +
                //             "\nSpinner 1 : " + String.valueOf(spinnerWaluty.getSelectedItem()),
                 //     Toast.LENGTH_SHORT).show();
                if (textKwota.getText().length() == 0 || textKurs.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float kwotatValue = Float.parseFloat(textKwota.getText().toString());
                float kursValue = Float.parseFloat(textKurs.getText().toString());
                if (zlotyButton.isChecked()) {
                    textKwota.setText(String
                            .valueOf(ConverterUtil.convertToZloty(kwotatValue,kursValue)));
                    zlotyButton.setChecked(false);
                    bitcoinButton.setChecked(true);
                } else {
                    textKwota.setText(String
                            .valueOf(ConverterUtil.convertToBitcoin(kwotatValue,kursValue)));
                    bitcoinButton.setChecked(false);
                    zlotyButton.setChecked(true);
                }

                break;
        }
    }
}
