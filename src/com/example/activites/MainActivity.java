package com.example.activites;

import java.text.DecimalFormat;

import com.example.test.R;
import com.porter.classes.Register;
import com.porter.classes.RegisterImp;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	static RelativeLayout rl;
	Register cashRegister;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		cashRegister = new RegisterImp();
		cashRegister.addItem("Pizza", 2.00);
		cashRegister.addItem("Hotdog", 1.50);
		cashRegister.addItem("Gatorade", 2.00);
		cashRegister.addItem("Water", 1.00);
		cashRegister.addItem("Nachos", 1.50);
		cashRegister.addItem("Soda", 1.00);
		cashRegister.addItem("Popcorn", 1.00);
		cashRegister.addItem("Candy Bar", 1.00);
		cashRegister.addItem("Carmel Apple Sucker", 0.25);
		cashRegister.addItem("Twizzlers", 0.25);
	
		
	}
	
	public void buyItem(View v){
		
		switch(v.getId()){
		case (R.id.pizza):
		    addItem("Pizza");
		    break;
		case(R.id.ImageButton2):
			addItem("Hotdog");
			break;
		case(R.id.ImageButton01):
			addItem("Gatorade");
			break;
		case(R.id.ImageButton02):
			addItem("Water");
			break;
		case(R.id.ImageButton03):
			addItem("Nachos");
			break;
		case(R.id.ImageButton05):
			addItem("Soda");
		    break;
		case(R.id.ImageButton08):
			addItem("Popcorn");
			break;
		case(R.id.ImageButton04):
			addItem("Candy Bar");
			break;
		case(R.id.ImageButton06):
			addItem("Carmel Apple Sucker");
			break;
		case(R.id.ImageButton07):
			addItem("Twizzlers");
			break;
		}
	}
	public void newRegister(){
		cashRegister = new RegisterImp();
		cashRegister.addItem("Pizza", 2.50);
		cashRegister.addItem("Hotdog", 1.50);
		cashRegister.addItem("Gatorade", 2.00);
		cashRegister.addItem("Water", 1.00);
		cashRegister.addItem("Nachos", 1.50);
		cashRegister.addItem("Soda", 1.00);
		cashRegister.addItem("Popcorn", 1.00);
		cashRegister.addItem("Candy Bar", 1.00);
		cashRegister.addItem("Carmel Apple Sucker", 0.25);
		cashRegister.addItem("Twizzlers", 0.25);
		TextView menu = (TextView)findViewById(R.id.textView1);
		menu.setText("");
		Button btn = (Button)findViewById(R.id.zero);
		btn.setText("$0.00");
		
		
	}
	public void addItem(String i){
		cashRegister.purchaseItem(i);
		
		String tMessage = cashRegister.getTotalMessage();
	 
	    TextView menu = (TextView)findViewById(R.id.textView1);
	    menu.setText(tMessage);
	    Button btn = (Button)findViewById(R.id.zero);
	    DecimalFormat df = new DecimalFormat("0.00");
	    String total_text = df.format(cashRegister.getTotal());
	    total_text = "$"+total_text;
	    btn.setText(total_text);
	}
	public void checkout (View v){
		Intent intent = new Intent(this, Checkout.class);
		intent.putExtra("total", cashRegister.checkout());
		newRegister();

		
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
	

			
			
		
			return rootView;
			
			
		}
	}
	
	public void clearOrder(View v){
		newRegister();
	}
}
