package com.smu.fullapplication.adapter;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.smu.fullapplication.R;

public class SliderFragment extends Fragment {
    public SliderFragment() {
        super(R.layout.fragment_slider);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new SliderAdapter(getActivity()));
    }

}

