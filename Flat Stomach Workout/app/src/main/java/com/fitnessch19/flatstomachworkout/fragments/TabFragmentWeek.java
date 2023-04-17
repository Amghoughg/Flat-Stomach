package com.fitnessch19.flatstomachworkout.fragments;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fitnessch19.flatstomachworkout.R;

public class TabFragmentWeek extends Fragment implements OnClickListener {
    public static final String TAG = "TabFragmentWeek";

    public static Editor editor2 ;
    public static String str2 ;

    public Button mBtnStdDiet;
    public Button mBtnVegDiet;
    public LinearLayout mLayoutStdDiet;
    public LinearLayout mLayoutVegDiet;
    public SharedPreferences mSharedPreferences;
    public String mWeekNumber;
    public Editor prefsEditor;
    public ScrollView scrollweekstddietfood;
    public ScrollView scrollweekvegdietfood;
    public CheckBox std_check1;
    public CheckBox std_check11;
    public CheckBox std_check12;
    public CheckBox std_check13;
    public CheckBox std_check14;
    public CheckBox std_check15;
    public CheckBox std_check19;
    public CheckBox std_check2;
    public CheckBox std_check20;
    public CheckBox std_check21;
    public CheckBox std_check22;
    public CheckBox std_check3;
    public CheckBox std_check4;
    public CheckBox std_check5;
    public CheckBox std_check6;
    public CheckBox std_check8;
    public CheckBox std_check9;
    public String stddiet;
    public String stddietcheckbox1;
    public String stddietcheckbox10;
    public String stddietcheckbox11;
    public String stddietcheckbox12;
    public String stddietcheckbox13;
    public String stddietcheckbox14;
    public String stddietcheckbox15;
    public String stddietcheckbox16;
    public String stddietcheckbox17;
    public String stddietcheckbox18;
    public String stddietcheckbox19;
    public String stddietcheckbox2;
    public String stddietcheckbox20;
    public String stddietcheckbox21;
    public String stddietcheckbox22;
    public String stddietcheckbox3;
    public String stddietcheckbox4;
    public String stddietcheckbox5;
    public String stddietcheckbox6;
    public String stddietcheckbox7;
    public String stddietcheckbox8;
    public String stddietcheckbox9;
    public CheckBox veg_check1;
    public CheckBox veg_check10;
    public CheckBox veg_check11;
    public CheckBox veg_check12;
    public CheckBox veg_check13;
    public CheckBox veg_check17;
    public CheckBox veg_check18;
    public CheckBox veg_check19;
    public CheckBox veg_check2;
    public CheckBox veg_check20;
    public CheckBox veg_check3;
    public CheckBox veg_check4;
    public CheckBox veg_check5;
    public CheckBox veg_check6;
    public CheckBox veg_check8;
    public String vegdiet;
    public String vegdietcheckbox1;
    public String vegdietcheckbox10;
    public String vegdietcheckbox11;
    public String vegdietcheckbox12;
    public String vegdietcheckbox13;
    public String vegdietcheckbox14;
    public String vegdietcheckbox15;
    public String vegdietcheckbox16;
    public String vegdietcheckbox17;
    public String vegdietcheckbox18;
    public String vegdietcheckbox19;
    public String vegdietcheckbox2;
    public String vegdietcheckbox20;
    public String vegdietcheckbox3;
    public String vegdietcheckbox4;
    public String vegdietcheckbox5;
    public String vegdietcheckbox6;
    public String vegdietcheckbox7;
    public String vegdietcheckbox8;
    public String vegdietcheckbox9;
    public Boolean week_stddietcheckbox1;
    public Boolean week_stddietcheckbox10;
    public Boolean week_stddietcheckbox11;
    public Boolean week_stddietcheckbox12;
    public Boolean week_stddietcheckbox13;
    public Boolean week_stddietcheckbox14;
    public Boolean week_stddietcheckbox15;
    public Boolean week_stddietcheckbox16;
    public Boolean week_stddietcheckbox17;
    public Boolean week_stddietcheckbox18;
    public Boolean week_stddietcheckbox19;
    public Boolean week_stddietcheckbox2;
    public Boolean week_stddietcheckbox20;
    public Boolean week_stddietcheckbox21;
    public Boolean week_stddietcheckbox22;
    public Boolean week_stddietcheckbox3;
    public Boolean week_stddietcheckbox4;
    public Boolean week_stddietcheckbox5;
    public Boolean week_stddietcheckbox6;
    public Boolean week_stddietcheckbox7;
    public Boolean week_stddietcheckbox8;
    public Boolean week_stddietcheckbox9;
    public Boolean week_stddietenabled;
    public Boolean week_vegdietcheckbox1;
    public Boolean week_vegdietcheckbox10;
    public Boolean week_vegdietcheckbox11;
    public Boolean week_vegdietcheckbox12;
    public Boolean week_vegdietcheckbox13;
    public Boolean week_vegdietcheckbox14;
    public Boolean week_vegdietcheckbox15;
    public Boolean week_vegdietcheckbox16;
    public Boolean week_vegdietcheckbox17;
    public Boolean week_vegdietcheckbox18;
    public Boolean week_vegdietcheckbox19;
    public Boolean week_vegdietcheckbox2;
    public Boolean week_vegdietcheckbox20;
    public Boolean week_vegdietcheckbox3;
    public Boolean week_vegdietcheckbox4;
    public Boolean week_vegdietcheckbox5;
    public Boolean week_vegdietcheckbox6;
    public Boolean week_vegdietcheckbox7;
    public Boolean week_vegdietcheckbox8;
    public Boolean week_vegdietcheckbox9;
    public Boolean week_vegdietenabled;

