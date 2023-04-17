package com.fitnessch19.flatstomachworkout.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.fitnessch19.flatstomachworkout.receiver.NotificationReceiver;

import java.util.Calendar;
import java.util.Locale;

public class CommonMethods {


    public AlarmManager f1499a;
    public Calendar b = Calendar.getInstance();
    public Context context;

    public CommonMethods(Context context2) {
        this.context = context2;
    }

    public void actionView(String str) {
        if (isConnectedToInternet()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this.context, "Please Check Internet Connection", 0).show();
        }
    }

    public boolean isConnectedToInternet() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
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

    public void setAlarm(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("Time");
        sb.append(i);
        String str = ":";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        Log.d("TimeSet", sb.toString());
        Context context2 = this.context;
        String str2 = NotificationCompat.CATEGORY_ALARM;
        this.f1499a = (AlarmManager) context2.getSystemService(str2);
        this.b.set(11, i);
        this.b.set(12, i2);
        this.b.set(13, i3);
        Intent intent = new Intent(this.context, NotificationReceiver.class);
        intent.getIntExtra("RequestCode", 100);
        this.f1499a.cancel(PendingIntent.getBroadcast(this.context, 100, intent, 134217728));
        String str3 = "Tag";
        Log.d(str3, "previous alarm canceled");
        Log.d(str3, "new alarm sets");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context.getApplicationContext(), 100, new Intent(this.context.getApplicationContext(), NotificationReceiver.class), 134217728);
        this.f1499a = (AlarmManager) this.context.getSystemService(str2);
        AlarmManager alarmManager = this.f1499a;
        if (alarmManager != null) {
            alarmManager.setRepeating(0, this.b.getTimeInMillis(), 86400000, broadcast);
        }
    }

    public void updateLocale(String str) {
        Locale locale = new Locale(str);
        Resources resources = this.context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
    }
}
