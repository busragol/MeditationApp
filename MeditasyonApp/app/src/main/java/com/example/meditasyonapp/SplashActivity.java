package com.example.meditasyonapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    //the function control internet and receive a context
    public boolean isInternet(final Context context) {

        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (isInternet(this)) {


            Thread t = new Thread() {
                public void run() {

                    try {
                        //sleep thread for 5 seconds, time in milliseconds
                        sleep(5000);

                        //start new activity
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);

                        //destroying Splash activity
                        finish();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            //start thread
            t.start();


        }
        else{
            AlertDialog alert=new AlertDialog.Builder(this).create();
            alert.setTitle("Bağlantı Hatası");
            alert.setMessage("Lütfen internet bağlantınızı kontrol edin");
            //clicking this button will terminate the application
            alert.setButton(DialogInterface.BUTTON_NEUTRAL, "TAMAM",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            int pid=android.os.Process.myPid();
                            android.os.Process.killProcess(pid);
                            dialog.dismiss();
                        }
                    }
            );
            alert.show();
        }
    }
}
