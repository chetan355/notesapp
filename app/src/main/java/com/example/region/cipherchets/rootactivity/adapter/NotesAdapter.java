package com.example.region.cipherchets.rootactivity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.region.cipherchets.rootactivity.NotesDetail;
import com.example.region.cipherchets.rootactivity.R;
import com.example.region.cipherchets.rootactivity.model.Notes;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>
{
    private List<Notes> notesList;
    private Context context;
    public static final int MODE_UPDATE=2;
    public NotesAdapter(List<Notes> notesList,Context context){
        this.notesList = notesList;
        this.context = context;
    }
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item,parent,false));
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Notes notes = notesList.get(position);
        holder.notes_date.setText(notesList.get(position).getDate());
        holder.short_head.setText(notesList.get(position).getShort_desc());
        holder.long_head.setText(notesList.get(position).getLong_desc());
        switch (position%5){
            case 0:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color1));
                break;
            case 6:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color2));
                break;
            case 1:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color3));
                break;
            case 7:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color4));
                break;
            case 5:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color5));
                break;
            case 8:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color1));
                break;
            case 3:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color4));
                break;
            case 9:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color1));
                break;
            case 2:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color5));
                break;
            case 4:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color3));
                break;
            default:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color1));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NotesDetail.class);
                    intent.putExtra("short_desc",notesList.get(position).getShort_desc());
                    intent.putExtra("long_desc",notesList.get(position).getLong_desc());
                    intent.putExtra("mode",MODE_UPDATE);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView notes_date, short_head,long_head;
        View view;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            notes_date = itemView.findViewById(R.id.notes_date);
            short_head = itemView.findViewById(R.id.short_desc);
            long_head = itemView.findViewById(R.id.long_desc);
            view = itemView.findViewById(R.id.view);
        }
    }
}
