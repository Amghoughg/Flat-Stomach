package com.fitnessch19.flatstomachworkout.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.activities.CalculateActivity;


public class Calculate_Fragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public float Heightincms = 0.0f;

    public RadioButton female;
    public EditText ft;
    public int height;
    public EditText inches;

    public RadioButton kg;

    public RadioButton lbs;

    public SharedPreferences mSharedPreferences;
    public RadioButton male;

    public SharedPreferences.Editor prefsEditor;
    public EditText weight;
    public int width;
    public EditText year;
    public TextView calculate;


    public static Calculate_Fragment newInstance(String str, String str2) {

        Calculate_Fragment mainFragment = new Calculate_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_calculator, viewGroup, false);


        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        this.lbs = (RadioButton) inflate.findViewById(R.id.lbs);
        this.kg = (RadioButton) inflate.findViewById(R.id.kg);
        this.male = (RadioButton) inflate.findViewById(R.id.male);
        this.female = (RadioButton) inflate.findViewById(R.id.female);
        this.ft = (EditText) inflate.findViewById(R.id.feet);
        this.inches = (EditText) inflate.findViewById(R.id.inches);
        this.year = (EditText) inflate.findViewById(R.id.year);
        this.weight = (EditText) inflate.findViewById(R.id.weight);
        this.calculate = (TextView)  inflate.findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calculate_Fragment firstScreenActivity;
                String str;
                Calculate_Fragment firstScreenActivity2;
                Intent intent = null;
                String str2 = "";
                if (Calculate_Fragment.this.year.getText().toString().equals(str2) || Calculate_Fragment.this.ft.getText().toString().equals(str2) || Calculate_Fragment.this.inches.getText().toString().equals(str2) || Calculate_Fragment.this.weight.getText().toString().equals(str2)) {
                    firstScreenActivity = Calculate_Fragment.this;
                    str = "Please fill all the fields";
                } else if (Calculate_Fragment.this.year.getText().toString().matches(str2) || Integer.parseInt(Calculate_Fragment.this.year.getText().toString()) < 5 || Integer.parseInt(Calculate_Fragment.this.year.getText().toString()) > 100) {
                    firstScreenActivity = Calculate_Fragment.this;
                    str = "Age should be in range 5-100 years";
                } else if (Calculate_Fragment.this.ft.getText().toString().matches(str2) || Integer.parseInt(Calculate_Fragment.this.ft.getText().toString()) < 2 || Integer.parseInt(Calculate_Fragment.this.ft.getText().toString()) > 7) {
                    firstScreenActivity = Calculate_Fragment.this;
                    str = "Feet should be in range 2-7";
                } else if (Calculate_Fragment.this.inches.getText().toString().matches(str2) || Integer.parseInt(Calculate_Fragment.this.inches.getText().toString()) < 0 || Integer.parseInt(Calculate_Fragment.this.inches.getText().toString()) > 12) {
                    firstScreenActivity = Calculate_Fragment.this;
                    str = "Inches should be in range 0-12";
                } else {
                    String str3 = "HEIGHT";
                    String str4 = "BMI";
                    if (Calculate_Fragment.this.kg.isChecked()) {
                        if (Calculate_Fragment.this.weight.getText().toString().matches(str2) || Integer.parseInt(Calculate_Fragment.this.weight.getText().toString()) < 5 || Integer.parseInt(Calculate_Fragment.this.weight.getText().toString()) > 100) {
                            firstScreenActivity = Calculate_Fragment.this;
                            str = "Weight should be in range 5-100 Kg";
                        } else {
                            Calculate_Fragment firstScreenActivity3 = Calculate_Fragment.this;
                            float b2 = firstScreenActivity3.calculateMetres(Float.parseFloat(firstScreenActivity3.ft.getText().toString()), Float.parseFloat(Calculate_Fragment.this.inches.getText().toString()));
                            Calculate_Fragment firstScreenActivity4 = Calculate_Fragment.this;
                            int a2 = firstScreenActivity3.calculateBMI(b2, firstScreenActivity4.calculateweight(Float.parseFloat(firstScreenActivity4.weight.getText().toString())));
                            Calculate_Fragment firstScreenActivity5 = Calculate_Fragment.this;
                            prefsEditor = mSharedPreferences.edit();
                            Calculate_Fragment.this.prefsEditor.putFloat(str4, (float) a2);
                            Calculate_Fragment.this.prefsEditor.putFloat(str3, Calculate_Fragment.this.Heightincms);
                            Calculate_Fragment.this.prefsEditor.apply();

                            intent = new Intent(getContext(), CalculateActivity.class);
                            getActivity().finish();
                        }
                    } else if (!Calculate_Fragment.this.lbs.isChecked()) {
                        return ;
                    } else {
                        if (Calculate_Fragment.this.weight.getText().toString().matches(str2) || Integer.parseInt(Calculate_Fragment.this.weight.getText().toString()) < 11 || Integer.parseInt(Calculate_Fragment.this.weight.getText().toString()) > 220) {
                            firstScreenActivity = Calculate_Fragment.this;
                            str = "Weight should be in range 11-220 lb";
                        } else {
                            Calculate_Fragment firstScreenActivity6 = Calculate_Fragment.this;
                            float b3 = firstScreenActivity6.calculateMetres(Float.parseFloat(firstScreenActivity6.ft.getText().toString()), Float.parseFloat(Calculate_Fragment.this.inches.getText().toString()));
                            Calculate_Fragment firstScreenActivity7 = Calculate_Fragment.this;
                            float a3 = (float) firstScreenActivity6.calculateBMI(b3, firstScreenActivity7.calculateweight(Float.parseFloat(firstScreenActivity7.weight.getText().toString())));
                            Calculate_Fragment firstScreenActivity8 = Calculate_Fragment.this;
                            firstScreenActivity8.prefsEditor = firstScreenActivity8.mSharedPreferences.edit();
                            Calculate_Fragment.this.prefsEditor.putFloat(str4, a3);
                            Calculate_Fragment.this.prefsEditor.putFloat(str3, Calculate_Fragment.this.Heightincms);
                            Calculate_Fragment.this.prefsEditor.apply();

                            intent = new Intent(getContext(), CalculateActivity.class);
                            getActivity().finish();
                        }
                    }

                    startActivity(intent.putExtra(str4, Calculate_Fragment.this.mSharedPreferences.getFloat(str4, 0.0f)).putExtra(str3, Calculate_Fragment.this.mSharedPreferences.getFloat(str3, 0.0f)));


                    return ;
                }
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });




        return inflate;
    }
    public int calculateBMI(float f, float f2) {
        return (int) (f2 / (f * f));
    }

    private float calculateHeightinCentimeter(float f) {
        return (float) ((int) (f * 100.0f));
    }


    public float calculateMetres(float f, float f2) {
        double d = (double) (f + (f2 / 12.0f));
        Double.isNaN(d);
        float f3 = (float) (d / 3.28d);
        this.Heightincms = calculateHeightinCentimeter(f3);
        return f3;
    }


    public float calculateweight(float f) {
        if (!this.lbs.isChecked()) {
            return f;
        }
        double d = (double) f;
        Double.isNaN(d);
        return (float) (d * 0.453592d);
    }



}


