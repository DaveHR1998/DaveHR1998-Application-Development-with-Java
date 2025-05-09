// com.smu.fullapplication.adapter.DetailFragment.java
package com.smu.fullapplication.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.smu.fullapplication.R;

public class DetailFragment extends Fragment {

    private static final String ARG_TEXT = "itemText";

    public static DetailFragment newInstance(String text) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView textView = view.findViewById(R.id.detailText);

        if (getArguments() != null) {
            String itemText = getArguments().getString(ARG_TEXT);
            textView.setText("Selected: " + itemText);
        }

        return view;
    }
}
