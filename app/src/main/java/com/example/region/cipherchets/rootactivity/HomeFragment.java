package com.example.region.cipherchets.rootactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.region.cipherchets.rootactivity.adapter.NotesAdapter;
import com.example.region.cipherchets.rootactivity.data.NotesDbHandler;
import com.example.region.cipherchets.rootactivity.model.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    TextView message;
    List<Notes> allnotes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        message = view.findViewById(R.id.msg_txt);
//        Notes notes = new Notes();
//        notes.setDate(currentDate);
//        notes.setTime(currentTime);
//        notes.setShort_desc("notes");
//        notes.setLong_desc("first notes of an app");
//        notesDbHandler.addNotes(notes);
//        Notes notes1 = new Notes();
//        notes1.setDate(currentDate);
//        notes1.setTime(currentTime);
//        notes1.setShort_desc("notes1");
//        notes1.setLong_desc("first notes of an app");
//        notesDbHandler.addNotes(notes1);
//        Notes notes2 = new Notes();
//        notes2.setDate(currentDate);
//        notes2.setTime(currentTime);
//        notes2.setShort_desc("notes2");
//        notes2.setLong_desc("first notes of an app");
//        notesDbHandler.addNotes(notes2);
//        Notes notes3 = new Notes();
//        notes3.setDate(currentDate);
//        notes3.setTime(currentTime);
//        notes3.setShort_desc("notes3");
//        notes3.setLong_desc("first notes of an app");
//        notesDbHandler.addNotes(notes3);
        fetchData();
        return view;
    }
    public void fetchData(){
        NotesDbHandler notesDbHandler = new NotesDbHandler(getContext());
        allnotes = notesDbHandler.getAllNotes();
//        for(Notes note:allnotes){
//            Log.d("debug","ID:"+note.getId()+"Date:"+note.getDate()+"Time:"+note.getTime()
//                    +"short_desc:"+note.getShort_desc()+"long_desc:"+note.getLong_desc());
//        }
        notesAdapter = new NotesAdapter(allnotes,getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(notesAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchData();
    }
}