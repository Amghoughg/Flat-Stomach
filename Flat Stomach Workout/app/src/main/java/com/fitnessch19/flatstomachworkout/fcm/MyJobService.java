package com.fitnessch19.flatstomachworkout.fcm;

import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class MyJobService extends JobService {
    public static final String TAG = "MyJobService";

    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "Performing long running task in scheduled job");
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
