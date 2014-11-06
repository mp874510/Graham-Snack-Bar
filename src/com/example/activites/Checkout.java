package com.example.activites;

import java.text.DecimalFormat;

import com.example.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Checkout extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkout);
	}
	
	public void add(View v){
		
		switch(v.getId()){
		case (R.id.one):
		    addTotal(1);
		    break;
		case (R.id.two):
		    addTotal(2);
		    break;
		case (R.id.three):
		    addTotal(3);
		    break;
		case (R.id.four):
		    addTotal(4);
		    break;
		case (R.id.five):
		    addTotal(5);
		    break;
		case (R.id.six):
		    addTotal(6);
		    break;
		case (R.id.seven):
		    addTotal(7);
		    break;
		case (R.id.eight):
		    addTotal(8);
		    break;
		case (R.id.nine):
		    addTotal(9);
		    break;
		case (R.id.zero):
		    addTotal(0);
		    break;
		}
	}
	
	public void addTotal(double i){
		
		TextView amountGiven = (TextView)findViewById(R.id.AmountGiven);
		String amountText = (String) amountGiven.getText();
	    double amount = Double.parseDouble(amountText.substring(1));
	    amount = (amount * 10) + (i / 100);
	    DecimalFormat df = new DecimalFormat("0.00");
	    amountGiven.setText("$"+df.format(amount));
	    
	}
	
	public void undo(View v){
		TextView amountGiven = (TextView)findViewById(R.id.AmountGiven);
		amountGiven.setText("$0.00");
	}
}
