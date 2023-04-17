package com.fitnessch19.flatstomachworkout.fragments;


import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.activities.After_MainActivity;
import com.fitnessch19.flatstomachworkout.activities.DayActivity;
import com.fitnessch19.flatstomachworkout.activities.MainActivity;
import com.fitnessch19.flatstomachworkout.activities.TipsActivity;
import com.fitnessch19.flatstomachworkout.adapters.WorkoutData;
import com.fitnessch19.flatstomachworkout.database.DatabaseOperations;
import com.fitnessch19.flatstomachworkout.meals.MealsMainActivity;
import com.fitnessch19.flatstomachworkout.receiver.NotificationReceiver;
import com.fitnessch19.flatstomachworkout.utils.AppUtils;
import com.fitnessch19.flatstomachworkout.utils.Constants;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import static androidx.core.app.NotificationCompat.CATEGORY_ALARM;

public class WorkOut_Fragment extends Fragment implements OnNavigationItemSelectedListener {
    public float Heightincms = 0.0f;
    public DrawerLayout drawer;
    public RadioButton female;
    public EditText ft;
    public int height;
    public EditText inches;
    public CoordinatorLayout cordinatorLayout;
    public RadioButton kg;
    public boolean l;
    public RadioButton lbs;
    public int m;
    public SharedPreferences mSharedPreferences;
    public RadioButton male;
    public int n;
    public Menu navMenu;
    public NavigationView nav_view;
    public Editor prefsEditor;
    public EditText weight;
    public int width;
    public EditText year;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ProgressBar progressBar1;
    private TextView percentScore1, dayleft;


    public ArrayList<String> arr;
    public List<WorkoutData> workoutDataList;
    public int workoutPosition = -1;
    public int daysCompletionConter = 0;
    public double k = 0.0d;

    public SharedPreferences launchDataPreferences;
    public DatabaseOperations databaseOperations;

