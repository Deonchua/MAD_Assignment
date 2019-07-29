package sg.edu.np.s10179199k.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note>{

    Context c;
    int layout;

    ArrayList<Note> text;


    public NoteAdapter(Context c, int layout, ArrayList<Note> title, ArrayList<Note> content)
    {
        super(c, layout, content);

        this.c = c;
        this.layout = layout;
        this.text = text;
    }


    /*
    class NoteHolder extends RecyclerView.ViewHolder
    {
        TextView title, content, date;

        public NoteHolder(View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
        }
    }


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.new_layout_note, parent, false);
        return new NoteHolder(v);
    }

    */

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if (v == null)
        {
            v = LayoutInflater.from(c)
                    .inflate(layout, parent, false);
            Log.d("L04", "New View" + position);
        }

        Log.d("L04", "Existing View" + position);



        TextView title = v.findViewById(R.id.note_title);
        TextView content = v.findViewById(R.id.note_content);
        TextView date = v.findViewById(R.id.note_date);

        Note n = text.get(position);
        title.setText(n.getTitle());
        content.setText(n.getContent());
        date.setText(n.getDate());

        return v;

    }


}
