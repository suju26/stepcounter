package com.example.stepcounter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener{

	private SensorManager sensorManager;
	private TextView count;
	boolean activityRunning;
	
	
	public void buttonClickFunction(View v)
	{
	            Intent intent = new Intent(this, CalorieActivity.class);
	            startActivity(intent);
	        }
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		count=(TextView) findViewById(R.id.count);
		sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);	
		
	}
	@Override
	protected void onResume(){
		super.onResume();
		activityRunning=true;
		Sensor countSensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
		if(countSensor != null){
			sensorManager.registerListener(this, countSensor,SensorManager.SENSOR_DELAY_UI);			
		}else{
			Toast.makeText(this, "Count sensor is not available", Toast.LENGTH_LONG).show();
			
		}
		
	}
 @Override
 protected void onPause(){
	 super.onPause();
	 activityRunning=true;
	 Sensor countSensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
		if(countSensor != null){
			sensorManager.registerListener(this, countSensor,SensorManager.SENSOR_DELAY_UI);			
		}else{
			Toast.makeText(this, "Count sensor is not available", Toast.LENGTH_LONG).show();
			
		}
	 
 }
 @Override
 public void onSensorChanged(SensorEvent event){
	 if(activityRunning){
		 count.setText(String.valueOf(event.values[0]));
		 
	 }
	 
 }
@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {
	// TODO Auto-generated method stub
	
}

	}

	

