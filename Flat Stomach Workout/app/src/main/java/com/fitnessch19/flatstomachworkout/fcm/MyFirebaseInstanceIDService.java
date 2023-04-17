package com.fitnessch19.flatstomachworkout.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    public static final String TAG = "MyFirebaseIIDService";

    private void sendRegistrationToServer(String str) {
    }

    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        StringBuilder sb = new StringBuilder();
        sb.append("Refreshed token: ");
        sb.append(token);
        Log.d(TAG, sb.toString());
        sendRegistrationToServer(token);
    }
}