    private void setEventListeners() {
        this.std_check1.setOnClickListener(this);
        this.std_check2.setOnClickListener(this);
        this.std_check3.setOnClickListener(this);
        this.std_check4.setOnClickListener(this);
        this.std_check5.setOnClickListener(this);
        this.std_check6.setOnClickListener(this);
        this.std_check8.setOnClickListener(this);
        this.std_check9.setOnClickListener(this);
        this.std_check11.setOnClickListener(this);
        this.std_check12.setOnClickListener(this);
        this.std_check13.setOnClickListener(this);
        this.std_check14.setOnClickListener(this);
        this.std_check15.setOnClickListener(this);
        this.std_check19.setOnClickListener(this);
        this.std_check20.setOnClickListener(this);
        this.std_check21.setOnClickListener(this);
        this.std_check22.setOnClickListener(this);
        this.veg_check1.setOnClickListener(this);
        this.veg_check2.setOnClickListener(this);
        this.veg_check3.setOnClickListener(this);
        this.veg_check4.setOnClickListener(this);
        this.veg_check5.setOnClickListener(this);
        this.veg_check6.setOnClickListener(this);
        this.veg_check8.setOnClickListener(this);
        this.veg_check10.setOnClickListener(this);
        this.veg_check11.setOnClickListener(this);
        this.veg_check12.setOnClickListener(this);
        this.veg_check13.setOnClickListener(this);
        this.veg_check17.setOnClickListener(this);
        this.veg_check18.setOnClickListener(this);
        this.veg_check19.setOnClickListener(this);
        this.veg_check20.setOnClickListener(this);
        this.std_check1.setText(getResources().getString(R.string.fatfreemilk));
        this.std_check2.setText(getResources().getString(R.string.Eggs));
        this.std_check3.setText(getResources().getString(R.string.yogurt));
        this.std_check4.setText(getResources().getString(R.string.wholewheatmultigrainbread));
        this.std_check5.setText(getResources().getString(R.string.Oatmealcookies));
        this.std_check6.setText(getResources().getString(R.string.applebananaorangepineappleblueberry));
        this.std_check8.setText(getResources().getString(R.string.FishTunaorsalmon));
        this.std_check9.setText(getResources().getString(R.string.Chickenbreasts));
        this.std_check11.setText(getResources().getString(R.string.carrotcucumbercabbagetomatobeansspinachlettucemushroom));
        this.std_check12.setText(getResources().getString(R.string.Brownrice));
        this.std_check13.setText(getResources().getString(R.string.Oats));
        this.std_check14.setText(getResources().getString(R.string.Wheat));
        this.std_check15.setText(getResources().getString(R.string.cornflakes));
        this.std_check19.setText(getResources().getString(R.string.greenteapowder));
        this.std_check20.setText(getResources().getString(R.string.Lemon));
        this.std_check21.setText(getResources().getString(R.string.Herbsspices));
        this.std_check22.setText(getResources().getString(R.string.coffeepowder));
        this.veg_check1.setText(getResources().getString(R.string.fatfreemilk));
        this.veg_check2.setText(getResources().getString(R.string.Eggs));
        this.veg_check3.setText(getResources().getString(R.string.yogurt));
        this.veg_check4.setText(getResources().getString(R.string.wholewheatmultigrainbread));
        this.veg_check5.setText(getResources().getString(R.string.Oatmealcookies));
        this.veg_check6.setText(getResources().getString(R.string.applebananaorangepineappleblueberry));
        this.veg_check8.setText(getResources().getString(R.string.Carrotcucumbercabbagetomatobeansspinachlettuce));
        this.veg_check10.setText(getResources().getString(R.string.Brownrice));
        this.veg_check11.setText(getResources().getString(R.string.Oats));
        this.veg_check12.setText(getResources().getString(R.string.Wheat));
        this.veg_check13.setText(getResources().getString(R.string.cornflakes));
        this.veg_check17.setText(getResources().getString(R.string.greenteapowder));
        this.veg_check18.setText(getResources().getString(R.string.Lemon));
        this.veg_check19.setText(getResources().getString(R.string.Herbsspices));
        this.veg_check20.setText(getResources().getString(R.string.coffeepowder));
    }

