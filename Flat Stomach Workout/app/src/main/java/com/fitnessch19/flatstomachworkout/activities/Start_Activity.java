package com.fitnessch19.flatstomachworkout.activities;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.fcm.AppInstalledReciever;
import com.fitnessch19.flatstomachworkout.receiver.NotificationReceiver;
import com.fitnessch19.flatstomachworkout.utils.Constants;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

import static androidx.core.app.NotificationCompat.CATEGORY_ALARM;

public class Start_Activity extends AppCompatActivity {
    public String TAG = "com.outthinking.abc";
    public FrameLayout adLoadingLayout;
    public LinearLayout adView;
    public boolean adloaded = false;
    public AdmobAds admobAdsObject = null;

    public Context context;
    public int currentapiVersion;
    public int height;
    public LayoutInflater inflater;
    public String k = null;
    public String l = null;
    public LayoutManager layoutManager;
    public AppInstalledReciever m;
    public FirebaseAnalytics mFirebaseAnalytics;
    public InterstitialAd mInterstitialAdloading;
    public int margin;
    public RecyclerView n;
    public LinearLayout nativeAdContainer;
    public LinearLayoutManager o;

    public SharedPreferences q;
    public CollapsingToolbarLayout r;
    public RecyclerView recycler_view_crosspromtionl;
    public View s;
    public int screenheight;
    public int screenwidth;
    public AppBarLayout t;
    public int testHeight = 0;
    public RelativeLayout u;

    public int width;


