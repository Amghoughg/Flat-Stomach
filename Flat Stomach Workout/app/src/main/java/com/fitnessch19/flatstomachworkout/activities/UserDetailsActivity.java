package com.fitnessch19.flatstomachworkout.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.fitnessch19.flatstomachworkout.ConstantValues;
import com.fitnessch19.flatstomachworkout.R;

import java.io.PrintStream;
import java.util.ArrayList;

//import com.fortyfourapps.heightboosterexercise.R;
//import com.fortyfourapps.heightboosterexercise.constant.ConstantValues;

public class UserDetailsActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public Button btn_nxt;
    /* access modifiers changed from: private */
    public EditText edttxt_height;
    /* access modifiers changed from: private */
    public EditText edttxt_height1;
    /* access modifiers changed from: private */
    public EditText edttxt_height2;
    /* access modifiers changed from: private */
    public EditText edttxt_weight;
    String[] height = {"ft+in", "cm"};
    /* access modifiers changed from: private */
    public RadioButton radioSexButton;
    /* access modifiers changed from: private */
    public RadioGroup radioSexGroup;
    private Spinner simpleSpinner_age;
    private Spinner simpleSpinner_height;
    private Spinner simpleSpinner_weight;
    /* access modifiers changed from: private */
    public String userAge;
    /* access modifiers changed from: private */
    public String usergender;
    /* access modifiers changed from: private */
    public String userheight;
    /* access modifiers changed from: private */
    public String userweight;
    String[] weight = {"kg", "lb"};

    private void init() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_userdetails);
        init();
        initializeviews();
        setUpView();
    }

    private void initializeviews() {
        this.radioSexGroup = (RadioGroup) findViewById(R.id.radioGrp);
        this.simpleSpinner_age = (Spinner) findViewById(R.id.simpleSpinner_age);
        this.simpleSpinner_height = (Spinner) findViewById(R.id.simpleSpinner_height);
        this.simpleSpinner_weight = (Spinner) findViewById(R.id.simpleSpinner_weight);
        this.edttxt_height = (EditText) findViewById(R.id.edttxt_height);
        this.edttxt_weight = (EditText) findViewById(R.id.edttxt_weight);
        this.btn_nxt = (Button) findViewById(R.id.btn_nxt);
        this.edttxt_height1 = (EditText) findViewById(R.id.edttxt_height1);
        this.edttxt_height2 = (EditText) findViewById(R.id.edttxt_height2);
    }

    private void setUpView() {
        this.btn_nxt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = 16)
            public void onClick(View view) {
                String str;
                if (UserDetailsActivity.this.radioSexGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(UserDetailsActivity.this, "Select your Gender", Toast.LENGTH_SHORT).show();
                } else if (UserDetailsActivity.this.userAge.equals("Select Age")) {
                    Toast.makeText(UserDetailsActivity.this, "Select your Age", Toast.LENGTH_SHORT).show();
                } else if (UserDetailsActivity.this.userheight.equals("ft+in") && UserDetailsActivity.this.edttxt_height.getText().toString().isEmpty() && UserDetailsActivity.this.edttxt_height1.getText().toString().isEmpty()) {
                    Toast.makeText(UserDetailsActivity.this, "Enter your Height", Toast.LENGTH_SHORT).show();
                } else if (UserDetailsActivity.this.userheight.equals("cm") && UserDetailsActivity.this.edttxt_height2.getText().toString().isEmpty()) {
                    Toast.makeText(UserDetailsActivity.this, "Enter your Height", Toast.LENGTH_SHORT).show();
                } else if (UserDetailsActivity.this.edttxt_weight.getText().toString().isEmpty()) {
                    Toast.makeText(UserDetailsActivity.this, "Enter your Weight", Toast.LENGTH_SHORT).show();
                } else {
                    UserDetailsActivity.this.btn_nxt.setBackground(UserDetailsActivity.this.getResources().getDrawable(R.drawable.a3_grad));
                    RadioButton unused = UserDetailsActivity.this.radioSexButton = (RadioButton) UserDetailsActivity.this.findViewById(UserDetailsActivity.this.radioSexGroup.getCheckedRadioButtonId());
                    String unused2 = UserDetailsActivity.this.usergender = String.valueOf(UserDetailsActivity.this.radioSexButton.getText());
                    if (UserDetailsActivity.this.userheight.equals("ft+in")) {
                        str = UserDetailsActivity.this.edttxt_height.getText().toString() + ":" + UserDetailsActivity.this.edttxt_height1.getText().toString() + " " + UserDetailsActivity.this.userheight;
                    } else {
                        str = UserDetailsActivity.this.edttxt_height2.getText().toString() + " " + UserDetailsActivity.this.userweight;
                    }
                    UserDetailsActivity.this.saveUserData(UserDetailsActivity.this.usergender, UserDetailsActivity.this.userAge, str, UserDetailsActivity.this.edttxt_weight.getText().toString() + " " + UserDetailsActivity.this.userweight);
                }
            }
        });
        ageSpinnerData();
        weightSpinnerData();
        heightSpinnerData();
    }

    private void ageSpinnerData() {
        final ArrayList arrayList = new ArrayList();
        arrayList.add("Select Age");
        for (int i = 1; i <= 100; i++) {
            arrayList.add(Integer.toString(i));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_text, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        this.simpleSpinner_age.setAdapter(arrayAdapter);
        this.simpleSpinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                String unused = UserDetailsActivity.this.userAge = String.valueOf(arrayList.get(i));
            }
        });
    }

    private void heightSpinnerData() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_text, this.height);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        this.simpleSpinner_height.setAdapter(arrayAdapter);
        this.simpleSpinner_height.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                String unused = UserDetailsActivity.this.userheight = String.valueOf(UserDetailsActivity.this.height[i]);
                PrintStream printStream = System.out;
                printStream.println("<<<<<<<<<<<" + UserDetailsActivity.this.userheight);
                if (UserDetailsActivity.this.userheight.equals("ft+in")) {
                    UserDetailsActivity.this.edttxt_height2.setVisibility(View.GONE);
                    UserDetailsActivity.this.edttxt_height1.setVisibility(View.VISIBLE);
                    UserDetailsActivity.this.edttxt_height.setVisibility(View.VISIBLE);
                    return;
                }
                UserDetailsActivity.this.edttxt_height2.setVisibility(View.VISIBLE);
                UserDetailsActivity.this.edttxt_height1.setVisibility(View.GONE);
                UserDetailsActivity.this.edttxt_height.setVisibility(View.GONE);
            }
        });
    }

    private void weightSpinnerData() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_text, this.weight);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        this.simpleSpinner_weight.setAdapter(arrayAdapter);
        this.simpleSpinner_weight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                String unused = UserDetailsActivity.this.userweight = String.valueOf(UserDetailsActivity.this.weight[i]);
            }
        });
    }


    public void saveUserData(String str, String str2, String str3, String str4) {
        SharedPreferences.Editor edit = getSharedPreferences(ConstantValues.PREFS_NAME, MODE_PRIVATE).edit();
        edit.putBoolean("logged", true);
        edit.putString("gender", str);
        edit.putString("age", str2);
        edit.putString("height", str3);
        edit.putString("weight", str4);
        edit.apply();
        edit.commit();
        startActivity(new Intent(this, Start_Activity.class));
        finish();
    }
}
