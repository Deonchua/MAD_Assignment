package sg.edu.np.s10179199k.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class CreateNote extends AppCompatActivity {

    EditText addTitle, addContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        addTitle = findViewById(R.id.txtTitle);
        addContent = findViewById(R.id.txtContent);


    }

    public void onSaveClick()
    {

    }
}
