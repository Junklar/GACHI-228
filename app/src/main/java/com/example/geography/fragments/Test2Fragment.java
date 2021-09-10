package com.example.geography.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.geography.Test;
import com.example.geography.databinding.FragmentTest2Binding;

public class Test2Fragment extends Fragment {
    private FragmentTest2Binding binding;
    private static final Test test = Test.tests[1];

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTest2Binding.inflate(inflater, container, false);

        return binding.getRoot();
    }


    public void onDestroyView() { super.onDestroyView(); binding = null; }
}