package com.fitnessch19.flatstomachworkout.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import android.util.Log;

import androidx.core.app.NotificationCompat.Builder;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.activities.Start_Activity;
import com.fitnessch19.flatstomachworkout.utils.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "AbsWorkoutFCM";

    private void sendNotification(String str, String str2, String str3, String str4) {
        Intent intent = new Intent(this, Start_Activity.class);
        intent.putExtra(Constants.APP_PACKAGE_NAME, str);
        intent.putExtra(Constants.APP_BANNER_URL, str2);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1073741824);
        String string = getString(R.string.default_notification_channel_id);
        Builder contentIntent = new Builder(this, string).setSmallIcon(R.drawable.ic_stat_name).setContentTitle(str4).setContentText(str3).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(activity);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(string, "Channel human readable title", 3));
        }
        notificationManager.notify(0, contentIntent.build());
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0061  */
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("From: ");
        sb.append(remoteMessage.getFrom());
        String sb2 = sb.toString();
        String str2 = TAG;
        Log.d(str2, sb2);
        String str3 = null;
        if (remoteMessage.getData().size() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Message data payload: ");
            sb3.append(remoteMessage.getData());
            Log.d(str2, sb3.toString());
            Map data = remoteMessage.getData();
            if (data.containsKey(Constants.APP_PACKAGE_NAME)) {
                str3 = (String) data.get(Constants.APP_PACKAGE_NAME);
                str = (String) data.get(Constants.APP_BANNER_URL);
                if (remoteMessage.getNotification() != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Message Notification Body: ");
                    sb4.append(remoteMessage.getNotification().getBody());
                    Log.d(str2, sb4.toString());
                }
                sendNotification(str3, str, remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
            }
        }
        str = null;
        if (remoteMessage.getNotification() != null) {
        }
        sendNotification(str3, str, remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
    }
}
