package com.fitnessch19.flatstomachworkout.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.adapters.PagerAdapter_tips;
import com.fitnessch19.flatstomachworkout.fragments.BlankFragment;
import com.fitnessch19.flatstomachworkout.utils.DepthPageTransformer;

public class TipsActivity extends AppCompatActivity {
    public ViewPager k;

    public class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return 10;
        }

        public Fragment getItem(int i) {
            return new BlankFragment();
        }
    }

    public void close(View view) {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.tips_layout);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.k = (ViewPager) findViewById(R.id.viewPager);
        this.k.setAdapter(new PagerAdapter_tips(supportFragmentManager));
        this.k.setClipToPadding(false);
        this.k.setPadding(80, 0, 120, 120);
        this.k.setPageTransformer(true, new DepthPageTransformer());
    }
}
