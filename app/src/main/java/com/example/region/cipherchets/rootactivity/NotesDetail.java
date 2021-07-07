package com.example.region.cipherchets.rootactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import java.util.Objects;

public class NotesDetail extends AppCompatActivity {
    EditText title,note;
    Intent intent;
    NotesDbHandler notesDbHandler;
    String currentDate,currentTime;
    Notes notesUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EEBE5C")));
        title = findViewById(R.id.titleEditText);
        note = findViewById(R.id.noteEditText);

        intent = getIntent();
        if(intent.getIntExtra("mode",0)==2){
            notesUpdate = intent.getParcelableExtra("notesObj");
            title.setText(notesUpdate.getShort_desc());
            note.setText(notesUpdate.getLong_desc());
        }
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
            this.setTitle("Create Note");
            MenuItem menuItem = menu.findItem(R.id.update);
            menuItem.setVisible(false);
            menu.findItem(R.id.delete).setVisible(false);
        }
        if(intent.getIntExtra("mode",0)==2){
            this.setTitle("Edit Note");
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
            updateNote();
        }
        if(item.getItemId()==R.id.delete){
            notesDbHandler.deleteNotes(notesUpdate.getId());
            finish();
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
        notesUpdate.setDate(currentDate);
        notesUpdate.setTime(currentTime);
        notesUpdate.setShort_desc(title.getText().toString());
        notesUpdate.setLong_desc(note.getText().toString());
        notesDbHandler.updateNotes(notesUpdate);
        finish();
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
        Notes notesSave = new Notes();
        notesSave.setDate(currentDate);
        notesSave.setTime(currentTime);
        notesSave.setShort_desc(title.getText().toString());
        notesSave.setLong_desc(note.getText().toString());
        notesDbHandler.addNotes(notesSave);
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