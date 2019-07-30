package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NoteContentActivity extends AppCompatActivity {

    private EditText title, content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_content);

        title = findViewById(R.id.txtTitle);
        content = findViewById(R.id.txtNoteContent);


    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.save_note)
        {
            onSaveNote();
        }
        return super.onOptionsItemSelected(item);
    }

    private void onSaveNote()
    {
        String header = title.getText().toString();
        String text = content.getText().toString();



    }

    private void loadNote()
    {

    }


}
