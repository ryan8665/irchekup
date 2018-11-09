package com.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baseClass.BaseActivity;
import com.checkup.checkuppro.R;

public class SplashActivity extends BaseActivity {
    TextView splashString;
    ProgressBar splashLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashLoading = (ProgressBar)findViewById(R.id.progressBar_splash);
        splashString = (TextView)findViewById(R.id.textView_splash);
        if (isNetworkAvailable()) {
            new loadPage().execute();

        } else {
            splashLoading.setVisibility(View.GONE);
            splashString.setVisibility(View.VISIBLE);
            splashString.setText(R.string.network_error);
        }
    }

    public class loadPage extends AsyncTask<String, Void, String> {
        boolean hasError = false;

        protected void onPreExecute() {
            splashLoading.setVisibility(View.VISIBLE);
            splashString.setVisibility(View.GONE);
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                Thread.sleep(2000);

                // Log.i("Splash", message);
            } catch (Exception e) {
                hasError = true;
                Log.e("Splash Error", e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(String result) {
            splashLoading.setVisibility(View.GONE);

            if(hasError){
                splashString.setVisibility(View.VISIBLE);
                splashString.setText(R.string.splash_error);
            }else {
                //Todo: check is user login
                if(true){
                          Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                          startActivity(intent);
                          SplashActivity.this.finish();
                }else {
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();

                }

            }

        }
    }

}
