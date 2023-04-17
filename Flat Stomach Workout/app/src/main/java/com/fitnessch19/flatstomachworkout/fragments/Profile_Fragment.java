package com.fitnessch19.flatstomachworkout.fragments;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.fitnessch19.flatstomachworkout.ConstantValues;
import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.activities.Activity_MyProfile;
import com.fitnessch19.flatstomachworkout.database.DatabaseOperations;
import com.fitnessch19.flatstomachworkout.receiver.NotificationReceiver;

import java.util.Calendar;

import static androidx.core.app.NotificationCompat.CATEGORY_ALARM;

public class Profile_Fragment extends Fragment {


    private TextView policy;
    private TextView profile;
    private TextView rateus;
    private TextView reminder;
    private TextView reset;
    private TextView share;
    public SharedPreferences mSharedPreferences;
    public SharedPreferences.Editor prefsEditor;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static Profile_Fragment newInstance(String str, String str2) {

        Profile_Fragment mainFragment = new Profile_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {

        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);


        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.prefsEditor = this.mSharedPreferences.edit();
        initilizeView(inflate);
        setUpView();





        return inflate;
    }

    private void initilizeView(View view2) {

        this.profile = (TextView) view2.findViewById(R.id.myprofile);
        this.reminder = (TextView) view2.findViewById(R.id.reminder);
        this.reset = (TextView) view2.findViewById(R.id.reset);
        this.rateus = (TextView) view2.findViewById(R.id.rateus);

        this.share = (TextView) view2.findViewById(R.id.share);
        this.policy = (TextView) view2.findViewById(R.id.privacypolicy);
    }

    private void setUpView() {


        this.profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Profile_Fragment.this.startActivity(new Intent(Profile_Fragment.this.getActivity(), Activity_MyProfile.class));
            }
        });
        this.reminder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                reminderpopup();
            }
        });
        this.reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                launchDialogue();
            }
        });


        this.share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/html");
                intent.putExtra("android.intent.extra.TEXT", "http://play.google.com/store/apps/details?id=" + Profile_Fragment.this.getActivity().getPackageName());


                Profile_Fragment.this.startActivity(Intent.createChooser(intent, "Loast Weight"));
            }
        });
        this.policy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String url = "https://crazytrendsapp.blogspot.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);     }
        });
        this.rateus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + Profile_Fragment.this.getActivity().getPackageName()));


                try {
                    Profile_Fragment.this.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Profile_Fragment Profile_Fragment = Profile_Fragment.this;
                    Profile_Fragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + Profile_Fragment.this.getActivity().getPackageName())));
                }
            }
        });
    }



    private void reminderpopup() {
        final Dialog dialog = new Dialog(getContext());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.reminder_popup);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
//                Profile_Fragment.this.nav_view.getMenu().getItem(0).setChecked(true);
            }
        });
        dialog.getWindow().setLayout(-1, -2);
        final TimePicker timePicker = (TimePicker) dialog.findViewById(R.id.datePicker1reminder);
        ((Button) dialog.findViewById(R.id.set_reminder)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int i;
                int i2;
                String str = ":";
                String str2 = "ReminderCheck";
                String str3 = "notification_minute";
                String str4 = "notification_hour";
                try {
                    dialog.dismiss();
                    if (Build.VERSION.SDK_INT >= 23) {
                        i2 = timePicker.getHour();
                        i = timePicker.getMinute();
                    } else {
                        i2 = timePicker.getCurrentHour().intValue();
                        i = timePicker.getCurrentMinute().intValue();
                    }
                    Profile_Fragment.this.prefsEditor.putBoolean("user_selection", true);
                    Profile_Fragment.this.prefsEditor.putInt(str4, i2);
                    Profile_Fragment.this.prefsEditor.putInt(str3, i);
                    Log.d(str2, "Reminder set in Main page");
                    Profile_Fragment.this.prefsEditor.apply();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Reminder set in ");
                    sb.append(Profile_Fragment.this.mSharedPreferences.getInt(str4, i2));
                    sb.append(str);
                    sb.append(Profile_Fragment.this.mSharedPreferences.getInt(str3, i));
                    sb.append(str);
                    sb.append(0);
                    Log.d(str2, sb.toString());
                    Profile_Fragment.this.setAlarm(Profile_Fragment.this.mSharedPreferences.getInt(str4, i2), Profile_Fragment.this.mSharedPreferences.getInt(str3, i), 0);
//                    Profile_Fragment.this.nav_view.getMenu().getItem(0).setChecked(true);
                    Toast.makeText(getActivity(), "Reminder Set Sucsessfully!", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.show();
    }
    public void setAlarm(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, i);
        instance.set(Calendar.MINUTE, i2);
        instance.set(Calendar.SECOND, i3);
        ((AlarmManager) getContext().getSystemService(CATEGORY_ALARM)).setRepeating(AlarmManager.RTC_WAKEUP, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(getContext(), 100, new Intent(getContext(), NotificationReceiver.class), 134217728));
    }

    private void launchDialogue() {
        final Dialog dialog = new Dialog(getContext(), R.style.Theme_Dialog);
        try {
            dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        dialog.setContentView(R.layout.restart_confirm_addialog_layout);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(true);
        ((TextView) dialog.findViewById(R.id.btnYes)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                    edit.clear();
                    edit.commit();
                    new DatabaseOperations(getActivity()).deleteTable();
                    Profile_Fragment.this.getActivity().getSharedPreferences(ConstantValues.PREFS_NAME, 0).edit().clear().commit();
                    Profile_Fragment.this.getActivity().finish();
                    System.exit(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) dialog.findViewById(R.id.btnNo)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        dialog.show();
    }
}


