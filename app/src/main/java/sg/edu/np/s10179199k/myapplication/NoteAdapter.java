package sg.edu.np.s10179199k.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class NoteAdapter
{
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

    }
}
