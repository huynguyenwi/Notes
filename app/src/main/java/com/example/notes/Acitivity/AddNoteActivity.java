package com.example.notes.Acitivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.example.notes.SQLite.DatabaseHelper;
import com.example.notes.NoteModel.Notes;
import com.example.notes.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class AddNoteActivity extends AppCompatActivity {

    Toolbar toolbaradd1, toolbaradd2;
    EditText titleinput, descriptioninput;
    ImageButton colorpicker;
    Button closebtn, sharebtn, confirmbtn;

    String Date, Time;
    Calendar calendar;

    int id;

    Context context;

    int colorRandom1;
    int colorRandom2;
    int selectedColor1;
    int selectedColor2;


    ImageButton imgbtn_red, imgbtn_orange, imgbtn_lightorange,imgbtn_yellow, imgbtn_lightgreen, imgbtn_green, imgbtn_darkgreen, imgbtn_blue, imgbtn_denim, imgbtn_purple;

    ImageView checkmarkImage1, checkmarkImage2, checkmarkImage3, checkmarkImage4, checkmarkImage5, checkmarkImage6, checkmarkImage7, checkmarkImage8, checkmarkImage9, checkmarkImage10;

    int[][] imgbtnPairs = {
            {R.color.red, R.color.lightpink},
            {R.color.orange, R.color.bisque},
            {R.color.darkorange, R.color.navajowhite},
            {R.color.gold, R.color.papayawhip},
            {R.color.yellowgreen, R.color.palegoldenrod},
            {R.color.limegreen, R.color.palegreen},
            {R.color.darkturquoise, R.color.paleturquoise},
            {R.color.royalblue, R.color.skyblue},
            {R.color.mediumblue, R.color.lightskyblue},
            {R.color.darkviolet, R.color.plum},

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        toolbaradd1 = findViewById(R.id.toolbaradd1);
        toolbaradd2 = findViewById(R.id.toolbaradd2);
        titleinput = findViewById(R.id.titleinput);
        descriptioninput = findViewById(R.id.descriptioninput);
        colorpicker = findViewById(R.id.colorpicker);
        closebtn = findViewById(R.id.closebtn);
        sharebtn = findViewById(R.id.sharebtn);
        confirmbtn = findViewById(R.id.confirmbtn);

        //overridePendingTransition(R.anim.zoom_out, R.anim.zoom_in);

        context = this;

//        selectedColor1 = context.getResources().getColor(R.color.red);
//        selectedColor2 = context.getResources().getColor(R.color.lightpink);
//        applyColorToView(selectedColor1, selectedColor2);




            Random random = new Random();
            int randomIndex = random.nextInt(imgbtnPairs.length);


            //selectedColor1 = ContextCompat.getColor(context, imgbtnPairs[randomIndex][0]);
            //selectedColor2 = ContextCompat.getColor(context, imgbtnPairs[randomIndex][1]);

            colorRandom1 = ContextCompat.getColor(context, imgbtnPairs[randomIndex][0]);
            colorRandom2 = ContextCompat.getColor(context, imgbtnPairs[randomIndex][1]);



            //applyColorToView(selectedColor1, selectedColor2);
            applyColorToView(colorRandom1, colorRandom2);



        //Hiển thị lên AddNoteActivity
        DatabaseHelper db = new DatabaseHelper(this);
        Intent intent = getIntent();

        id = intent.getIntExtra("ID",0);

        Notes notes = db.getNotes(id);

//        if(notes!=null) {
//            titleinput.setText(notes.getTitle());
//            descriptioninput.setText(notes.getDescription());
//
//            toolbaradd1.setBackgroundColor(notes.getColor1());
//            toolbaradd2.setBackgroundColor(notes.getColor1());
//            descriptioninput.setBackgroundColor(notes.getColor2());
//
//
//        }


        //Lấy ngày tháng, thời gian
        //calendar = Calendar.getInstance();
        calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+7"));
        Date = calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" +calendar.get(Calendar.YEAR);
        //Time = pad(calendar.get(Calendar.HOUR))+":"+pad(calendar.get(Calendar.MINUTE))+":"+pad(calendar.get(Calendar.SECOND));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        Time = sdf.format(calendar.getTime());

        //tạo click cho nút V
        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                if (notes == null) {
//                    String newTitle = titleinput.getText().toString();
//                    String newDescription = descriptioninput.getText().toString();
//                    Notes newNote = new Notes(newTitle, newDescription, Date, Time, selectedColor1, selectedColor2);
//                    //Notes newNote = new Notes(newTitle, newDescription, Date, Time, colorRandom1, colorRandom2);
//                    db.AddNote(newNote);
//                } else {
//                    // Cập nhật ghi chú hiện tại nếu có thay đổi
//                    String newTitle = titleinput.getText().toString();
//                    String newDescription = descriptioninput.getText().toString();
//
//                    if (selectedColor1 == 0 && selectedColor2 == 0) {
//                        selectedColor1 = notes.getColor1();
//                        selectedColor2 = notes.getColor2();
//                    }
//
//                    if (!notes.getTitle().equals(newTitle) || !notes.getDescription().equals(newDescription)
//                            || notes.getDate() != Date || notes.getColor1() != selectedColor1 || notes.getColor2() != selectedColor2 ) {
//                        db.updateNote(id, newTitle, newDescription,Date, Time, selectedColor1, selectedColor2);
//                    }

                if (notes == null) {
                    String newTitle = titleinput.getText().toString();
                    String newDescription = descriptioninput.getText().toString();
                    if (selectedColor1 == 0 && selectedColor2 == 0) {
                        selectedColor1 = colorRandom1;
                        selectedColor2 = colorRandom2;
                    }

                    Notes newNote = new Notes(newTitle, newDescription, Date, Time, selectedColor1, selectedColor2);
                    db.AddNote(newNote);
                } else {
                    String newTitle = titleinput.getText().toString();
                    String newDescription = descriptioninput.getText().toString();
                    if (selectedColor1 == 0 && selectedColor2 == 0) {
                        selectedColor1 = notes.getColor1();
                        selectedColor2 = notes.getColor2();
                    }
                    if (!notes.getTitle().equals(newTitle) || !notes.getDescription().equals(newDescription)
                            || notes.getDate() != Date || notes.getColor1() != selectedColor1 || notes.getColor2() != selectedColor2) {
                        db.updateNote(id, newTitle, newDescription, Date, Time, selectedColor1, selectedColor2);
                    }
                }

                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shareContent;
                if (notes != null) {
                    shareContent = notes.getDescription();
                } else {
                    shareContent = "Note";
                }
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_SUBJECT, "Shared Note");
                intent1.putExtra(Intent.EXTRA_TEXT, shareContent);
                startActivity(Intent.createChooser(intent1, "Share using"));
            }
        });

        colorpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(Gravity.CENTER);
            }
        });


    }

    private void openDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            dialog.setContentView(R.layout.layout_dialog_landscape);
        }else {
            dialog.setContentView(R.layout.layout_dialog);
        }

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER == gravity){
            dialog.setCancelable(true);
        }

        checkColor();

        imgbtn_red = dialog.findViewById(R.id.imgbtn_red);
        imgbtn_orange = dialog.findViewById(R.id.imgbtn_orange);
        imgbtn_lightorange = dialog.findViewById(R.id.imgbtn_lightorange);
        imgbtn_yellow = dialog.findViewById(R.id.imgbtn_yellow);
        imgbtn_lightgreen = dialog.findViewById(R.id.imgbtn_lightgreen);
        imgbtn_green = dialog.findViewById(R.id.imgbtn_green);
        imgbtn_darkgreen = dialog.findViewById(R.id.imgbtn_darkgreen);
        imgbtn_blue = dialog.findViewById(R.id.imgbtn_blue);
        imgbtn_denim = dialog.findViewById(R.id.imgbtn_denim);
        imgbtn_purple = dialog.findViewById(R.id.imgbtn_purple);



        checkmarkImage1 = dialog.findViewById(R.id.checkmark_image1);
        checkmarkImage2 = dialog.findViewById(R.id.checkmark_image2);
        checkmarkImage3 = dialog.findViewById(R.id.checkmark_image3);
        checkmarkImage4 = dialog.findViewById(R.id.checkmark_image4);
        checkmarkImage5 = dialog.findViewById(R.id.checkmark_image5);
        checkmarkImage6 = dialog.findViewById(R.id.checkmark_image6);
        checkmarkImage7 = dialog.findViewById(R.id.checkmark_image7);
        checkmarkImage8 = dialog.findViewById(R.id.checkmark_image8);
        checkmarkImage9 = dialog.findViewById(R.id.checkmark_image9);
        checkmarkImage10 = dialog.findViewById(R.id.checkmark_image10);


        checkColor();

        boolean[] isSelected = new boolean[10];


        imgbtn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               // Toast.makeText(AddNoteActivity.this,"Pick Color Red",Toast.LENGTH_SHORT).show();
                selectedColor1 = ContextCompat.getColor(context,R.color.red);
                selectedColor2 = ContextCompat.getColor(context,R.color.lightpink);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[0] = true;
                // Ẩn tất cả các dấu tích trước khi hiển thị dấu tích cho ô này
                hideAllCheckMarks();
                // Hiển thị dấu tích cho ô hiện tại
                checkmarkImage1.setVisibility(View.VISIBLE);

            }
        });

        imgbtn_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.orange);
                selectedColor2 = ContextCompat.getColor(context,R.color.bisque);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[1] = true;
                hideAllCheckMarks();
                checkmarkImage2.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_lightorange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.darkorange);
                selectedColor2 = ContextCompat.getColor(context,R.color.navajowhite);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[2] = true;
                hideAllCheckMarks();
                checkmarkImage3.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.gold);
                selectedColor2 = ContextCompat.getColor(context,R.color.papayawhip);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[3] = true;
                hideAllCheckMarks();
                checkmarkImage4.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_lightgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.yellowgreen);
                selectedColor2 = ContextCompat.getColor(context,R.color.palegoldenrod);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[4] = true;
                hideAllCheckMarks();
                checkmarkImage5.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.limegreen);
                selectedColor2 = ContextCompat.getColor(context,R.color.palegreen);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[5] = true;
                hideAllCheckMarks();
                checkmarkImage6.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_darkgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.darkturquoise);
                selectedColor2 = ContextCompat.getColor(context,R.color.paleturquoise);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[6] = true;
                hideAllCheckMarks();
                checkmarkImage7.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.royalblue);
                selectedColor2 = ContextCompat.getColor(context,R.color.skyblue);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[7] = true;
                hideAllCheckMarks();
                checkmarkImage8.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_denim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.mediumblue);
                selectedColor2 = ContextCompat.getColor(context,R.color.lightskyblue);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[8] = true;
                hideAllCheckMarks();
                checkmarkImage9.setVisibility(View.VISIBLE);
            }
        });

        imgbtn_purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedColor1 = ContextCompat.getColor(context,R.color.darkviolet);
                selectedColor2 = ContextCompat.getColor(context,R.color.plum);
                applyColorToView1(selectedColor1,selectedColor2);

                isSelected[9] = true;
                hideAllCheckMarks();
                checkmarkImage10.setVisibility(View.VISIBLE);
            }
        });

        dialog.show();
    }



    private void applyColorToView(int color1, int color2) {
        toolbaradd1.setBackgroundColor(color1);
        descriptioninput.setBackgroundColor(color2);
        toolbaradd2.setBackgroundColor(color1);

        DatabaseHelper db = new DatabaseHelper(this);
        Intent intent = getIntent();

        id = intent.getIntExtra("ID",0);

        Notes notes = db.getNotes(id);

        if(notes!=null) {
            titleinput.setText(notes.getTitle());
            descriptioninput.setText(notes.getDescription());

            toolbaradd1.setBackgroundColor(notes.getColor1());
            toolbaradd2.setBackgroundColor(notes.getColor1());
            descriptioninput.setBackgroundColor(notes.getColor2());


        }


       // this.selectedColor1 = color1;
       // this.selectedColor2 = color2;

        checkColor();


        Log.d("AddNoteActivity", "Color 1: " + color1);
        Log.d("AddNoteActivity", "Color 2: " + color2);
//        Log.d("AddNote", "Color 1: " + String.format("#%06X", (0xFFFFFF & color1)));
//        Log.d("AddNote", "Color 2: " + String.format("#%06X", (0xFFFFFF & color2)));

    }

    private void applyColorToView1(int color1, int color2) {
        toolbaradd1.setBackgroundColor(color1);
        descriptioninput.setBackgroundColor(color2);
        toolbaradd2.setBackgroundColor(color1);



        // this.selectedColor1 = color1;
        // this.selectedColor2 = color2;

        checkColor();



        Log.d("AddNoteActivity", "Color 1: " + color1);
        Log.d("AddNoteActivity", "Color 2: " + color2);
//        Log.d("AddNote", "Color 1: " + String.format("#%06X", (0xFFFFFF & color1)));
//        Log.d("AddNote", "Color 2: " + String.format("#%06X", (0xFFFFFF & color2)));

    }

    private void hideAllCheckMarks() {
        checkmarkImage1.setVisibility(View.GONE);
        checkmarkImage2.setVisibility(View.GONE);
        checkmarkImage3.setVisibility(View.GONE);
        checkmarkImage4.setVisibility(View.GONE);
        checkmarkImage5.setVisibility(View.GONE);
        checkmarkImage6.setVisibility(View.GONE);
        checkmarkImage7.setVisibility(View.GONE);
        checkmarkImage8.setVisibility(View.GONE);
        checkmarkImage9.setVisibility(View.GONE);
        checkmarkImage10.setVisibility(View.GONE);
    }



