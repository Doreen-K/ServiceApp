package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                int num;
                for(num=1; num<7; num++){
                    try{
                        if((num == 6)){
                            num= 0;
                        }
                        Log.d("TIMER", "Second" + num);
                        Thread.sleep(1000);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    public void startService(View view){
        startService(new Intent(this,AudioPlayerService.class));
    }
    public void stopService(View view){
        stopService(new Intent(this, AudioPlayerService.class));
    }
}