    public BroadcastReceiver progressReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            double doubleExtra = intent.getDoubleExtra(AppUtils.KEY_PROGRESS, 0.0d);
            try {
                ((WorkoutData) workoutDataList.get(workoutPosition)).setProgress((float) doubleExtra);
                WorkOut_Fragment Workout = WorkOut_Fragment.this;
                k = 0.0d;
                daysCompletionConter = 0;
                for (int i = 0; i < Constants.TOTAL_DAYS; i++) {
                    WorkOut_Fragment Workout2 = WorkOut_Fragment.this;
                    double d = Workout2.k;
                    double progress = (double) ((WorkoutData) Workout2.workoutDataList.get(i)).getProgress();
                    Double.isNaN(progress);
                    Workout2.k = (double) ((float) (d + ((progress * 4.348d) / 100.0d)));
                    if (((WorkoutData) WorkOut_Fragment.this.workoutDataList.get(i)).getProgress() >= 99.0f) {
                        WorkOut_Fragment.this.daysCompletionConter = WorkOut_Fragment.this.daysCompletionConter + 1;
                    }
                }
                WorkOut_Fragment Workout3 = WorkOut_Fragment.this;
                Workout3.daysCompletionConter = Workout3.daysCompletionConter + (WorkOut_Fragment.this.daysCompletionConter / 3);
                WorkOut_Fragment.this.progressBar1.setProgress((int) WorkOut_Fragment.this.k);
                TextView g = WorkOut_Fragment.this.percentScore1;
                StringBuilder sb = new StringBuilder();
                sb.append((int) WorkOut_Fragment.this.k);
                sb.append("%");
                g.setText(sb.toString());
                TextView h = WorkOut_Fragment.this.dayleft;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Constants.TOTAL_DAYS - WorkOut_Fragment.this.daysCompletionConter);
                sb2.append(" Days left");
                h.setText(sb2.toString());
//                WorkOut_Fragment.this.adapter.notifyDataSetChanged();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(doubleExtra);
                Log.i("progress broadcast", sb3.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


    After_MainActivity mainAcdsctivity;

    public WorkOut_Fragment(After_MainActivity mainActivity) {
        this.mainAcdsctivity = mainActivity;
    }

    public static WorkOut_Fragment newInstance(String str, String str2, After_MainActivity mainActivity) {
        WorkOut_Fragment mainFragment = new WorkOut_Fragment(mainActivity);
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        mainFragment.setArguments(bundle);
        return mainFragment;
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
        ((TextView) dialog.findViewById(R.id.btnYes)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                    edit.clear();
                    edit.commit();
                    new DatabaseOperations(getActivity()).deleteTable();
                    WorkOut_Fragment.this.nav_view.getMenu().getItem(0).setChecked(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) dialog.findViewById(R.id.btnNo)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WorkOut_Fragment.this.nav_view.getMenu().getItem(0).setChecked(true);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void reminderpopup() {
        final Dialog dialog = new Dialog(getContext());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.reminder_popup);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                WorkOut_Fragment.this.nav_view.getMenu().getItem(0).setChecked(true);
            }
        });
        dialog.getWindow().setLayout(-1, -2);
        final TimePicker timePicker = (TimePicker) dialog.findViewById(R.id.datePicker1reminder);
        ((Button) dialog.findViewById(R.id.set_reminder)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int i;
                int i2;
                String str = ":";
                String str2 = "ReminderCheck";
                String str3 = "notification_minute";
                String str4 = "notification_hour";
                try {
                    dialog.dismiss();
                    if (VERSION.SDK_INT >= 23) {
                        i2 = timePicker.getHour();
                        i = timePicker.getMinute();
                    } else {
                        i2 = timePicker.getCurrentHour().intValue();
                        i = timePicker.getCurrentMinute().intValue();
                    }
                    WorkOut_Fragment.this.prefsEditor.putBoolean("user_selection", true);
                    WorkOut_Fragment.this.prefsEditor.putInt(str4, i2);
                    WorkOut_Fragment.this.prefsEditor.putInt(str3, i);
                    Log.d(str2, "Reminder set in Main page");
                    WorkOut_Fragment.this.prefsEditor.apply();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Reminder set in ");
                    sb.append(WorkOut_Fragment.this.mSharedPreferences.getInt(str4, i2));
                    sb.append(str);
                    sb.append(WorkOut_Fragment.this.mSharedPreferences.getInt(str3, i));
                    sb.append(str);
                    sb.append(0);
                    Log.d(str2, sb.toString());
                    WorkOut_Fragment.this.setAlarm(WorkOut_Fragment.this.mSharedPreferences.getInt(str4, i2), WorkOut_Fragment.this.mSharedPreferences.getInt(str3, i), 0);
                    WorkOut_Fragment.this.nav_view.getMenu().getItem(0).setChecked(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.show();
    }

    private void shareApp() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.app_name));
        StringBuilder sb = new StringBuilder();
        sb.append("https://play.google.com/store/apps/details?id=");
        sb.append(getContext().getPackageName());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Hi, i am using this amazing app ");
        sb3.append(getResources().getString(R.string.app_name));
        sb3.append(" and its awesome!\n\n This app keeps you fit and helps to get best results at home.\n\n Download the app here: \n");
        sb3.append(sb2);
        String sb4 = sb3.toString();
        intent.putExtra("android.intent.extra.TEXT", sb4);
        intent.putExtra("android.intent.extra.STREAM", sb4);
        intent.setType("text/plain");
        startActivity(intent);
    }


    public void b(View view) {
        startActivity(new Intent(getContext(), MainActivity.class));
        getActivity().finish();
    }

    public void c(View view) {
        startActivity(new Intent(getContext(), MealsMainActivity.class));
        getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    public void imageclick(View view) {
        startActivity(new Intent(getContext(), TipsActivity.class));
    }

    public void a(int i, MaterialDialog materialDialog, DialogAction dialogAction) {
        TextView textView = null;
        String str = null;
        try {
            materialDialog.dismiss();
            String str2 = (String) this.arr.get(i);
            if (this.workoutDataList != null) {
                this.workoutDataList.clear();
            }
            this.databaseOperations.insertExcDayData(str2, 0.0f);
            this.databaseOperations.insertExcCounter(str2, 0);
            this.workoutDataList = this.databaseOperations.getAllDaysProgress();
//            this.adapter = new AllDayAdapter(getActivity(), this.workoutDataList);
//            this.recyclerView.getRecycledViewPool().clear();
//            this.recyclerView.setAdapter(this.adapter);
            this.daysCompletionConter--;
            TextView textView2 = this.dayleft;
            StringBuilder sb = new StringBuilder();
            sb.append(Constants.TOTAL_DAYS - this.daysCompletionConter);
            sb.append(" Days left");
            textView2.setText(sb.toString());
            if (this.daysCompletionConter > 0) {
                this.progressBar1.setProgress((int) (k - 4.348d));
                textView = this.percentScore1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append((int) (this.k - 4.348d));
                sb2.append("%");
                str = sb2.toString();
            } else {
                if (this.daysCompletionConter == 0) {
                    this.progressBar1.setProgress(0);
                    textView = this.percentScore1;
                    str = "0%";
                }
                Intent intent = new Intent(getActivity(), DayActivity.class);
                intent.putExtra("day", str2);
                intent.putExtra("day_num", i);
                intent.putExtra("progress", ((WorkoutData) this.workoutDataList.get(i)).getProgress());
                startActivity(intent);
            }
            textView.setText(str);
            Intent intent2 = new Intent(getActivity(), DayActivity.class);
            intent2.putExtra("day", str2);
            intent2.putExtra("day_num", i);
            intent2.putExtra("progress", ((WorkoutData) this.workoutDataList.get(i)).getProgress());
            startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            this.databaseOperations.deleteTable();
            SharedPreferences.Editor edit = this.launchDataPreferences.edit();
            String str = "daysInserted";
            edit.putBoolean(str, false);
            edit.apply();
            edit.putBoolean(str, true);
            edit.apply();
            List<WorkoutData> list = this.workoutDataList;
            if (list != null) {
                list.clear();
            }
            this.workoutDataList = this.databaseOperations.getAllDaysProgress();
//            this.adapter = new AllDayAdapter(getActivity(), this.workoutDataList);
//            this.recyclerView.getRecycledViewPool().clear();
//            this.recyclerView.setAdapter(this.adapter);
            this.progressBar1.setProgress(0);
            this.percentScore1.setText("0%");
            TextView textView = this.dayleft;
            StringBuilder sb = new StringBuilder();
            sb.append(Constants.TOTAL_DAYS);
            sb.append(" Days left");
            textView.setText(sb.toString());
        }
        super.onActivityResult(i, i2, intent);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_firstactivity2, viewGroup, false);

        progressBar1 = (ProgressBar) inflate.findViewById(R.id.progress);
        percentScore1 = (TextView) inflate.findViewById(R.id.percentScore);
        dayleft = (TextView) inflate.findViewById(R.id.daysLeft);

        this.launchDataPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.databaseOperations = new DatabaseOperations(getActivity());
        final String str1 = "thirtyday";
        boolean z = this.launchDataPreferences.getBoolean(str1, false);
        String str2 = "daysInserted";
        boolean z2 = this.launchDataPreferences.getBoolean(str2, false);

        if (!z2 && this.databaseOperations.CheckDBEmpty() == 0) {
            this.databaseOperations.insertExcALLDayData();
            SharedPreferences.Editor edit = this.launchDataPreferences.edit();
            edit.putBoolean(str2, true);
            edit.apply();
        }


        int i;

        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;

        this.drawer = (DrawerLayout) inflate.findViewById(R.id.fdrawer_layout);

        this.nav_view = (NavigationView) inflate.findViewById(R.id.fnav_view);
        this.nav_view.setNavigationItemSelectedListener(this);
        this.nav_view.getMenu().getItem(0).setChecked(true);
        this.navMenu = this.nav_view.getMenu();
        this.nav_view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ArrayList arrayList = new ArrayList();
                WorkOut_Fragment.this.nav_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                for (int i = 0; i < WorkOut_Fragment.this.navMenu.size(); i++) {
                    if (i == 0) {
                        WorkOut_Fragment.this.navMenu.getItem(i).setTitle(new SpannableString(navMenu.getItem(i).getTitle()));
                    }
                    WorkOut_Fragment.this.nav_view.findViewsWithText(arrayList, navMenu.getItem(i).getTitle(), View.FIND_VIEWS_WITH_TEXT);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((TextView) it.next()).setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto_medium.ttf"), Typeface.NORMAL);
                }
            }
        });
