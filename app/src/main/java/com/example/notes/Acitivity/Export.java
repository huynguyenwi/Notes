package com.example.notes.Acitivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


import com.example.notes.JSON.JSONManager;
import com.example.notes.NoteModel.Notes;
import com.example.notes.R;
import com.example.notes.SQLite.DatabaseHelper;

import java.io.File;
import java.util.List;

public class Export extends AppCompatActivity {

    Button closebtn1;
    Toolbar toolbar1;

    JSONManager jsonManager = new JSONManager();
    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export);

        closebtn1 = findViewById(R.id.closebtn1);
        closebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exportData();

            }
        });

        
    }

    private void exportData () {
        // Lấy dữ liệu từ cơ sở dữ liệu
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        notesList = databaseHelper.getNote();

        // Xác định đường dẫn tệp JSON
        String fileName = "notes.json"; // Tên tệp có thể thay đổi tùy theo yêu cầu
        String filePath = getFilePath(this, fileName);

        // Thực hiện xuất dữ liệu sang tệp JSON
        jsonManager.exportToJSON(notesList, filePath);

        // Hiển thị thông báo hoàn tất export
        Toast.makeText(this,"Export Successfull!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Export.this, ImportAndExport.class);
        intent.putExtra("show_dialog_export", true);
        intent.putExtra("file_name", fileName);
        startActivity(intent);
    }

    public String getFilePath(Context context, String fileName) {
        return context.getFilesDir() + "/" + fileName;
    }




//    private String getFilename(){
//        String filepath = Environment.getExternalStorageDirectory().getPath();
//        File file = new File(filepath, Notes);
//        if (!file.exists()){
//            file.mkdir();
//        }
//        return (file.getAbsolutePath() + "/" + System.currentTimeMillis() + file_exts[currentFormat]);
//    }

}