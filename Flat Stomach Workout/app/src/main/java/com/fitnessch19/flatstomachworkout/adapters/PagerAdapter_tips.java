package com.fitnessch19.flatstomachworkout.adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.fitnessch19.flatstomachworkout.fragments.Tipsfragment;

public class PagerAdapter_tips extends FragmentStatePagerAdapter {
    public PagerAdapter_tips(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public int getCount() {
        return 10;
    }

    public Fragment getItem(int i) {
        Tipsfragment tipsfragment = new Tipsfragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos", i);
        tipsfragment.setArguments(bundle);
        return tipsfragment;
    }
}
