package com.example.activites;

import java.text.DecimalFormat;

import com.example.test.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class Checkout extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkout);
		Intent intent = getIntent();
		double total = intent.getDoubleExtra("total", 0);
		TextView amountDue = (TextView)findViewById(R.id.AmountDue);
		DecimalFormat df = new DecimalFormat("0.00");
		String amountDueText = df.format(total);
		amountDue.setText("$"+amountDueText);
		TextView amountGiven = (TextView)findViewById(R.id.AmountGiven);
		
		if(!isEnoughMoney())
			amountGiven.setTextColor(Color.RED);
			
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
	
	public void checkout(View v){

		if(!isEnoughMoney())
			showNotEnoughMessage();
		else
			showChangeMessage();
		
		
		
		
		
		//final Dialog dialog = new Dialog(this);

        //dialog.setContentView(R.layout.custom_dialog);
        //dialog.setTitle("Custom Alert Dialog");

      //  final EditText editText=(EditText)dialog.findViewById(R.id.editText);
       // Button save=(Button)dialog.findViewById(R.id.save);
        //Button btnCancel=(Button)dialog.findViewById(R.id.cancel);
      //  dialog.show();
		
	}
	public void showChangeMessage(){
		final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Custom Alert Dialog");

        final EditText editText=(EditText)dialog.findViewById(R.id.editText);
        Button save=(Button)dialog.findViewById(R.id.save);
        Button btnCancel=(Button)dialog.findViewById(R.id.cancel);
        dialog.show();
	}
	
	public void showNotEnoughMessage(){
		new AlertDialog.Builder(this)
	    .setTitle("Not Enough Money")
	    .setMessage("The Amount Given is less than the Amount Due. Please enter the correct amount given")
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // continue with delete
	        }
	     })
	    //.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
	    //    public void onClick(DialogInterface dialog, int which) { 
	            // do nothing
	    //    }
	    // })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
	}
	public void addTotal(double i){
		
		TextView amountGiven = (TextView)findViewById(R.id.AmountGiven);
		String amountText = (String) amountGiven.getText();
	    double amount = Double.parseDouble(amountText.substring(1));
	    amount = (amount * 10) + (i / 100);
	    DecimalFormat df = new DecimalFormat("0.00");
	    amountGiven.setText("$"+df.format(amount));
	    
	    if(!isEnoughMoney())
			amountGiven.setTextColor(Color.RED);
	    else
	    	amountGiven.setTextColor(Color.BLACK);
	    
	}
	
	public void undo(View v){
		TextView amountGiven = (TextView)findViewById(R.id.AmountGiven);
		amountGiven.setText("$0.00");
	    if(!isEnoughMoney())
			amountGiven.setTextColor(Color.RED);
	    else
	    	amountGiven.setTextColor(Color.BLACK);
	}
	
	public boolean isEnoughMoney(){
		TextView amountGiven = (TextView)findViewById(R.id.AmountGiven);
		TextView amountDue = (TextView)findViewById(R.id.AmountDue);
		
		String amountGivenText = (String)amountGiven.getText();
		String amoumntDueText = (String)amountDue.getText();
		
		double ag = Double.parseDouble(amountGivenText.substring(1));
		double ad = Double.parseDouble(amoumntDueText.substring(1));
		
		if(ad <= ag)
			return true;
		else
			return false;
	}
	
}
