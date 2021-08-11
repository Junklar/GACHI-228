package com.example.geography;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.geography.databinding.MainBinding;
import static com.example.geography.TestQ.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    private NavController navController;
    private AppBarConfiguration mAppBarConfiguration;
    private MainBinding binding;
    public static int qIndex = 0;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        randomQ();

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

    private void randomQ() {
        final Random r = new Random();
        for (int i = 0; i < q.length; i++) { // Рандом ответов
            final String[] s = q[i];
            for (int j = q[i].length - 1; j > 0; j--) {
                final int jMO = j-1;
                final int index = (jMO != 0) ? r.nextInt(jMO)+1 : 1;
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
        for (int i = 0; i < q2.length; i++) { // Рандом ответов
            final String[] s = q[i];
            for (int j = q[i].length - 1; j > 0; j--) {
                final int jMO = j-1;
                final int index = (jMO != 0) ? r.nextInt(jMO)+1 : 1;
                final boolean jQAns = j == qAns[i];
                if (jQAns || index == qAns[i])
                    qAns[i] = jQAns ? index : j;
                String tmp = s[index]; s[index] = s[j]; s[j] = tmp;
            }
        }
        for (int i = q2.length - 1; i > 0; i--) { // Рандом вопросов
            final int index = r.nextInt(i);
            int swapQAns = qAns[index]; qAns[index] = qAns[i]; qAns[i] = swapQAns;
            String[] tmp = q[index]; q[index] = q[i]; q[i] = tmp;
        }
    }

}