package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Equation extends AppCompatActivity {

    EditText varA, varB, varC;
    TextView EquText, solveText;
    Button Solve;
    Switch switcher;
    View eqback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);
        Solve = (Button) findViewById(R.id.Solve);
        varA = (EditText) findViewById(R.id.varA);
        varB = (EditText) findViewById(R.id.varB);
        varC = (EditText) findViewById(R.id.varC);
        EquText = (TextView) findViewById(R.id.EquText);
        solveText = (TextView) findViewById(R.id.Solvetext);
        switcher = (Switch) findViewById(R.id.switch2);
        eqback = (View) findViewById(R.id.eqback);
        eqback.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        Solve.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((varA.getText().toString()!="")&(varB.getText().toString()!="")&(varC.getText().toString()!="")) {
                    double a = Double.parseDouble(varA.getText().toString());
                    double b = Double.parseDouble(varB.getText().toString());
                    double c = Double.parseDouble(varC.getText().toString());
                    double d = b * b - 4 * a * c;
                    if (a == 0.0) {
                        solveText.setText(("x = " + (-b / c)));
                    } else if (d < 0) {
                        solveText.setText(("No solution"));
                    } else {
                        double x1 = (-b + Math.sqrt(d)) / (2 * a);
                        double x2 = (-b - Math.sqrt(d)) / (2 * a);
                        solveText.setText("x1 = " + x1 + "   x2 = " + x2);

                    }
                }
            }
        });
        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    eqback.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                } else eqback.setBackgroundColor(getResources().getColor(R.color.colorDarkBlue));
            }
        });
    }
}
