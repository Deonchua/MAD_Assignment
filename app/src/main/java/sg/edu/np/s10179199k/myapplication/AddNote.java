package sg.edu.np.s10179199k.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Model.Note;

public class AddNote extends AppCompatActivity {

    private EditText title;
    private EditText desc;
    private TextView date;
    private Button addNote;
    private String currentDate;

    //Firebase auth
    /*Firebase.mAuthListner;
    FirebaseAuth.AuthStateListener */





    DatabaseReference databaseNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //Creating new fields for note
        title = (EditText)findViewById(R.id.etTitle);
        desc = (EditText)findViewById(R.id.etDesc);
        //date = (TextView)findViewById(R.id.date);

        addNote = (Button)findViewById(R.id.addBtn);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotes();
            }
        });

        databaseNotes = FirebaseDatabase.getInstance().getReference("notes");


        //Creating new fields for note

        currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        date.setText(currentDate);


    }
    private void addNotes() {

        String heading = title.getText().toString().trim(); //title
        String description = desc.getText().toString().trim(); //description

        if (TextUtils.isEmpty(heading)) {
            Toast.makeText(AddNote.this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            String id = databaseNotes.push().getKey();

            Note note = new Note(id,heading,description, currentDate);

            databaseNotes.child(id).setValue(note);

            Toast.makeText(this, "Note added", Toast.LENGTH_SHORT).show();
            //refreshEditTexts();
            finish();
        }




    }
}
