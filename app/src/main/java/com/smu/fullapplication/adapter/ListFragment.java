// com.smu.fullapplication.adapter.ListFragment.java
package com.smu.fullapplication.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.smu.fullapplication.R;

public class ListFragment extends Fragment {

    private ListView listView;
    private String[] items = {
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
    };

    OnItemSelectedListener callback;

    public interface OnItemSelectedListener {
        void onItemSelected(String itemText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // The parent must implement OnItemSelectedListener
        Fragment parent = getParentFragment();
        if (parent instanceof OnItemSelectedListener) {
            callback = (OnItemSelectedListener) parent;
        } else {
            throw new ClassCastException(parent.toString()
                    + " must implement ListFragment.OnItemSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listView = view.findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                items
        );

        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener((AdapterView<?> parent, View view1, int position, long id) -> {
            String selectedItem = items[position];
            callback.onItemSelected(selectedItem); // Notify parent
        });

        return view;
    }
}
