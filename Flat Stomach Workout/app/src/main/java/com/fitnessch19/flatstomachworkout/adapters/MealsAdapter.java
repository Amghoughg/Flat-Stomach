package com.fitnessch19.flatstomachworkout.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.fragments.DailyMeal;
import com.fitnessch19.flatstomachworkout.utils.MealsItemObject;

import java.util.List;

public class MealsAdapter extends Adapter<MealsAdapter.MealsRecyclerViewHolders> {
    public Context context;
    public List<MealsItemObject> itemList;
    public SharedPreferences mSharedPreferences;
//    public SharedPreferences.Editor prefsEditor = this.mSharedPreferences.edit();

    class MealsRecyclerViewHolders extends ViewHolder implements OnClickListener {
//        public CardView cardview1;
        public TextView countryName;

        public MealsRecyclerViewHolders(View view) {
            super(view);
            view.setOnClickListener(this);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.setMargins(5, 5, 5, 5);
            layoutParams.weight = 1.0f;
//            this.cardview1 = (CardView) view.findViewById(R.id.cardviewone);
//            this.cardview1.setLayoutParams(layoutParams);
            this.countryName = (TextView) view.findViewById(R.id.row_day);
        }

        public void onClick(View view) {
            DailyMeal dailyMeal = new DailyMeal();
            Bundle bundle = new Bundle();
            bundle.putInt("DAY", getAdapterPosition() + 1);
            dailyMeal.setArguments(bundle);
            FragmentTransaction beginTransaction = ((AppCompatActivity) MealsAdapter.this.context).getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.nav_host_fragment, dailyMeal);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
        }
    }

    public MealsAdapter(Context context2, List<MealsItemObject> list) {
        this.itemList = list;
        this.context = context2;
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
    }

    public int getItemCount() {
        return this.itemList.size();
    }

    public void onBindViewHolder(MealsRecyclerViewHolders mealsRecyclerViewHolders, int i) {
        mealsRecyclerViewHolders.countryName.setText(((MealsItemObject) this.itemList.get(i)).getName());
        int i2 = i + 1;
        StringBuilder sb = new StringBuilder();
        sb.append("DAY_");
        sb.append(i2);
        sb.append("_CHECKED");
        if (Boolean.valueOf(this.mSharedPreferences.getBoolean(sb.toString(), false)).booleanValue()) {
//            mealsRecyclerViewHolders.cardview1.setCardBackgroundColor(this.context.getResources().getColor(R.color.colorAccent));
//            mealsRecyclerViewHolders.countryName.setTextColor(this.context.getResources().getColor(R.color.white));
        }
    }

    public MealsRecyclerViewHolders onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MealsRecyclerViewHolders(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meals_days_row, null));
    }
}
