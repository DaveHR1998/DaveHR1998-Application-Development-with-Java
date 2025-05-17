package com.smu.fullapplication.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.smu.fullapplication.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.smu.fullapplication.R;

public class PersonCursorAdapter extends CursorAdapter {
    public PersonCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = view.findViewById(R.id.personName);
        TextView age = view.findViewById(R.id.personAge);

        @SuppressLint("Range") String personName = cursor.getString(cursor.getColumnIndex("name"));
        @SuppressLint("Range") int personAge = cursor.getInt(cursor.getColumnIndex("age"));

        name.setText(personName);
        age.setText("Age: " + personAge);
    }
}