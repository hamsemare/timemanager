package com.hacked.hamsemare.alarmmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class wait extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        Button stop= findViewById(R.id.stop_btn);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(wait.this, MainActivity.class);

                startActivity(i);
            }
        });

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        //update every second
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                //Current_time Calculation
                                TextView current_time = findViewById(R.id.current_time);
                                SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
                                //Setting the time zone
                                dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("MST"));
                                current_time.setText(String.valueOf(dateTimeInGMT.format(new Date())));

                                //Set_time Calculation





                            }
                        });
                    }
                }

                catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }
}