//            inflate.findViewById(R.id.calculate).setOnClickListener(new c(this));
        inflate.findViewById(R.id.calculate).setOnClickListener(new OnClickListener() {


            public void onClick(View v) {
                mainAcdsctivity.loadFragment_Calculator(new Calculate_Fragment());


            }
        });
        inflate.findViewById(R.id.startexercise).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                b(view);
            }
        });
        inflate.findViewById(R.id.startdiet).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAcdsctivity.loadFragment_Mealplan(new MealPlanFragment());
            }
        });
        Toolbar toolbar2 = (Toolbar) inflate.findViewById(R.id.ex_time_toolbar);
        this.cordinatorLayout = (CoordinatorLayout) inflate.findViewById(R.id.notification_layout);
        final TimePicker timePicker = (TimePicker) inflate.findViewById(R.id.datePicker1);
        Button button = (Button) inflate.findViewById(R.id.set);
        this.prefsEditor = this.mSharedPreferences.edit();
        if (VERSION.SDK_INT >= 23) {
            this.m = timePicker.getHour();
            i = timePicker.getMinute();
        } else {
            this.m = timePicker.getCurrentHour().intValue();
            i = timePicker.getCurrentMinute().intValue();
        }
        this.n = i;
        this.prefsEditor.putInt("notification_hour", this.m);
        this.prefsEditor.putInt("notification_minute", this.n);
        String str = "first_time_notification";
        this.l = this.mSharedPreferences.getBoolean(str, false);
        if (!this.l) {
            Editor edit = this.mSharedPreferences.edit();
            edit.putBoolean(str, Boolean.TRUE.booleanValue());
            edit.apply();
            this.cordinatorLayout.setVisibility(View.VISIBLE);
        } else {
            this.cordinatorLayout.setVisibility(View.GONE);
        }
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WorkOut_Fragment firstScreenActivity;
                int i;
                if (VERSION.SDK_INT >= 23) {
                    WorkOut_Fragment.this.m = timePicker.getHour();
                    firstScreenActivity = WorkOut_Fragment.this;
                    i = timePicker.getMinute();
                } else {
                    WorkOut_Fragment.this.m = timePicker.getCurrentHour().intValue();
                    firstScreenActivity = WorkOut_Fragment.this;
                    i = timePicker.getCurrentMinute().intValue();
                }
                firstScreenActivity.n = i;
                WorkOut_Fragment.this.prefsEditor.putBoolean("user_selection", true);
                String str = "notification_hour";
                WorkOut_Fragment.this.prefsEditor.putInt(str, WorkOut_Fragment.this.m);
                String str2 = "notification_minute";
                WorkOut_Fragment.this.prefsEditor.putInt(str2, WorkOut_Fragment.this.n);
                String str3 = "ReminderCheck";
                Log.d(str3, "Reminder set in Main page");
                WorkOut_Fragment.this.prefsEditor.apply();
                StringBuilder sb = new StringBuilder();
                sb.append("Reminder set in ");
                sb.append(WorkOut_Fragment.this.mSharedPreferences.getInt(str, WorkOut_Fragment.this.m));
                String str4 = ":";
                sb.append(str4);
                sb.append(WorkOut_Fragment.this.mSharedPreferences.getInt(str2, WorkOut_Fragment.this.n));
                sb.append(str4);
                sb.append(0);
                Log.d(str3, sb.toString());
                WorkOut_Fragment firstScreenActivity2 = WorkOut_Fragment.this;
                firstScreenActivity2.setAlarm(firstScreenActivity2.mSharedPreferences.getInt(str, WorkOut_Fragment.this.m), WorkOut_Fragment.this.mSharedPreferences.getInt(str2, WorkOut_Fragment.this.n), 0);
                WorkOut_Fragment.this.cordinatorLayout.setVisibility(View.GONE);
            }
        });
        toolbar2.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WorkOut_Fragment firstScreenActivity = WorkOut_Fragment.this;
                firstScreenActivity.setAlarm(firstScreenActivity.mSharedPreferences.getInt("notification_hour", WorkOut_Fragment.this.m), WorkOut_Fragment.this.mSharedPreferences.getInt("notification_minute", WorkOut_Fragment.this.n), 0);
                WorkOut_Fragment.this.cordinatorLayout.setVisibility(View.GONE);
            }
        });


        List<WorkoutData> list = this.workoutDataList;
        if (list != null) {
            list.clear();
        }
        this.workoutDataList = databaseOperations.getAllDaysProgress();
        this.progressBar1 = (ProgressBar) inflate.findViewById(R.id.progress);

        for (i = 0; i < Constants.TOTAL_DAYS; i++) {
            double d = this.k;
            double progress = (double) ((WorkoutData) this.workoutDataList.get(i)).getProgress();
            Double.isNaN(progress);
            this.k = (double) ((float) (d + ((progress * 4.348d) / 100.0d)));
            if (((WorkoutData) this.workoutDataList.get(i)).getProgress() >= 99.0f) {
                this.daysCompletionConter++;
            }
        }


        int i2 = this.daysCompletionConter;
        this.daysCompletionConter = i2 + (i2 / 3);
        this.progressBar1.setProgress((int) this.k);
        TextView textView = this.percentScore1;
        StringBuilder sb = new StringBuilder();
        sb.append((int) this.k);
        sb.append("%");
        textView.setText(sb.toString());
        TextView textView2 = this.dayleft;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Constants.TOTAL_DAYS - this.daysCompletionConter);
        sb2.append(" Days left");
        textView2.setText(sb2.toString());


        if (z) {
            SharedPreferences.Editor edit2 = this.launchDataPreferences.edit();
            edit2.putBoolean(str1, false);
            edit2.apply();
            restartExcercise();
            this.daysCompletionConter = 0;
        }
        getActivity().registerReceiver(this.progressReceiver, new IntentFilter(AppUtils.WORKOUT_BROADCAST_FILTER));
        if (this.daysCompletionConter > 4) {


        }


        return inflate;

    }


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String str = "android.intent.action.VIEW";
        int itemId = menuItem.getItemId();
        if (itemId != R.id.trainingplan) {
            if (itemId == R.id.meals_plan) {
                startActivity(new Intent(getContext(), MealsMainActivity.class));
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            } else if (itemId == R.id.reminder) {
                reminderpopup();
            } else if (itemId == R.id.restartprogress) {
                launchDialogue();
            } else if (itemId == R.id.share) {
                shareApp();
            } else if (itemId == R.id.rateus) {
                try {
                    startActivity(new Intent(str, Uri.parse("market://details?id=com.fitnessch19.flatstomachworkout")));
                } catch (ActivityNotFoundException unused) {
                    startActivity(new Intent(str, Uri.parse("http://play.google.com/store/apps/details?id=com.fitnessch19.chestworkout")));
                }
            }

        }
        this.drawer.closeDrawer((int) GravityCompat.START);
        return true;
    }

    public void onResume() {
        this.nav_view.getMenu().getItem(0).setChecked(true);
        super.onResume();
    }

    public void setAlarm(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, i);
        instance.set(Calendar.MINUTE, i2);
        instance.set(Calendar.SECOND, i3);
        ((AlarmManager) getContext().getSystemService(CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(getContext(), 100, new Intent(getContext(), NotificationReceiver.class), 134217728));
    }

    public void restartExcercise() {
        SharedPreferences.Editor edit = this.launchDataPreferences.edit();
        String str = "daysInserted";
        edit.putBoolean(str, false);
        edit.apply();
        for (int i = 0; i < 30; i++) {
            String str2 = (String) this.arr.get(i);
            this.databaseOperations.insertExcDayData(str2, 0.0f);
            this.databaseOperations.insertExcCounter(str2, 0);
        }
        edit.putBoolean(str, true);
        edit.apply();
        List<WorkoutData> list = this.workoutDataList;
        if (list != null) {
            list.clear();
        }
        this.workoutDataList = this.databaseOperations.getAllDaysProgress();

        this.progressBar1.setProgress(0);
        this.percentScore1.setText("0%");
        TextView textView = this.dayleft;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TOTAL_DAYS);
        sb.append(" Days left");
        textView.setText(sb.toString());
    }
}
