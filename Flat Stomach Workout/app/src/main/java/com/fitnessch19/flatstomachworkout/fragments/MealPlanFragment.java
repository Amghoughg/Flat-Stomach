package com.fitnessch19.flatstomachworkout.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fitnessch19.flatstomachworkout.R;
import com.fitnessch19.flatstomachworkout.adapters.MealsAdapter;
import com.fitnessch19.flatstomachworkout.utils.MealsItemObject;

import java.util.ArrayList;
import java.util.List;

public class MealPlanFragment extends Fragment {
    public static final String TAG = "RecyclerViewFragment";
    public Button mShoppingBtn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    private List<MealsItemObject> getAllItemList() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 30) {
            StringBuilder sb = new StringBuilder();
            sb.append("Day ");
            i++;
            sb.append(i);
            arrayList.add(new MealsItemObject(sb.toString()));
        }
        return arrayList;
    }

    public static MealPlanFragment newInstance(String str, String str2) {
        MealPlanFragment mainFragment = new MealPlanFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }



    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.meals_app_bar_main, viewGroup, false);
        inflate.setTag(TAG);
//        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) inflate.findViewById(R.id.toolbar));
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
//        setHasOptionsMenu(true);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler);
        MealsAdapter mealsAdapter = new MealsAdapter(getActivity(), getAllItemList());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setAdapter(mealsAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
//        this.mShoppingBtn = (Button) inflate.findViewById(R.id.shoppinglistbtn);
//        this.mShoppingBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
//                FragmentTransaction beginTransaction = MealPlanFragment.this.getFragmentManager().beginTransaction();
//                beginTransaction.replace(R.id.meals_content_fragment, shoppingListFragment);
//                beginTransaction.addToBackStack((String) null);
//                beginTransaction.commit();
//            }
//        });
        return inflate;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
