package com.smu.fullapplication.adapter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smu.fullapplication.R;


public class FragmentDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        BottomNavigationView nav = findViewById(R.id.bottomNavigation);
        nav.setOnItemSelectedListener(item -> {
            Fragment frag = null;
            int id = item.getItemId();
            if (id == R.id.nav_overlay) frag = new com.smu.fullapplication.adapter.OverlayFragment();
            else if (id == R.id.nav_slider) frag = new SliderFragment();
            else if (id == R.id.nav_master_detail) frag = new MasterDetailFragment();
            if (frag != null) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, frag)
                        .commit();
//
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.fragmentContainer, frag);
                fragmentTransaction.commit();
            }
            return true;
        });

        // Load first fragment
        nav.setSelectedItemId(R.id.nav_overlay);
    }
}
