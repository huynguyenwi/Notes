package com.example.notes.Adapter;



import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.res.Configuration;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.Acitivity.AddNoteActivity;
import com.example.notes.SQLite.DatabaseHelper;
import com.example.notes.NoteModel.Notes;
import com.example.notes.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    List<Notes> notesList;

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

    public MyAdapter(Context context, List<Notes> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        View view;
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_landscape, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        }
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String title = notesList.get(position).getTitle();
        String description = notesList.get(position).getDescription();
        String date = notesList.get(position).getDate();
        int color1 = notesList.get(position).getColor1();
        int color2 = notesList.get(position).getColor2();

//        int color1 = ContextCompat.getColor(context, R.color.red);
//        int color2 = ContextCompat.getColor(context, R.color.lightpink);



        holder.titleOutput.setText(title);
        holder.descriptionOutput.setText(description);
        holder.dateOutput.setText(date);



//        holder.titleOutput.setBackgroundColor(color1);
//        holder.descriptionOutput.setBackgroundColor(color2);
//        holder.dateOutput.setBackgroundColor(color1);


        if(color2 == -1235432){
            color1 = ContextCompat.getColor(context, imgbtnPairs[0][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[0][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[0][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[0][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[0][0]));
        }
        if (color2 == -23296) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[1][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[1][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[1][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[1][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[1][0]));
        }
        if (color2 == -29696) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[2][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[2][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[2][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[2][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[2][0]));
        }
        if (color2 == -10496) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[3][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[3][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[3][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[3][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[3][0]));
        }
        if (color2 == -6632142) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[4][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[4][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[4][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[4][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[4][0]));
        }
        if (color2 == -13447886) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[5][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[5][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[5][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[5][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[5][0]));
        }
        if (color2 == -16724271) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[6][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[6][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[6][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[6][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[6][0]));
        }
        if (color2 == -12490271) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[7][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[7][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[7][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[7][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[7][0]));
        }
        if (color2 == -16777011) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[8][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[8][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[8][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[8][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[8][0]));
        }
        if (color2 == -7077677) {
            color1 = ContextCompat.getColor(context, imgbtnPairs[9][0]);
            color2 = ContextCompat.getColor(context, imgbtnPairs[9][1]);

            holder.titleOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[9][0]));
            holder.descriptionOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[9][1]));
            holder.dateOutput.setBackgroundColor(ContextCompat.getColor(context, imgbtnPairs[9][0]));
        }

        Log.d("MyAdapter", "Color 1: " + color1);
        Log.d("MyAdapter", "Color 2: " + color2);

        Log.d("MyAdapter", "Color 1 hex: " + Integer.toHexString(color1));
        Log.d("MyAdapter", "Color 2 hex: " + Integer.toHexString(color2));


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder mydialog = new AlertDialog.Builder(context);
                mydialog.setTitle("Delete this note");
                mydialog.setMessage("Are you sure you want to delete Note?");
                mydialog.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int itemPosition = holder.getAdapterPosition();

                        //delete the note
                        // Xóa ghi chú khỏi danh sách
                        notesList.remove(itemPosition);
                        notifyItemRemoved(itemPosition);

                        // Cập nhật cơ sở dữ liệu
                        DatabaseHelper db = new DatabaseHelper(context.getApplicationContext());
                        db.deleteNote(notesList.get(itemPosition).getId());

                    }
                });
                mydialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mydialog.create().show();

                return true;
            }
        });


    }


    @Override
    public int getItemCount() {
        return  notesList == null ? 0 : notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleOutput;
        TextView descriptionOutput;
        TextView dateOutput;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleOutput = itemView.findViewById(R.id.titleoutput);
            descriptionOutput = itemView.findViewById(R.id.descriptionoutput);
            dateOutput = itemView.findViewById(R.id.dateoutput);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        Intent intent = new Intent(view.getContext(), AddNoteActivity.class);
                        intent.putExtra("ID", notesList.get(getAdapterPosition()).getId());
                        view.getContext().startActivity(intent);

                }
            });
        }
    }



}
