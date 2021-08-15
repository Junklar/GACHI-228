package com.example.geography.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.geography.Test;
import com.example.geography.databinding.FragmentTest2Binding;

public class Test2Fragment extends Fragment {
    private FragmentTest2Binding binding;
    private CheckBox[] checkBoxes;
    private static int qIndex = 0;
    private static final Test test = Test.tests[1];
    
    @SuppressLint("SetTextI18n")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTest2Binding.inflate(inflater, container, false);
        checkBoxes = new CheckBox[]{binding.checkBox1, binding.checkBox2, binding.checkBox3, binding.checkBox4};
        setQ(0);
        binding.back.setOnClickListener((v) -> setQ(-1));
        binding.next.setOnClickListener((v) -> setQ(1));

        binding.finish.setOnClickListener((e)->{ getActivity().onBackPressed(); });
        return binding.getRoot();
    }

    private void setQ(int next) {
        for (int i = 0; i < checkBoxes.length; i++)
            test.ans[qIndex][i] = checkBoxes[i].isChecked();
        qIndex += next;
        if (qIndex == test.strings.length || qIndex == -1) {
            qIndex -= next;
            return;
        }
        for (int j = 0; j < checkBoxes.length; j++) {
            checkBoxes[j].setText(test.strings[qIndex][j+1]);
            checkBoxes[j].setChecked(test.ans[qIndex][j]);
        }
        binding.qText.setText(test.strings[qIndex][0]);
        binding.progressBar4.setProgress(qIndex * 10);
        binding.progressBar4.setSecondaryProgress(qIndex > 0? (qIndex * 10) + 10 : 10);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}