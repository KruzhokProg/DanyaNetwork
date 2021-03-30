package com.example.danyanetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.danyanetwork.Fragments.AdSearchFragment;
import com.example.danyanetwork.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView menuNav = findViewById(R.id.bottomNavigationView);
        menuNav.setOnNavigationItemSelectedListener(navListener);
        menuNav.findViewById(R.id.person).performClick();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ProfileFragment(getSupportFragmentManager())).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.person:
                    selectedFragment = new ProfileFragment(getSupportFragmentManager());
                    break;
                case R.id.search:
                    selectedFragment = new AdSearchFragment(getSupportFragmentManager());
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
            return true;
        }
    };

}