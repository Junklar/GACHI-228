package com.example.geography;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class TestQFragment extends Fragment {
    public static final String QTEXT = "qtext";
    public static final String RADIO1 = "radio1";
    public static final String RADIO2 = "radio2";
    public static final String RADIO3 = "radio3";
    public static final String RADIO4 = "radio4";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle state) {
        View v = inflater.inflate(R.layout.fragment_test_q, group, false);
        TextView text = v.findViewById(R.id.q_text);
        text.setText(getArguments().getString(QTEXT));
        RadioButton r1 = v.findViewById(R.id.radio1);
        r1.setText(getArguments().getString(RADIO1));
        RadioButton r2 = v.findViewById(R.id.radio2);
        r2.setText(getArguments().getString(RADIO2));
        RadioButton r3 = v.findViewById(R.id.radio3);
        r3.setText(getArguments().getString(RADIO3));
        RadioButton r4 = v.findViewById(R.id.radio4);
        r4.setText(getArguments().getString(RADIO4));
        return v;
    }
}