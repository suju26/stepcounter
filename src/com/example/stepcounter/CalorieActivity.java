/* Resting Energy Expenditure (REE)
 10 x weight (kg) + 6.25 x height(ft/0.032808+inch/0.39370)cm – 5 x age (y) + 5 = REE

 For females:

 10 x weight (kg) + 6.25 x height (cm) – 5 x age (y) – 161 = REE*/

/*BMIExample: Weight = 68 kg, Height = 165 cm (1.65 m)
Calculation: 68 ÷ (1.65)2 = 24.98*/
package com.example.stepcounter;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CalorieActivity extends Activity  {
	double numage,numweight,numfoot,numinch;
	private RadioGroup radiogender;
	private RadioButton radioSexButton;
	double tdde;
	double cal_req_to_maintain_weight;
	String selecteditem;
	Spinner spinneractivity ;
	Spinner spinnergoal;
	String selectedgoal;
	double calintake;
	double cal_to_weight_loss;
	double cal_to_weight_gain;
	double bmi;
	double meter;
	String bmiresult;
	double lbs;
	



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		// Spinner element
		Spinner activity_spinner = (Spinner) findViewById(R.id.spinner1);
		// Spinner click listener
		// activity_spinner.setOnItemSelectedListener(this);
		// Spinner Drop down elements
		List<String> setactivity = new ArrayList<String>();
		setactivity.add("Sedentary");
		setactivity.add("Light activity");
		setactivity.add("Moderate activity");
		setactivity.add("Very Active");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setactivity);
		// Drop down layout style - list view with radio button
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		activity_spinner.setAdapter(dataAdapter);



		radiogender=(RadioGroup)findViewById(R.id.radioGroup1);
		//Spinner Activity Level
		spinneractivity = (Spinner)findViewById(R.id.spinner1);
		spinneractivity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selecteditem=parent.getItemAtPosition(position).toString();	
				Log.d("", "selecteditem : "+selecteditem);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});


	}
	public void OnAddition(View a){

		if(a.getId()==R.id.OnAdd)
		{



			EditText txtages=(EditText) findViewById(R.id.txtage); 
			double numage=Double.parseDouble(txtages.getText().toString());
			EditText txtweight=(EditText)findViewById(R.id.EditText01);
			double numweight=Double.parseDouble(txtweight.getText().toString());
			EditText txtfoot=(EditText)findViewById(R.id.editText1);
			EditText txtinch=(EditText)findViewById(R.id.EditText02);


			//Conversion of Foot and inch in centimeter
			double conf=Double.parseDouble(txtfoot.getText().toString());
			double coni=Double.parseDouble(txtinch.getText().toString());
			double confoot=conf/0.032808;
			double coninch=coni*2.54;
			double heighcm=confoot+coninch;

			//Gender Radio Button

			int selectedId=radiogender.getCheckedRadioButtonId();
			radioSexButton=(RadioButton)findViewById(selectedId);
			if(radioSexButton.getText().equals("Male")){
				tdde=10*numweight+6.25*heighcm-5*numage+5;
			}
			if(radioSexButton.getText().equals("Female"))
			{
				tdde=10*numweight+6.25*heighcm-5*numage-161;

			}



			if(selecteditem.equals("Sedentary")){
				cal_req_to_maintain_weight=tdde*1.2;

			}
			if(selecteditem.equals("Light activity")){
				cal_req_to_maintain_weight=tdde*1.375;

			}
			if(selecteditem.equals("Moderate activity")){
				cal_req_to_maintain_weight=tdde*1.55;

			}
			if(selecteditem.equals("Very Active")){
				cal_req_to_maintain_weight=tdde*1.725;

			}
			
			cal_to_weight_loss=cal_req_to_maintain_weight-(cal_req_to_maintain_weight*0.20);
			cal_to_weight_gain=cal_req_to_maintain_weight+(cal_req_to_maintain_weight*0.20);
			
			meter=heighcm/100;
			bmi=numweight/(meter*meter);
			bmi=Math.round(bmi);
			System.out.println("your ................."+bmi);
			
			if(bmi<=18){
				 bmiresult="underweight";
			}
			if(bmi>18 && bmi<=25){
				 bmiresult="healthy";
			}
			if(bmi>25 && bmi<=30)
			{
				 bmiresult="overweight";
			}
			
			if(bmi>30){
				 bmiresult="obsese";
			}
			
			//Coding for Macro Calculation
			//TO convert kg to lbs
			
			double convert_kg_to_lbs=numweight*2.2046;
			
			//Calculating Macro Req to Maintain
			double mprotein=convert_kg_to_lbs*0.825;//Protein
			double mfats1=cal_req_to_maintain_weight*0.25;
			double mfats=mfats1/9;//Fats
			
			//TO calculate remaining calorie , in order to calculate carbs intake
			double rcal1=mprotein*4;
			double rcal2=mfats*9;
			double rcal=cal_req_to_maintain_weight-(rcal1+rcal2);
		    double mcarbs=rcal/4;
		    
		    
		    
		  //Calculating Macro Req to Lose
			double lprotein=convert_kg_to_lbs*0.825;//Protein
			double lfats1=cal_to_weight_loss*0.25;
			double lfats=lfats1/9;//Fats
			
			//TO calculate remaining calorie , in order to calculate carbs intake
			double lrcal1=lprotein*4;
			double lrcal2=lfats*9;
			double lrcal=cal_to_weight_loss-(lrcal1+lrcal2);
		    double lcarbs=lrcal/4;//Carbs
		    
		    
		    
		    //Calculating Macro Req to Gain
			double gprotein=convert_kg_to_lbs*0.825;//Protein
			double gfats1=cal_to_weight_gain*0.25;
			double gfats=gfats1/9;//Fats
			
			//TO calculate remaining calorie , in order to calculate carbs intake
			double grcal1=gprotein*4;
			double grcal2=gfats*9;
			double grcal=cal_to_weight_gain-(grcal1+grcal2);
		    double gcarbs=grcal/4;//Carbs
			
			//Create Intent t0 pass value from calrieactivity to result activity
			
			Intent i=new Intent(this,Result.class);
			Bundle getdata=new Bundle();
			getdata.putDouble("keymaintain", cal_req_to_maintain_weight);
			getdata.putDouble("keyloss", cal_to_weight_loss);
			getdata.putDouble("keygain", cal_to_weight_gain);
			getdata.putString("keybimind", bmiresult);
			//Calculation for Maintainance 
			getdata.putDouble("keymp", mprotein);
			getdata.putDouble("keymf",mfats);
			getdata.putDouble("keymc", mcarbs);
			
			//Calculation for lose 
			getdata.putDouble("keylp", lprotein);
			getdata.putDouble("keylf",lfats);
			getdata.putDouble("keylc", lcarbs);
			
			//Calculation for Gain
			getdata.putDouble("keygp", gprotein);
			getdata.putDouble("keygf",gfats);
			getdata.putDouble("keygc", gcarbs);
			

			i.putExtras(getdata);
			startActivity(i);
			
			
			
			


		}
	}

}
