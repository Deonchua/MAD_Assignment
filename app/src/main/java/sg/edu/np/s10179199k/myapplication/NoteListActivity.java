package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {

    static ArrayList <Note> data;

    FloatingActionButton fabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        FloatingActionButton fabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteListActivity.this, CreateNote.class);
                startActivity(intent);
            }
        });

        //Data
        data = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
        {
            Note n = new Note();
            n.setTitle("Title " + 1);
            n.setContent("Content " + 1);
            data.add(n);
        }

        // Adapter
        NoteAdapter noteAdapter = new NoteAdapter(this, R.layout.layout_note, data);

        //Listview
        ListView noteList = findViewById(R.id.lvNoteList);
        noteList.setAdapter(noteAdapter);

        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(NoteListActivity.this, NoteContentActivity.class);

                Note selectedItem = (Note)adapterView.getItemAtPosition(i);
                intent.putExtra("Note: ", selectedItem.getTitle());
                startActivity(intent);
            }
        });

        /*
        noteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                new AlertDialog.Builder(NoteListActivity.this)
                                .setIcon(R.drawable.ic_dia)
            }
        });
        */
    }

}
