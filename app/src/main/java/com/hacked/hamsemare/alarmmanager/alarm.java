package com.hacked.hamsemare.alarmmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class alarm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button back= findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(alarm.this, MainActivity.class);
                startActivity(i);
            }
        });
        EditText time = findViewById(R.id.c_time);
        Button done= findViewById(R.id.done_btn);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time==""){
                    time.s
                }
                Intent j= new Intent(alarm.this, wait.class);
                startActivity(j);
            }
        });

    }
}
