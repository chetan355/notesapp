package com.example.region.cipherchets.rootactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.region.cipherchets.rootactivity.data.NotesDbHandler;
import com.example.region.cipherchets.rootactivity.model.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RootActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        NotesDbHandler notesDbHandler = new NotesDbHandler(RootActivity.this);
        Notes notes = new Notes();
        notes.setDate(currentDate);
        notes.setTime(currentTime);
        notes.setShort_desc("notes1");
        notes.setLong_desc("first notes of an app");
        notesDbHandler.addNotes(notes);
        List<Notes> allnotes = notesDbHandler.getAllNotes();
        for(Notes note:allnotes){
            Log.d("debug","ID:"+note.getId()+"Date:"+note.getDate()+"Time:"+note.getTime()
                                    +"short_desc:"+note.getShort_desc()+"long_desc:"+note.getLong_desc());
        }
    }
}