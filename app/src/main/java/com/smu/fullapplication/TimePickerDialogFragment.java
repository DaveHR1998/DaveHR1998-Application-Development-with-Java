package com.smu.fullapplication;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerDialogFragment extends DialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the current time
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create and return a TimePickerDialog
        return new TimePickerDialog(getActivity(), (view, hourOfDay, minute1) -> {
            // Handle selected time
            Toast.makeText(getActivity(), "Selected Time: " + hourOfDay + ":" + minute1, Toast.LENGTH_SHORT).show();
        }, hour, minute, true);
    }
}
