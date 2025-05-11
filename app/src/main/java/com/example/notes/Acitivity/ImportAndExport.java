package com.example.notes.Acitivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.notes.Adapter.MyArrayAdapter;
import com.example.notes.NoteModel.NoteList;
import com.example.notes.R;

import java.util.ArrayList;

public class ImportAndExport extends Import {

    String title[] = {"Export", "Import"};
    //String description[] = {"getString(R.string.description)", "getString(R.string.description1)"};

    String description[];
    ArrayList<NoteList> noteList;
    MyArrayAdapter myArrayAdapter;
    ListView listView;
    Button cancelbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_and_export);

        description = new String[]{getString(R.string.description), getString(R.string.description1)};

        listView = findViewById(R.id.lv);

        listView.setVerticalScrollBarEnabled(false);


        noteList = new ArrayList<>();

        for (int i = 0; i < title.length; i++){
            noteList.add(new NoteList(title[i],description[i]));
        }


        myArrayAdapter = new MyArrayAdapter(ImportAndExport.this, R.layout.layout_item_lv, noteList);
        listView.setAdapter(myArrayAdapter);


        //xử lý click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = noteList.get(i).getTitle();

                if(selectedItem.equals("Export")) {
                    Intent intent = new Intent(ImportAndExport.this, Export.class);
                    startActivity(intent);
                } else if(selectedItem.equals("Import")) {
                    Intent intent = new Intent(ImportAndExport.this, Import.class);
                    startActivity(intent);
                }
            }
        });

        cancelbtn = findViewById(R.id.cancelbtn);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        if (getIntent().getBooleanExtra("show_dialog_export", false)) {
            String fileName = getIntent().getStringExtra("file_name");
            dialogExport(fileName);
        }


//        if (getIntent().getBooleanExtra("show_dialog_import", false)) {
//            int numberOfNotes = getIntent().getIntExtra("number_of_notes", 1);
//            dialogImport(numberOfNotes);
//        }
        if (getIntent().getBooleanExtra("import_data", false)) {
            // Start the import dialog
            dialogImport();
        }
        if (getIntent().getBooleanExtra("close", false)) {
            dialogClose();
        }
    }


    public void dialogExport(String fileName){
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);

        mydialog.setTitle("Export notes");
        mydialog.setMessage("All your notes are now successfully exported to: " + fileName);
        mydialog.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
//        mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });

        mydialog.setCancelable(true);

        mydialog.create().show();

    }
    public void dialogImport(){
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Import notes");
        //mydialog.setMessage("Are you sure you want to import " + numberOfNotes + " notes?");
        mydialog.setMessage("Are you sure you want to import notes?");

        mydialog.setPositiveButton("IMPORT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               importData();
                dialogInterface.dismiss();
            }
        });
        mydialog.setNegativeButton("DISCARD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mydialog.setCancelable(true);

        mydialog.create().show();

    }
    private void dialogClose() {
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Import notes");
        mydialog.setMessage("Import notes has failed, invalid file location.");

        mydialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mydialog.setCancelable(true);

        mydialog.create().show();

    }

}