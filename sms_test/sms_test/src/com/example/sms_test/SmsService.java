package com.example.sms_test;

/**
 * Created by pluto on 2015/12/18.
 */
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.app.Service;

import java.io.IOException;

public class SmsService extends Service{

    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }

    @Override
    public void onCreate(){

        Log.d("TAG", "setWallpaper service is started");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "onStartCommand() executed");
        SetWallpaper("ss");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy() executed");
    }

    public  void SetWallpaper(String topic) {

        WallpaperManager wallpaperManager =
                WallpaperManager.getInstance(SmsService.this);
        try {
            wallpaperManager.setResource(+R.drawable.happybirthday);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("TAG", "wallpaper is started");

    }

}
