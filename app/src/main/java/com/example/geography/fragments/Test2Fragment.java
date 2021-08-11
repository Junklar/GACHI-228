package com.example.geography.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.fragment.app.Fragment;

import com.example.geography.databinding.FragmentTest2Binding;
import com.example.geography.databinding.FragmentTestBinding;
import static com.example.geography.TestQ.*;
import static com.example.geography.MainActivity.qIndex;
import static com.example.geography.TestQ.qAns2;

public class Test2Fragment extends Fragment {
    private FragmentTest2Binding binding;
    private CheckBox[] checkBoxes;
    
    @SuppressLint("SetTextI18n")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTest2Binding.inflate(inflater, container, false);
        checkBoxes = new CheckBox[]{binding.checkBox1, binding.checkBox2, binding.checkBox3, binding.checkBox4};

        setQ(qIndex);
        binding.back.setOnClickListener((e)->{
            setAns();
            if (qIndex != 0)
                setQ(--qIndex);
        });

        binding.next.setOnClickListener((e)->{
            setAns();
            if (qIndex != (q2.length-1))
                setQ(++qIndex);
            else
                binding.finish.setVisibility(View.VISIBLE);
        });

        binding.finish.setOnClickListener((e)-> setAns());
        return binding.getRoot();
    }


    private void setQ(int i) {
        binding.qText.setText(q2[qIndex][0]);
        binding.checkBox1.setText(q2[i][1]);
        binding.checkBox2.setText(q2[i][2]);
        binding.checkBox3.setText(q2[i][3]);
        binding.checkBox4.setText(q2[i][4]);
        binding.finish.setVisibility(View.INVISIBLE);
        prevAns();
        binding.progressBar4.setProgress(i * 10);
        binding.progressBar4.setSecondaryProgress(i > 0? (i * 10) + 10 : 10);
    }

    private void setAns() {
        for (int i = 0; i < checkBoxes.length; i++)
            ans2[qIndex][i] = (i == (qAns2[qIndex]-1)) == checkBoxes[i].isChecked();
    }
    private void prevAns() {
        for (int i = 0; i < checkBoxes.length; i++)
            checkBoxes[i].setChecked(false);
    }
    private String TF(int i) {
        return ans2[qIndex][i]?"T":"F";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}