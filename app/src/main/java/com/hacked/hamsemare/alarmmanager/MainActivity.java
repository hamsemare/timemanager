package com.hacked.hamsemare.alarmmanager;

import android.annotation.SuppressLint;
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

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button set_alarm= findViewById(R.id.set_btn);
        set_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, alarm.class);
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

                                // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                //LocalDate localDate = LocalDate.now();
                                //Calendar now = Calendar.getInstance();
                                //current_time.setText(String.valueOf(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate) + "\n" + hour + ":" + minute + ":" + second + " " +num));

                                TextView current_time = findViewById(R.id.current_time);
                                SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
                                //Setting the time zone
                                dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("MST"));
                                current_time.setText(String.valueOf(dateTimeInGMT.format(new Date())));



                                /*
                                Integer hour=now.get(Calendar.HOUR_OF_DAY);
                                Integer minute=now.get(Calendar.MINUTE);
                                Integer second=now.get(Calendar.SECOND);
                                String m="am";
                                String a="pm";
                                String num="";
                                if (hour< 12){
                                    num=m;
                                }
                                else{
                                    num=a;
                                    hour=hour-12;
                                }



                                if (hour < 12) {
                                    if (minute == 60) {
                                        minute = 0;
                                        hour++;
                                    }
                                } else {
                                    if (minute == 60) {
                                        minute = 0;
                                        hour = 1;
                                    }
                                }
                                if (second >= 60) {
                                    second = second%60;
                                    minute++;
                                }

                                if (second<10)
                                    current_time.setText(String.valueOf(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate) + "\n" + hour + ":" + minute + ":0" + second));
                                else
                                    current_time.setText(String.valueOf(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate) + "\n" + hour + ":" + minute + ":" + second));
                                */

                            }
                        });
                    }
                }

                catch (InterruptedException e) {
                }
            }
        };

        t.start();

        /*
        //"hh" in pattern is for 12 hour time format and "aa" is for AM/PM
        SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
        //Setting the time zone
        dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("MST"));
        //system_call to print it to the terminal
        //System.out.println(dateTimeInGMT.format(new Date()));
        current_time.setText(String.valueOf(dateTimeInGMT.format(new Date())));
        */

    }

}
