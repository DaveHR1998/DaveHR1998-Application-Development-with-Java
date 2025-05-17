package com.smu.fullapplication.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smu.fullapplication.R;
import com.smu.fullapplication.room.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private final List<PersonEntity> persons = new ArrayList<>();

    public interface OnItemClickListener {
        void onItemClick(PersonEntity person);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(PersonEntity person);
    }

    private OnItemClickListener clickListener;
    private OnItemLongClickListener longClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.longClickListener = listener;
    }

    public void setPersons(List<PersonEntity> newList) {
        persons.clear();
        persons.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        PersonEntity person = persons.get(position);
        holder.name.setText(person.name);
        holder.age.setText("Age: " + person.age);

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) clickListener.onItemClick(person);
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (longClickListener != null) longClickListener.onItemLongClick(person);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView name, age;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.personName);
            age = itemView.findViewById(R.id.personAge);
        }
    }


}
