package com.example.geography;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestQFragment extends Fragment {
    public static final String QTEXT = "qtext";
    //public static final String ARG_PARAM2 = "param2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle state) {
        View v = inflater.inflate(R.layout.fragment_test_q, group, false);
        TextView text = v.findViewById(R.id.q_text);
        text.setText(getArguments().getString(QTEXT));
        return v;
    }
}