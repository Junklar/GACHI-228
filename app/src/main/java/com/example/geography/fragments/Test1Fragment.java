package com.example.geography.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.geography.Test;
import com.example.geography.TestPagerAdapter;
import com.example.geography.databinding.FragmentTest1Binding;

public class Test1Fragment extends Fragment {
    private FragmentTest1Binding binding;

    private static final Test test = Test.tests[0];

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle state) {
        binding = FragmentTest1Binding.inflate(inflater, group, false);
        binding.tabLayout.setupWithViewPager(binding.pager);
        binding.pager.setAdapter(new TestPagerAdapter(getParentFragmentManager(),test));
        return binding.getRoot();
        /*setQ(0);
        binding.back.setOnClickListener((v) -> setQ(-1));
        binding.next.setOnClickListener((v) -> setQ(1));

        binding.finish.setOnClickListener((e)->{
            getActivity().onBackPressed();
            ListViewAdapter.arrayList.remove(test);
            ListViewAdapter.arrayList.add(test);
        });
        return binding.getRoot();*/
    }

    /*private void setQ(int next) {
        for (int i = 0; i < list.length; i++)
            test.userItems[qIndex].ans = list[i].isChecked() ? (i+1) : 0;
        final int qNext = qIndex + next;
        if (qNext == test.items.length || qNext == -1)
            return;
        qIndex = qNext;
        for (int j = 0; j < list.length; j++) {
            list[j].setText(test.items[qIndex].strings[j+1]);
            list[j].setChecked(test.userItems[qIndex].ans == (j+1));
        }
        binding.qText.setText(test.items[qIndex].strings[0]);
        binding.progressBar4.setProgress(qIndex * 10);
        binding.progressBar4.setSecondaryProgress(qIndex > 0? (qIndex * 10) + 10 : 10);
    }*/

    public void onDestroyView() { super.onDestroyView(); binding = null; }
}