    public void actionView(String str) {
        if (isConnectedToInternet()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Please Check Internet Connection..", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isConnectedToInternet() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    for (NetworkInfo state : allNetworkInfo) {
                        if (state.getState() == State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }


//    private void setUpLoadingTimeAd() {
//        this.adLoadingLayout = (FrameLayout) findViewById(R.id.ad_loading_layout);
//        this.adLoadingLayout.setVisibility(View.VISIBLE);
//        LayoutParams layoutParams = this.adLoadingLayout.getLayoutParams();
//        layoutParams.height = this.height;
//        this.adLoadingLayout.setLayoutParams(layoutParams);
//        this.mInterstitialAdloading = new InterstitialAd(this);
//        this.mInterstitialAdloading.setAdUnitId(Constants.INTERSTITIAL_AT_LAUNCH);
//        this.mInterstitialAdloading.setAdListener(new AdListener() {
//            public void onAdClosed() {
//                Start_Activity.this.adLoadingLayout.setVisibility(View.GONE);
//                Start_Activity.this.b();
//            }
//
//            public void onAdFailedToLoad(int i) {
//                super.onAdFailedToLoad(i);
//                Start_Activity.this.adLoadingLayout.setVisibility(View.GONE);
//                Start_Activity.this.b();
//            }
//
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                try {
//                    if (Start_Activity.this.mInterstitialAdloading != null && Start_Activity.this.mInterstitialAdloading.isLoaded()) {
//                        Start_Activity.this.mInterstitialAdloading.show();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        this.mInterstitialAdloading.loadAd(new Builder().build());
//    }


    public void b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getStringExtra(Constants.APP_PACKAGE_NAME);
            this.l = intent.getStringExtra(Constants.APP_BANNER_URL);
            if (!(this.k == null || this.l == null)) {
                c();
                Editor edit = getApplicationContext().getSharedPreferences(Constants.FCM_CROSS_PROMO_PREF, 0).edit();
                edit.putString("appPackageNameFromFCM", this.k);
                edit.apply();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("appPackageUrlFromFCM: ");
        sb.append(this.k);
        Log.d("onCreate", sb.toString());
    }

    public void c() {
        final Dialog dialog = new Dialog(this, 16974122);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.FCMDialogAnimation;
        dialog.setContentView(R.layout.launch_fcm_dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.setCancelable(true);
        ((ImageView) dialog.findViewById(R.id.ad_close)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        FrameLayout frameLayout = (FrameLayout) dialog.findViewById(R.id.layoutContainer_dialog);
        frameLayout.setVisibility(View.VISIBLE);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.image);
        LayoutParams layoutParams = imageView.getLayoutParams();
        int i = this.width;
        layoutParams.width = i - (i / 10);
        imageView.getLayoutParams().height = this.width;
        try {
            if (this.l != null) {
                Picasso.get().load(this.l).resize(this.width - (this.width / 10), this.width).placeholder((int) R.drawable.progress_animation).error((int) R.drawable.error).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE);
            }
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Start_Activity crossPromoMainActivity = Start_Activity.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("market://details?id=");
                    sb.append(Start_Activity.this.k);
                    crossPromoMainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                    dialog.dismiss();
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString(Param.ITEM_ID, Start_Activity.this.k);
                        bundle.putString(Param.ITEM_NAME, "clicked");
                        bundle.putString(Param.CONTENT_TYPE, "image");
                        Start_Activity.this.mFirebaseAnalytics.logEvent(Event.SELECT_CONTENT, bundle);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        dialog.show();
    }

//    public void onBackPressed() {
//        if (this.adLoadingLayout.getVisibility() == View.VISIBLE) {
//            this.adLoadingLayout.setVisibility(View.GONE);
//        } else if (this.adLoadingLayout.getVisibility() == View.GONE) {
//            if (isConnectedToInternet()) {
//
//                finish();
//                System.exit(1);
//            }
//            super.onBackPressed();
//        }
//        finish();
//
//    }

    @RequiresApi(api = 21)
    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot()) {
            finish();
            return;
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.context = this;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;

            setContentView((int) R.layout.start_activity);

        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        this.r = (CollapsingToolbarLayout) ((Start_Activity) this.context).findViewById(R.id.collapsingLayout);
        this.s = ((Start_Activity) this.context).findViewById(R.id.toolbar);
        this.t = (AppBarLayout) ((Start_Activity) this.context).findViewById(R.id.appBarLayout);


//        setUpLoadingTimeAd();
        findViewById(R.id.start).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent;
                Start_Activity crossPromoMainActivity = Start_Activity.this;
                crossPromoMainActivity.q = PreferenceManager.getDefaultSharedPreferences(crossPromoMainActivity.context);
                String str = "first_time";
                String str2 = "TAG";
                if (!Start_Activity.this.q.getBoolean(str, false)) {
                    Editor edit = Start_Activity.this.q.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                    Start_Activity.this.setAlarm();
                    Log.d(str2, "alarm came in if");
                    intent = new Intent(Start_Activity.this, After_MainActivity.class);
                } else {
                    Log.d(str2, "alarm not came in else");
                    intent = new Intent(Start_Activity.this, After_MainActivity.class);
                }
                Start_Activity.this.startActivity(intent);
                finish();
            }
        });
        this.m = new AppInstalledReciever();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentFilter.addDataScheme("package");
        registerReceiver(this.m, intentFilter);
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String str = "type";
            if (extras.containsKey(str) && extras.getString(str).equals("test type")) {
                Toast.makeText(this, extras.getString("message"), 0).show();
            }
            this.k = intent.getStringExtra(Constants.APP_PACKAGE_NAME);
            this.l = intent.getStringExtra(Constants.APP_BANNER_URL);
            StringBuilder sb = new StringBuilder();
            sb.append("appPackageNameFromFCM: ");
            sb.append(this.k);
            Log.d("onNewIntent", sb.toString());
            if (this.k != null && this.l != null) {
                Editor edit = getApplicationContext().getSharedPreferences(Constants.FCM_CROSS_PROMO_PREF, 0).edit();
                edit.putString("appPackageNameFromFCM", this.k);
                edit.apply();
                c();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.mInterstitialAdloading = null;
//        this.adLoadingLayout.setVisibility(View.GONE);
    }

    public void setAlarm() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 7);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        ((AlarmManager) getSystemService(CATEGORY_ALARM)).setRepeating(AlarmManager.RTC_WAKEUP, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(getApplicationContext(), 100, new Intent(getApplicationContext(), NotificationReceiver.class), 134217728));
    }

//    public void onBackPressed() {
//
//        final Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.adview_layout_exit);
//        ((GifImageView) dialog.findViewById(R.id.GifImageView)).setGifImageResource(R.drawable.rate);
//        ((Button) dialog.findViewById(R.id.btnno)).setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        ((Button) dialog.findViewById(R.id.btnrate)).setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                try {
//
//                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
//                } catch (ActivityNotFoundException unused) {
//
//                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
//                }
//            }
//        });
//        ((Button) dialog.findViewById(R.id.btnyes)).setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                dialog.dismiss();
//                finish();
//                System.exit(1);
//
//
//            }
//        });
//        dialog.show();
//    }
}
