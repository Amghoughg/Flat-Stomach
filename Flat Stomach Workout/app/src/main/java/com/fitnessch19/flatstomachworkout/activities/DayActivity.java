package com.fitnessch19.flatstomachworkout.activities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.adapters.IndividualDayAdapter;
import com.fitnessch19.flatstomachworkout.adapters.WorkoutData;
import com.fitnessch19.flatstomachworkout.database.DatabaseOperations;
import com.fitnessch19.flatstomachworkout.listners.RecyclerItemClickListener;
import com.fitnessch19.flatstomachworkout.listners.RecyclerItemClickListener.onItemClickListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DayActivity extends AppCompatActivity {
    public LinearLayout container;
    public DatabaseOperations databaseOperations;
    public Editor editorDay;
    public RecyclerView k;
    public Button l;
    public LinearLayoutManager m;
    public IndividualDayAdapter n;
    public String o;
    public float p;
    public SharedPreferences preferencesDay;
    public HashMap<String, Integer> hashMapExcAnimResIds;
    public HashMap<String, Integer> hashMapExcDescription;
    public int[] s = {R.array.day1, R.array.day2, R.array.day3, R.array.day4, R.array.day5, R.array.day6, R.array.day7, R.array.day8, R.array.day9, R.array.day10, R.array.day11, R.array.day12, R.array.day13, R.array.day14, R.array.day15, R.array.day16, R.array.day17, R.array.day18, R.array.day19, R.array.day20, R.array.day21, R.array.day22, R.array.day23, R.array.day24, R.array.day25, R.array.day26, R.array.day27, R.array.day28, R.array.day29, R.array.day30};
    public int[] t = {R.array.day1_cycles, R.array.day2_cycles, R.array.day3_cycles, R.array.day4_cycles, R.array.day5_cycles, R.array.day6_cycles, R.array.day7_cycles, R.array.day8_cycles, R.array.day9_cycles, R.array.day10_cycles, R.array.day11_cycles, R.array.day12_cycles, R.array.day13_cycles, R.array.day14_cycles, R.array.day15_cycles, R.array.day16_cycles, R.array.day17_cycles, R.array.day18_cycles, R.array.day19_cycles, R.array.day20_cycles, R.array.day21_cycles, R.array.day22_cycles, R.array.day23_cycles, R.array.day24_cycles, R.array.day25_cycles, R.array.day26_cycles, R.array.day27_cycles, R.array.day28_cycles, R.array.day29_cycles, R.array.day30_cycles};
    public int u = -1;
    public ArrayList<WorkoutData> v;
    public InterstitialAd w;
    public AdRequest x;
    public Intent y;


    public void requestNewInterstitial() {
        this.w.loadAd(this.x);
    }

    private void setAdmodAds() {
        this.w = new InterstitialAd(this);
        this.w.setAdUnitId(getString(R.string.g_inr));
        this.x = new Builder().build();
        this.w.setAdListener(new AdListener() {
            public void onAdClosed() {
                super.onAdClosed();
                DayActivity dayActivity = DayActivity.this;
                dayActivity.startActivity(dayActivity.y);
                DayActivity.this.requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.hashMapExcDescription = new HashMap<>();
        this.hashMapExcDescription.put(getString(R.string.trunk_rotation), Integer.valueOf(R.string.trunk_rotation_desc));
        this.hashMapExcDescription.put(getString(R.string.mountain_climber), Integer.valueOf(R.string.mountain_climber_desc));
        this.hashMapExcDescription.put(getString(R.string.clapping_crunches), Integer.valueOf(R.string.clapping_crunches_desc));
        this.hashMapExcDescription.put(getString(R.string.swimming_and_superman), Integer.valueOf(R.string.swimming_and_superman_desc));
        this.hashMapExcDescription.put(getString(R.string.butt_bridge), Integer.valueOf(R.string.butt_bridge_desc));
        this.hashMapExcDescription.put(getString(R.string.flutter_kicks), Integer.valueOf(R.string.flutter_kicks_desc));
        this.hashMapExcDescription.put(getString(R.string.plank), Integer.valueOf(R.string.plank_desc));
        this.hashMapExcDescription.put(getString(R.string.reverse_crunches), Integer.valueOf(R.string.reverse_crunches_desc));
        this.hashMapExcDescription.put(getString(R.string.bent_leg_twist), Integer.valueOf(R.string.bent_leg_twist_desc));
        this.hashMapExcDescription.put(getString(R.string.bicycle_crunches), Integer.valueOf(R.string.bicycle_crunches_desc));
        this.hashMapExcDescription.put(getString(R.string.russian_twist), Integer.valueOf(R.string.russian_twist_desc));
        this.hashMapExcDescription.put(getString(R.string.reclined_oblique_twist), Integer.valueOf(R.string.reclined_oblique_twist_desc));
        this.hashMapExcDescription.put(getString(R.string.cross_arm_crunches), Integer.valueOf(R.string.cross_arm_crunches_desc));
        this.hashMapExcDescription.put(getString(R.string.standing_bicycle), Integer.valueOf(R.string.standing_bicycle_desc));
        this.hashMapExcDescription.put(getString(R.string.leg_drops), Integer.valueOf(R.string.leg_drops_desc));
        this.hashMapExcDescription.put(getString(R.string.side_leg_rise_left), Integer.valueOf(R.string.side_leg_rise_left_desc));
        this.hashMapExcDescription.put(getString(R.string.side_leg_rise_right), Integer.valueOf(R.string.side_leg_rise_right_desc));
        this.hashMapExcDescription.put(getString(R.string.long_arm_crunches), Integer.valueOf(R.string.long_arm_crunches_desc));
        this.hashMapExcDescription.put(getString(R.string.dead_bug), Integer.valueOf(R.string.dead_bug_desc));
        this.hashMapExcDescription.put(getString(R.string.reverse_crunch_advance), Integer.valueOf(R.string.reverse_crunch_advance_desc));
        this.hashMapExcDescription.put(getString(R.string.cross_body_mountain_climber), Integer.valueOf(R.string.cross_body_mountain_climber_desc));
        this.hashMapExcDescription.put(getString(R.string.roll_up), Integer.valueOf(R.string.roll_up_desc));
        this.hashMapExcDescription.put(getString(R.string.Side_plank_hip_left), Integer.valueOf(R.string.Side_plank_hip_left_desc));
        this.hashMapExcDescription.put(getString(R.string.Side_plank_hip_right), Integer.valueOf(R.string.Side_plank_hip_right_desc));
        this.hashMapExcDescription.put(getString(R.string.V_sits), Integer.valueOf(R.string.V_sits_desc));
        this.hashMapExcDescription.put(getString(R.string.Windshield_wipers), Integer.valueOf(R.string.Windshield_wipers_desc));

    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.hashMapExcAnimResIds = new HashMap<>();
        this.hashMapExcAnimResIds.put(getString(R.string.trunk_rotation), Integer.valueOf(R.array.trunk_rotation));
        this.hashMapExcAnimResIds.put(getString(R.string.mountain_climber), Integer.valueOf(R.array.mountain_climber));
        this.hashMapExcAnimResIds.put(getString(R.string.clapping_crunches), Integer.valueOf(R.array.clapping_crunches));
        this.hashMapExcAnimResIds.put(getString(R.string.swimming_and_superman), Integer.valueOf(R.array.swimming_and_superman));
        this.hashMapExcAnimResIds.put(getString(R.string.butt_bridge), Integer.valueOf(R.array.butt_bridge));
        this.hashMapExcAnimResIds.put(getString(R.string.flutter_kicks), Integer.valueOf(R.array.flutter_kicks));
        this.hashMapExcAnimResIds.put(getString(R.string.plank), Integer.valueOf(R.array.plank));
        this.hashMapExcAnimResIds.put(getString(R.string.reverse_crunches), Integer.valueOf(R.array.reverse_crunches));
        this.hashMapExcAnimResIds.put(getString(R.string.bent_leg_twist), Integer.valueOf(R.array.bent_leg_twist));
        this.hashMapExcAnimResIds.put(getString(R.string.bicycle_crunches), Integer.valueOf(R.array.bicycle_crunches));
        this.hashMapExcAnimResIds.put(getString(R.string.russian_twist), Integer.valueOf(R.array.russian_twist));
        this.hashMapExcAnimResIds.put(getString(R.string.reclined_oblique_twist), Integer.valueOf(R.array.reclined_oblique_twist));
        this.hashMapExcAnimResIds.put(getString(R.string.cross_arm_crunches), Integer.valueOf(R.array.cross_arm_crunches));
        this.hashMapExcAnimResIds.put(getString(R.string.standing_bicycle), Integer.valueOf(R.array.standing_bicycle));
        this.hashMapExcAnimResIds.put(getString(R.string.leg_drops), Integer.valueOf(R.array.leg_drops));
        this.hashMapExcAnimResIds.put(getString(R.string.side_leg_rise_left), Integer.valueOf(R.array.side_leg_rise_left));
        this.hashMapExcAnimResIds.put(getString(R.string.side_leg_rise_right), Integer.valueOf(R.array.side_leg_rise_right));
        this.hashMapExcAnimResIds.put(getString(R.string.long_arm_crunches), Integer.valueOf(R.array.long_arm_crunches));
        this.hashMapExcAnimResIds.put(getString(R.string.dead_bug), Integer.valueOf(R.array.dead_bug));
        this.hashMapExcAnimResIds.put(getString(R.string.reverse_crunch_advance), Integer.valueOf(R.array.reverse_crunch_advance));
        this.hashMapExcAnimResIds.put(getString(R.string.cross_body_mountain_climber), Integer.valueOf(R.array.cross_body_mountain_climber));
        this.hashMapExcAnimResIds.put(getString(R.string.roll_up), Integer.valueOf(R.array.roll_up));
        this.hashMapExcAnimResIds.put(getString(R.string.Side_plank_hip_left), Integer.valueOf(R.array.Side_plank_hip_left));
        this.hashMapExcAnimResIds.put(getString(R.string.Side_plank_hip_right), Integer.valueOf(R.array.Side_plank_hip_right));
        this.hashMapExcAnimResIds.put(getString(R.string.V_sits), Integer.valueOf(R.array.V_sits));
        this.hashMapExcAnimResIds.put(getString(R.string.Windshield_wipers), Integer.valueOf(R.array.Windshield_wipers));
    }


    public ArrayList<WorkoutData> d() {
        ArrayList<WorkoutData> arrayList = new ArrayList<>();
        String[] stringArray = getResources().getStringArray(this.s[this.u]);
        String dayExcCycles = this.databaseOperations.getDayExcCycles(this.o);
        StringBuilder sb = new StringBuilder();
        sb.append("Day exc cycles DayActivity: ");
        sb.append(dayExcCycles);
        String str = "TAG";
        Log.e(str, sb.toString());
        int[] iArr = new int[0];
        JSONObject jSONObject = null;
        if (dayExcCycles != null) {
            try {
                jSONObject = new JSONObject(dayExcCycles);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        iArr = new int[jSONObject.length()];
        for (int i = 0; i < stringArray.length; i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("prepareAdapterData: ");
            sb2.append(stringArray[i]);
            Log.i(str, sb2.toString());
            TypedArray obtainTypedArray = getResources().obtainTypedArray(((Integer) this.hashMapExcAnimResIds.get(stringArray[i])).intValue());
            int length = obtainTypedArray.length();
            int[] iArr2 = new int[length];
            WorkoutData workoutData = new WorkoutData();
            for (int i2 = 0; i2 < length; i2++) {
                iArr2[i2] = obtainTypedArray.getResourceId(i2, -1);
            }
            workoutData.setExcName(stringArray[i]);
            workoutData.setExcDescResId(((Integer) this.hashMapExcDescription.get(stringArray[i])).intValue());
            try {
                iArr[i] = jSONObject.getInt(String.valueOf(i));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            workoutData.setExcCycles(iArr[i]);
            workoutData.setPosition(i);
            workoutData.setImageIdList(iArr2);
            arrayList.add(workoutData);
        }
        return arrayList;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.day_layout);
        this.k = (RecyclerView) findViewById(R.id.recyclerAllDaysList);
        this.l = (Button) findViewById(R.id.buttonTwo);
        this.m = new LinearLayoutManager(this, 1, false);
        setAdmodAds();
        c();
        b();
        Bundle extras = getIntent().getExtras();
        this.o = extras.getString("day");
        this.u = extras.getInt("day_num");
        this.p = extras.getFloat("progress");
        this.databaseOperations = new DatabaseOperations(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mtoolbar);
        ((TextView) toolbar.findViewById(R.id.mtoolbar_title)).setText(this.o);
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DayActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.mtoolbar_title1);
        textView.setText(this.o);
        this.v = d();
        this.n = new IndividualDayAdapter(this, this.o, this.v, 200);
        this.k.setLayoutManager(this.m);
        this.k.setAdapter(this.n);
        this.k.addOnItemTouchListener(new RecyclerItemClickListener(this, new onItemClickListener() {
            public void OnItem(View view, int i) {
                if (i < DayActivity.this.v.size()) {
                    Intent intent = new Intent(DayActivity.this, ExcDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("day", DayActivity.this.o);
                    bundle.putIntArray("framesIdArray", ((WorkoutData) DayActivity.this.v.get(i)).getImageIdList());
                    bundle.putString("excName", ((WorkoutData) DayActivity.this.v.get(i)).getExcName());
                    DayActivity dayActivity = DayActivity.this;
                    bundle.putInt("excNameDescResId", ((Integer) dayActivity.hashMapExcDescription.get(((WorkoutData) dayActivity.v.get(i)).getExcName())).intValue());
                    bundle.putInt("excCycle", ((WorkoutData) DayActivity.this.v.get(i)).getExcCycles());
                    bundle.putInt("excPosition", i);
                    intent.putExtras(bundle);
                    DayActivity.this.startActivity(intent);
                }
            }
        }));
        this.l.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DayActivity dayActivity = DayActivity.this;
                dayActivity.y = new Intent(dayActivity, MainExcerciseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("workoutDataList", DayActivity.this.v);
                DayActivity.this.y.putExtras(bundle);
                DayActivity dayActivity2 = DayActivity.this;
                dayActivity2.y.putExtra("day", dayActivity2.o);
                DatabaseOperations databaseOperations = new DatabaseOperations(DayActivity.this);
                DayActivity dayActivity3 = DayActivity.this;
                dayActivity3.p = databaseOperations.getExcDayProgress(dayActivity3.o);
                DayActivity dayActivity4 = DayActivity.this;
                dayActivity4.y.putExtra("progress", dayActivity4.p);
                if (DayActivity.this.w.isLoaded()) {
                    DayActivity.this.w.show();
                    return;
                }
                DayActivity dayActivity5 = DayActivity.this;
                dayActivity5.startActivity(dayActivity5.y);
            }
        });
    }

    public void onDestroy() {
        this.k.setAdapter(null);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onResume() {
        super.onResume();
        this.v = d();
        this.n = new IndividualDayAdapter(this, this.o, this.v, 200);
        this.k.setAdapter(this.n);
        this.k.setLayoutManager(new LinearLayoutManager(this));
        this.n.notifyDataSetChanged();
    }
}
