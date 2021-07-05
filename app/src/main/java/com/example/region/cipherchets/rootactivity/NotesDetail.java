package com.example.region.cipherchets.rootactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.region.cipherchets.rootactivity.data.NotesDbHandler;
import com.example.region.cipherchets.rootactivity.model.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NotesDetail extends AppCompatActivity {
    EditText title,note;
    Intent intent;
    NotesDbHandler notesDbHandler;
    String currentDate,currentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);
        title = findViewById(R.id.titleEditText);
        note = findViewById(R.id.noteEditText);
        intent = getIntent();
        title.setText(intent.getStringExtra("short_desc"));
        note.setText(intent.getStringExtra("long_desc"));
        notesDbHandler = new NotesDbHandler(this);
        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_edit_menu,menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(intent.getIntExtra("mode",0)==1){
            MenuItem menuItem = menu.findItem(R.id.update);
            menuItem.setVisible(false);
        }
        if(intent.getIntExtra("mode",0)==2){
            MenuItem menuItem = menu.findItem(R.id.save);
            menuItem.setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.save){
            saveNote();
        }
        if(item.getItemId()==R.id.update){

        }
        return super.onOptionsItemSelected(item);
    }
    private void updateNote(){
        if(title.getText().toString().equals("")){
            Toast.makeText(this,"Please Enter Title Of Note",Toast.LENGTH_SHORT).show();
            return;
        }
        if(note.getText().toString().equals("")){
            Toast.makeText(this,"Please Enter Content Of Note",Toast.LENGTH_SHORT).show();
            return;
        }

    }
    private void saveNote()
    {
        if(title.getText().toString().equals("")){
            Toast.makeText(this,"Please Enter Title Of Note",Toast.LENGTH_SHORT).show();
            return;
        }
        if(note.getText().toString().equals("")){
            Toast.makeText(this,"Please Enter Content Of Note",Toast.LENGTH_SHORT).show();
            return;
        }
        Notes notes = new Notes();
        notes.setDate(currentDate);
        notes.setTime(currentTime);
        notes.setShort_desc(title.getText().toString());
        notes.setLong_desc(note.getText().toString());
        notesDbHandler.addNotes(notes);
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
        finish();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("id","1");
        setResult(RESULT_OK, intent);
        finish();
    }
}