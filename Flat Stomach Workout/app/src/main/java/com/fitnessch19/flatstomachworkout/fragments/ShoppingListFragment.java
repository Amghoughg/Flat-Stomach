package com.fitnessch19.flatstomachworkout.fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.adapters.PagerAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.tabs.TabLayout;

public class ShoppingListFragment extends Fragment {
    public static final String TAG = "ShoppingListFragment";
    public AdRequest adRequest;
    public InterstitialAd interstitial;


    public void requestNewInterstitial() {
        this.interstitial.loadAd(this.adRequest);
    }

    private void setAdmodAds() {
        this.interstitial = new InterstitialAd(getActivity());
        this.interstitial.setAdUnitId(getString(R.string.g_inr));
        this.adRequest = new AdRequest.Builder().build();
        this.interstitial.setAdListener(new AdListener() {
            public void onAdClosed() {
                super.onAdClosed();
                ShoppingListFragment.this.requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setAdmodAds();
        View inflate = layoutInflater.inflate(R.layout.layout_shoppinglist, viewGroup, false);
        inflate.setTag(TAG);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().mutate().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);
        setHasOptionsMenu(true);
        TabLayout tabLayout = (TabLayout) inflate.findViewById(R.id.tab_layout);
        tabLayout.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.colorAccent));
        tabLayout.addTab(tabLayout.newTab().setText((CharSequence) "WEEK 1"));
        tabLayout.addTab(tabLayout.newTab().setText((CharSequence) "WEEK 2"));
        tabLayout.addTab(tabLayout.newTab().setText((CharSequence) "WEEK 3"));
        tabLayout.addTab(tabLayout.newTab().setText((CharSequence) "WEEK 4"));
        tabLayout.addTab(tabLayout.newTab().setText((CharSequence) "WEEK 5"));
        tabLayout.setTabGravity(0);
        final ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.pager);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        return inflate;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.interstitial.isLoaded()) {
                this.interstitial.show();
            }
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
