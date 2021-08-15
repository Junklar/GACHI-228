package com.example.geography;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.geography.databinding.MainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    private NavController navController;
    private AppBarConfiguration mAppBarConfiguration;
    private MainBinding binding;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        randomTest(Q.Q1, Test.tests[0].testAns);
        randomTest(Q.Q2, Test.tests[1].testAns);

        setSupportActionBar(binding.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_info, R.id.nav_test1, R.id.nav_test2
        ).setDrawerLayout(drawer).build();
        navController = Navigation.findNavController(this, R.id.host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    private void randomTest(String[][] q, int[] qAns) {
        final Random r = new Random();
        for (int i = 0; i < q.length; i++) { // Рандом ответов
            final String[] s = q[i];
            for (int j = q[i].length - 1; j > 0; j--) {
                final int index = (j-1 != 0) ? r.nextInt(j-1)+1 : 1;
                final boolean jQAns = j == qAns[i];
                if (jQAns || index == qAns[i])
                    qAns[i] = jQAns ? index : j;
                String tmp = s[index]; s[index] = s[j]; s[j] = tmp;
            }
        }
        for (int i = q.length - 1; i > 0; i--) { // Рандом вопросов
            final int index = r.nextInt(i);
            int swapQAns = qAns[index]; qAns[index] = qAns[i]; qAns[i] = swapQAns;
            String[] tmp = q[index]; q[index] = q[i]; q[i] = tmp;
        }
    }

}