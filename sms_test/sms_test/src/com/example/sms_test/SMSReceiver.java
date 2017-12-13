package com.example.sms_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony.Sms;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import android.app.WallpaperManager;


import java.io.IOException;

public class SMSReceiver extends BroadcastReceiver{

    private Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) 
    {
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
        String str = "";            
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            str+="topic:{";
            for (int i=0; i<msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                //str+= "SMS from"+msgs[i].getOriginatingAddress();
                //str+=":";
                str += msgs[i].getMessageBody().toString();
                //555str+="\n";
            }
            str+="}";

            //---display the new SMS message---
           // Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
            mContext=context;

            WallpaperManager wallpaperManager = WallpaperManager.getInstance(mContext.getApplicationContext());
            try {
                if(str.equals("topic:{Happy Birthday}")==true) {
                    wallpaperManager.setResource(+R.drawable.happybirthday);
                }
                else if (str.equals("topic:{Merry Christmas}") == true) {
                        wallpaperManager.setResource(+R.drawable.merry);
                    }
                else if (str.equals("topic:{Valentine's Day}") == true) {
                        wallpaperManager.setResource(+R.drawable.love);
                    }
                else if (str.equals("topic:{Mother's Day}") == true) {
                        wallpaperManager.setResource(+R.drawable.mother);
                    }
                else if (str.equals("topic:{Father's Day}") == true) {
                    wallpaperManager.setResource(+R.drawable.father);
                }
                else if (str.equals("topic:{Happy New Year}") == true) {
                    wallpaperManager.setResource(+R.drawable.happynewyear);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("TAG", "wallpaper is started");
        }                         
    }

}
