package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   Button logbutton, helpbutton;
    EditText logString, passString, nick;
    TextView welcomeText;
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logbutton = (Button) findViewById(R.id.LogButton);
        helpbutton = (Button) findViewById(R.id.HelpButton);
        logString = (EditText) findViewById(R.id.LogString);
        welcomeText = (TextView) findViewById(R.id.WelcomeText);
        passString = (EditText) findViewById(R.id.PassString);
        nick = findViewById(R.id.Nick);
        back = (View) findViewById(R.id.Back);
        back.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        View.OnClickListener onClBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.LogButton:
                        String templog = logString.getText().toString();
                        String temppass = passString.getText().toString();
                        if ((templog.equals(getString(R.string.checkLogin))) & (temppass.equals(getString(R.string.checkPassword)))) {
                            Intent intent = new Intent(MainActivity.this, Menu.class);
                            if (!(nick.getText().toString().equals(""))) {
                                intent.putExtra("username", nick.getText().toString());
                            } else intent.putExtra("username", R.string.User);
                            logString.setText("");
                            passString.setText("");
                            nick.setText("");
                            startActivity(intent);
                        } else
                            welcomeText.setText(R.string.Wrong);
                        break;
                    case R.id.HelpButton:
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Login: oleg Password: 42", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                }
            }
        };
        logbutton.setOnClickListener(onClBtn);
        helpbutton.setOnClickListener(onClBtn);
    }
}
