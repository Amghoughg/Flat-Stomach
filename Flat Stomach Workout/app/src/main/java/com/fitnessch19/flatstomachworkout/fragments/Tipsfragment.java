package com.fitnessch19.flatstomachworkout.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.fitnessch19.flatstomachworkout.R;

public class Tipsfragment extends Fragment {


    public TextView f1495a;
    public TextView b;
    public String[] c;
    public int[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public int e;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.tipsfragment, viewGroup, false);
        this.f1495a = (TextView) inflate.findViewById(R.id.tipsserialno);
        this.b = (TextView) inflate.findViewById(R.id.tipsdescription);
        FragmentActivity activity = getActivity();
        activity.getClass();
        this.c = activity.getResources().getStringArray(R.array.tips);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.e = arguments.getInt("pos");
        }
        TextView textView = this.f1495a;
        StringBuilder sb = new StringBuilder();
        sb.append("Tip ");
        sb.append(this.d[this.e]);
        textView.setText(String.valueOf(sb.toString()));
        this.b.setText(this.c[this.e]);
        return inflate;
    }
}
