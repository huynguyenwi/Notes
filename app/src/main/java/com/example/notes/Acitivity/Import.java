package com.example.notes.Acitivity;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.notes.Adapter.MyAdapter;
import com.example.notes.Adapter.MyAdapterNoteImportList;
import com.example.notes.JSON.JSONManager;
import com.example.notes.NoteModel.Notes;
import com.example.notes.NoteModel.NotesImportList;
import com.example.notes.R;
import com.example.notes.SQLite.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class Import extends AppCompatActivity {
    Button closebtn2;
    Button storagebtn1;
    JSONManager jsonManager = new JSONManager();

    String file[] ={"Notes-20231109T203555.ocn","Notes-20231109T203555.ocn"};
    ArrayList<NotesImportList> notesImportLists;
    MyAdapterNoteImportList myAdapterNoteImportList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        closebtn2 = findViewById(R.id.closebtn2);
        closebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                Intent intent = new Intent(Import.this, ImportAndExport.class);
                intent.putExtra("close", true);
                startActivity(intent);
            }
        });

        storagebtn1 = findViewById(R.id.storagebtn1);
        storagebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //importData();
                Intent intent = new Intent(Import.this, ImportAndExport.class);
                intent.putExtra("import_data", true);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.listview);

        notesImportLists = new ArrayList<>();

        for(int i = 0; i < file.length; i++){
            notesImportLists.add(new NotesImportList(file[i]));
        }

        myAdapterNoteImportList = new MyAdapterNoteImportList(Import.this, R.layout.layout_lv_import, notesImportLists);

        listView.setAdapter(myAdapterNoteImportList);
    }

    protected void importData() {
        // Xác định đường dẫn tệp JSON cần import
        String fileName = "notes.json"; // Tên tệp có thể thay đổi tùy theo yêu cầu
        String filePath = getFilePath(this, fileName);

        // Thực hiện import dữ liệu từ tệp JSON
        List<Notes> importedNotes = jsonManager.importFromJSON(filePath);

        // Ghi đè cơ sở dữ liệu hiện tại bằng dữ liệu đã import
        overwriteDatabase(importedNotes);


        // Hiển thị thông báo hoàn tất import
        Toast.makeText(this,"Import Successfull!", Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(Import.this, ImportAndExport.class);
//        intent.putExtra("show_dialog_import", true);
//        intent.putExtra("number_of_notes", importedNotes.size());
//        startActivity(intent);
    }
    public String getFilePath(Context context, String fileName) {
        return context.getFilesDir() + "/" + fileName;
    }

    private void overwriteDatabase(List<Notes> importedNotes) {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.deleteAll(); // Xóa tất cả các ghi chú trong cơ sở dữ liệu

        // Thêm lại tất cả các ghi chú đã được import vào cơ sở dữ liệu
        for (Notes note : importedNotes) {
            databaseHelper.AddNote(note);
        }
    }

}