private void checkColor() {
    if (checkmarkImage1 != null && checkmarkImage2 != null && checkmarkImage3 != null && checkmarkImage4 != null && checkmarkImage5 != null &&
            checkmarkImage6 != null && checkmarkImage7 != null && checkmarkImage8 != null && checkmarkImage9 != null && checkmarkImage10 != null) {

        DatabaseHelper db = new DatabaseHelper(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("ID", 0);
        Notes notes = db.getNotes(id);

//        if (notes != null) {
//            selectedColor1 = notes.getColor1();
//            selectedColor2 = notes.getColor2();
//        }
//        applyColorToView(selectedColor1, selectedColor2);
        if (notes != null) {
            int color1 = notes.getColor1();
            int color2 = notes.getColor2();
            for (int i = 0; i < imgbtnPairs.length; i++) {
                if (color1 == ContextCompat.getColor(context, imgbtnPairs[i][0]) &&
                        color2 == ContextCompat.getColor(context, imgbtnPairs[i][1])) {
                    switch (i) {
                        case 0:
                            checkmarkImage1.setVisibility(View.VISIBLE);
                            break;
                        case 1:
                            checkmarkImage2.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            checkmarkImage3.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            checkmarkImage4.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            checkmarkImage5.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            checkmarkImage6.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            checkmarkImage7.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            checkmarkImage8.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            checkmarkImage9.setVisibility(View.VISIBLE);
                            break;
                        case 9:
                            checkmarkImage10.setVisibility(View.VISIBLE);
                            break;
                        default:
                            break;
                    }
                }
            }
        } else {
            for (int i = 0; i < imgbtnPairs.length; i++) {
                if (colorRandom1 == ContextCompat.getColor(context, imgbtnPairs[i][0]) &&
                        colorRandom2 == ContextCompat.getColor(context, imgbtnPairs[i][1])) {
                    switch (i) {
                        case 0:
                            checkmarkImage1.setVisibility(View.VISIBLE);
                            break;
                        case 1:
                            checkmarkImage2.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            checkmarkImage3.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            checkmarkImage4.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            checkmarkImage5.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            checkmarkImage6.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            checkmarkImage7.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            checkmarkImage8.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            checkmarkImage9.setVisibility(View.VISIBLE);
                            break;
                        case 9:
                            checkmarkImage10.setVisibility(View.VISIBLE);
                            break;
                        default:
                            break;
                    }
                }
                }
            }
        }
    }


//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        DatabaseHelper db = new DatabaseHelper(this);
//        Intent intent = getIntent();
//
//        id = intent.getIntExtra("ID",0);
//
//        Notes notes = db.getNotes(id);
//        if (selectedColor1 == 0 && selectedColor2 == 0) {
//            selectedColor1 = notes.getColor1();
//            selectedColor2 = notes.getColor2();
//        }
//
//        outState.putInt("colorRandom1", colorRandom1);
//        outState.putInt("colorRandom2", colorRandom2);
//        outState.putInt("selectedColor1", selectedColor1);
//        outState.putInt("selectedColor2", selectedColor2);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState != null) {
//            if (savedInstanceState.containsKey("colorRandom1") && savedInstanceState.containsKey("colorRandom2")) {
//                colorRandom1 = savedInstanceState.getInt("colorRandom1");
//                colorRandom2 = savedInstanceState.getInt("colorRandom2");
//            }
//            if (savedInstanceState.containsKey("selectedColor1") && savedInstanceState.containsKey("selectedColor2")) {
//                selectedColor1 = savedInstanceState.getInt("selectedColor1");
//                selectedColor2 = savedInstanceState.getInt("selectedColor2");
//            }
//            applyColorToView(selectedColor1 != 0 ? selectedColor1 : colorRandom1, selectedColor2 != 0 ? selectedColor2 : colorRandom2);
//        }
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//        SharedPreferences.Editor editor = settings.edit();
//        editor.putInt(COLOR_RANDOM_1, colorRandom1);
//        editor.putInt(COLOR_RANDOM_2, colorRandom2);
//        editor.putInt(SELECTED_COLOR_1, selectedColor1);
//        editor.putInt(SELECTED_COLOR_2, selectedColor2);
//        editor.apply();
//
//        DatabaseHelper db = new DatabaseHelper(this);
//        Intent intent = getIntent();
//
//        id = intent.getIntExtra("ID",0);
//
//        Notes notes = db.getNotes(id);
//        if (selectedColor1 == 0 && selectedColor2 == 0) {
//            selectedColor1 = notes.getColor1();
//            selectedColor2 = notes.getColor2();
//        }
//        outState.putInt("selectedColor1", selectedColor1);
//        outState.putInt("selectedColor2", selectedColor2);
//
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//        colorRandom1 = settings.getInt(COLOR_RANDOM_1, 0);
//        colorRandom2 = settings.getInt(COLOR_RANDOM_2, 0);
//        selectedColor1 = settings.getInt(SELECTED_COLOR_1, 0);
//        selectedColor2 = settings.getInt(SELECTED_COLOR_2, 0);
//        applyColorToView(colorRandom1 != 0 ? colorRandom1 : selectedColor1, colorRandom2 != 0 ? colorRandom2 : selectedColor2);
//
//
//        if (savedInstanceState != null) {
//            selectedColor1 = savedInstanceState.getInt("selectedColor1");
//            selectedColor2 = savedInstanceState.getInt("selectedColor2");
//            applyColorToView(selectedColor1, selectedColor2);
//        }
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//         //Lưu trạng thái màu vào NoteViewModel khi chúng thay đổi
//        noteViewModel.setColorRandom1(colorRandom1);
//        noteViewModel.setColorRandom2(colorRandom2);
//        noteViewModel.setSelectedColor1(selectedColor1);
//        noteViewModel.setSelectedColor2(selectedColor2);
//
//        DatabaseHelper db = new DatabaseHelper(this);
//        Intent intent = getIntent();
//
//        id = intent.getIntExtra("ID",0);
//
////        Notes notes = db.getNotes(id);
////        if (notes != null) {
////            if (selectedColor1 == 0 && selectedColor2 == 0) {
////                selectedColor1 = notes.getColor1();
////                selectedColor2 = notes.getColor2();
////            }
////        }
////
////        outState.putInt("selectedColor1", selectedColor1);
////        outState.putInt("selectedColor2", selectedColor2);
//
//    }
//
//    // ...
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // Lấy lại trạng thái màu từ NoteViewModel
//        colorRandom1 = noteViewModel.getColorRandom1();
//        colorRandom2 = noteViewModel.getColorRandom2();
//        selectedColor1 = noteViewModel.getSelectedColor1();
//        selectedColor2 = noteViewModel.getSelectedColor2();
//
//        // Áp dụng lại màu vào giao diện của bạn
//        applyColorToView(colorRandom1, colorRandom2);
//
//
////        if (savedInstanceState != null) {
////            if (savedInstanceState.containsKey("selectedColor1") && savedInstanceState.containsKey("selectedColor2")) {
////                selectedColor1 = savedInstanceState.getInt("selectedColor1");
////                selectedColor2 = savedInstanceState.getInt("selectedColor2");
////            }
////            applyColorToView(selectedColor1, selectedColor2);
////        }
//    }



//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        DatabaseHelper db = new DatabaseHelper(this);
//        Intent intent = getIntent();
//        id = intent.getIntExtra("ID", 0);
//        Notes notes = db.getNotes(id);
//
//        if (notes != null) {
//            selectedColor1 = notes.getColor1();
//            selectedColor2 = notes.getColor2();
//        }
//        outState.putInt("colorRandom1", colorRandom1);
//        outState.putInt("colorRandom2", colorRandom2);
//        outState.putInt("selectedColor1", selectedColor1);
//        outState.putInt("selectedColor2", selectedColor2);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState != null) {
//            if (savedInstanceState.containsKey("colorRandom1") && savedInstanceState.containsKey("colorRandom2")) {
//                colorRandom1 = savedInstanceState.getInt("colorRandom1");
//                colorRandom2 = savedInstanceState.getInt("colorRandom2");
//            }
//            if (savedInstanceState.containsKey("selectedColor1") && savedInstanceState.containsKey("selectedColor2")) {
//                selectedColor1 = savedInstanceState.getInt("selectedColor1");
//                selectedColor2 = savedInstanceState.getInt("selectedColor2");
//            }
//            applyColorToView(colorRandom1 != 0 ? colorRandom1 : selectedColor1, colorRandom2 != 0 ? colorRandom2 : selectedColor2);
//        }
//    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("colorRandom1", colorRandom1);
        outState.putInt("colorRandom2", colorRandom2);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            colorRandom1 = savedInstanceState.getInt("colorRandom1");
            colorRandom2 = savedInstanceState.getInt("colorRandom2");
            applyColorToView(colorRandom1,colorRandom2);
        }
    }








}

