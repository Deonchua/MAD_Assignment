package sg.edu.np.s10179199k.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    ArrayList <Note> titles = new ArrayList<>();
    ArrayList <Note> notes = new ArrayList<>();
    ArrayAdapter noteAdapter;

    ListView noteList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        //Data

        /*
        notes = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
        {
            Note n = new Note();
            n.setTitle("Title " + 1 + ": " + notes);
            n.setContent("Content " + 1 + ": " + notes);
            notes.add(n);
        }
        */


        // Adapter
       /* final NoteAdapter noteAdapter = new NoteAdapter(this, R.layout.layout_note, titles, notes);

        //Listview
        ListView noteList = findViewById(R.id.lvNoteList);
        noteList.setAdapter(noteAdapter);



        FloatingActionButton fabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteListActivity.this, NoteContentActivity.class);
                startActivity(intent);
            }
        });



        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(NoteListActivity.this, NoteContentActivity.class);

                Note selectedItem = (Note)adapterView.getItemAtPosition(i);
                intent.putExtra("Note: " + i + ": ", selectedItem.getTitle());
                startActivity(intent);
            }
        });

        *//*
        noteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                new AlertDialog.Builder(NoteListActivity.this)
                                .setIcon(R.drawable.ic_dia)
            }
        });
        *//*
*/
    }

    public void onNoteLongClick()
    {
        noteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int itemNo = position;

                new AlertDialog.Builder(NoteListActivity.this)
                        .setTitle("Delete Note")
                        .setMessage("Do you want to delete : " + titles)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                titles.remove(which);
                                notes.remove(which);
                                noteAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            }
        });
    }

}
