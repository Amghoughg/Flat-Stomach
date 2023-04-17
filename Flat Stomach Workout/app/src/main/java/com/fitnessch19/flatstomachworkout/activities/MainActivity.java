package com.fitnessch19.flatstomachworkout.activities;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.MaterialDialog.Builder;
import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.adapters.AllDayAdapter;
import com.fitnessch19.flatstomachworkout.adapters.WorkoutData;
import com.fitnessch19.flatstomachworkout.database.DatabaseOperations;
import com.fitnessch19.flatstomachworkout.listners.RecyclerItemClickListener;
import com.fitnessch19.flatstomachworkout.listners.RecyclerItemClickListener.onItemClickListener;
import com.fitnessch19.flatstomachworkout.utils.AppUtils;
import com.fitnessch19.flatstomachworkout.utils.Constants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   public ImageView imageView;
    public AllDayAdapter adapter;
    public ArrayList<String> arr;
    public DatabaseOperations databaseOperations;
    public TextView dayleft;
    public int daysCompletionConter = 0;
    public int height;
    public double k = 0.0d;
    public SharedPreferences launchDataPreferences;
    public TextView percentScore1;
    public ProgressBar progressBar;
    public BroadcastReceiver progressReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            double doubleExtra = intent.getDoubleExtra(AppUtils.KEY_PROGRESS, 0.0d);
            try {
                ((WorkoutData) workoutDataList.get(workoutPosition)).setProgress((float) doubleExtra);
                MainActivity mainActivity = MainActivity.this;
                mainActivity.k = 0.0d;
                mainActivity.daysCompletionConter = 0;
                for (int i = 0; i < Constants.TOTAL_DAYS; i++) {
                    MainActivity mainActivity2 = MainActivity.this;
                    double d = mainActivity2.k;
                    double progress = (double) ((WorkoutData) mainActivity2.workoutDataList.get(i)).getProgress();
                    Double.isNaN(progress);
                    mainActivity2.k = (double) ((float) (d + ((progress * 4.348d) / 100.0d)));
                    if (((WorkoutData) workoutDataList.get(i)).getProgress() >= 99.0f) {
                        daysCompletionConter = daysCompletionConter + 1;
                    }
                }
                MainActivity mainActivity3 = MainActivity.this;
                mainActivity3.daysCompletionConter = mainActivity3.daysCompletionConter + (daysCompletionConter / 3);
                progressBar.setProgress((int) k);
                TextView g = percentScore1;
                StringBuilder sb = new StringBuilder();
                sb.append((int) k);
                sb.append("%");
                g.setText(sb.toString());
                TextView h = dayleft;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Constants.TOTAL_DAYS - daysCompletionConter);
                sb2.append(" Days left");
                h.setText(sb2.toString());
                adapter.notifyDataSetChanged();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(doubleExtra);
                Log.i("progress broadcast", sb3.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    public RecyclerView recyclerView;
    public int squareSize;
    public int width;
    public List<WorkoutData> workoutDataList;
    public int workoutPosition = -1;

    public /* synthetic */ void a(int i, MaterialDialog materialDialog, DialogAction dialogAction) {
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
            this.adapter = new AllDayAdapter(this, this.workoutDataList);
            this.recyclerView.getRecycledViewPool().clear();
            this.recyclerView.setAdapter(this.adapter);
            this.daysCompletionConter--;
            TextView textView2 = this.dayleft;
            StringBuilder sb = new StringBuilder();
            sb.append(Constants.TOTAL_DAYS - this.daysCompletionConter);
            sb.append(" Days left");
            textView2.setText(sb.toString());
            if (this.daysCompletionConter > 0) {
                this.progressBar.setProgress((int) (this.k - 4.348d));
                textView = this.percentScore1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append((int) (this.k - 4.348d));
                sb2.append("%");
                str = sb2.toString();
            } else {
                if (this.daysCompletionConter == 0) {
                    this.progressBar.setProgress(0);
                    textView = this.percentScore1;
                    str = "0%";
                }
                Intent intent = new Intent(this, DayActivity.class);
                intent.putExtra("day", str2);
                intent.putExtra("day_num", i);
                intent.putExtra("progress", ((WorkoutData) this.workoutDataList.get(i)).getProgress());
                startActivity(intent);
            }
            textView.setText(str);
            Intent intent2 = new Intent(this, DayActivity.class);
            intent2.putExtra("day", str2);
            intent2.putExtra("day_num", i);
            intent2.putExtra("progress", ((WorkoutData) this.workoutDataList.get(i)).getProgress());
            startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void b(final int i) {
        new Builder(this).title((CharSequence) "Confirm!").titleColor(ContextCompat.getColor(this, R.color.black)).content((CharSequence) "Would you like to repeat this workout?").contentColor(ContextCompat.getColor
                (this, R.color.textColor)).positiveText((CharSequence) "Yes").positiveColor
                (ContextCompat.getColor(this, R.color.colorAccent))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        a(i, dialog, which);
                    }
                }).negativeText((CharSequence) "No")
                .negativeColor(ContextCompat.getColor(this, R.color.textColor))
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            this.databaseOperations.deleteTable();
            Editor edit = this.launchDataPreferences.edit();
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
            this.adapter = new AllDayAdapter(this, this.workoutDataList);
            this.recyclerView.getRecycledViewPool().clear();
            this.recyclerView.setAdapter(this.adapter);
            this.progressBar.setProgress(0);
            this.percentScore1.setText("0%");
            TextView textView = this.dayleft;
            StringBuilder sb = new StringBuilder();
            sb.append(Constants.TOTAL_DAYS);
            sb.append(" Days left");
            textView.setText(sb.toString());
        }
        super.onActivityResult(i, i2, intent);
    }



    @SuppressLint("WrongViewCast")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_main);
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        getSupportActionBar().setDisplayShowTitleEnabled(false);



        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        imageView  = (ImageView) findViewById(R.id.back_arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        this.percentScore1 = (TextView) findViewById(R.id.percentScore);
        this.dayleft = (TextView) findViewById(R.id.daysLeft);
        this.launchDataPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.databaseOperations = new DatabaseOperations(this);
        String str = "thirtyday";
        boolean z = this.launchDataPreferences.getBoolean(str, false);
        String str2 = "daysInserted";
        boolean z2 = this.launchDataPreferences.getBoolean(str2, false);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;
        if (!z2 && this.databaseOperations.CheckDBEmpty() == 0) {
            this.databaseOperations.insertExcALLDayData();
            Editor edit = this.launchDataPreferences.edit();
            edit.putBoolean(str2, true);
            edit.apply();
        }
        List<WorkoutData> list = this.workoutDataList;
        if (list != null) {
            list.clear();
        }
        this.workoutDataList = this.databaseOperations.getAllDaysProgress();
        this.progressBar = (ProgressBar) findViewById(R.id.progress);
        this.progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.launch_progressbar));
        for (int i = 0; i < Constants.TOTAL_DAYS; i++) {
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
        this.progressBar.setProgress((int) this.k);
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
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
//        this.manager = new GridLayoutManager(this, 3);
        this.adapter = new AllDayAdapter(this, this.workoutDataList);
        this.arr = new ArrayList<>();
        this.recyclerView.getRecycledViewPool().clear();
        for (int i3 = 1; i3 <= Constants.TOTAL_DAYS; i3++) {
            ArrayList<String> arrayList = this.arr;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Day ");
            sb3.append(i3);
            arrayList.add(sb3.toString());
        }
        if (z) {
            Editor edit2 = this.launchDataPreferences.edit();
            edit2.putBoolean(str, false);
            edit2.apply();
            restartExcercise();
            this.daysCompletionConter = 0;
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(mLayoutManager);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new onItemClickListener() {
            public void OnItem(View view, int i) {
                Intent intent;
                workoutPosition = i;
                if ((workoutPosition + 1) % 4 == 0) {
                    intent = new Intent(MainActivity.this, RestDayActivity.class);
                } else if (((WorkoutData) workoutDataList.get(i)).getProgress() < 99.0f) {
                    intent = new Intent(MainActivity.this, DayActivity.class);
                    intent.putExtra("day", (String) arr.get(i));
                    intent.putExtra("day_num", i);
                    intent.putExtra("progress", ((WorkoutData) workoutDataList.get(i)).getProgress());
                } else {
                    b(i);
                    return;
                }
                startActivity(intent);
            }
        }));
        registerReceiver(this.progressReceiver, new IntentFilter(AppUtils.WORKOUT_BROADCAST_FILTER));
        if (this.daysCompletionConter > 4) {


        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.progressReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    public void restartExcercise() {
        Editor edit = this.launchDataPreferences.edit();
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
        this.adapter = new AllDayAdapter(this, this.workoutDataList);
        this.recyclerView.getRecycledViewPool().clear();
        this.recyclerView.setAdapter(this.adapter);
        this.progressBar.setProgress(0);
        this.percentScore1.setText("0%");
        TextView textView = this.dayleft;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TOTAL_DAYS);
        sb.append(" Days left");
        textView.setText(sb.toString());
    }

    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, After_MainActivity.class);
        startActivity(intent);
        finish();
    }


}
