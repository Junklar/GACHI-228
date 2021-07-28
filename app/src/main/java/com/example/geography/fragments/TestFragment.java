package com.example.geography.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.geography.databinding.FragmentTestBinding;

import java.util.Random;

public class TestFragment extends Fragment {
    public static final String[][] q = {
            {"З чого складається водна оболонка Землі - гідросфера?",
                    "з вод суші і Світового океану",
                    "з вод суші, Світового океану і води в атмосфері - правильно",
                    "з річок, озер, морів, боліт, ставків",
                    "тільки з вод суші"},
            {"Як називаються ділянки суші, оточені з трьох сторін водою, а з четвертого - з'єднані з нею?",
                    "материки","архіпелаги","півострова - правильно","острова"},
            {"Яка частина гідросфери не відображена на картах?",
                    "річки","моря","озера","підземні води - правильно"},
            {"Як називається безперервний процес переміщення води зі Світового океану на сушу і назад?",
                    "Світовий океан","течії","водна спільнота","Світової кругообіг води - правильно"},
            {"Яке харчування має більшість річок Росії?",
                    "снігове - правильно","дощове","льодовикове","змішане"}
    };
    private FragmentTestBinding binding;

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater, container, false);
        return onCreate(binding.getRoot());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private View onCreate(View root) {
        Random r = new Random();
        for (String[] s: q) random(s, true);
        random(q, false);
        binding.qText.setText(q[0][0]);
        binding.checkBox1.setText(q[0][1]);
        binding.checkBox2.setText(q[0][2]);
        binding.checkBox3.setText(q[0][3]);
        binding.checkBox4.setText(q[0][4]);
        return root;
    }

    private void random(Object[] s, boolean generateAnswers) {
        final Random r = new Random();
        for (int i = s.length - 1; i > 0; i--) { // Рандом ответов
            final int index = generateAnswers ? ((i-1)!=0 ? r.nextInt(i-1)+1 : 1) : r.nextInt(i);
            Object tmp = s[index]; s[index] = s[i]; s[i] = tmp;
        }
    }

    /*
        <item>Який океан вважається найбільшим?</item>
        <item>Яке озеро наполовину складається з прісної води, а наполовину - з солоної?</item>
        <item>Вкажіть штучну водойму:</item>
        <item>В яке море впадає річка Волга?</item>
        <item>Яка течія починається біля берегів Північної Америки і має північно-східний напрямок?</item>
     */
}