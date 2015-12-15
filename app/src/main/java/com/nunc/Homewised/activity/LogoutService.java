package com.nunc.Homewised.activity;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.widget.Toast;


/**
 * Created by nunc on 14-11-2015.
 */
public class LogoutService extends Service {
    public static CountDownTimer timer;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        timer = new CountDownTimer(1 * 60 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                Toast.makeText(getApplicationContext(), "this is  class Time out!!! =)",
                        Toast.LENGTH_SHORT).show();
                //Some code
                //HomeWisedLog.v
            }

            public void onFinish() {
               // HomeWisedLog.v("TAG", "Call Logout by Service");
                Intent i = new Intent(getApplicationContext(),SplashScreen.class);
                startActivity(i);
                // Code for Logout
                stopSelf();
            }
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
}