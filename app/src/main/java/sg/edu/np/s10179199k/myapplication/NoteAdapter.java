package sg.edu.np.s10179199k.myapplication;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>
{
    Context context;
    List<Note> noteList = new ArrayList<>();

    public NoteAdapter(Context context, List<Note> noteList)
    {
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.new_layout_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(v);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder nvh, int position)
    {
        nvh.tvTitle.setText(noteList.get(position).getTitle());
        nvh.tvContent.setText(noteList.get(position).getTitle());
    }


    @Override
    public int getItemCount()
    {
        return noteList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitle, tvContent;

        public NoteViewHolder(View itemView)
        {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.note_title);
            tvContent = itemView.findViewById(R.id.note_content);
        }
    }


}
