package com.example.stepcounter;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Result extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		//Get the bundle
		Bundle bundle = getIntent().getExtras();

		//Extract the data…
		double wmaintain = bundle.getDouble("keymaintain");
		double wloss = bundle.getDouble("keyloss");
		double wgain = bundle.getDouble("keygain");
		String bmires=bundle.getString("keybimind");
		//Maintain Macros
		double mp=bundle.getDouble("keymp");
		double mf=bundle.getDouble("keymf");
		double mc=bundle.getDouble("keymc");

		//Maintain Macros
		double lp=bundle.getDouble("keylp");
		double lf=bundle.getDouble("keylf");
		double lc=bundle.getDouble("keylc");

		//Gain Macros
		double gp=bundle.getDouble("keygp");
		double gf=bundle.getDouble("keygf");
		double gc=bundle.getDouble("keygc");

		//To calculate macros



		TextView txtm=(TextView)findViewById(R.id.txtmaintainance);
		txtm.setText(""+Math.round(wmaintain));
		TextView txtl=(TextView)findViewById(R.id.txtfatloss);
		txtl.setText(""+Math.round(wloss));
		TextView txtg=(TextView)findViewById(R.id.txtweightgain);
		txtg.setText(""+Math.round(wgain));
		TextView txtbmi=(TextView)findViewById(R.id.txtbmiresult);
		txtbmi.setText(""+bmires);

		//Maintain Macro
		TextView txtmp=(TextView)findViewById(R.id.txtpm);
		txtmp.setText(""+Math.round(mp)+" "+"Protein");
		TextView txtmf=(TextView)findViewById(R.id.txtmf);
		txtmf.setText(""+Math.round(mf)+" "+"Fats");
		TextView txtmc=(TextView)findViewById(R.id.txtmc);
		txtmc.setText(""+Math.round(mc)+" "+"Carbs");

		//Lose Macro
		TextView txtlp=(TextView)findViewById(R.id.txtlp);
		txtlp.setText(""+Math.round(lp)+" "+"Protein");
		TextView txtlf=(TextView)findViewById(R.id.txtlf);
		txtlf.setText(""+Math.round(lf)+" "+"Fats");
		TextView txtlc=(TextView)findViewById(R.id.txtlc);
		txtlc.setText(""+Math.round(lc)+" "+"Carbs");

		//Gain Macro
		TextView txtgp=(TextView)findViewById(R.id.txtgp);
		txtgp.setText(""+Math.round(gp)+" "+"Protein");
		TextView txtgf=(TextView)findViewById(R.id.txtgf);
		txtgf.setText(""+Math.round(gf)+" "+"Fats");
		TextView txtgc=(TextView)findViewById(R.id.txtgc);
		txtgc.setText(""+Math.round(gc)+" "+"Carbs");




	}

	public void onclicksaveresult()
	{

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		return super.onOptionsItemSelected(item);
	}
}
