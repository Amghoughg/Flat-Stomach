package com.fitnessch19.flatstomachworkout.alarm.alarm_activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.alarm.alarm_fragments.ReminderFragment;

public class AlarmMainActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.alarm_activity_main);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.sample_content_fragment, new ReminderFragment());
            beginTransaction.commit();
        }
    }
}
