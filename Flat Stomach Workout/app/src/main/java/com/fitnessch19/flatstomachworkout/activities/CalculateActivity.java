package com.fitnessch19.flatstomachworkout.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.utils.CustomSeekBar;
import com.fitnessch19.flatstomachworkout.utils.ProgressItem;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class CalculateActivity extends Activity {
    public float Heightincms = 0.0f;
    public AdRequest adRequest;
    public double bmiblueSpan = 4.0d;
    public double bmigreenSpan = 7.0d;
    public float bmiorangeSpan = 10.0f;
    public float bmiredSpan;
    public CustomSeekBar bmiseekBar;
    public float bmitotalSpan = 50.0f;
    public float bmivioletSpan = 15.0f;
    public float bmiyellowSpan = 5.0f;
    public RadioButton female;
    public EditText ft;
    public TextView height_desc;
    public double heightblueSpan = 16.0d;
    public double heightgreenSpan = 8.0d;
    public float heightorangeSpan = 7.0f;
    public float heightredSpan;
    public CustomSeekBar heightseekBar;
    public float heighttotalSpan = 213.0f;
    public float heightvioletSpan = 135.0f;
    public float heightyellowSpan = 12.0f;
    public TextView hght2;
    public TextView hght4;
    public EditText inches;
    public InterstitialAd interstitial;
    public RadioButton kg;
    public RadioButton lbs;
    public ProgressItem mProgressItem;
    public SharedPreferences mSharedPreferences;
    public RadioButton male;
    public Editor prefsEditor;
    public ArrayList<ProgressItem> progressItemList;
    public EditText weight;
    public TextView wght2;
    public TextView wght4;
    public EditText year;


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

    private void initDataToSeekbar() {
        float floatExtra;
        TextView textView = null;
        Resources resources = null;
        int i = 0;
        TextView textView2 = null;
        String str = null;
        this.heightseekBar.setEnabled(true);
        this.bmiseekBar.setEnabled(true);
        this.progressItemList = new ArrayList<>();
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem = this.mProgressItem;
        progressItem.progressItemPercentage = (this.bmivioletSpan / this.bmitotalSpan) * 100.0f;
        progressItem.color = R.color.violet;
        this.progressItemList.add(progressItem);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem2 = this.mProgressItem;
        double d = this.bmiblueSpan;
        double d2 = (double) this.bmitotalSpan;
        Double.isNaN(d2);
        progressItem2.progressItemPercentage = ((float) (d / d2)) * 100.0f;
        progressItem2.color = R.color.blue;
        this.progressItemList.add(progressItem2);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem3 = this.mProgressItem;
        double d3 = this.bmigreenSpan;
        double d4 = (double) this.bmitotalSpan;
        Double.isNaN(d4);
        progressItem3.progressItemPercentage = ((float) (d3 / d4)) * 100.0f;
        progressItem3.color = R.color.green;
        this.progressItemList.add(progressItem3);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem4 = this.mProgressItem;
        progressItem4.progressItemPercentage = (this.bmiyellowSpan / this.bmitotalSpan) * 100.0f;
        progressItem4.color = R.color.yellow;
        this.progressItemList.add(progressItem4);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem5 = this.mProgressItem;
        progressItem5.progressItemPercentage = (this.bmiorangeSpan / this.bmitotalSpan) * 100.0f;
        progressItem5.color = R.color.orange;
        this.progressItemList.add(progressItem5);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem6 = this.mProgressItem;
        progressItem6.progressItemPercentage = (this.bmiredSpan / this.bmitotalSpan) * 100.0f;
        progressItem6.color = R.color.red;
        this.progressItemList.add(progressItem6);
        this.bmiseekBar.initData(this.progressItemList);
        float floatExtra2 = getIntent().getFloatExtra("BMI", 0.0f);
        this.bmiseekBar.setProgress((int) floatExtra2);
        this.wght4.setText(String.valueOf(floatExtra2));
        if (floatExtra2 >= 0.0f && floatExtra2 <= 15.0f) {
            textView2 = this.wght2;
            str = "Severely Underweight";
        } else if (floatExtra2 >= 16.0f && floatExtra2 <= 18.0f) {
            textView2 = this.wght2;
            str = "Underweight";
        } else if (floatExtra2 >= 19.0f && floatExtra2 <= 25.0f) {
            textView2 = this.wght2;
            str = "Normal (Healthy Weight)";
        } else if (floatExtra2 >= 26.0f && floatExtra2 <= 30.0f) {
            textView2 = this.wght2;
            str = "Overweight";
        } else if (floatExtra2 < 31.0f || floatExtra2 > 40.0f) {
            if (floatExtra2 >= 41.0f && floatExtra2 <= 50.0f) {
                textView2 = this.wght2;
                str = "Severely Obese";
            }
            this.bmiseekBar.invalidate();
            this.progressItemList = new ArrayList<>();
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem7 = this.mProgressItem;
            progressItem7.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
            progressItem7.color = R.color.violet;
            this.progressItemList.add(progressItem7);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem8 = this.mProgressItem;
            double d5 = this.heightblueSpan;
            double d6 = (double) this.heighttotalSpan;
            Double.isNaN(d6);
            progressItem8.progressItemPercentage = ((float) (d5 / d6)) * 100.0f;
            progressItem8.color = R.color.blue;
            this.progressItemList.add(progressItem8);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem9 = this.mProgressItem;
            double d7 = this.heightgreenSpan;
            double d8 = (double) this.heighttotalSpan;
            Double.isNaN(d8);
            progressItem9.progressItemPercentage = ((float) (d7 / d8)) * 100.0f;
            progressItem9.color = R.color.green;
            this.progressItemList.add(progressItem9);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem10 = this.mProgressItem;
            progressItem10.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
            progressItem10.color = R.color.yellow;
            this.progressItemList.add(progressItem10);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem11 = this.mProgressItem;
            progressItem11.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
            progressItem11.color = R.color.orange;
            this.progressItemList.add(progressItem11);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem12 = this.mProgressItem;
            progressItem12.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
            progressItem12.color = R.color.red;
            this.progressItemList.add(progressItem12);
            this.heightseekBar.initData(this.progressItemList);
            floatExtra = getIntent().getFloatExtra("HEIGHT", 0.0f);
            this.heightseekBar.setProgress((int) floatExtra);
            this.hght4.setText(String.valueOf(floatExtra));
            if (floatExtra < 0.0f && floatExtra <= 135.0f) {
                this.hght2.setText("Very Short Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.veryshort;
            } else if (floatExtra < 136.0f && floatExtra <= 150.0f) {
                this.hght2.setText("Too Short Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.tooshortheight;
            } else if (floatExtra < 151.0f && floatExtra <= 158.0f) {
                this.hght2.setText("Below Average Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.belowaverageheight;
            } else if (floatExtra < 159.0f && floatExtra <= 170.0f) {
                this.hght2.setText("Average Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.averageheight;
            } else if (floatExtra >= 171.0f || floatExtra > 178.0f) {
                if (floatExtra >= 179.0f && floatExtra <= 213.0f) {
                    this.hght2.setText("Extra Long Height");
                    textView = this.height_desc;
                    resources = getResources();
                    i = R.string.extralongheight;
                }
                this.heightseekBar.invalidate();
                this.heightseekBar.setEnabled(false);
                this.bmiseekBar.setEnabled(false);
            } else {
                this.hght2.setText("Above Average Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.aboveaverageheight;
            }
            textView.setText(resources.getString(i));
            this.heightseekBar.invalidate();
            this.heightseekBar.setEnabled(false);
            this.bmiseekBar.setEnabled(false);
        } else {
            textView2 = this.wght2;
            str = "Obese";
        }
        textView2.setText(str);
        this.bmiseekBar.invalidate();
        this.progressItemList = new ArrayList<>();
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem72 = this.mProgressItem;
        progressItem72.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
        progressItem72.color = R.color.violet;
        this.progressItemList.add(progressItem72);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem82 = this.mProgressItem;
        double d52 = this.heightblueSpan;
        double d62 = (double) this.heighttotalSpan;
        Double.isNaN(d62);
        progressItem82.progressItemPercentage = ((float) (d52 / d62)) * 100.0f;
        progressItem82.color = R.color.blue;
        this.progressItemList.add(progressItem82);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem92 = this.mProgressItem;
        double d72 = this.heightgreenSpan;
        double d82 = (double) this.heighttotalSpan;
        Double.isNaN(d82);
        progressItem92.progressItemPercentage = ((float) (d72 / d82)) * 100.0f;
        progressItem92.color = R.color.green;
        this.progressItemList.add(progressItem92);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem102 = this.mProgressItem;
        progressItem102.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
        progressItem102.color = R.color.yellow;
        this.progressItemList.add(progressItem102);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem112 = this.mProgressItem;
        progressItem112.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
        progressItem112.color = R.color.orange;
        this.progressItemList.add(progressItem112);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem122 = this.mProgressItem;
        progressItem122.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
        progressItem122.color = R.color.red;
        this.progressItemList.add(progressItem122);
        this.heightseekBar.initData(this.progressItemList);
        floatExtra = getIntent().getFloatExtra("HEIGHT", 0.0f);
        this.heightseekBar.setProgress((int) floatExtra);
        this.hght4.setText(String.valueOf(floatExtra));
        if (floatExtra < 0.0f) {
        }
        if (floatExtra < 136.0f) {
        }
        if (floatExtra < 151.0f) {
        }
        if (floatExtra < 159.0f) {
        }
        if (floatExtra >= 171.0f) {
        }
        this.hght2.setText("Extra Long Height");
        textView = this.height_desc;
        resources = getResources();
        i = R.string.extralongheight;
        textView.setText(resources.getString(i));
        this.heightseekBar.invalidate();
        this.heightseekBar.setEnabled(false);
        this.bmiseekBar.setEnabled(false);
    }


    public void initDataToSeekbar(float f, float f2) {
        TextView textView = null;
        Resources resources = null;
        int i = 0;
        TextView textView2 = null;
        String str = null;
        this.heightseekBar.setEnabled(true);
        this.bmiseekBar.setEnabled(true);
        this.progressItemList = new ArrayList<>();
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem = this.mProgressItem;
        progressItem.progressItemPercentage = (this.bmivioletSpan / this.bmitotalSpan) * 100.0f;
        progressItem.color = R.color.violet;
        this.progressItemList.add(progressItem);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem2 = this.mProgressItem;
        double d = this.bmiblueSpan;
        double d2 = (double) this.bmitotalSpan;
        Double.isNaN(d2);
        progressItem2.progressItemPercentage = ((float) (d / d2)) * 100.0f;
        progressItem2.color = R.color.blue;
        this.progressItemList.add(progressItem2);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem3 = this.mProgressItem;
        double d3 = this.bmigreenSpan;
        double d4 = (double) this.bmitotalSpan;
        Double.isNaN(d4);
        progressItem3.progressItemPercentage = ((float) (d3 / d4)) * 100.0f;
        progressItem3.color = R.color.green;
        this.progressItemList.add(progressItem3);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem4 = this.mProgressItem;
        progressItem4.progressItemPercentage = (this.bmiyellowSpan / this.bmitotalSpan) * 100.0f;
        progressItem4.color = R.color.yellow;
        this.progressItemList.add(progressItem4);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem5 = this.mProgressItem;
        progressItem5.progressItemPercentage = (this.bmiorangeSpan / this.bmitotalSpan) * 100.0f;
        progressItem5.color = R.color.orange;
        this.progressItemList.add(progressItem5);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem6 = this.mProgressItem;
        progressItem6.progressItemPercentage = (this.bmiredSpan / this.bmitotalSpan) * 100.0f;
        progressItem6.color = R.color.red;
        this.progressItemList.add(progressItem6);
        this.bmiseekBar.initData(this.progressItemList);
        this.bmiseekBar.setProgress((int) f);
        this.wght4.setText(String.valueOf(f));
        if (f >= 0.0f && f <= 15.0f) {
            textView2 = this.wght2;
            str = "Severely Underweight";
        } else if (f >= 16.0f && f <= 18.0f) {
            textView2 = this.wght2;
            str = "Underweight";
        } else if (f >= 19.0f && f <= 25.0f) {
            textView2 = this.wght2;
            str = "Normal (Healthy Weight)";
        } else if (f >= 26.0f && f <= 30.0f) {
            textView2 = this.wght2;
            str = "Overweight";
        } else if (f < 31.0f || f > 40.0f) {
            if (f >= 41.0f && f <= 50.0f) {
                textView2 = this.wght2;
                str = "Severely Obese";
            }
            this.bmiseekBar.invalidate();
            this.progressItemList = new ArrayList<>();
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem7 = this.mProgressItem;
            progressItem7.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
            progressItem7.color = R.color.violet;
            this.progressItemList.add(progressItem7);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem8 = this.mProgressItem;
            double d5 = this.heightblueSpan;
            double d6 = (double) this.heighttotalSpan;
            Double.isNaN(d6);
            progressItem8.progressItemPercentage = ((float) (d5 / d6)) * 100.0f;
            progressItem8.color = R.color.blue;
            this.progressItemList.add(progressItem8);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem9 = this.mProgressItem;
            double d7 = this.heightgreenSpan;
            double d8 = (double) this.heighttotalSpan;
            Double.isNaN(d8);
            progressItem9.progressItemPercentage = ((float) (d7 / d8)) * 100.0f;
            progressItem9.color = R.color.green;
            this.progressItemList.add(progressItem9);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem10 = this.mProgressItem;
            progressItem10.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
            progressItem10.color = R.color.yellow;
            this.progressItemList.add(progressItem10);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem11 = this.mProgressItem;
            progressItem11.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
            progressItem11.color = R.color.orange;
            this.progressItemList.add(progressItem11);
            this.mProgressItem = new ProgressItem();
            ProgressItem progressItem12 = this.mProgressItem;
            progressItem12.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
            progressItem12.color = R.color.red;
            this.progressItemList.add(progressItem12);
            this.heightseekBar.initData(this.progressItemList);
            this.heightseekBar.setProgress((int) f2);
            this.hght4.setText(String.valueOf(f2));
            if (f2 < 0.0f && f2 <= 135.0f) {
                this.hght2.setText("Very Short Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.veryshort;
            } else if (f2 < 136.0f && f2 <= 150.0f) {
                this.hght2.setText("Too Short Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.tooshortheight;
            } else if (f2 < 151.0f && f2 <= 158.0f) {
                this.hght2.setText("Below Average Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.belowaverageheight;
            } else if (f2 < 159.0f && f2 <= 170.0f) {
                this.hght2.setText("Average Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.averageheight;
            } else if (f2 >= 171.0f || f2 > 178.0f) {
                if (f2 >= 179.0f && f2 <= 213.0f) {
                    this.hght2.setText("Extra Long Height");
                    textView = this.height_desc;
                    resources = getResources();
                    i = R.string.extralongheight;
                }
                this.heightseekBar.invalidate();
                this.heightseekBar.setEnabled(false);
                this.bmiseekBar.setEnabled(false);
            } else {
                this.hght2.setText("Above Average Height");
                textView = this.height_desc;
                resources = getResources();
                i = R.string.aboveaverageheight;
            }
            textView.setText(resources.getString(i));
            this.heightseekBar.invalidate();
            this.heightseekBar.setEnabled(false);
            this.bmiseekBar.setEnabled(false);
        } else {
            textView2 = this.wght2;
            str = "Obese";
        }
        textView2.setText(str);
        this.bmiseekBar.invalidate();
        this.progressItemList = new ArrayList<>();
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem72 = this.mProgressItem;
        progressItem72.progressItemPercentage = (this.heightvioletSpan / this.heighttotalSpan) * 100.0f;
        progressItem72.color = R.color.violet;
        this.progressItemList.add(progressItem72);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem82 = this.mProgressItem;
        double d52 = this.heightblueSpan;
        double d62 = (double) this.heighttotalSpan;
        Double.isNaN(d62);
        progressItem82.progressItemPercentage = ((float) (d52 / d62)) * 100.0f;
        progressItem82.color = R.color.blue;
        this.progressItemList.add(progressItem82);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem92 = this.mProgressItem;
        double d72 = this.heightgreenSpan;
        double d82 = (double) this.heighttotalSpan;
        Double.isNaN(d82);
        progressItem92.progressItemPercentage = ((float) (d72 / d82)) * 100.0f;
        progressItem92.color = R.color.green;
        this.progressItemList.add(progressItem92);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem102 = this.mProgressItem;
        progressItem102.progressItemPercentage = (this.heightyellowSpan / this.heighttotalSpan) * 100.0f;
        progressItem102.color = R.color.yellow;
        this.progressItemList.add(progressItem102);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem112 = this.mProgressItem;
        progressItem112.progressItemPercentage = (this.heightorangeSpan / this.heighttotalSpan) * 100.0f;
        progressItem112.color = R.color.orange;
        this.progressItemList.add(progressItem112);
        this.mProgressItem = new ProgressItem();
        ProgressItem progressItem122 = this.mProgressItem;
        progressItem122.progressItemPercentage = (this.heightredSpan / this.heighttotalSpan) * 100.0f;
        progressItem122.color = R.color.red;
        this.progressItemList.add(progressItem122);
        this.heightseekBar.initData(this.progressItemList);
        this.heightseekBar.setProgress((int) f2);
        this.hght4.setText(String.valueOf(f2));
        if (f2 < 0.0f) {
        }
        if (f2 < 136.0f) {
        }
        if (f2 < 151.0f) {
        }
        if (f2 < 159.0f) {
        }
        if (f2 >= 171.0f) {
        }
        this.hght2.setText("Extra Long Height");
        textView = this.height_desc;
        resources = getResources();
        i = R.string.extralongheight;
        textView.setText(resources.getString(i));
        this.heightseekBar.invalidate();
        this.heightseekBar.setEnabled(false);
        this.bmiseekBar.setEnabled(false);
    }


    public void requestNewInterstitial() {
        this.interstitial.loadAd(this.adRequest);
    }

    private void setAdmodAds() {
        this.interstitial = new InterstitialAd(this);
        this.interstitial.setAdUnitId(getString(R.string.g_inr));
        this.adRequest = new Builder().build();
        this.interstitial.setAdListener(new AdListener() {
            public void onAdClosed() {
                super.onAdClosed();
                CalculateActivity.this.requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }

    public void a() {
        final Dialog dialog = new Dialog(this, R.style.AppTheme);
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.getWindow().setLayout(-1, -1);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.activity_customdialog_heightcheckout);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.setCancelable(true);
        this.lbs = (RadioButton) dialog.findViewById(R.id.lbs);
        this.kg = (RadioButton) dialog.findViewById(R.id.kg);
        this.male = (RadioButton) dialog.findViewById(R.id.male);
        this.female = (RadioButton) dialog.findViewById(R.id.female);
        this.ft = (EditText) dialog.findViewById(R.id.feet);
        this.inches = (EditText) dialog.findViewById(R.id.inches);
        this.year = (EditText) dialog.findViewById(R.id.year);
        this.weight = (EditText) dialog.findViewById(R.id.weight);
        ((TextView) dialog.findViewById(R.id.calculate)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CalculateActivity calculateActivity;
                String str;
                String str2 = "";
                if (CalculateActivity.this.year.getText().toString().equals(str2) || CalculateActivity.this.ft.getText().toString().equals(str2) || CalculateActivity.this.inches.getText().toString().equals(str2) || CalculateActivity.this.weight.getText().toString().equals(str2)) {
                    calculateActivity = CalculateActivity.this;
                    str = "Please fill all the fields";
                } else if (Integer.parseInt(CalculateActivity.this.year.getText().toString()) < 5 || Integer.parseInt(CalculateActivity.this.year.getText().toString()) > 100) {
                    calculateActivity = CalculateActivity.this;
                    str = "Age should be in range 5-100 years";
                } else if (Integer.parseInt(CalculateActivity.this.ft.getText().toString()) < 2 || Integer.parseInt(CalculateActivity.this.ft.getText().toString()) > 7) {
                    calculateActivity = CalculateActivity.this;
                    str = "Feet should be in range 2-7";
                } else if (Integer.parseInt(CalculateActivity.this.inches.getText().toString()) < 0 || Integer.parseInt(CalculateActivity.this.inches.getText().toString()) > 12) {
                    calculateActivity = CalculateActivity.this;
                    str = "Inches should be in range 0-12";
                } else {
                    String str3 = "HEIGHT";
                    String str4 = "BMI";
                    if (CalculateActivity.this.kg.isChecked()) {
                        if (Integer.parseInt(CalculateActivity.this.weight.getText().toString()) < 5 || Integer.parseInt(CalculateActivity.this.weight.getText().toString()) > 100) {
                            calculateActivity = CalculateActivity.this;
                            str = "Weight should be in range 5-100 Kg";
                        } else {
                            CalculateActivity calculateActivity2 = CalculateActivity.this;
                            float b2 = calculateActivity2.calculateMetres(Float.parseFloat(calculateActivity2.ft.getText().toString()), Float.parseFloat(CalculateActivity.this.inches.getText().toString()));
                            CalculateActivity calculateActivity3 = CalculateActivity.this;
                            int c = calculateActivity2.calculateBMI(b2, calculateActivity3.calculateweight(Float.parseFloat(calculateActivity3.weight.getText().toString())));
                            CalculateActivity calculateActivity4 = CalculateActivity.this;
                            calculateActivity4.prefsEditor = calculateActivity4.mSharedPreferences.edit();
                            float f = (float) c;
                            CalculateActivity.this.prefsEditor.putFloat(str4, f);
                            CalculateActivity.this.prefsEditor.putFloat(str3, CalculateActivity.this.Heightincms);
                            CalculateActivity.this.prefsEditor.apply();
                            CalculateActivity calculateActivity5 = CalculateActivity.this;
                            calculateActivity5.initDataToSeekbar(f, calculateActivity5.Heightincms);
                            dialog.dismiss();
                            if (!CalculateActivity.this.interstitial.isLoaded()) {
                                return;
                            }
                        }
                    } else if (!CalculateActivity.this.lbs.isChecked()) {
                        return;
                    } else {
                        if (Integer.parseInt(CalculateActivity.this.weight.getText().toString()) < 11 || Integer.parseInt(CalculateActivity.this.weight.getText().toString()) > 220) {
                            calculateActivity = CalculateActivity.this;
                            str = "Weight should be in range 11-220 lb";
                        } else {
                            CalculateActivity calculateActivity6 = CalculateActivity.this;
                            float b3 = calculateActivity6.calculateMetres(Float.parseFloat(calculateActivity6.ft.getText().toString()), Float.parseFloat(CalculateActivity.this.inches.getText().toString()));
                            CalculateActivity calculateActivity7 = CalculateActivity.this;
                            int c2 = calculateActivity6.calculateBMI(b3, calculateActivity7.calculateweight(Float.parseFloat(calculateActivity7.weight.getText().toString())));
                            CalculateActivity calculateActivity8 = CalculateActivity.this;
                            calculateActivity8.prefsEditor = calculateActivity8.mSharedPreferences.edit();
                            float f2 = (float) c2;
                            CalculateActivity.this.prefsEditor.putFloat(str4, f2);
                            CalculateActivity.this.prefsEditor.putFloat(str3, CalculateActivity.this.Heightincms);
                            CalculateActivity.this.prefsEditor.apply();
                            CalculateActivity calculateActivity9 = CalculateActivity.this;
                            calculateActivity9.initDataToSeekbar(f2, calculateActivity9.Heightincms);
                            dialog.dismiss();
                            if (!CalculateActivity.this.interstitial.isLoaded()) {
                                return;
                            }
                        }
                    }
                    CalculateActivity.this.interstitial.show();
                    return;
                }
                Toast.makeText(calculateActivity, str, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    public void imageclick(View view) {
        startActivity(new Intent(this, TipsActivity.class));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_calculate);

        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        this.bmiseekBar = (CustomSeekBar) findViewById(R.id.bmiseekBar);
        this.heightseekBar = (CustomSeekBar) findViewById(R.id.heightseekBar);
        this.wght2 = (TextView) findViewById(R.id.wght2);
        this.wght4 = (TextView) findViewById(R.id.wght4);
        this.hght2 = (TextView) findViewById(R.id.hght2);
        this.hght4 = (TextView) findViewById(R.id.hght4);
        this.height_desc = (TextView) findViewById(R.id.height_desc);
        initDataToSeekbar();
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        findViewById(R.id.edit).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CalculateActivity.this.a();
            }
        });
        findViewById(R.id.startexercise).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CalculateActivity calculateActivity = CalculateActivity.this;
                calculateActivity.startActivity(new Intent(calculateActivity, MainActivity.class));
                CalculateActivity.this.finish();
            }
        });
        setAdmodAds();
    }

    public void onBackPressed() {
        Intent intent = new Intent(CalculateActivity.this, After_MainActivity.class);
        startActivity(intent);
        finish();
    }
}
