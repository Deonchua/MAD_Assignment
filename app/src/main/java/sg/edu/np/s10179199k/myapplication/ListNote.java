package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

//import Model.NoteAdapter;
import Model.Note;
public class ListNote extends AppCompatActivity {

   /* DatabaseReference databaseNotes;
    private RecyclerView recyclerView;
    //private NoteAdapter adapter;


    private List<Note> listitems;
    private List<Note> myListitems;
    private TextView defaultText;

    Gson gson = new Gson();

    protected void onStart() {
        super.onStart();
        databaseNotes.addValueEventListener(new ValueEventListener() {
            //executed every-time we change anything in database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                listitems.clear();

                for (DataSnapshot notesSnapshot : dataSnapshot.getChildren()) {
                    Note note = notesSnapshot.getValue(Note.class);
                    Log.i("THE_CURRENT_NOTE:::", note.toString());
                    listitems.add(note);
                }

                //to sort the list based on latest addition by time
                Collections.sort(listitems, new Comparator<Note>() {
                    @Override
                    public int compare(Note o1, Note o2) {
                        return deserializeStringDate(o2.getDate()).compareTo(deserializeStringDate(o1.getDate()));
                    }
                });

                myListitems = getMyList(listitems); //getting only current user notes

                if (myListitems.size() != 0) {

                    defaultText.setVisibility(View.GONE);
                    //adapter = new NoteAdapter(ListNote.this, myListitems);
                    //recyclerView.setAdapter(adapter);

                } else {
                    defaultText.setVisibility(View.VISIBLE);
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note);

        defaultText = (TextView) findViewById(R.id.rvTextView);

        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseNotes = FirebaseDatabase.getInstance().getReference("note");

        listitems = new ArrayList<>();
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.add, menu);

        MenuItem search = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_note:
                startActivity(new Intent(ListNote.this, AddNote.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public Date deserializeStringDate(String drt){
        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            d = dateFormat.parse(drt);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d;
    }

    public List<Note> getMyList(List<Note> nonFiltered){
        ArrayList<Note> myList = new ArrayList<>();
        return myList;


    }
    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //adapter.getFilter().filter(newText);
                return true;
            }
        });
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }*/

    /*public DatabaseReference getDatabase(){
        return databaseNotes;
    }*/
}

