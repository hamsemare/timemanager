package com.hacked.hamsemare.alarmmanager;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import steelkiwi.com.library.DotsLoaderView;

public class loader extends AppCompatActivity {
    DotsLoaderView loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        loader=(DotsLoaderView)findViewById(R.id.loader);
        show_loader();
    }

    private void show_loader() {
        AsyncTask<String, String, String> loadAsync= new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
                loader.show();
            }

            @Override
            protected String doInBackground(String... strings) {
                try{
                    Thread.sleep(10000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                return "done";
            }

            @Override
            protected void onPostExecute(String s) {
                if (s.equals("done")){
                    loader.hide();
                }
            }
        };
        loadAsync.execute();
    }


}
