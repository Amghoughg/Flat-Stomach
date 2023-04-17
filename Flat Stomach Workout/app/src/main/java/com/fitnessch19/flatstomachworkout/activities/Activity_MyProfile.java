package com.fitnessch19.flatstomachworkout.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fitnessch19.flatstomachworkout.ConstantValues;
import com.fitnessch19.flatstomachworkout.R;
public class Activity_MyProfile extends AppCompatActivity {
    private String age;
    private TextView age_profile;
    private String gender;
    private TextView gender_profile;
    private String height;
    private TextView height_profile;
    private Toolbar toolbar;
    private String weight;
    private TextView weight_profile;
    TextView change_profile;
    private  ImageView imageView;


    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activyt_profile);


        initializeviews();
        getUserData();


    }

    private void initializeviews() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.gender_profile = (TextView) findViewById(R.id.gender_profile);
        this.age_profile = (TextView) findViewById(R.id.age_profile);
        this.height_profile = (TextView) findViewById(R.id.height_profile);
        this.weight_profile = (TextView) findViewById(R.id.weight_profile);
        this.change_profile = (TextView) findViewById(R.id.change_profile);
        this.imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        change_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_MyProfile.this,UserDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getUserData() {


        SharedPreferences sharedPreferences = getSharedPreferences(ConstantValues.PREFS_NAME, 0);
        this.gender = sharedPreferences.getString("gender", (String) null);
        this.age = sharedPreferences.getString("age", (String) null);
        this.height = sharedPreferences.getString("height", (String) null);
        this.weight = sharedPreferences.getString("weight", (String) null);
        this.gender_profile.setText(this.gender);
        this.age_profile.setText(this.age);
        this.weight_profile.setText(this.weight);
        this.height_profile.setText(this.height);
    }
    public void onBackPressed() {
        finish();
    }

}
