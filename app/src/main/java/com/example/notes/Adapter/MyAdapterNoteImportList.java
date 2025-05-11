package com.example.notes.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.notes.NoteModel.NotesImportList;
import com.example.notes.R;

import java.util.ArrayList;

public class MyAdapterNoteImportList extends ArrayAdapter<NotesImportList> {

    Activity context;
    int IdLayout;

    ArrayList<NotesImportList> myList;

    public MyAdapterNoteImportList(Activity context, int idLayout, ArrayList<NotesImportList> myList) {
        super(context, idLayout, myList);
        this.context = context;
        IdLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =  context.getLayoutInflater();
        convertView = layoutInflater.inflate(IdLayout, null);
        NotesImportList notesImportList = myList.get(position);

        TextView textview_importfile = convertView.findViewById(R.id.textview_importfile);

        textview_importfile.setText(notesImportList.getFile());

        return convertView;
    }
}
