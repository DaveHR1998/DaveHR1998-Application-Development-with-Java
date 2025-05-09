// com.smu.fullapplication.adapter.MasterDetailFragment.java
package com.smu.fullapplication.adapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smu.fullapplication.R;

public class MasterDetailFragment extends Fragment
        implements ListFragment.OnItemSelectedListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_detail, container, false);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.listContainer, new ListFragment());
        transaction.replace(R.id.detailContainer, new DetailFragment());
        transaction.commit();

        return view;
    }

    @Override
    public void onItemSelected(String itemText) {
        DetailFragment detailFragment = DetailFragment.newInstance(itemText);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.detailContainer, detailFragment);
        transaction.commit();
    }
}
