package edu.txstate.sl20.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double dblConvertRate = 2.2;
    double dblWeightEntered ;
    double dblConvertedWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weightOfPatient = findViewById(R.id.txtWeightOfPatient);
        RadioButton poundToKilo = findViewById(R.id.radPoundToKilo);
        RadioButton kiloToPound = findViewById(R.id.radKiloToPound);
        Button convertWeight = findViewById(R.id.btnConvert);
        TextView results = findViewById(R.id.txtResults);

        convertWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = "Sam";
                String name2 = "Sam";
                String name3 = name1;
                if (name1 == name2){ //false
                }

                if (name1 == name3){//true
                }

                if (name1.equals(name2)){ //true
                }

                if (weightOfPatient.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "The weight must not be empty.", Toast.LENGTH_LONG);
                    return;
                }

                try {
                    dblWeightEntered = Double.parseDouble(weightOfPatient.getText().toString());
                } catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Invalid Input!", Toast.LENGTH_LONG);
                    return;
                }

                if (poundToKilo.isChecked()){
                    if (dblWeightEntered > 500 || dblWeightEntered <0) {
                        Toast.makeText(MainActivity.this, "The weight must be .......", Toast.LENGTH_LONG);
                        return;
                    } else {
                        dblConvertedWeight = dblWeightEntered / dblConvertRate;
                    }
                } else {
                    dblConvertedWeight = dblWeightEntered*dblConvertRate;
                }

                DecimalFormat tenth = new DecimalFormat("#.#");
                results.setText(tenth.format(dblConvertedWeight));


            }
        });

    }
}