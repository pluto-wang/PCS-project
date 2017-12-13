package com.example.sms_test;

import java.util.ArrayList;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	 Button btnSendSMS;
	 EditText txtPhoneNo;
     private Spinner spinner;
     private String[] list = {"Happy Birthday","Merry Christmas","Valentine's Day","Mother's Day","Father's Day","Happy New Year"};
     private ArrayAdapter<String> listAdapter;
     static  String message;
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
        spinner = (Spinner)findViewById(R.id.spinner1);
        btnSendSMS.getBackground().setAlpha(100);

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(listAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                message = list[position];
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

            btnSendSMS.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                      String phoneNo = txtPhoneNo.getText().toString();
                      //String message = txtMessage.getText().toString();
                      if (phoneNo.length() > 0 && message.length() > 0)
                          sendSMS(phoneNo, message);
                      else
                          Toast.makeText(getBaseContext(), "Please enter both phone number and message.",Toast.LENGTH_SHORT).show();
                 }
            }
            );
        }

    private void sendSMS(String phoneNumber, String message){
        PendingIntent pi = PendingIntent.getActivity(this, 0,new Intent(this, MainActivity.class), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);        
    }   
	
 }
	
	
	

