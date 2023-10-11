package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MaterialButton addnewnotebtn;
    RecyclerView recyclerView;

    List<Notes> notesList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addnewnotebtn = findViewById(R.id.newnotebtn);
        addnewnotebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });


        recyclerView = findViewById(R.id.recyclerview);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        notesList = databaseHelper.getNote();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        Collections.reverse(notesList);
        recyclerView.setLayoutManager(gridLayoutManager);


        myAdapter = new MyAdapter(this,notesList);
        recyclerView.setAdapter(myAdapter);



    }



}