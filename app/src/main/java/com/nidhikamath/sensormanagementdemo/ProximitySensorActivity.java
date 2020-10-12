package com.nidhikamath.sensormanagementdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener{

    private TextView sensor;
    private SensorManager sensorManager = null;
    private Sensor proximitySensor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        initializeSensor();
        addSensorEventListener();
    }

    private void addSensorEventListener() {
        //sensorManager.registerListener(eventListener, proximitySensor, 2 * 1000 * 1000);
        //sensorManager.registerListener(eventListener, proximitySensor, 0);
    }

    private void initializeSensor() {
        sensor = findViewById(R.id.sensor);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor =  sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, proximitySensor, 0);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("sensor values ", sensorEvent.values[0] + " " + proximitySensor.getMaximumRange());
        if(sensorEvent.values[0] < proximitySensor.getMaximumRange()){
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            sensor.setTextColor(Color.WHITE);
        }else{
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            sensor.setTextColor(Color.BLACK);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}