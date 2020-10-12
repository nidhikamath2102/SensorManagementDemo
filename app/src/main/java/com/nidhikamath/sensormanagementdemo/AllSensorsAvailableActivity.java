package com.nidhikamath.sensormanagementdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AllSensorsAvailableActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private List<Sensor> sensors = new ArrayList<>();
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sensors_available);

        textView = findViewById(R.id.textView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        getSensors();
    }

    private void getSensors() {
        for(Sensor sensor: sensors){
            textView.setText(textView.getText() + "\n" + sensor.getName());
        }
    }
}