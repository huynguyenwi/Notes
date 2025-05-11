package com.example.notes.JSON;

import android.content.Context;

import com.example.notes.NoteModel.Notes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONManager {
    private static final String TAG = "JSONManager";
    public void exportToJSON(List<Notes> notesList, String filePath) {
        Gson gson = new Gson();
        String json = gson.toJson(notesList);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Notes> importFromJSON(String filePath) {
        Gson gson = new Gson();
        List<Notes> notesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            notesList = gson.fromJson(br, new TypeToken<List<Notes>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notesList;
    }

}
