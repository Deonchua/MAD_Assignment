package sg.edu.np.s10179199k.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {

    Context c;
    int layout;
    ArrayList<Note> data;

    public NoteAdapter(Context c, int layout, ArrayList<Note> data)
    {
        super(c, layout, data);
        this.c = c;
        this.layout = layout;
        this.data = data;
    }

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

        TextView title = v.findViewById(R.id.txtTitle);
        TextView content = v.findViewById(R.id.txtContent);

        Note n = data.get(position);
        title.setText(n.getTitle());
        content.setText(n.getContent());

        return v;

    }
}
