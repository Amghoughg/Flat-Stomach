package com.fitnessch19.flatstomachworkout.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;

import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.Builder;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.activities.Start_Activity;

import static android.os.Build.VERSION_CODES.O;

public class NotificationReceiver extends BroadcastReceiver {
    public final String CHANNEL_ID = "reminder_notification";

    private void createNotificationChannel(Context context) {
        if (VERSION.SDK_INT >= O) {
            NotificationChannel notificationChannel = new NotificationChannel("reminder_notification", "Reminder Notification", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Include all the notifications");
            ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(notificationChannel);
        }
    }

    public void onReceive(Context context, Intent intent) {
        createNotificationChannel(context);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.new_banner);
        ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(100, new Builder(context, "reminder_notification")
                        .setContentIntent(PendingIntent.getActivity(context, 100,
                                new Intent(context, Start_Activity.class), 134217728))
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_stat_name))
                        .setSmallIcon(R.drawable.ic_stat_name).setContentTitle("Hey! it's Workout time")
                        .setVibrate(new long[]{0, 500, 1000})

                        .setContentText("Let's do Loast Weight workout.")
                        .setStyle(new BigPictureStyle().bigPicture(decodeResource)
                                .setBigContentTitle("Hi guys! Let's start").setSummaryText("Let's get ready to do Loast Weight Exercise"))
                        .setAutoCancel(true).build());
    }
}