    public void onClick(View view) {
        Editor editor;
        String str;

        int id = view.getId();
        if (id == R.id.stddietfoodcheckBox1) {
            this.week_stddietcheckbox1 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox1, false));
            if (!this.week_stddietcheckbox1.booleanValue()) {
                this.std_check1.setChecked(true);
                editor2 = this.prefsEditor;
                str2 = this.stddietcheckbox1;
            } else {
                editor = this.prefsEditor;
                str = this.stddietcheckbox1;
                editor.putBoolean(str, false);
                this.prefsEditor.commit();
            }
        } else if (id != R.id.vegdietfoodcheckBox8) {
            switch (id) {
                case R.id.stddietfoodcheckBox11 /*2131362220*/:
                    this.week_stddietcheckbox11 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox11, false));
                    if (this.week_stddietcheckbox11.booleanValue()) {
                        editor = this.prefsEditor;
                        str = this.stddietcheckbox11;
                        break;
                    } else {
                        this.std_check11.setChecked(true);
                        editor2 = this.prefsEditor;
                        str2 = this.stddietcheckbox11;
                        break;
                    }
                case R.id.stddietfoodcheckBox12 /*2131362221*/:
                    this.week_stddietcheckbox12 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox12, false));
                    if (this.week_stddietcheckbox12.booleanValue()) {
                        editor = this.prefsEditor;
                        str = this.stddietcheckbox12;
                        break;
                    } else {
                        this.std_check12.setChecked(true);
                        editor2 = this.prefsEditor;
                        str2 = this.stddietcheckbox12;
                        break;
                    }
                case R.id.stddietfoodcheckBox13 /*2131362222*/:
                    this.week_stddietcheckbox13 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox13, false));
                    if (this.week_stddietcheckbox13.booleanValue()) {
                        editor = this.prefsEditor;
                        str = this.stddietcheckbox13;
                        break;
                    } else {
                        this.std_check13.setChecked(true);
                        editor2 = this.prefsEditor;
                        str2 = this.stddietcheckbox13;
                        break;
                    }
                case R.id.stddietfoodcheckBox14 /*2131362223*/:
                    this.week_stddietcheckbox14 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox14, false));
                    if (this.week_stddietcheckbox14.booleanValue()) {
                        editor = this.prefsEditor;
                        str = this.stddietcheckbox14;
                        break;
                    } else {
                        this.std_check14.setChecked(true);
                        editor2 = this.prefsEditor;
                        str2 = this.stddietcheckbox14;
                        break;
                    }
                case R.id.stddietfoodcheckBox15 /*2131362224*/:
                    this.week_stddietcheckbox15 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox15, false));
                    if (this.week_stddietcheckbox15.booleanValue()) {
                        editor = this.prefsEditor;
                        str = this.stddietcheckbox15;
                        break;
                    } else {
                        this.std_check15.setChecked(true);
                        editor2 = this.prefsEditor;
                        str2 = this.stddietcheckbox15;
                        break;
                    }
                default:
                    switch (id) {
                        case R.id.stddietfoodcheckBox19 /*2131362228*/:
                            this.week_stddietcheckbox19 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox19, false));
                            if (this.week_stddietcheckbox19.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox19;
                                break;
                            } else {
                                this.std_check19.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox19;
                                break;
                            }
                        case R.id.stddietfoodcheckBox2 /*2131362229*/:
                            this.week_stddietcheckbox2 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox2, false));
                            if (this.week_stddietcheckbox2.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox2;
                                break;
                            } else {
                                this.std_check2.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox2;
                                break;
                            }
                        case R.id.stddietfoodcheckBox20 /*2131362230*/:
                            this.week_stddietcheckbox20 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox20, false));
                            if (this.week_stddietcheckbox20.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox20;
                                break;
                            } else {
                                this.std_check20.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox20;
                                break;
                            }
                        case R.id.stddietfoodcheckBox21 /*2131362231*/:
                            this.week_stddietcheckbox21 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox21, false));
                            if (this.week_stddietcheckbox21.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox21;
                                break;
                            } else {
                                this.std_check21.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox21;
                                break;
                            }
                        case R.id.stddietfoodcheckBox22 /*2131362232*/:
                            this.week_stddietcheckbox22 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox22, false));
                            if (this.week_stddietcheckbox22.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox22;
                                break;
                            } else {
                                this.std_check22.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox22;
                                break;
                            }
                        case R.id.stddietfoodcheckBox3 /*2131362233*/:
                            this.week_stddietcheckbox3 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox3, false));
                            if (this.week_stddietcheckbox3.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox3;
                                break;
                            } else {
                                this.std_check3.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox3;
                                break;
                            }
                        case R.id.stddietfoodcheckBox4 /*2131362234*/:
                            this.week_stddietcheckbox4 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox4, false));
                            if (this.week_stddietcheckbox4.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox4;
                                break;
                            } else {
                                this.std_check4.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox4;
                                break;
                            }
                        case R.id.stddietfoodcheckBox5 /*2131362235*/:
                            this.week_stddietcheckbox5 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox5, false));
                            if (this.week_stddietcheckbox5.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox5;
                                break;
                            } else {
                                this.std_check5.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox5;
                                break;
                            }
                        case R.id.stddietfoodcheckBox6 /*2131362236*/:
                            this.week_stddietcheckbox6 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox6, false));
                            if (this.week_stddietcheckbox6.booleanValue()) {
                                editor = this.prefsEditor;
                                str = this.stddietcheckbox6;
                                break;
                            } else {
                                this.std_check6.setChecked(true);
                                editor2 = this.prefsEditor;
                                str2 = this.stddietcheckbox6;
                                break;
                            }
                        default:
                            switch (id) {
                                case R.id.stddietfoodcheckBox8 /*2131362238*/:
                                    this.week_stddietcheckbox8 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox8, false));
                                    if (this.week_stddietcheckbox8.booleanValue()) {
                                        editor = this.prefsEditor;
                                        str = this.stddietcheckbox8;
                                        break;
                                    } else {
                                        this.std_check8.setChecked(true);
                                        editor2 = this.prefsEditor;
                                        str2 = this.stddietcheckbox8;
                                        break;
                                    }
                                case R.id.stddietfoodcheckBox9 /*2131362239*/:
                                    this.week_stddietcheckbox9 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox9, false));
                                    if (this.week_stddietcheckbox9.booleanValue()) {
                                        editor = this.prefsEditor;
                                        str = this.stddietcheckbox9;
                                        break;
                                    } else {
                                        this.std_check9.setChecked(true);
                                        editor2 = this.prefsEditor;
                                        str2 = this.stddietcheckbox9;
                                        break;
                                    }
                                default:
                                    switch (id) {
                                        case R.id.vegdietfoodcheckBox1 /*2131362343*/:
                                            this.week_vegdietcheckbox1 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox1, false));
                                            if (this.week_vegdietcheckbox1.booleanValue()) {
                                                editor = this.prefsEditor;
                                                str = this.vegdietcheckbox1;
                                                break;
                                            } else {
                                                this.veg_check1.setChecked(true);
                                                editor2 = this.prefsEditor;
                                                str2 = this.vegdietcheckbox1;
                                                break;
                                            }
                                        case R.id.vegdietfoodcheckBox10 /*2131362344*/:
                                            this.week_vegdietcheckbox10 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox10, false));
                                            if (this.week_vegdietcheckbox10.booleanValue()) {
                                                editor = this.prefsEditor;
                                                str = this.vegdietcheckbox10;
                                                break;
                                            } else {
                                                this.veg_check10.setChecked(true);
                                                editor2 = this.prefsEditor;
                                                str2 = this.vegdietcheckbox10;
                                                break;
                                            }
                                        case R.id.vegdietfoodcheckBox11 /*2131362345*/:
                                            this.week_vegdietcheckbox11 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox11, false));
                                            if (this.week_vegdietcheckbox11.booleanValue()) {
                                                editor = this.prefsEditor;
                                                str = this.vegdietcheckbox11;
                                                break;
                                            } else {
                                                this.veg_check11.setChecked(true);
                                                editor2 = this.prefsEditor;
                                                str2 = this.vegdietcheckbox11;
                                                break;
                                            }
                                        case R.id.vegdietfoodcheckBox12 /*2131362346*/:
                                            this.week_vegdietcheckbox12 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox12, false));
                                            if (this.week_vegdietcheckbox12.booleanValue()) {
                                                editor = this.prefsEditor;
                                                str = this.vegdietcheckbox12;
                                                break;
                                            } else {
                                                this.veg_check12.setChecked(true);
                                                editor2 = this.prefsEditor;
                                                str2 = this.vegdietcheckbox12;
                                                break;
                                            }
                                        case R.id.vegdietfoodcheckBox13 /*2131362347*/:
                                            this.week_vegdietcheckbox13 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox13, false));
                                            if (this.week_vegdietcheckbox13.booleanValue()) {
                                                editor = this.prefsEditor;
                                                str = this.vegdietcheckbox13;
                                                break;
                                            } else {
                                                this.veg_check13.setChecked(true);
                                                editor2 = this.prefsEditor;
                                                str2 = this.vegdietcheckbox13;
                                                break;
                                            }
                                        default:
                                            switch (id) {
                                                case R.id.vegdietfoodcheckBox17 /*2131362351*/:
                                                    this.week_vegdietcheckbox17 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox17, false));
                                                    if (this.week_vegdietcheckbox17.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox17;
                                                        break;
                                                    } else {
                                                        this.veg_check17.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox17;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox18 /*2131362352*/:
                                                    this.week_vegdietcheckbox18 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox18, false));
                                                    if (this.week_vegdietcheckbox18.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox18;
                                                        break;
                                                    } else {
                                                        this.veg_check18.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox18;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox19 /*2131362353*/:
                                                    this.week_vegdietcheckbox19 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox19, false));
                                                    if (this.week_vegdietcheckbox19.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox19;
                                                        break;
                                                    } else {
                                                        this.veg_check19.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox19;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox2 /*2131362354*/:
                                                    this.week_vegdietcheckbox2 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox2, false));
                                                    if (this.week_vegdietcheckbox2.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox2;
                                                        break;
                                                    } else {
                                                        this.veg_check2.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox2;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox20 /*2131362355*/:
                                                    this.week_vegdietcheckbox20 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox20, false));
                                                    if (this.week_vegdietcheckbox20.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox20;
                                                        break;
                                                    } else {
                                                        this.veg_check20.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox20;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox3 /*2131362356*/:
                                                    this.week_vegdietcheckbox3 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox3, false));
                                                    if (this.week_vegdietcheckbox3.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox3;
                                                        break;
                                                    } else {
                                                        this.veg_check3.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox3;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox4 /*2131362357*/:
                                                    this.week_vegdietcheckbox4 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox4, false));
                                                    if (this.week_vegdietcheckbox4.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox4;
                                                        break;
                                                    } else {
                                                        this.veg_check4.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox4;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox5 /*2131362358*/:
                                                    this.week_vegdietcheckbox5 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox5, false));
                                                    if (this.week_vegdietcheckbox5.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox5;
                                                        break;
                                                    } else {
                                                        this.veg_check5.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox5;
                                                        break;
                                                    }
                                                case R.id.vegdietfoodcheckBox6 /*2131362359*/:
                                                    this.week_vegdietcheckbox6 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox6, false));
                                                    if (this.week_vegdietcheckbox6.booleanValue()) {
                                                        editor = this.prefsEditor;
                                                        str = this.vegdietcheckbox6;
                                                        break;
                                                    } else {
                                                        this.veg_check6.setChecked(true);
                                                        editor2 = this.prefsEditor;
                                                        str2 = this.vegdietcheckbox6;
                                                        break;
                                                    }
                                                default:
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            this.week_vegdietcheckbox8 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox8, false));
            if (!this.week_vegdietcheckbox8.booleanValue()) {
                this.veg_check8.setChecked(true);
                editor2 = this.prefsEditor;
                str2 = this.vegdietcheckbox8;
            } else {
                editor = this.prefsEditor;
                str = this.vegdietcheckbox8;
                editor.putBoolean(str, false);
                this.prefsEditor.commit();
            }
        }
        editor2.putBoolean(str2, true);
        this.prefsEditor.commit();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mWeekNumber = getArguments().getString("WEEK");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.tab_fragment_week, viewGroup, false);
        inflate.setTag(TAG);
        this.scrollweekstddietfood = (ScrollView) inflate.findViewById(R.id.scrollweekstddietfood);
        this.scrollweekvegdietfood = (ScrollView) inflate.findViewById(R.id.scrollweekvegdietfood);
        this.mBtnStdDiet = (Button) inflate.findViewById(R.id.weekStddiet);
        this.mBtnVegDiet = (Button) inflate.findViewById(R.id.weekvegdiet);
        this.mLayoutStdDiet = (LinearLayout) inflate.findViewById(R.id.weekstddietfood);
        this.mLayoutVegDiet = (LinearLayout) inflate.findViewById(R.id.weekvegdietfood);
        this.std_check1 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox1);
        this.std_check2 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox2);
        this.std_check3 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox3);
        this.std_check4 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox4);
        this.std_check5 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox5);
        this.std_check6 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox6);
        this.std_check8 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox8);
        this.std_check9 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox9);
        this.std_check11 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox11);
        this.std_check12 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox12);
        this.std_check13 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox13);
        this.std_check14 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox14);
        this.std_check15 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox15);
        this.std_check19 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox19);
        this.std_check20 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox20);
        this.std_check21 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox21);
        this.std_check22 = (CheckBox) inflate.findViewById(R.id.stddietfoodcheckBox22);
        this.veg_check1 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox1);
        this.veg_check2 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox2);
        this.veg_check3 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox3);
        this.veg_check4 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox4);
        this.veg_check5 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox5);
        this.veg_check6 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox6);
        this.veg_check8 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox8);
        this.veg_check10 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox10);
        this.veg_check11 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox11);
        this.veg_check12 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox12);
        this.veg_check13 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox13);
        this.veg_check17 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox17);
        this.veg_check18 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox18);
        this.veg_check19 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox19);
        this.veg_check20 = (CheckBox) inflate.findViewById(R.id.vegdietfoodcheckBox20);
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        this.prefsEditor = this.mSharedPreferences.edit();
        if (this.mWeekNumber.equals("WEEK1")) {
            this.stddiet = "WEEK_1_STDDIET";
            this.vegdiet = "WEEK_1_VEGDIET";
            this.stddietcheckbox1 = "WEEK1_STD_CHECKBOX1";
            this.stddietcheckbox2 = "WEEK1_STD_CHECKBOX2";
            this.stddietcheckbox3 = "WEEK1_STD_CHECKBOX3";
            this.stddietcheckbox4 = "WEEK1_STD_CHECKBOX4";
            this.stddietcheckbox5 = "WEEK1_STD_CHECKBOX5";
            this.stddietcheckbox6 = "WEEK1_STD_CHECKBOX6";
            this.stddietcheckbox7 = "WEEK1_STD_CHECKBOX7";
            this.stddietcheckbox8 = "WEEK1_STD_CHECKBOX8";
            this.stddietcheckbox9 = "WEEK1_STD_CHECKBOX9";
            this.stddietcheckbox10 = "WEEK1_STD_CHECKBOX10";
            this.stddietcheckbox11 = "WEEK1_STD_CHECKBOX11";
            this.stddietcheckbox12 = "WEEK1_STD_CHECKBOX12";
            this.stddietcheckbox13 = "WEEK1_STD_CHECKBOX13";
            this.stddietcheckbox14 = "WEEK1_STD_CHECKBOX14";
            this.stddietcheckbox15 = "WEEK1_STD_CHECKBOX15";
            this.stddietcheckbox16 = "WEEK1_STD_CHECKBOX16";
            this.stddietcheckbox17 = "WEEK1_STD_CHECKBOX17";
            this.stddietcheckbox18 = "WEEK1_STD_CHECKBOX18";
            this.stddietcheckbox19 = "WEEK1_STD_CHECKBOX19";
            this.stddietcheckbox20 = "WEEK1_STD_CHECKBOX20";
            this.stddietcheckbox21 = "WEEK1_STD_CHECKBOX21";
            this.stddietcheckbox22 = "WEEK1_STD_CHECKBOX22";
            this.vegdietcheckbox1 = "WEEK1_VEG_CHECKBOX1";
            this.vegdietcheckbox2 = "WEEK1_VEG_CHECKBOX2";
            this.vegdietcheckbox3 = "WEEK1_VEG_CHECKBOX3";
            this.vegdietcheckbox4 = "WEEK1_VEG_CHECKBOX4";
            this.vegdietcheckbox5 = "WEEK1_VEG_CHECKBOX5";
            this.vegdietcheckbox6 = "WEEK1_VEG_CHECKBOX6";
            this.vegdietcheckbox7 = "WEEK1_VEG_CHECKBOX7";
            this.vegdietcheckbox8 = "WEEK1_VEG_CHECKBOX8";
            this.vegdietcheckbox9 = "WEEK1_VEG_CHECKBOX9";
            this.vegdietcheckbox10 = "WEEK1_VEG_CHECKBOX10";
            this.vegdietcheckbox11 = "WEEK1_VEG_CHECKBOX11";
            this.vegdietcheckbox12 = "WEEK1_VEG_CHECKBOX12";
            this.vegdietcheckbox13 = "WEEK1_VEG_CHECKBOX13";
            this.vegdietcheckbox14 = "WEEK1_VEG_CHECKBOX14";
            this.vegdietcheckbox15 = "WEEK1_VEG_CHECKBOX15";
            this.vegdietcheckbox16 = "WEEK1_VEG_CHECKBOX16";
            this.vegdietcheckbox17 = "WEEK1_VEG_CHECKBOX17";
            this.vegdietcheckbox18 = "WEEK1_VEG_CHECKBOX18";
            this.vegdietcheckbox19 = "WEEK1_VEG_CHECKBOX19";
            str = "WEEK1_VEG_CHECKBOX20";
        } else if (this.mWeekNumber.equals("WEEK2")) {
            this.stddiet = "WEEK_2_STDDIET";
            this.vegdiet = "WEEK_2_VEGDIET";
            this.stddietcheckbox1 = "WEEK2_STD_CHECKBOX1";
            this.stddietcheckbox2 = "WEEK2_STD_CHECKBOX2";
            this.stddietcheckbox3 = "WEEK2_STD_CHECKBOX3";
            this.stddietcheckbox4 = "WEEK2_STD_CHECKBOX4";
            this.stddietcheckbox5 = "WEEK2_STD_CHECKBOX5";
            this.stddietcheckbox6 = "WEEK2_STD_CHECKBOX6";
            this.stddietcheckbox7 = "WEEK2_STD_CHECKBOX7";
            this.stddietcheckbox8 = "WEEK2_STD_CHECKBOX8";
            this.stddietcheckbox9 = "WEEK2_STD_CHECKBOX9";
            this.stddietcheckbox10 = "WEEK2_STD_CHECKBOX10";
            this.stddietcheckbox11 = "WEEK2_STD_CHECKBOX11";
            this.stddietcheckbox12 = "WEEK2_STD_CHECKBOX12";
            this.stddietcheckbox13 = "WEEK2_STD_CHECKBOX13";
            this.stddietcheckbox14 = "WEEK2_STD_CHECKBOX14";
            this.stddietcheckbox15 = "WEEK2_STD_CHECKBOX15";
            this.stddietcheckbox16 = "WEEK2_STD_CHECKBOX16";
            this.stddietcheckbox17 = "WEEK2_STD_CHECKBOX17";
            this.stddietcheckbox18 = "WEEK2_STD_CHECKBOX18";
            this.stddietcheckbox19 = "WEEK2_STD_CHECKBOX19";
            this.stddietcheckbox20 = "WEEK2_STD_CHECKBOX20";
            this.stddietcheckbox21 = "WEEK2_STD_CHECKBOX21";
            this.stddietcheckbox22 = "WEEK2_STD_CHECKBOX22";
            this.vegdietcheckbox1 = "WEEK2_VEG_CHECKBOX1";
            this.vegdietcheckbox2 = "WEEK2_VEG_CHECKBOX2";
            this.vegdietcheckbox3 = "WEEK2_VEG_CHECKBOX3";
            this.vegdietcheckbox4 = "WEEK2_VEG_CHECKBOX4";
            this.vegdietcheckbox5 = "WEEK2_VEG_CHECKBOX5";
            this.vegdietcheckbox6 = "WEEK2_VEG_CHECKBOX6";
            this.vegdietcheckbox7 = "WEEK2_VEG_CHECKBOX7";
            this.vegdietcheckbox8 = "WEEK2_VEG_CHECKBOX8";
            this.vegdietcheckbox9 = "WEEK2_VEG_CHECKBOX9";
            this.vegdietcheckbox10 = "WEEK2_VEG_CHECKBOX10";
            this.vegdietcheckbox11 = "WEEK2_VEG_CHECKBOX11";
            this.vegdietcheckbox12 = "WEEK2_VEG_CHECKBOX12";
            this.vegdietcheckbox13 = "WEEK2_VEG_CHECKBOX13";
            this.vegdietcheckbox14 = "WEEK2_VEG_CHECKBOX14";
            this.vegdietcheckbox5 = "WEEK2_VEG_CHECKBOX15";
            this.vegdietcheckbox16 = "WEEK2_VEG_CHECKBOX16";
            this.vegdietcheckbox17 = "WEEK2_VEG_CHECKBOX17";
            this.vegdietcheckbox18 = "WEEK2_VEG_CHECKBOX18";
            this.vegdietcheckbox19 = "WEEK2_VEG_CHECKBOX19";
            str = "WEEK2_VEG_CHECKBOX20";
        } else if (this.mWeekNumber.equals("WEEK3")) {
            this.stddiet = "WEEK_3_STDDIET";
            this.vegdiet = "WEEK_3_VEGDIET";
            this.stddietcheckbox1 = "WEEK3_STD_CHECKBOX1";
            this.stddietcheckbox2 = "WEEK3_STD_CHECKBOX2";
            this.stddietcheckbox3 = "WEEK3_STD_CHECKBOX3";
            this.stddietcheckbox4 = "WEEK3_STD_CHECKBOX4";
            this.stddietcheckbox5 = "WEEK3_STD_CHECKBOX5";
            this.stddietcheckbox6 = "WEEK3_STD_CHECKBOX6";
            this.stddietcheckbox7 = "WEEK3_STD_CHECKBOX7";
            this.stddietcheckbox8 = "WEEK3_STD_CHECKBOX8";
            this.stddietcheckbox9 = "WEEK3_STD_CHECKBOX9";
            this.stddietcheckbox10 = "WEEK3_STD_CHECKBOX10";
            this.stddietcheckbox11 = "WEEK3_STD_CHECKBOX11";
            this.stddietcheckbox12 = "WEEK3_STD_CHECKBOX12";
            this.stddietcheckbox13 = "WEEK3_STD_CHECKBOX13";
            this.stddietcheckbox14 = "WEEK3_STD_CHECKBOX14";
            this.stddietcheckbox15 = "WEEK3_STD_CHECKBOX15";
            this.stddietcheckbox16 = "WEEK3_STD_CHECKBOX16";
            this.stddietcheckbox17 = "WEEK3_STD_CHECKBOX17";
            this.stddietcheckbox18 = "WEEK3_STD_CHECKBOX18";
            this.stddietcheckbox19 = "WEEK3_STD_CHECKBOX19";
            this.stddietcheckbox20 = "WEEK3_STD_CHECKBOX20";
            this.stddietcheckbox21 = "WEEK3_STD_CHECKBOX21";
            this.stddietcheckbox22 = "WEEK3_STD_CHECKBOX22";
            this.vegdietcheckbox1 = "WEEK3_VEG_CHECKBOX1";
            this.vegdietcheckbox2 = "WEEK3_VEG_CHECKBOX2";
            this.vegdietcheckbox3 = "WEEK3_VEG_CHECKBOX3";
            this.vegdietcheckbox4 = "WEEK3_VEG_CHECKBOX4";
            this.vegdietcheckbox5 = "WEEK3_VEG_CHECKBOX5";
            this.vegdietcheckbox6 = "WEEK3_VEG_CHECKBOX6";
            this.vegdietcheckbox7 = "WEEK3_VEG_CHECKBOX7";
            this.vegdietcheckbox8 = "WEEK3_VEG_CHECKBOX8";
            this.vegdietcheckbox9 = "WEEK3_VEG_CHECKBOX9";
            this.vegdietcheckbox10 = "WEEK3_VEG_CHECKBOX10";
            this.vegdietcheckbox11 = "WEEK3_VEG_CHECKBOX11";
            this.vegdietcheckbox12 = "WEEK3_VEG_CHECKBOX12";
            this.vegdietcheckbox13 = "WEEK3_VEG_CHECKBOX13";
            this.vegdietcheckbox14 = "WEEK3_VEG_CHECKBOX14";
            this.vegdietcheckbox15 = "WEEK3_VEG_CHECKBOX15";
            this.vegdietcheckbox16 = "WEEK3_VEG_CHECKBOX16";
            this.vegdietcheckbox17 = "WEEK3_VEG_CHECKBOX17";
            this.vegdietcheckbox18 = "WEEK3_VEG_CHECKBOX18";
            this.vegdietcheckbox19 = "WEEK3_VEG_CHECKBOX19";
            str = "WEEK3_VEG_CHECKBOX20";
        } else if (this.mWeekNumber.equals("WEEK4")) {
            this.stddiet = "WEEK_4_STDDIET";
            this.vegdiet = "WEEK_4_VEGDIET";
            this.stddietcheckbox1 = "WEEK4_STD_CHECKBOX1";
            this.stddietcheckbox2 = "WEEK4_STD_CHECKBOX2";
            this.stddietcheckbox3 = "WEEK4_STD_CHECKBOX3";
            this.stddietcheckbox4 = "WEEK4_STD_CHECKBOX4";
            this.stddietcheckbox5 = "WEEK4_STD_CHECKBOX5";
            this.stddietcheckbox6 = "WEEK4_STD_CHECKBOX6";
            this.stddietcheckbox7 = "WEEK4_STD_CHECKBOX7";
            this.stddietcheckbox8 = "WEEK4_STD_CHECKBOX8";
            this.stddietcheckbox9 = "WEEK4_STD_CHECKBOX9";
            this.stddietcheckbox10 = "WEEK4_STD_CHECKBOX10";
            this.stddietcheckbox11 = "WEEK4_STD_CHECKBOX11";
            this.stddietcheckbox12 = "WEEK4_STD_CHECKBOX12";
            this.stddietcheckbox13 = "WEEK4_STD_CHECKBOX13";
            this.stddietcheckbox14 = "WEEK4_STD_CHECKBOX14";
            this.stddietcheckbox15 = "WEEK4_STD_CHECKBOX15";
            this.stddietcheckbox16 = "WEEK4_STD_CHECKBOX16";
            this.stddietcheckbox17 = "WEEK4_STD_CHECKBOX17";
            this.stddietcheckbox18 = "WEEK4_STD_CHECKBOX18";
            this.stddietcheckbox19 = "WEEK4_STD_CHECKBOX19";
            this.stddietcheckbox20 = "WEEK4_STD_CHECKBOX20";
            this.stddietcheckbox21 = "WEEK4_STD_CHECKBOX21";
            this.stddietcheckbox22 = "WEEK4_STD_CHECKBOX22";
            this.vegdietcheckbox1 = "WEEK4_VEG_CHECKBOX1";
            this.vegdietcheckbox2 = "WEEK4_VEG_CHECKBOX2";
            this.vegdietcheckbox3 = "WEEK4_VEG_CHECKBOX3";
            this.vegdietcheckbox4 = "WEEK4_VEG_CHECKBOX4";
            this.vegdietcheckbox5 = "WEEK4_VEG_CHECKBOX5";
            this.vegdietcheckbox6 = "WEEK4_VEG_CHECKBOX6";
            this.vegdietcheckbox7 = "WEEK4_VEG_CHECKBOX7";
            this.vegdietcheckbox8 = "WEEK4_VEG_CHECKBOX8";
            this.vegdietcheckbox9 = "WEEK4_VEG_CHECKBOX9";
            this.vegdietcheckbox10 = "WEEK4_VEG_CHECKBOX10";
            this.vegdietcheckbox11 = "WEEK4_VEG_CHECKBOX11";
            this.vegdietcheckbox12 = "WEEK4_VEG_CHECKBOX12";
            this.vegdietcheckbox13 = "WEEK4_VEG_CHECKBOX13";
            this.vegdietcheckbox14 = "WEEK4_VEG_CHECKBOX14";
            this.vegdietcheckbox15 = "WEEK4_VEG_CHECKBOX15";
            this.vegdietcheckbox16 = "WEEK4_VEG_CHECKBOX16";
            this.vegdietcheckbox17 = "WEEK4_VEG_CHECKBOX17";
            this.vegdietcheckbox18 = "WEEK4_VEG_CHECKBOX18";
            this.vegdietcheckbox19 = "WEEK4_VEG_CHECKBOX19";
            str = "WEEK4_VEG_CHECKBOX20";
        } else {
            if (this.mWeekNumber.equals("WEEK5")) {
                this.stddiet = "WEEK_5_STDDIET";
                this.vegdiet = "WEEK_5_VEGDIET";
                this.stddietcheckbox1 = "WEEK5_STD_CHECKBOX1";
                this.stddietcheckbox2 = "WEEK5_STD_CHECKBOX2";
                this.stddietcheckbox3 = "WEEK5_STD_CHECKBOX3";
                this.stddietcheckbox4 = "WEEK5_STD_CHECKBOX4";
                this.stddietcheckbox5 = "WEEK5_STD_CHECKBOX5";
                this.stddietcheckbox6 = "WEEK5_STD_CHECKBOX6";
                this.stddietcheckbox7 = "WEEK5_STD_CHECKBOX7";
                this.stddietcheckbox8 = "WEEK5_STD_CHECKBOX8";
                this.stddietcheckbox9 = "WEEK5_STD_CHECKBOX9";
                this.stddietcheckbox10 = "WEEK5_STD_CHECKBOX10";
                this.stddietcheckbox11 = "WEEK5_STD_CHECKBOX11";
                this.stddietcheckbox12 = "WEEK5_STD_CHECKBOX12";
                this.stddietcheckbox13 = "WEEK5_STD_CHECKBOX13";
                this.stddietcheckbox14 = "WEEK5_STD_CHECKBOX14";
                this.stddietcheckbox15 = "WEEK5_STD_CHECKBOX15";
                this.stddietcheckbox16 = "WEEK5_STD_CHECKBOX16";
                this.stddietcheckbox17 = "WEEK5_STD_CHECKBOX17";
                this.stddietcheckbox18 = "WEEK5_STD_CHECKBOX18";
                this.stddietcheckbox19 = "WEEK5_STD_CHECKBOX19";
                this.stddietcheckbox20 = "WEEK5_STD_CHECKBOX20";
                this.stddietcheckbox21 = "WEEK5_STD_CHECKBOX21";
                this.stddietcheckbox22 = "WEEK5_STD_CHECKBOX22";
                this.vegdietcheckbox1 = "WEEK5_VEG_CHECKBOX1";
                this.vegdietcheckbox2 = "WEEK5_VEG_CHECKBOX2";
                this.vegdietcheckbox3 = "WEEK5_VEG_CHECKBOX3";
                this.vegdietcheckbox4 = "WEEK5_VEG_CHECKBOX4";
                this.vegdietcheckbox5 = "WEEK5_VEG_CHECKBOX5";
                this.vegdietcheckbox6 = "WEEK5_VEG_CHECKBOX6";
                this.vegdietcheckbox7 = "WEEK5_VEG_CHECKBOX7";
                this.vegdietcheckbox8 = "WEEK5_VEG_CHECKBOX8";
                this.vegdietcheckbox9 = "WEEK5_VEG_CHECKBOX9";
                this.vegdietcheckbox10 = "WEEK5_VEG_CHECKBOX10";
                this.vegdietcheckbox11 = "WEEK5_VEG_CHECKBOX11";
                this.vegdietcheckbox12 = "WEEK5_VEG_CHECKBOX12";
                this.vegdietcheckbox13 = "WEEK5_VEG_CHECKBOX13";
                this.vegdietcheckbox14 = "WEEK5_VEG_CHECKBOX14";
                this.vegdietcheckbox15 = "WEEK5_VEG_CHECKBOX15";
                this.vegdietcheckbox16 = "WEEK5_VEG_CHECKBOX16";
                this.vegdietcheckbox17 = "WEEK5_VEG_CHECKBOX17";
                this.vegdietcheckbox18 = "WEEK5_VEG_CHECKBOX18";
                this.vegdietcheckbox19 = "WEEK5_VEG_CHECKBOX19";
                str = "WEEK5_VEG_CHECKBOX20";
            }
            this.week_stddietenabled = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddiet, false));
            this.week_vegdietenabled = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdiet, false));
            this.week_stddietcheckbox1 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox1, false));
            this.week_stddietcheckbox2 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox2, false));
            this.week_stddietcheckbox3 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox3, false));
            this.week_stddietcheckbox4 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox4, false));
            this.week_stddietcheckbox5 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox5, false));
            this.week_stddietcheckbox6 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox6, false));
            this.week_stddietcheckbox7 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox7, false));
            this.week_stddietcheckbox8 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox8, false));
            this.week_stddietcheckbox9 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox9, false));
            this.week_stddietcheckbox10 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox10, false));
            this.week_stddietcheckbox11 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox11, false));
            this.week_stddietcheckbox12 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox12, false));
            this.week_stddietcheckbox13 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox13, false));
            this.week_stddietcheckbox14 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox14, false));
            this.week_stddietcheckbox15 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox15, false));
            this.week_stddietcheckbox16 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox16, false));
            this.week_stddietcheckbox17 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox17, false));
            this.week_stddietcheckbox18 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox18, false));
            this.week_stddietcheckbox19 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox19, false));
            this.week_stddietcheckbox20 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox20, false));
            this.week_stddietcheckbox21 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox21, false));
            this.week_stddietcheckbox22 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox22, false));
            this.std_check1.setChecked(this.week_stddietcheckbox1.booleanValue());
            this.std_check2.setChecked(this.week_stddietcheckbox2.booleanValue());
            this.std_check3.setChecked(this.week_stddietcheckbox3.booleanValue());
            this.std_check4.setChecked(this.week_stddietcheckbox4.booleanValue());
            this.std_check5.setChecked(this.week_stddietcheckbox5.booleanValue());
            this.std_check6.setChecked(this.week_stddietcheckbox6.booleanValue());
            this.std_check8.setChecked(this.week_stddietcheckbox8.booleanValue());
            this.std_check9.setChecked(this.week_stddietcheckbox9.booleanValue());
            this.std_check11.setChecked(this.week_stddietcheckbox11.booleanValue());
            this.std_check12.setChecked(this.week_stddietcheckbox12.booleanValue());
            this.std_check13.setChecked(this.week_stddietcheckbox13.booleanValue());
            this.std_check14.setChecked(this.week_stddietcheckbox14.booleanValue());
            this.std_check15.setChecked(this.week_stddietcheckbox15.booleanValue());
            this.std_check19.setChecked(this.week_stddietcheckbox19.booleanValue());
            this.std_check20.setChecked(this.week_stddietcheckbox20.booleanValue());
            this.std_check21.setChecked(this.week_stddietcheckbox21.booleanValue());
            this.std_check22.setChecked(this.week_stddietcheckbox22.booleanValue());
            this.week_vegdietcheckbox1 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox1, false));
            this.week_vegdietcheckbox2 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox2, false));
            this.week_vegdietcheckbox3 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox3, false));
            this.week_vegdietcheckbox4 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox4, false));
            this.week_vegdietcheckbox5 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox5, false));
            this.week_vegdietcheckbox6 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox6, false));
            this.week_vegdietcheckbox7 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox7, false));
            this.week_vegdietcheckbox8 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox8, false));
            this.week_vegdietcheckbox9 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox9, false));
            this.week_vegdietcheckbox10 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox10, false));
            this.week_vegdietcheckbox11 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox11, false));
            this.week_vegdietcheckbox12 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox12, false));
            this.week_vegdietcheckbox13 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox13, false));
            this.week_vegdietcheckbox14 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox14, false));
            this.week_vegdietcheckbox15 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox15, false));
            this.week_vegdietcheckbox16 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox16, false));
            this.week_vegdietcheckbox17 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox17, false));
            this.week_vegdietcheckbox18 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox18, false));
            this.week_vegdietcheckbox19 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox19, false));
            this.week_vegdietcheckbox20 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox20, false));
            this.veg_check1.setChecked(this.week_vegdietcheckbox1.booleanValue());
            this.veg_check2.setChecked(this.week_vegdietcheckbox2.booleanValue());
            this.veg_check3.setChecked(this.week_vegdietcheckbox3.booleanValue());
            this.veg_check4.setChecked(this.week_vegdietcheckbox4.booleanValue());
            this.veg_check5.setChecked(this.week_vegdietcheckbox5.booleanValue());
            this.veg_check6.setChecked(this.week_vegdietcheckbox6.booleanValue());
            this.veg_check8.setChecked(this.week_vegdietcheckbox8.booleanValue());
            this.veg_check10.setChecked(this.week_vegdietcheckbox10.booleanValue());
            this.veg_check11.setChecked(this.week_vegdietcheckbox11.booleanValue());
            this.veg_check12.setChecked(this.week_vegdietcheckbox12.booleanValue());
            this.veg_check13.setChecked(this.week_vegdietcheckbox13.booleanValue());
            this.veg_check17.setChecked(this.week_vegdietcheckbox17.booleanValue());
            this.veg_check18.setChecked(this.week_vegdietcheckbox18.booleanValue());
            this.veg_check19.setChecked(this.week_vegdietcheckbox19.booleanValue());
            this.veg_check20.setChecked(this.week_vegdietcheckbox20.booleanValue());
            if (!this.week_stddietenabled.booleanValue() && !this.week_vegdietenabled.booleanValue()) {
                this.mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                this.mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));
                this.scrollweekstddietfood.setVisibility(View.VISIBLE);
                this.scrollweekvegdietfood.setVisibility(4);
            } else if (this.week_stddietenabled.booleanValue() && this.week_vegdietenabled.booleanValue()) {
                this.mBtnStdDiet.setTextColor(getResources().getColor(R.color.black));
                this.mBtnVegDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                this.scrollweekstddietfood.setVisibility(4);
                this.scrollweekvegdietfood.setVisibility(View.VISIBLE);
            } else if (!this.week_stddietenabled.booleanValue() && !this.week_vegdietenabled.booleanValue()) {
                this.mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
                this.mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));
                this.scrollweekstddietfood.setVisibility(View.VISIBLE);
                this.scrollweekvegdietfood.setVisibility(4);
                this.prefsEditor.putBoolean(this.stddiet, true);
                this.prefsEditor.putBoolean(this.vegdiet, false);
                this.prefsEditor.apply();
            }
            this.mBtnStdDiet.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TabFragmentWeek tabFragmentWeek = TabFragmentWeek.this;
                    tabFragmentWeek.week_stddietenabled = Boolean.valueOf(tabFragmentWeek.mSharedPreferences.getBoolean(TabFragmentWeek.this.stddiet, false));
                    if (!TabFragmentWeek.this.week_stddietenabled.booleanValue()) {
                        TabFragmentWeek.this.mBtnStdDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.colorAccent));
                        TabFragmentWeek.this.scrollweekstddietfood.setVisibility(View.VISIBLE);
                        TabFragmentWeek.this.mBtnVegDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.black));
                        TabFragmentWeek.this.scrollweekvegdietfood.setVisibility(4);
                        TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.stddiet, true);
                        TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.vegdiet, false);
                    }
                    TabFragmentWeek.this.prefsEditor.commit();
                }
            });
            this.mBtnVegDiet.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TabFragmentWeek tabFragmentWeek = TabFragmentWeek.this;
                    tabFragmentWeek.week_vegdietenabled = Boolean.valueOf(tabFragmentWeek.mSharedPreferences.getBoolean(TabFragmentWeek.this.vegdiet, false));
                    if (!TabFragmentWeek.this.week_vegdietenabled.booleanValue()) {
                        TabFragmentWeek.this.mBtnVegDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.colorAccent));
                        TabFragmentWeek.this.scrollweekvegdietfood.setVisibility(View.VISIBLE);
                        TabFragmentWeek.this.mBtnStdDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.black));
                        TabFragmentWeek.this.scrollweekstddietfood.setVisibility(4);
                        TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.vegdiet, true);
                        TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.stddiet, false);
                    }
                    TabFragmentWeek.this.prefsEditor.commit();
                }
            });
            setEventListeners();
            return inflate;
        }
        this.vegdietcheckbox20 = str;
        this.week_stddietenabled = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddiet, false));
        this.week_vegdietenabled = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdiet, false));
        this.week_stddietcheckbox1 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox1, false));
        this.week_stddietcheckbox2 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox2, false));
        this.week_stddietcheckbox3 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox3, false));
        this.week_stddietcheckbox4 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox4, false));
        this.week_stddietcheckbox5 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox5, false));
        this.week_stddietcheckbox6 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox6, false));
        this.week_stddietcheckbox7 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox7, false));
        this.week_stddietcheckbox8 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox8, false));
        this.week_stddietcheckbox9 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox9, false));
        this.week_stddietcheckbox10 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox10, false));
        this.week_stddietcheckbox11 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox11, false));
        this.week_stddietcheckbox12 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox12, false));
        this.week_stddietcheckbox13 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox13, false));
        this.week_stddietcheckbox14 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox14, false));
        this.week_stddietcheckbox15 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox15, false));
        this.week_stddietcheckbox16 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox16, false));
        this.week_stddietcheckbox17 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox17, false));
        this.week_stddietcheckbox18 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox18, false));
        this.week_stddietcheckbox19 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox19, false));
        this.week_stddietcheckbox20 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox20, false));
        this.week_stddietcheckbox21 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox21, false));
        this.week_stddietcheckbox22 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.stddietcheckbox22, false));
        this.std_check1.setChecked(this.week_stddietcheckbox1.booleanValue());
        this.std_check2.setChecked(this.week_stddietcheckbox2.booleanValue());
        this.std_check3.setChecked(this.week_stddietcheckbox3.booleanValue());
        this.std_check4.setChecked(this.week_stddietcheckbox4.booleanValue());
        this.std_check5.setChecked(this.week_stddietcheckbox5.booleanValue());
        this.std_check6.setChecked(this.week_stddietcheckbox6.booleanValue());
        this.std_check8.setChecked(this.week_stddietcheckbox8.booleanValue());
        this.std_check9.setChecked(this.week_stddietcheckbox9.booleanValue());
        this.std_check11.setChecked(this.week_stddietcheckbox11.booleanValue());
        this.std_check12.setChecked(this.week_stddietcheckbox12.booleanValue());
        this.std_check13.setChecked(this.week_stddietcheckbox13.booleanValue());
        this.std_check14.setChecked(this.week_stddietcheckbox14.booleanValue());
        this.std_check15.setChecked(this.week_stddietcheckbox15.booleanValue());
        this.std_check19.setChecked(this.week_stddietcheckbox19.booleanValue());
        this.std_check20.setChecked(this.week_stddietcheckbox20.booleanValue());
        this.std_check21.setChecked(this.week_stddietcheckbox21.booleanValue());
        this.std_check22.setChecked(this.week_stddietcheckbox22.booleanValue());
        this.week_vegdietcheckbox1 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox1, false));
        this.week_vegdietcheckbox2 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox2, false));
        this.week_vegdietcheckbox3 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox3, false));
        this.week_vegdietcheckbox4 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox4, false));
        this.week_vegdietcheckbox5 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox5, false));
        this.week_vegdietcheckbox6 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox6, false));
        this.week_vegdietcheckbox7 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox7, false));
        this.week_vegdietcheckbox8 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox8, false));
        this.week_vegdietcheckbox9 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox9, false));
        this.week_vegdietcheckbox10 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox10, false));
        this.week_vegdietcheckbox11 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox11, false));
        this.week_vegdietcheckbox12 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox12, false));
        this.week_vegdietcheckbox13 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox13, false));
        this.week_vegdietcheckbox14 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox14, false));
        this.week_vegdietcheckbox15 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox15, false));
        this.week_vegdietcheckbox16 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox16, false));
        this.week_vegdietcheckbox17 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox17, false));
        this.week_vegdietcheckbox18 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox18, false));
        this.week_vegdietcheckbox19 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox19, false));
        this.week_vegdietcheckbox20 = Boolean.valueOf(this.mSharedPreferences.getBoolean(this.vegdietcheckbox20, false));
        this.veg_check1.setChecked(this.week_vegdietcheckbox1.booleanValue());
        this.veg_check2.setChecked(this.week_vegdietcheckbox2.booleanValue());
        this.veg_check3.setChecked(this.week_vegdietcheckbox3.booleanValue());
        this.veg_check4.setChecked(this.week_vegdietcheckbox4.booleanValue());
        this.veg_check5.setChecked(this.week_vegdietcheckbox5.booleanValue());
        this.veg_check6.setChecked(this.week_vegdietcheckbox6.booleanValue());
        this.veg_check8.setChecked(this.week_vegdietcheckbox8.booleanValue());
        this.veg_check10.setChecked(this.week_vegdietcheckbox10.booleanValue());
        this.veg_check11.setChecked(this.week_vegdietcheckbox11.booleanValue());
        this.veg_check12.setChecked(this.week_vegdietcheckbox12.booleanValue());
        this.veg_check13.setChecked(this.week_vegdietcheckbox13.booleanValue());
        this.veg_check17.setChecked(this.week_vegdietcheckbox17.booleanValue());
        this.veg_check18.setChecked(this.week_vegdietcheckbox18.booleanValue());
        this.veg_check19.setChecked(this.week_vegdietcheckbox19.booleanValue());
        this.veg_check20.setChecked(this.week_vegdietcheckbox20.booleanValue());
        if (!this.week_stddietenabled.booleanValue()) {
        }
        if (this.week_stddietenabled.booleanValue()) {
        }
        this.mBtnStdDiet.setTextColor(getResources().getColor(R.color.colorAccent));
        this.mBtnVegDiet.setTextColor(getResources().getColor(R.color.black));
        this.scrollweekstddietfood.setVisibility(View.VISIBLE);
        this.scrollweekvegdietfood.setVisibility(4);
        this.prefsEditor.putBoolean(this.stddiet, true);
        this.prefsEditor.putBoolean(this.vegdiet, false);
        this.prefsEditor.apply();
        this.mBtnStdDiet.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TabFragmentWeek tabFragmentWeek = TabFragmentWeek.this;
                tabFragmentWeek.week_stddietenabled = Boolean.valueOf(tabFragmentWeek.mSharedPreferences.getBoolean(TabFragmentWeek.this.stddiet, false));
                if (!TabFragmentWeek.this.week_stddietenabled.booleanValue()) {
                    TabFragmentWeek.this.mBtnStdDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.colorAccent));
                    TabFragmentWeek.this.scrollweekstddietfood.setVisibility(View.VISIBLE);
                    TabFragmentWeek.this.mBtnVegDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.black));
                    TabFragmentWeek.this.scrollweekvegdietfood.setVisibility(4);
                    TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.stddiet, true);
                    TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.vegdiet, false);
                }
                TabFragmentWeek.this.prefsEditor.commit();
            }
        });
        this.mBtnVegDiet.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TabFragmentWeek tabFragmentWeek = TabFragmentWeek.this;
                tabFragmentWeek.week_vegdietenabled = Boolean.valueOf(tabFragmentWeek.mSharedPreferences.getBoolean(TabFragmentWeek.this.vegdiet, false));
                if (!TabFragmentWeek.this.week_vegdietenabled.booleanValue()) {
                    TabFragmentWeek.this.mBtnVegDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.colorAccent));
                    TabFragmentWeek.this.scrollweekvegdietfood.setVisibility(View.VISIBLE);
                    TabFragmentWeek.this.mBtnStdDiet.setTextColor(TabFragmentWeek.this.getResources().getColor(R.color.black));
                    TabFragmentWeek.this.scrollweekstddietfood.setVisibility(4);
                    TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.vegdiet, true);
                    TabFragmentWeek.this.prefsEditor.putBoolean(TabFragmentWeek.this.stddiet, false);
                }
                TabFragmentWeek.this.prefsEditor.commit();
            }
        });
        setEventListeners();
        return inflate;
    }
}
