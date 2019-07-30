package Model;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

/*import sg.edu.np.s10179199k.myapplication.Note.R;*/


/*
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> implements Filterable{

    private Activity context;
    private List<Note> noteList;
    private List<Note> mFilteredList;

    private Menu context_menu;
    ActionMode mActionMode;
    boolean isMultiSelect = false;
    ArrayList<Note> multiselect_list = new ArrayList<>();
    public NoteAdapter(Activity context, List<Note> noteList)
    {
        this.context = context;
        this.noteList = noteList;
        this.mFilteredList = noteList;


    }
*/
    /*public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_item, parent, false);

        return new ViewHolder(v);
    }
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Note n = mFilteredList.get(position);
        holder.listTitle.setText(n.getTitle());
        holder.listDesc.setText(n.getDescription());
        holder.notesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMultiSelect) {
                    multi_select(position,v);
                }
                else {


}*/
    /*Context c;
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

    }*/



