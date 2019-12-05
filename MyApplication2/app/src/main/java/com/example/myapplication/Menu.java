package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    Button Camera, Browser, Equation;
    TextView Question, hiName;
    Switch switcher;
    View menuback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Camera = (Button) findViewById(R.id.Camera);
        Browser = (Button) findViewById(R.id.Browser);
        Equation = (Button) findViewById(R.id.Equation);
        Question = (TextView) findViewById(R.id.Question);
        hiName = (TextView) findViewById(R.id.HiName);
        switcher = (Switch) findViewById(R.id.switch1);
        menuback = (View) findViewById(R.id.menuback);
        menuback.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("username");
            hiName.setText(name);
        }
        View.OnClickListener onClBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.Camera:
                        Intent intent3 = new Intent();
                        intent3.setAction(Intent.ACTION_CAMERA_BUTTON);
                        intent3.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_CAMERA));
                        sendOrderedBroadcast(intent3, null);
                        startActivity(intent3);
                        break;
                    case R.id.Browser:
                        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                        startActivity(intent1);
                        break;
                    case R.id.Equation:
                        Intent intent2 = new Intent(Menu.this, Equation.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        Camera.setOnClickListener(onClBtn);
        Browser.setOnClickListener(onClBtn);
        Equation.setOnClickListener(onClBtn);
        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    menuback.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                } else menuback.setBackgroundColor(getResources().getColor(R.color.colorDarkBlue));
            }
        });
    }
}
