package com.fitnessch19.flatstomachworkout.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.fitnessch19.flatstomachworkout.GifImageView;
import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.fragments.Calculate_Fragment;
import com.fitnessch19.flatstomachworkout.fragments.MealPlanFragment;
import com.fitnessch19.flatstomachworkout.fragments.Profile_Fragment;
import com.fitnessch19.flatstomachworkout.fragments.WorkOut_Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class After_MainActivity extends AppCompatActivity  {
    BottomNavigationView bottomNavigation;


    ImageView imageView1;
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            String str = "";
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:


                    toolbar.setTitle(getString(R.string.app_name));
                    After_MainActivity .this.openFragment(WorkOut_Fragment.newInstance(str, str,After_MainActivity.this));
                    return true;

                case R.id.navigation_calculator:
                    toolbar.setTitle("BMI Calculator");
                    After_MainActivity .this.openFragment(Calculate_Fragment.newInstance(str, str));
                    return true;

                case R.id.navigation_diet_plan:
                    toolbar.setTitle("Diet Plan");
                    After_MainActivity .this.openFragment(MealPlanFragment.newInstance(str, str));
                    return true;

                case R.id.navigation_profile:
                    toolbar.setTitle("Me");
//                    Intent intent = new Intent(After_MainActivity.this, Activity_MyProfile.class);
//                    startActivity(intent);
                  After_MainActivity .this.openFragment(Profile_Fragment.newInstance(str, str));
                    return true;



                default:

                    return false;
            }
        }
    };


    Toolbar toolbar;


    @SuppressLint("ResourceType")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT > 23) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        setContentView((int) R.layout.after_activity_main);


//        bottomNavigation.setItemIconTintList(null);


        if (VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
//            window.setStatusBarColor(Color.parseColor("#EF5050"));
        }
        this.toolbar = initToolbar();




        String str = "#ffffff";
//        this.toolbar.setTitleTextColor(Color.parseColor(str));
//        this.toolbar.getNavigationIcon().setColorFilter(Color.parseColor(str), Mode.MULTIPLY);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        this.bottomNavigation = bottomNavigationView;

        bottomNavigationView.setOnNavigationItemSelectedListener(this.navigationItemSelectedListener);
        String str2 = "";

//        After_MainActivity  mainActivity = null;
        openFragment(WorkOut_Fragment.newInstance(str2 ,str2 ,this ));
        ((AdView) findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());


    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    public void loadFragment_After(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        toolbar.setTitle("Hight Workout");
        bottomNavigation.setSelectedItemId(R.id.navigation_home);
    }



    public void loadFragment_Profile(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        toolbar.setTitle("Me");
        bottomNavigation.setSelectedItemId(R.id.navigation_profile);
    }

    public void loadFragment_Calculator(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        toolbar.setTitle("BMI Calculator");
        bottomNavigation.setSelectedItemId(R.id.navigation_calculator);
    }

    public void loadFragment_Mealplan(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.nav_host_fragment, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        toolbar.setTitle("Diet Plan");
        bottomNavigation.setSelectedItemId(R.id.navigation_diet_plan);
    }


    private Toolbar initToolbar() {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);


        return toolbar2;
    }





    public void onBackPressed() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.adview_layout_exit);
        ((GifImageView) dialog.findViewById(R.id.GifImageView)).setGifImageResource(R.drawable.rate);
        ((Button) dialog.findViewById(R.id.btnno)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.btnrate)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    After_MainActivity  mainActivity = After_MainActivity .this;
                    mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + After_MainActivity .this.getPackageName())));
                } catch (ActivityNotFoundException unused) {
                    After_MainActivity  mainActivity2 = After_MainActivity .this;
                    mainActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + After_MainActivity .this.getPackageName())));
                }
            }
        });
        ((Button) dialog.findViewById(R.id.btnyes)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                After_MainActivity .this.finish();
                System.exit(1);


            }
        });
        dialog.show();



    }
}
