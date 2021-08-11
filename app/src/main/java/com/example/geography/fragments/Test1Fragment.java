package com.example.geography.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.geography.MainActivity;
import com.example.geography.R;
import com.example.geography.databinding.FragmentTestBinding;

import static com.example.geography.MainActivity.fragmentManager;
import static com.example.geography.TestQ.*;
import static com.example.geography.MainActivity.qIndex;
import static com.example.geography.TestQ.qAns;

import java.util.Objects;

public class Test1Fragment extends Fragment {
    private FragmentTestBinding binding;
    private CheckBox[] checkBoxes;


    @SuppressLint({"SetTextI18n", "ResourceType"})
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater, container, false);
        checkBoxes = new CheckBox[]{binding.checkBox1, binding.checkBox2, binding.checkBox3, binding.checkBox4};

        setQ(qIndex);
        binding.back.setOnClickListener((e)->{
            setAns();
            if (qIndex != 0)
                setQ(--qIndex);
        });

        binding.next.setOnClickListener((e)->{
            setAns();
            if (qIndex != (q.length-1))
                setQ(++qIndex);
            else
                binding.finish.setVisibility(View.VISIBLE);
        });

        binding.finish.setOnClickListener((e)->{ getActivity().onBackPressed(); });
        return binding.getRoot();
    }


    private void setQ(int i) {
        binding.qText.setText(q[qIndex][0]);
        binding.finish.setVisibility(View.INVISIBLE);
        for (int j = 0; j < checkBoxes.length; j++) {
            checkBoxes[j].setText(q[i][j+1]);
            checkBoxes[j].setChecked(ans[qIndex][j]);
        }
        binding.progressBar4.setProgress(i * 10);
        binding.progressBar4.setSecondaryProgress(i > 0? (i * 10) + 10 : 10);
    }

    private void setAns() {
        for (int i = 0; i < checkBoxes.length; i++)
            ans[qIndex][i] = checkBoxes[i].isChecked();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}