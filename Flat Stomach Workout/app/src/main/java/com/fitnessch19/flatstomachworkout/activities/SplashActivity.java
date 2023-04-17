
package com.fitnessch19.flatstomachworkout.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;

import com.fitnessch19.flatstomachworkout.ConstantValues;
import com.fitnessch19.flatstomachworkout.R;


public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = PathInterpolatorCompat.MAX_NUM_POINTS;

    public Boolean logg;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_splash);
        this.logg = Boolean.valueOf(getSharedPreferences(ConstantValues.PREFS_NAME, 0).getBoolean("logged", false));
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (SplashActivity.this.logg.booleanValue()) {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, Start_Activity.class));
                    SplashActivity.this.finish();
                    return;
                }
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, UserDetailsActivity.class));
                SplashActivity.this.finish();
            }
        }, 3000);
    }
}