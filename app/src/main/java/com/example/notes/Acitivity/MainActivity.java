package com.example.notes.Acitivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.notes.SQLite.DatabaseHelper;
import com.example.notes.Adapter.MyAdapter;
import com.example.notes.NoteModel.Notes;
import com.example.notes.R;
import com.google.android.material.button.MaterialButton;


import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    MaterialButton addnewnotebtn, probtn;
    RecyclerView recyclerView;

    List<Notes> notesList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addnewnotebtn = findViewById(R.id.newnotebtn);

        probtn = findViewById(R.id.probtn);


        addnewnotebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivityForResult(intent, 1); // 1 là requestCode
            }
        });

        probtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImportAndExport.class));
            }
        });


        //overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);

        recyclerView = findViewById(R.id.recyclerview);



        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        notesList = databaseHelper.getNote();

       // GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
       // recyclerView.setLayoutManager(gridLayoutManager);

        GridLayoutManager gridLayoutManager;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridLayoutManager = new GridLayoutManager(this, 3);
        } else {

            gridLayoutManager = new GridLayoutManager(this, 2);
        }
        recyclerView.setLayoutManager(gridLayoutManager);


        Collections.reverse(notesList);


       myAdapter = new MyAdapter(this,notesList);
       recyclerView.setAdapter(myAdapter);


        myAdapter.notifyDataSetChanged();

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) { // Kiểm tra xem requestCode có trùng với số bạn đã gửi khi gọi startActivityForResult không
//            if (resultCode == RESULT_OK) {
//                int selectedColor1 = data.getIntExtra("selectedColor1", -1);
//                int selectedColor2 = data.getIntExtra("selectedColor2", -1);
//                myAdapter.setColors(selectedColor1, selectedColor2); // Gọi phương thức setColors với màu đã chọn
//            }
//        }
//    }

}