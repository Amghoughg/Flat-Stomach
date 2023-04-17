package com.fitnessch19.flatstomachworkout.fcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.fitnessch19.flatstomachworkout.utils.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;

public class AppInstalledReciever extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
        String string = context.getSharedPreferences(Constants.FCM_CROSS_PROMO_PREF, 0).getString("appPackageNameFromFCM", "");
        StringBuilder sb = new StringBuilder();
        sb.append("packageName outside if: ");
        sb.append(encodedSchemeSpecificPart);
        String str = "onReceive ";
        Log.i(str, sb.toString());
        try {
            if (encodedSchemeSpecificPart.equalsIgnoreCase(string)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("packageName inside if: ");
                sb2.append(encodedSchemeSpecificPart);
                Log.i(str, sb2.toString());
                Bundle bundle = new Bundle();
                bundle.putString(Param.ITEM_ID, encodedSchemeSpecificPart);
                String str2 = Param.ITEM_NAME;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("installed-");
                sb3.append(encodedSchemeSpecificPart);
                bundle.putString(str2, sb3.toString());
                bundle.putString(Param.CONTENT_TYPE, "image");
                FirebaseAnalytics.getInstance(context).logEvent(Event.SELECT_CONTENT, bundle);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("packageName inside try: ");
            sb4.append(encodedSchemeSpecificPart);
            Log.i(str, sb4.toString());
            context.unregisterReceiver(this);
        } catch (Exception e) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("packageName inside catch: ");
            sb5.append(e.getMessage());
            Log.i(str, sb5.toString());
            e.printStackTrace();
        }
    }
}
