package com.example.notes.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.notes.NoteModel.NoteList;
import com.example.notes.R;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NoteList> {

    Activity context;
    int IdLayout;

    ArrayList<NoteList> myList;

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<NoteList> myList) {
        super(context, idLayout, myList);
        this.context = context;
        IdLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(IdLayout,null);
        NoteList noteList = myList.get(position);

        TextView textView1 = convertView.findViewById(R.id.textview1);
        TextView textView2 = convertView.findViewById(R.id.textview2);

        textView1.setText(noteList.getTitle());
        textView2.setText(noteList.getDescription());
        return convertView;
    }
}
