package com.nidhikamath.sensormanagementdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void proxmity(View view) {
        startActivity(new Intent(this, ProximitySensorActivity.class));
    }

    public void allsensors(View view) {
        startActivity(new Intent(this, AllSensorsAvailableActivity.class));
    }
}