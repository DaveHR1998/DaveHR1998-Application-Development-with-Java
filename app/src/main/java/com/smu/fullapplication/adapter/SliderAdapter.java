package com.smu.fullapplication.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SliderAdapter extends FragmentStateAdapter {
    public SliderAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if(position == 0) {
            fragment = new SlidePage1Fragment();
        } else if(position == 1) {
            fragment = new SlidePage2Fragment();
        } else if(position == 2) {
            fragment = new SlidePage3Fragment();
        } else {
            fragment = new SlidePage1Fragment();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
