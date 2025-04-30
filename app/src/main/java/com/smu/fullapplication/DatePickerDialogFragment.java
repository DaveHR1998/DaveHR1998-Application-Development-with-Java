package com.smu.fullapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerDialogFragment extends DialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the current date
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create and return a DatePickerDialog
        return new DatePickerDialog(getActivity(), (view, year1, monthOfYear, dayOfMonth) -> {
            // Handle selected date
            Toast.makeText(getActivity(), "Selected Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1, Toast.LENGTH_SHORT).show();
        }, year, month, day);
    }
}
